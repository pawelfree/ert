package pl.pd.emir.parsers;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import pl.pd.emir.commons.StringUtil;
import pl.pd.emir.embeddable.BusinessEntityData;
import pl.pd.emir.embeddable.ContractDataDetailed;
import pl.pd.emir.embeddable.CurrencyTradeData;
import pl.pd.emir.embeddable.PercentageRateData;
import pl.pd.emir.embeddable.RiskReduce;
import pl.pd.emir.embeddable.TransactionClearing;
import pl.pd.emir.embeddable.TransactionDetails;
import pl.pd.emir.entity.Client;
import pl.pd.emir.entity.Transaction;
import pl.pd.emir.enums.DataType;
import pl.pd.emir.enums.OriginalStatus;
import pl.pd.emir.enums.ProcessingStatus;
import pl.pd.emir.enums.ValidationStatus;
import pl.pd.emir.imports.ImportResult;
import pl.pd.emir.imports.utils.ImportValidationUtils;
import pl.pd.emir.register.ClientManager;
import org.apache.commons.lang3.ArrayUtils;

public class TransactionCsvParserTmb extends TransactionCsvParser {

    private final transient ClientManager clientMng;
    private final transient Date twoDatesSwap;

    public TransactionCsvParserTmb(ClientManager clientMng, Date twoDatesSwap) {
        this.clientMng = clientMng;
        this.twoDatesSwap = twoDatesSwap;
    }

    @Override
    public Transaction parseAndValidateRow(ImportResult importResult, String... data) {

        Transaction transaction = null;

        //walidacja pod kontem błędów
        if (validateErrors(importResult, data)) {

            String[] transactionDtls = ArrayUtils.addAll(Arrays.copyOfRange(data, 28, 31), Arrays.copyOfRange(data, 39, 57)); //szczegoly transakcji
            transactionDtls = ArrayUtils.addAll(transactionDtls, Arrays.copyOfRange(data, 86, 89)); //szczegoly transakcji

            //Wczytanie wartości z szablonu transakcji
            OriginalStatus r3 = null; //STATUS_TR
            String r4 = null; //ID_KLIENTA
            String r41 = null; //ID_KLIENTA2
            String r5 = null; //POTWIERDZONA dla BTMU powinno być wymagane
            BusinessEntityData r6 = null; //kontrahent2: dane klienta
            BusinessEntityData r7 = null; //kontrahent: dane klienta
            ContractDataDetailed r8 = null; //kontrakt 4.2
            TransactionDetails r9 = null;
            RiskReduce r10 = null; //ryzyko 4.4
            TransactionClearing r11 = null; //rozliczanie 4.5
            PercentageRateData r12 = null;
            CurrencyTradeData r13 = null; 

            //walidacja pod kontem ostrzeżeń
            String f1 = ImportValidationUtils.validateStringField(data[0], null, 50, "ID_TR", true, "1", importResult); //ID_TR
            OriginalStatus f3 = ImportValidationUtils.validateEnumField(OriginalStatus.class, r3, data[2], "STATUS_TR", true, "3", importResult); //STATUS_TR
            //TODO chwilowe bo kontrachent i klient to nie to samo
            String f4  = ImportValidationUtils.validateStringField(data[3],  r4, 100, "ID_KLIENTA", true, "4", importResult); //ID_KLIENTA
            String f41 = ImportValidationUtils.validateStringField(data[11], r41, 100, "ID_KLIENTA2",true, "12", importResult);             
            String f5 = ImportValidationUtils.validateStringBooleanField(data[5], "1", "0", r5, false, "POTWIERDZONA", "6", importResult); //POTWIERDZONA dla BTMU powinno być wymagane
            BusinessEntityData f6 = ImportValidationUtils.validateBusinessEntityData(getBfnIdTpFromClient(Arrays.copyOfRange(data, 6, 17)), true, r6, importResult); //kontrahent2: dane klienta np. BTMU
            BusinessEntityData f7 = ImportValidationUtils.validateBusinessEntityData(getBfnIdTpFromClient(Arrays.copyOfRange(data, 17, 28)), false, r7, importResult); //kontrahent: dane klienta
            ContractDataDetailed f8 = ImportValidationUtils.validateContractDetailed(Arrays.copyOfRange(data, 31, 39), r8, importResult); //kontrakt 4.2
            TransactionDetails f9 = ImportValidationUtils.validateTransactionDtls(transactionDtls, r9, importResult,
                    unitPriceField41, unitPriceCurrencyField42, unitPriceRateField43,
                    tradeNominalField44, tradeMultiplField45, tradeQtyField46, tradeUppField47, tradeAggrVerField55,
                    tradeExecDateField49, tradeEffDateField50, tradeMattDateField51,
                    tradeTermDateField52, tradeSettlDateField53, tradeSettlDateField54);
            RiskReduce f10 = ImportValidationUtils.validateRiskReduce(Arrays.copyOfRange(data, 57, 59), r10, importResult, riskConfDateField56); //ryzyko 4.4
            TransactionClearing f11 = ImportValidationUtils.validateTransactionClearing(Arrays.copyOfRange(data, 59, 64), r11, importResult, settlementDateField60); //rozliczanie 4.5
            PercentageRateData f12 = ImportValidationUtils.validatePercentageRate(Arrays.copyOfRange(data, 64, 72), r12,
                    importResult, //stopa procent.
                    percLeg1Field63, percLeg2Field64);
            CurrencyTradeData f13 = ImportValidationUtils.validateCurrencyTrade(Arrays.copyOfRange(data, 72, 76), r13, importResult,
                    currRate1Field72, currRate2Field73); //transakcje walut.

            //walidacja zależności pomiędzy ceną a symbolem waluty
            ImportValidationUtils.validateMoneyCompleteness(unitPriceField41, unitPriceCurrencyField42, "TRADADDTLINF_AMT", "TRADADDTLINF_AMT_WAL", "43", importResult);

            //TODO: usunąć DataType bo to jest to samo co OriginalStatus
            DataType dataType = DataType.NEW;
            if (OriginalStatus.M.equals(f3)) {
                dataType = DataType.ONGOING;
            } else if (OriginalStatus.C.equals(f3)) {
                dataType = DataType.COMPLETED;
            }

            //TODO PAWEL transaction party field nie jest nigdzie ustawiany?? !!
            transaction = new Transaction(f1, transactionDateField1, f3, f4, transactionPartyField4, f41, f5, f6, f7, f8, f9,
                    f10, f11, f12, f13, dataType, ProcessingStatus.NEW, ValidationStatus.VALID, new Client(), new Client());
            
            transaction.setValidationStatus(importResult.getValidationStatus());

        }

        return transaction;
    }

    /**
     * Weryfikacja pod kątem błedów.
     *
     * @param data dane pojedynczego rekordu z wczytywanego ekstraktu
     * @return dane pojedyńczego rekorku uzupełnione o CTRPTYDTLS_BNFCRYID_ID i CTRPTYDTLS_BNFCRYID_TP oraz
     * KTRPTYDTLS_BNFCRYID_ID i KTRPTYDTLS_BNFCRYID_TP
     */
    private String[] getBfnIdTpFromClient(String[] data) {
        String[] businessEnt = data;
        if (StringUtil.isEmpty(businessEnt[5])) {
            return data;
        }
        Client client = clientMng.getClientByOrginalId(businessEnt[5]);
        if (Objects.isNull(client)) {
            businessEnt[5] = "";
            return data;
        }
        if (Objects.nonNull(client)) {
            businessEnt[5] = client.getInstitutionId() == null ? "" : client.getInstitutionId();
            businessEnt[6] = client.getInstitutionIdType() == null ? "" : client.getInstitutionIdType().toString();
        }
        return businessEnt;
    }

}
