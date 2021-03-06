package pl.pd.emir.parsers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import org.apache.commons.lang3.ArrayUtils;
import pl.pd.emir.commons.DateUtils;
import pl.pd.emir.commons.StringUtil;
import pl.pd.emir.embeddable.BusinessEntityData;
import pl.pd.emir.embeddable.ContractDataDetailed;
import pl.pd.emir.embeddable.CurrencyTradeData;
import pl.pd.emir.embeddable.PercentageRateData;
import pl.pd.emir.embeddable.RiskReduce;
import pl.pd.emir.embeddable.TransactionClearing;
import pl.pd.emir.embeddable.TransactionDetails;
import pl.pd.emir.entity.Client;
import pl.pd.emir.entity.ImportFailLog;
import pl.pd.emir.entity.Transaction;
import pl.pd.emir.enums.CurrencyCode;
import pl.pd.emir.enums.DataType;
import pl.pd.emir.enums.OriginalStatus;
import pl.pd.emir.enums.ProcessingStatus;
import pl.pd.emir.enums.TransactionParty;
import pl.pd.emir.enums.ValidationStatus;
import pl.pd.emir.imports.ImportFaillogUtils;
import pl.pd.emir.imports.ImportResult;
import pl.pd.emir.imports.utils.ImportValidationUtils;
import static pl.pd.emir.imports.utils.ImportValidationUtils.validateAmountField;
import static pl.pd.emir.imports.utils.ImportValidationUtils.validateEnumField;

public class TransactionCsvParser extends BaseCsvParser<Transaction> {

    protected static final int COLUMN_COUNT = 89;

    protected transient TransactionParty transactionPartyField4;

    protected transient Date transactionDateField1,
            tradeExecDateField49, tradeEffDateField50, tradeMattDateField51, tradeTermDateField52, tradeSettlDateField53, tradeSettlDateField54,
            riskConfDateField56, settlementDateField60;

    protected transient Integer tradeMultiplField45, tradeQtyField46, tradeAggrVerField55;

    protected transient BigDecimal unitPriceField41, unitPriceRateField43, tradeNominalField44, tradeUppField47,
            currRate1Field72, currRate2Field73, percLeg1Field63, percLeg2Field64;

    protected transient CurrencyCode unitPriceCurrencyField42;

    public TransactionCsvParser() {
    }

    /**
     * Przetwarzanie pojedynczego wiersza ekstraktu.
     *
     */
    @Override
    public Transaction parseAndValidateRow(ImportResult importResult, String... data) {

        Transaction transaction = null;

        //walidacja pod kontem błędów
        if (validateErrors(importResult, data)) {

            String[] transactionDtls = ArrayUtils.addAll(Arrays.copyOfRange(data, 28, 31), Arrays.copyOfRange(data, 39, 57)); //szczegoly transakcji
            transactionDtls = ArrayUtils.addAll(transactionDtls, Arrays.copyOfRange(data, 86, 89)); //szczegoly transakcji

            //walidacja pod kontem ostrzeżeń
            String f1 = ImportValidationUtils.validateStringField(data[0], null, 50, "ID_TR", true, "1", importResult); //ID_TR
            OriginalStatus f3 = ImportValidationUtils.validateEnumField(OriginalStatus.class, null, data[2], "STATUS_TR", true, "3", importResult); //STATUS_TR
            //TODO chwilowe bo kontrachent i klient to nie to samo
            String f4  = ImportValidationUtils.validateStringField(data[3],  null, 100, "ID_KLIENTA", true, "4", importResult); //ID_KLIENTA
            String f41 = ImportValidationUtils.validateStringField(data[11], null, 100, "ID_KLIENTA2",true, "12", importResult); 
            String f5 = ImportValidationUtils.validateStringBooleanField(data[5], "1", "0", null, false, "POTWIERDZONA", "6", importResult); //POTWIERDZONA dla BTMU powinno być wymagane
            BusinessEntityData f6 = ImportValidationUtils.validateBusinessEntityData(Arrays.copyOfRange(data, 6, 17), true, null, importResult); //kontrahent2 dane klienta np BTMU
            BusinessEntityData f7 = ImportValidationUtils.validateBusinessEntityData(Arrays.copyOfRange(data, 17, 28), false, null, importResult); //kontrahent dane klienta
            ContractDataDetailed f8 = ImportValidationUtils.validateContractDetailed(Arrays.copyOfRange(data, 31, 39), null, importResult); //kontrakt 4.2
            TransactionDetails f9 = ImportValidationUtils.validateTransactionDtls(transactionDtls, null, importResult,
                    unitPriceField41, unitPriceCurrencyField42, unitPriceRateField43,
                    tradeNominalField44, tradeMultiplField45, tradeQtyField46,
                    tradeUppField47, tradeAggrVerField55,
                    tradeExecDateField49, tradeEffDateField50, tradeMattDateField51,
                    tradeTermDateField52, tradeSettlDateField53,tradeSettlDateField54);
            RiskReduce f10 = ImportValidationUtils.validateRiskReduce(Arrays.copyOfRange(data, 57, 59), null, importResult, riskConfDateField56); //ryzyko 4.4
            TransactionClearing f11 = ImportValidationUtils.validateTransactionClearing(Arrays.copyOfRange(data, 59, 64), null, importResult, settlementDateField60); //rozliczanie 4.5
            PercentageRateData f12 = ImportValidationUtils.validatePercentageRate(Arrays.copyOfRange(data, 64, 72), null,
                    importResult, //stopa procent.
                    percLeg1Field63, percLeg2Field64);
            CurrencyTradeData f13 = ImportValidationUtils.validateCurrencyTrade(Arrays.copyOfRange(data, 72, 76), null, importResult,
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

            transaction = new Transaction(f1, transactionDateField1, f3, f4, transactionPartyField4, f41 ,f5, f6, f7, f8, f9,
                    f10, f11, f12, f13, dataType, ProcessingStatus.NEW, ValidationStatus.VALID, new Client(), new Client());

            transaction.setValidationStatus(importResult.getValidationStatus());

        }

        return transaction;
    }

    /**
     * Weryfikacja pod kontem błedów.
     *
     * @param data dane pojedynczego rekordu z wczytywanego ekstraktu
     * @return false w przypadku wystąpienia błędów walidacji, w przeciwnym przypadku true
     */
    protected boolean validateErrors(ImportResult importResult, String[] data) {
        //pole ID_TR musi byc uzupelnione
        if (StringUtil.isEmpty(data[0])) {
            importResult.addError(new ImportFailLog(ImportFaillogUtils.getString(
                    ImportFaillogUtils.ImportFaillogKey.EMPTY_TRANSACTION_ID, rowNum)));
        }

        //ilosc kolumn w wierszu
        int size = Arrays.asList(data).size();
        if (size != COLUMN_COUNT) {
            importResult.addError(new ImportFailLog(ImportFaillogUtils.getString(
                    ImportFaillogUtils.ImportFaillogKey.INVALID_COLUMN_COUNT_ERROR, importResult.getRecordId())));
            return false;
        }

        //wczytanie wartości z szablonu transakcji
        //wartości numeryczne
        TransactionParty r4 = null;
        BigDecimal r41 = null;
        CurrencyCode r42 = null;
        BigDecimal r43 = null;
        BigDecimal r44 = null;
        Integer r45 = null;
        Integer r46 = null;
        BigDecimal r47 = null;
        Integer r55 = null;
        BigDecimal r63 = null;
        BigDecimal r64 = null;
        BigDecimal r72 = null;
        BigDecimal r73 = null;
        BigDecimal r83 = null;
        BigDecimal r84 = null;
        BigDecimal r87 = null;
        //daty
        Date r49 = null;
        Date r50 = null;
        Date r51 = null;
        Date r52 = null;
        Date r53 = null;
        Date r54 = null;
        Date r56 = null;
        Date r60 = null;
        Date r80 = null;
        Date r81 = null;

        //kontrola wartosci numerycznych
        transactionPartyField4 = ImportValidationUtils.validateEnumField(TransactionParty.class, r4, data[4], "STRONA_TR", true, "5", importResult);
        unitPriceField41 = validateAmountField(data[41], 25, 5, r41, false, true, "TRADADDTLINF_AMT", "42", importResult);
        unitPriceCurrencyField42 = validateEnumField(CurrencyCode.class, r42, data[42], "TRADADDTLINF_AMT_WAL", false, "43", importResult);
        unitPriceRateField43 = validateAmountField(data[43], 25, 5, r43, false, true, "TRADADDTLINF_PRCNTG", "44", importResult);
        tradeNominalField44 = ImportValidationUtils.validateAmountField(data[44], 22, 2, r44, true, true, "TRADADDTLINF_NMNLAMT", "45", importResult);
        tradeMultiplField45 = ImportValidationUtils.validateIntegerField(data[45], r45, false, "TRADADDTLINF_PRICMLTPLR", "46", importResult);
        tradeQtyField46 = ImportValidationUtils.validateIntegerField(data[46], r46, true, "TRADADDTLINF_QTY", "47", importResult);
        tradeUppField47 = ImportValidationUtils.validateAmountField(data[47], 12, 2, r47, false, true, "TRADADDTLINF_UPPMT", "48", importResult);
        tradeAggrVerField55 = ImportValidationUtils.validateIntegerField(data[56], r55, false, "TRADADDTLINF_MSTRAGRMNTVRSN", "57", importResult);
        percLeg1Field63 = ImportValidationUtils.validateAmountField(data[64], 25, 5, r63, false, true, "IRTRAD_FXDRATELG1", "65", importResult);
        percLeg2Field64 = ImportValidationUtils.validateAmountField(data[65], 25, 5, r64, false, true, "IRTRAD_FXDRATELG2", "66", importResult);
        currRate1Field72 = ImportValidationUtils.validateAmountField(data[73], 15, 5, r72, false, true, "FXTRAD_XCHGRATE1", "74", importResult);
        currRate2Field73 = ImportValidationUtils.validateAmountField(data[74], 15, 5, r73, false, true, "FXTRAD_FRWRDXCHGRATE", "75", importResult);
        
        //kontrola dat
        transactionDateField1 = ImportValidationUtils.validateDateField(data[1], null, DateUtils.ISO_DATE_FORMAT, true, "DATA_TR", "2", importResult);
        //TODO usunąć obejscie problemu AS
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTimeInMillis(0);
        cal.set( 2017, 04, 01, 00, 00, 00);
        Date firstMay2017 = cal.getTime(); 
        //TODO jesli bedzie problem z data to tu sie wywali nullpointer
        tradeExecDateField49 = ImportValidationUtils.validateDateField(data[49], r49, DateUtils.ISO_DATE_TIME_FORMAT, true, "TRADADDTLINF_EXECDTTM", "50", importResult);
        if (tradeExecDateField49.before(firstMay2017)) {
            tradeExecDateField49 = firstMay2017;
        }
        //TODO usunąć obejscie problemu AS
        tradeEffDateField50 = ImportValidationUtils.validateDateField(data[50], r50, DateUtils.ISO_DATE_TIME_FORMAT, false, "TRADADDTLINF_FCTYDT", "51", importResult);
        if (tradeEffDateField50.before(firstMay2017)) {
            tradeEffDateField50 = firstMay2017;
        }
        tradeMattDateField51 = ImportValidationUtils.validateDateField(data[51], r51, DateUtils.ISO_DATE_TIME_FORMAT, false, "TRADADDTLINF_MTRTYDT", "52", importResult);
        tradeTermDateField52 = ImportValidationUtils.validateDateField(data[52], r52, DateUtils.ISO_DATE_TIME_FORMAT, "C".equalsIgnoreCase(data[2]), "TRADADDTLINF_TRMNTNDT", "53", importResult);
        tradeSettlDateField53 = ImportValidationUtils.validateDateField(data[53], r53, DateUtils.ISO_DATE_TIME_FORMAT, false, "TRADADDTLINF_STTLMTDT", "54", importResult);
        tradeSettlDateField54 = ImportValidationUtils.validateDateField(data[54], r54, DateUtils.ISO_DATE_TIME_FORMAT, false, "TRADADDTLINF_STTLMTDT_2", "55", importResult);
        //TODO usunac obejscie problemu AS
        riskConfDateField56 = ImportValidationUtils.validateDateField(data[57], r56, DateUtils.ISO_DATE_TIME_FORMAT, false, "RSKMTGTN_CNFRMTNDTTM", "57", importResult);
        if (Objects.nonNull(riskConfDateField56) && riskConfDateField56.before(firstMay2017)) {
            riskConfDateField56 = firstMay2017;
        }
        settlementDateField60 = ImportValidationUtils.validateDateField(data[61], r60, DateUtils.ISO_DATE_TIME_FORMAT, false, "CLRGINF_CLRDTTM", "61", importResult);

        return !importResult.hasErrors();
    }

    @Override
    public Integer getRowIdIndex() {
        return 0;
    }

}
