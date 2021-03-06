package pl.pd.emir.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import pl.pd.emir.commons.DateUtils;
import pl.pd.emir.commons.StringUtil;
import pl.pd.emir.commons.interfaces.Logable;
import pl.pd.emir.commons.interfaces.Selectable;
import pl.pd.emir.commons.interfaces.Validatable;
import pl.pd.emir.embeddable.BusinessEntityData;
import pl.pd.emir.embeddable.ContractDataDetailed;
import pl.pd.emir.embeddable.CurrencyTradeData;
import pl.pd.emir.embeddable.PercentageRateData;
import pl.pd.emir.embeddable.RiskReduce;
import pl.pd.emir.embeddable.TransactionClearing;
import pl.pd.emir.embeddable.TransactionDetails;
import pl.pd.emir.embeddable.ValuationData;
import pl.pd.emir.entity.administration.ChangeLog;
import pl.pd.emir.entity.annotations.ValidateCompleteness;
import pl.pd.emir.entity.kdpw.KdpwMsgItem;
import static pl.pd.emir.entity.utils.HistoryUtils.checkFieldsEquals;
import static pl.pd.emir.entity.utils.HistoryUtils.checkFieldsEqualsMsg;
import pl.pd.emir.enums.ConfirmedStatus;
import pl.pd.emir.enums.DataType;
import pl.pd.emir.enums.EventType;
import pl.pd.emir.enums.OriginalStatus;
import pl.pd.emir.enums.ProcessingStatus;
import pl.pd.emir.enums.TransactionParty;
import pl.pd.emir.enums.ValidationStatus;
import pl.pd.emir.resources.EventLogBuilder;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.DescriptorCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.mappings.AggregateObjectMapping;
import pl.pd.emir.entity.annotations.TransactionDataChange;

@Entity
@Table(name = "CONTRACT")
@NamedQueries({
    @NamedQuery(name = "Transaction.getByOriginalIdAndData",
            query = "select t FROM Transaction t WHERE t.originalId = :originalId and t.transactionDate = :date"),
    @NamedQuery(name = "Transaction.findNewestConfirmed",
            query = "select t FROM Transaction t "
            + "WHERE t.transactionDetails.sourceTransId=:sourceTransId"
            + " and not t.id = :currentId"
            + " and t.processingStatus=pl.pd.emir.enums.ProcessingStatus.CONFIRMED ORDER BY t.dateSupply DESC"),
    @NamedQuery(name = "Transaction.countDistinctTransactionForDay",
            query = "select count(distinct(t.transactionDetails.sourceTransId)) FROM Transaction t "
            + "WHERE t.client.id = :idClient"
            + " and t.contractDetailedData.contractData.prod1Code = :instrumentType"
            + " and t.transactionDate = :day"),
    @NamedQuery(name = "Transaction.sumAmountNewestTransactionForDay",
            query = "select distinct(t.transactionDetails.sourceTransId), t.transactionDetails.nominalAmount FROM Transaction t "
            + "WHERE t.client.id = :idClient"
            + " and t.contractDetailedData.contractData.prod1Code = :instrumentType"
            + " and t.transactionDate = :day "
            + " order by t.id desc"),
    @NamedQuery(name = "Transaction.importRaport",
            query = "select t FROM Transaction t "
            + "WHERE t.fileName = :file "
            + "and t.transactionDate = :date"),
    @NamedQuery(name = "Transaction.getByDateAndOriginalId",
            query = "select t FROM Transaction t "
            + "WHERE t.originalId = :originalId "
            + "AND t.transactionDate BETWEEN :transactionDateFrom AND :transactionDateTo "
            + "ORDER BY t.extractVersion"),
    @NamedQuery(name = "Transaction.getByDate",
            query = "select t FROM Transaction t "
            + "WHERE t.transactionDate BETWEEN :transactionDateFrom AND :transactionDateTo"),
    @NamedQuery(name = "Transaction.findOtherProcessingNew",
            query = "SELECT t FROM Transaction t WHERE t.id != :currentId "
            + " AND t.processingStatus = pl.pd.emir.enums.ProcessingStatus.NEW"
            + " AND t.transactionDate <= :transactionDate"
            + " AND t.transactionDetails.sourceTransId = :sourceTransId "),
    @NamedQuery(name = "Transaction.getByOriginalId",
            query = "select t FROM Transaction t WHERE t.originalId = :originalId "),
    @NamedQuery(name = "Transaction.getByOriginalIdMaxVersion",
            query = "select t FROM Transaction t WHERE t.originalId = :originalId and t.extractVersion = (SELECT MAX(r.extractVersion) FROM Transaction r WHERE r.originalId = t.originalId)"),
    @NamedQuery(name = "Transaction.getBySourceNrRefMaxVersion",
            query = "select t FROM Transaction t WHERE t.transactionDetails.sourceTransRefNr = :sourceNrRef and t.extractVersion = (SELECT MAX(r.extractVersion) FROM Transaction r WHERE r.transactionDetails.sourceTransRefNr = t.transactionDetails.sourceTransRefNr)"),
    @NamedQuery(name = "Transaction.getFullByOriginalId",
            query = "select t FROM Transaction t LEFT JOIN FETCH t.relatedItems WHERE t.originalId = :originalId "),
    @NamedQuery(name = "Transaction.getSentByOriginalIdAndDate",
            query = "select t FROM Transaction t"
            + " WHERE t.originalId = :originalId"
            + " AND t.transactionDate = :transactionDate"
            + " AND t.processingStatus = pl.pd.emir.enums.ProcessingStatus.SENT"),
    @NamedQuery(name = "Transaction.getValidMaxDate",
            query = "SELECT MAX(t.transactionDate) FROM Transaction t WHERE"
            + " t.validationStatus = pl.pd.emir.enums.ValidationStatus.VALID"),
    @NamedQuery(name = "Transaction.getValidMinDate",
            query = "SELECT MIN(t.transactionDate) FROM Transaction t WHERE"
            + " t.validationStatus = pl.pd.emir.enums.ValidationStatus.VALID"),
    @NamedQuery(name = "Transaction.isPossibilityDeleteTransaction",
            query = "SELECT MAX(t.id), MAX(t.transactionDate), MAX(t.extractVersion) FROM Transaction t WHERE t.originalId = :originalId"),
    @NamedQuery(name = "Transaction.getNewerMutationsCount",
            query = "SELECT COUNT(t.id) FROM Transaction t"
            + " WHERE t.originalId = :originalId"
            + " AND (t.transactionDate > :transactionDate"
            + " OR (t.transactionDate = :transactionDate"
            + " AND t.extractVersion > :extractVersion))"
            + " AND t.processingStatus != :processingStatus"),
    @NamedQuery(name = "Transaction.getNewerVersionCount",
            query = "SELECT COUNT(t.id) FROM Transaction t"
            + " WHERE t.originalId = :originalId"
            + " AND t.transactionDate = :transactionDate"
            + " AND t.extractVersion > :extractVersion"
            + " AND t.processingStatus != :processingStatus"),
    @NamedQuery(name = "Transaction.getNewestVersionTransaction",
            query = "SELECT MAX(t.extractVersion) FROM Transaction t WHERE t.originalId = :originalId"
            + " AND t.transactionDate = :transactionDate"),
    @NamedQuery(name = "Transaction.getPreviousCount",
            query = "SELECT COUNT (t.id) FROM Transaction t WHERE t.originalId = :originalId and t.transactionDate < :date"),
    /**
     * Zwraca najnowszą datę transakcji dla określonych statusów procesowania.
     */
    @NamedQuery(name = "Transaction.getMaxDateToSend",
            query = "SELECT MAX(t.transactionDate) FROM Transaction t WHERE t.dataToSend = TRUE"),
    /**
     * Zwraca najstarszą datę transakcji dla określonych statusów procesowania.
     */
    @NamedQuery(name = "Transaction.getMinDateToSend",
            query = "SELECT MIN(t.transactionDate) FROM Transaction t WHERE t.dataToSend = TRUE"),
    @NamedQuery(name = "Transaction.getByMaxVersion",
            query = "SELECT t FROM Transaction t WHERE"
            + " t.transactionDate = :transactionDate"
            + " AND t.originalId = :originalId"
            + " AND t.extractVersion = (SELECT MAX(s.extractVersion) FROM Transaction s WHERE s.transactionDate = :transactionDate AND s.originalId = :originalId )"),
    @NamedQuery(name = "Transaction.getByNewestVersion",
            query = "SELECT t FROM Transaction t WHERE t.transactionDate = :transactionDate AND t.originalId = :originalId AND t.newestVersion = TRUE"),
    @NamedQuery(name = "Transaction.getTransactionByImportLog",
            query = "SELECT t FROM Transaction t WHERE t.importLog = :importLog"),
    @NamedQuery(name = "Transaction.getCountTransactionByClient",
            query = "SELECT COUNT(t.id) FROM Transaction t WHERE t.client = :client"),
    @NamedQuery(name = "Transaction.getForStatusTr",
            query = "SELECT COUNT(t.id) FROM Transaction t WHERE t.originalId = :originalId AND t.transactionDate < :reportingDate AND t.processingStatus NOT IN :statusList"),
    @NamedQuery(name = "Transaction.findProcessedByKDPW",
            query = "SELECT t FROM Transaction t WHERE t.transactionDetails.sourceTransId = :tradeIdId"
            + " AND t.newestVersion = TRUE"
            + " AND t.transactionDate ="
            + " (SELECT MAX(t1.transactionDate) FROM Transaction t1 WHERE t1.transactionDetails.sourceTransId = :tradeIdId AND t1.transactionDate <= :transactionDate)"),
    @NamedQuery(name = "Transaction.findNewestVersion",
            query = "SELECT t FROM Transaction t WHERE t.transactionDetails.sourceTransId = :tradeIdId"
            + " AND t.newestVersion = TRUE"
            + " AND (t.transactionDate = :transactionDate"
            + " OR t.transactionDate = :transactionDate1) "
            + " ORDER BY t.transactionDate DESC"),
    @NamedQuery(name = "Transaction.countImported",
            query = "SELECT count(t.id) FROM Transaction t WHERE t.transactionDate = :transactionDate"),
    @NamedQuery(name = "Transaction.countImportedNew",
            query = "SELECT count(t.id) FROM Transaction t WHERE t.transactionDate = :transactionDate AND t.dataType = pl.pd.emir.enums.DataType.NEW"),
    @NamedQuery(name = "Transaction.countImportedMature",
            query = "SELECT count(t.id) FROM Transaction t WHERE t.transactionDate = :transactionDate AND CAST(t.transactionDetails.maturityDate AS date) = :transactionDate"),
    @NamedQuery(name = "Transaction.countKdpwClientReports",
            query = "select count(t.id)*2 from Transaction t where t.alreadySent = TRUE and t.transactionDate = :transactionDate and t.clientData.commercialActity = pl.pd.emir.enums.CommercialActity.Y"),
    @NamedQuery(name = "Transaction.countToKdpwReports",
            query = "select count(t.id) from Transaction t where t.alreadySent = TRUE and t.transactionDate = :transactionDate and t.clientData.commercialActity IS NULL")
})
@Customizer(Transaction.class)
public class Transaction extends Extract implements Logable<Long>, Selectable<Long>, DescriptorCustomizer, Validatable, Historable<Transaction>, Sendable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "commision_seq_gen")
    @SequenceGenerator(name = "commision_seq_gen", sequenceName = "SQ_EMIR_COMMISION", allocationSize = 1000)
    private Long id;

    /**
     * Typ danych: nowa | trwajaca(mutacja) | zakonczona
     */
    @Column(name = "DATA_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private DataType dataType;

    /**
     * Opcjonalne szczegółowe informacje dotyczące transakcji (zmiany)
     */
    @Column(name = "ACTION_TYPE_DETAILS", length = 50, nullable = true)
    private String actionTypeDetails;

    /**
     * Status przetwarzania
     */
    @Column(name = "PROCESSING_STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProcessingStatus processingStatus;

    /**
     * Status poprawnosci
     */
    @Column(name = "VALIDATION_STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private ValidationStatus validationStatus;

    /**
     * ID_TR, Unikalny identyfikator transakcji z ekstraktu [0]
     */
    @ValidateCompleteness(subjectClass = Transaction.class)
    @Column(name = "ORIGINAL_ID", length = 50)
    private String originalId;

    /**
     * DATA_TR, Data waluty [1]
     */
    @ValidateCompleteness(subjectClass = Transaction.class)
    @Column(name = "TRANSACTION_DATE")
    @Temporal(TemporalType.DATE)
    private Date transactionDate;

    /**
     * STATUS_TR, Status transakcji – jaki typ danych ma zostać przekazany w komunikacie [2]
     */
    @ValidateCompleteness(subjectClass = Transaction.class)
    @Column(name = "ORIGINAL_STATUS", length = 3)
    @Enumerated(EnumType.STRING)
    private OriginalStatus originalStatus;

    @Transient
    private String originalClientId;

    @Transient
    private String originalClientId2;

    /**
     * Klient, którego dotyczy transakcja Pole moze byc puste. Zaleznosc ustalana na podstawie pola CLIENT_ID z
     * ekstrakty TRANSAKCJE_E.
     */
    @ValidateCompleteness(subjectClass = Transaction.class)
    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    /**
     * Klient (drugi), którego dotyczy transakcja Pole moze byc puste. Zaleznosc ustalana na podstawie pola CLIENT2_ID z
     * ekstrakty TRANSAKCJE_E.
     */
    @ValidateCompleteness(subjectClass = Transaction.class)
    @ManyToOne
    @JoinColumn(name = "CLIENT2_ID")
    private Client client2;

    /**
     * STRONA_TR, Strona, po której znajduje się kontrahent (client) z punktu widzenia 2 kontrahenta (client2) np. BTMU
     * Druga strona jest odwrotnościa tej
     */
    @Column(name = "TRANSACTION_PARTY", length = 3)
    @Enumerated(EnumType.STRING)
    @TransactionDataChange
    private TransactionParty transactionParty;

    /**
     * POTWIERDZONA, Transakcja potwierdzona lub niepotwierdzona ?? przez klienta
     */
    @Column(name = "CONFIRMED")
    @Enumerated(EnumType.STRING)
    private ConfirmedStatus confirmed;

    /**
     * Dane drugiego kontrahenta (np. BTMU)
     */
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "idCode", column
                = @Column(name = "CLIENT2_ID_CODE")),
        @AttributeOverride(name = "idCodeType", column
                = @Column(name = "CLIENT2_ID_CODE_TYPE")),
        @AttributeOverride(name = "memberId", column
                = @Column(name = "CLIENT2_MEMBER_ID")),
        @AttributeOverride(name = "memberIdType", column
                = @Column(name = "CLIENT2_MEMBER_ID_TYPE")),
        @AttributeOverride(name = "settlingAccout", column
                = @Column(name = "CLIENT2_SETTLING_ACCOUNT")),
        @AttributeOverride(name = "beneficiaryCode", column
                = @Column(name = "CLIENT2_BENEFICIARY_CODE")),
        @AttributeOverride(name = "beneficiaryCodeType", column
                = @Column(name = "CLIENT2_BENEFICIARY_CODE_TYPE")),
        @AttributeOverride(name = "transactionType", column
                = @Column(name = "CLIENT2_TRANSACTION_TYPE")),
        @AttributeOverride(name = "commercialActity", column
                = @Column(name = "CLIENT2_COMMERCIAL_ACTIVITI")),
        @AttributeOverride(name = "settlementThreshold", column
                = @Column(name = "CLIENT2_SETTLEMENT_THRESHOLD")),
        @AttributeOverride(name = "commWalletCode", column
                = @Column(name = "CLIENT2_COMM_WALLET_CODE"))})
    private BusinessEntityData client2Data;

    /**
     * Dane kontrahenta(klienta) [17-27]
     */
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "idCode", column
                = @Column(name = "CLIENT_ID_CODE")),
        @AttributeOverride(name = "idCodeType", column
                = @Column(name = "CLIENT_ID_CODE_TYPE")),
        @AttributeOverride(name = "memberId", column
                = @Column(name = "CLIENT_MEMBER_ID")),
        @AttributeOverride(name = "memberIdType", column
                = @Column(name = "CLIENT_MEMBER_ID_TYPE")),
        @AttributeOverride(name = "settlingAccout", column
                = @Column(name = "CLIENT_SETTLING_ACCOUNT")),
        @AttributeOverride(name = "beneficiaryCode", column
                = @Column(name = "CLIENT_BENEFICIARY_CODE")),
        @AttributeOverride(name = "beneficiaryCodeType", column
                = @Column(name = "CLIENT_BENEFICIARY_CODE_TYPE")),
        @AttributeOverride(name = "transactionType", column
                = @Column(name = "CLIENT_TRANSACTION_TYPE")),
        @AttributeOverride(name = "commercialActity", column
                = @Column(name = "CLIENT_COMMERCIAL_ACTIVITI")),
        @AttributeOverride(name = "settlementThreshold", column
                = @Column(name = "CLIENT_SETTLEMENT_THRESHOLD")),
        @AttributeOverride(name = "commWalletCode", column
                = @Column(name = "CLIENT_COMM_WALLET_CODE"))})
    private BusinessEntityData clientData;

    /**
     * Szczegolowe dane kontraktu (4.2) [30-37]
     */
    @ValidateCompleteness(subjectClass = Transaction.class, entry = true)
    @Embedded
    private ContractDataDetailed contractDetailedData;

    /**
     * Pozostale dane transakcji: ogolne(4.1), szczegoly(4.3), pozostale (4.9) [28-30, 39-55, 85-87]
     */
    @ValidateCompleteness(subjectClass = Transaction.class, entry = true)
    @Embedded
    private TransactionDetails transactionDetails;

    /**
     * Ograniczenie/zglaszanie ryzyka (4.4) [56-57]
     */
    @Embedded
    private RiskReduce riskReduce;

    /**
     * Rozliczanie (4.5) [58-62]
     */
    @ValidateCompleteness(subjectClass = Transaction.class, entry = true)
    @Embedded
    private TransactionClearing transactionClearing;

    /**
     * Stopy procentowe (4.6) [63-70]
     */
    @Embedded
    private PercentageRateData percentageRateData;

    /**
     * Transakcje walutowe (4.7) [71-74]
     */
    @Embedded
    private CurrencyTradeData currencyTradeData;

    /**
     * Zabezpieczenie transakcji
     */
    @ValidateCompleteness(subjectClass = Transaction.class, checkValuationReporting = true, entry = true)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROTECTION_ID")
    private Protection protection;

    /**
     * Wycena transakcji
     */
    @ValidateCompleteness(subjectClass = Transaction.class, checkValuationReporting = true, entry = true)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "VALUATION_ID")
    private Valuation valuation;

    /**
     * Data zasilenia
     */
    @Column(name = "DATE_SUPPLY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSupply;

    /**
     * Wersja ekstraktu z którego wczytano encję.
     */
    @Column(name = "EXTRACT_VERSION", nullable = false)
    private Integer extractVersion;

    /**
     * Czy najnowsza wersja transakcji w dniu.
     */
    @Column(name = "NEWEST_VERSION", nullable = false)
    private Boolean newestVersion;

    /**
     * Dane do wysyłki.
     */
    @Column(name = "DATA_TO_SEND", nullable = false)
    private Boolean dataToSend;

    /**
     * Nazwa pliku, z którego wczytano ekstrakt.
     */
    @Column(name = "FILE_NAME", length = 512, nullable = true)
    private String fileName;

    @Transient
    private transient boolean selected;

    @Column(name = "ALREADY_SENT")
    private Boolean alreadySent;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TRANSACTION_KDPW_MSG",
            joinColumns
            = @JoinColumn(name = "TRANS_ID", referencedColumnName = "ID"),
            inverseJoinColumns
            = @JoinColumn(name = "KDPW_ITEM_ID", referencedColumnName = "ID"))
    private List<KdpwMsgItem> relatedItems;

    @Version
    private Long version;

    @Column(name = "CLIENT_VERSION")
    private Integer clientVersion;
    
    @Column(name = "CLIENT2_VERSION")
    private Integer client2Version;

    public Transaction() {
        super();
        initFields();
        setDataToSend();
    }

    //TODO PAWEL ustawianie clienta na koncu jest bez sensu skoro mamy jego id
    public Transaction(String originalId, Date transactionDate, OriginalStatus originalStatus,
            String originalClientId, TransactionParty clientTransactionParty, String originalClientId2,
            String confirmed, BusinessEntityData client2Data, BusinessEntityData clientData,
            ContractDataDetailed contractDetailedData, TransactionDetails transactionDetails,
            RiskReduce riskReduce, TransactionClearing transactionClearing, PercentageRateData percentageRateData, CurrencyTradeData currencyTradeData,
            DataType dataType, ProcessingStatus processingStatus, ValidationStatus validationStatus, 
            Client client, Client client2) {
        super();
        setFields(originalId, transactionDate, originalStatus,
                originalClientId, clientTransactionParty, originalClientId2,
                StringUtil.isEmpty(confirmed) || confirmed.equals("0") ? ConfirmedStatus.UNCONFIRMED : ConfirmedStatus.CONFIRMED,
                client2Data, clientData, contractDetailedData, transactionDetails,
                riskReduce, transactionClearing, percentageRateData, currencyTradeData,
                dataType, processingStatus, validationStatus, client, client2);
        setDataToSend();
    }

    public Transaction fullClone() {
        Transaction tmp = new Transaction();
        tmp.dataType = this.dataType;
        tmp.processingStatus = this.processingStatus;
        tmp.validationStatus = this.validationStatus;
        tmp.confirmed = this.confirmed;
        tmp.dateSupply = this.dateSupply;
        tmp.originalClientId = this.originalClientId;
        tmp.originalClientId2 = this.originalClientId2;
        tmp.originalId = this.originalId;
        tmp.originalStatus = this.originalStatus;
        tmp.processingStatus = this.processingStatus;
        tmp.transactionDate = this.transactionDate;
        tmp.transactionParty = this.transactionParty;
        //złożone - należy nie przypisaywać referencji dla osobnych encji.
        //relacje
        try {
            tmp.client = this.client.fullClone();
        } catch (NullPointerException e) {
            Client newClient = new Client();
            tmp.client = newClient.fullClone();
        }
        try {
            tmp.client2 = this.client2.fullClone();
        } catch (NullPointerException e) {
            Client newClient = new Client();
            tmp.client2 = newClient.fullClone();
        }
        try {
            tmp.valuation = this.valuation.fullClone();
        } catch (NullPointerException e) {
            Valuation newValuation = new Valuation();
            ValuationData valueData = new ValuationData();
            newValuation.setValuationData(valueData);
            tmp.valuation = newValuation.fullClone();
        }
        try {
            tmp.protection = this.protection.fullClone();
        } catch (NullPointerException e) {
            Protection newProtection = new Protection();
            tmp.protection = newProtection.fullClone();
        }
        //Embedded
        tmp.client2Data = this.client2Data == null ? new BusinessEntityData() : this.client2Data.fullClone();
        tmp.clientData = this.clientData == null ? new BusinessEntityData() : this.clientData.fullClone();
        tmp.contractDetailedData = this.contractDetailedData == null ? new ContractDataDetailed() : this.contractDetailedData.fullClone();
        tmp.currencyTradeData = this.currencyTradeData == null ? new CurrencyTradeData() : this.currencyTradeData.fullClone();
        tmp.percentageRateData = this.percentageRateData == null ? new PercentageRateData() : this.percentageRateData.fullClone();
        tmp.riskReduce = this.riskReduce == null ? new RiskReduce() : this.riskReduce.fullClone();
        tmp.transactionClearing = this.transactionClearing == null ? new TransactionClearing() : this.transactionClearing.fullClone();
        tmp.transactionDetails = this.transactionDetails == null ? new TransactionDetails() : this.transactionDetails.fullClone();

        tmp.setDataToSend();
        return tmp;
    }

    @Override
    public void customize(ClassDescriptor descriptor) {
        ((AggregateObjectMapping) descriptor.getMappingForAttributeName("client2Data")).setIsNullAllowed(false);
        ((AggregateObjectMapping) descriptor.getMappingForAttributeName("clientData")).setIsNullAllowed(false);
        ((AggregateObjectMapping) descriptor.getMappingForAttributeName("contractDetailedData")).setIsNullAllowed(false);
        ((AggregateObjectMapping) descriptor.getMappingForAttributeName("currencyTradeData")).setIsNullAllowed(false);
        ((AggregateObjectMapping) descriptor.getMappingForAttributeName("percentageRateData")).setIsNullAllowed(false);
        ((AggregateObjectMapping) descriptor.getMappingForAttributeName("riskReduce")).setIsNullAllowed(false);
        ((AggregateObjectMapping) descriptor.getMappingForAttributeName("transactionClearing")).setIsNullAllowed(false);
        ((AggregateObjectMapping) descriptor.getMappingForAttributeName("transactionDetails")).setIsNullAllowed(false);
    }

    private void setFields(String originalId, Date transactionDate, OriginalStatus originalStatus,
            String originalClientId, TransactionParty clientTransactionParty, String originalClientId2,
            ConfirmedStatus confirmed, BusinessEntityData client2Data, BusinessEntityData clientData,
            ContractDataDetailed contractDetailedData, TransactionDetails transactionDetails,
            RiskReduce riskReduce, TransactionClearing transactionClearing, PercentageRateData percentageRateData, CurrencyTradeData currencyTradeData,
            DataType dataType, ProcessingStatus processingStatus, ValidationStatus validationStatus, 
            //TODO PAWEL to jest raczej zbedne
            Client client, Client client2) {
        this.originalId = originalId;
        this.transactionDate = transactionDate;
        this.originalStatus = originalStatus;
        this.originalClientId = originalClientId;
        this.transactionParty = clientTransactionParty;
        this.originalClientId2 = originalClientId2;
        this.confirmed = confirmed;
        this.client2Data = client2Data;
        this.clientData = clientData;
        this.transactionDetails = transactionDetails;
        this.riskReduce = riskReduce;
        this.transactionClearing = transactionClearing;
        this.percentageRateData = percentageRateData;
        this.currencyTradeData = currencyTradeData;
        this.dataType = dataType;
        this.processingStatus = processingStatus;
        this.validationStatus = validationStatus;
        this.client = client;
        this.client2 = client2;
        this.contractDetailedData = contractDetailedData;
        if (this.dateSupply == null) {
            this.dateSupply = new Date();
        }
    }

    @Override
    public final void initFields() {
        if (this.client == null) {
            this.client = new Client();
        }
        if (this.client2 == null) {
            this.client2 = new Client();
        }
        if (this.client2Data == null) {
            this.client2Data = new BusinessEntityData();
        }
        if (this.clientData == null) {
            this.clientData = new BusinessEntityData();
        }
        if (this.contractDetailedData == null) {
            this.contractDetailedData = new ContractDataDetailed();
        }
        if (this.transactionDetails == null) {
            this.transactionDetails = new TransactionDetails();
        }
        if (this.riskReduce == null) {
            this.riskReduce = new RiskReduce();
        }
        if (this.transactionClearing == null) {
            this.transactionClearing = new TransactionClearing();
        }
        if (this.percentageRateData == null) {
            this.percentageRateData = new PercentageRateData();
        }
        if (this.currencyTradeData == null) {
            this.currencyTradeData = new CurrencyTradeData();
        }
        if (this.protection == null) {
            this.protection = new Protection();
        }
        if (this.valuation == null) {
            this.valuation = new Valuation();
        }
        if (this.relatedItems == null) {
            this.relatedItems = new ArrayList<>();
        }
    }

    @Override
    public List<ChangeLog> getChangeLogs(Transaction newEntity) {
        List<ChangeLog> result = new ArrayList<>();

        //złożone pola
        Client.checkEntity(result, client, newEntity.client);
        Client.checkEntity(result, client2, newEntity.client2);
        BusinessEntityData.checkEntity(result, client2Data, newEntity.client2Data, true);
        BusinessEntityData.checkEntity(result, clientData, newEntity.clientData, false);
        ContractDataDetailed.checkEntity(result, contractDetailedData, newEntity.contractDetailedData);
        TransactionDetails.checkEntity(result, transactionDetails, newEntity.transactionDetails);
        RiskReduce.checkEntity(result, riskReduce, newEntity.riskReduce);
        TransactionClearing.checkEntity(result, transactionClearing, newEntity.transactionClearing);
        PercentageRateData.checkEntity(result, percentageRateData, newEntity.percentageRateData);
        CurrencyTradeData.checkEntity(result, currencyTradeData, newEntity.currencyTradeData);
        Protection.checkEntity(result, protection, newEntity.protection);
        Valuation.checkEntity(result, valuation, newEntity.valuation);
        //pols proste
        checkFieldsEquals(result, originalId, newEntity.originalId, EventLogBuilder.EventDetailsKey.ORIGINAL_ID);
        checkFieldsEquals(result, originalClientId, newEntity.originalClientId, EventLogBuilder.EventDetailsKey.ORIGINAL_CLIENT_ID);
        checkFieldsEquals(result, originalClientId2, newEntity.originalClientId2, EventLogBuilder.EventDetailsKey.ORIGINAL_CLIENT_ID2);        
        checkFieldsEquals(result, transactionParty, newEntity.transactionParty, EventLogBuilder.EventDetailsKey.TRANSACTION_PARTY);
        if (Objects.nonNull(confirmed) && Objects.nonNull(newEntity.confirmed)) {
            checkFieldsEqualsMsg(result, confirmed.getMsgKey(), newEntity.confirmed.getMsgKey(), EventLogBuilder.EventDetailsKey.CONFIRMED);
        }
        checkFieldsEquals(result, originalStatus, newEntity.originalStatus, EventLogBuilder.EventDetailsKey.ORIGINAL_STATUS);
        if (Objects.nonNull(dataType) && Objects.nonNull(newEntity.dataType)) {
            checkFieldsEqualsMsg(result, dataType.getMsgKey(), newEntity.dataType.getMsgKey(), EventLogBuilder.EventDetailsKey.DATA_TYPE);
        }
        //pola dataset
        checkFieldsEquals(result, dateSupply, newEntity.dateSupply, EventLogBuilder.EventDetailsKey.DATE_SUPPLY);
        checkFieldsEquals(result, transactionDate, newEntity.transactionDate, EventLogBuilder.EventDetailsKey.TRANSACTION_DATE);
        if (Objects.nonNull(processingStatus) && Objects.nonNull(newEntity.processingStatus)) {
            checkFieldsEqualsMsg(result, processingStatus.getMsgKey(), newEntity.processingStatus.getMsgKey(), EventLogBuilder.EventDetailsKey.PROCESSING_STATUS);
        }
        if (Objects.nonNull(getValidationStatus()) && Objects.nonNull(newEntity.getValidationStatus())) {
            checkFieldsEqualsMsg(result, getValidationStatus().getMsgKey(), newEntity.getValidationStatus().getMsgKey(), EventLogBuilder.EventDetailsKey.VALIDATION_STATUS);
        }
        return result;
    }

    /**
     * Zmiana statusu procesowania transakcji na: WYSŁANA.
     */
    public final void sent() {
        this.processingStatus = ProcessingStatus.SENT;
        setDataToSend();
    }

    /**
     * Zmiana statusu procesowania transakcji na: WYSŁANE ANULOWANIE.
     */
    public final void cancellationSent() {
        this.processingStatus = ProcessingStatus.CANCELLATION_SENT;
        setDataToSend();
    }

    /**
     * Zmiana statusu procesowania transakcji na: NIEWYSŁANA.
     */
    public final void unsent() {
        this.processingStatus = ProcessingStatus.UNSENT;
        setDataToSend();
    }

    /**
     * Zmiana statusu procesowania transakcji na: PRZYJĘTA.
     */
    public final void confirm() {
        this.processingStatus = ProcessingStatus.CONFIRMED;
        setDataToSend();
    }

    /**
     * Zmiana statusu procesowania transakcji na: ODRZUCONA.
     */
    public final void reject() {
        this.processingStatus = ProcessingStatus.REJECTED;
        setDataToSend();
    }

    /**
     * Zmiana statusu procesowania transakcji na: CZĘŚCIOWO ODRZUCONA.
     */
    public final void partlyReject() {
        this.processingStatus = ProcessingStatus.PARTLY_REJECTED;
        setDataToSend();
    }

    /**
     * Zmiana statusu procesowania transakcji na: ANULOWANA.
     */
    public final void cancel() {
        this.processingStatus = ProcessingStatus.CANCELED;
        setDataToSend();
    }

    /**
     * Zmiana statusu procesowania transakcji na: ANULOWANA CZĘŚCIOWO.
     */
    public final void partlyCanceled() {
        this.processingStatus = ProcessingStatus.PARTLY_CANCELED;
        setDataToSend();
    }

    public void addKdpwItem(final KdpwMsgItem item) {
        relatedItems.add(item);
        this.alreadySent = Boolean.TRUE;
    }

    public boolean isConfirmed() {
        return ProcessingStatus.CONFIRMED.equals(this.processingStatus);
    }

    public boolean isPartlyCanceled() {
        return ProcessingStatus.PARTLY_CANCELED.equals(this.processingStatus);
    }

    public final String getInfo() {
        final StringBuilder result = new StringBuilder();
        result.append("[ ");
        result.append("Id = ").append(id);
        result.append(", ");
        result.append("originalId = ").append(originalId);
        result.append(", ");
        result.append("transactionDate = ").append(DateUtils.formatDate(transactionDate, DateUtils.DATE_FORMAT));
        result.append(" ]");
        return result.toString();
    }

    protected final void setDataToSend() {
        dataToSend = (processingStatus == ProcessingStatus.NEW || processingStatus == ProcessingStatus.CORRECTED)
                && validationStatus == ValidationStatus.VALID
                && Boolean.TRUE.equals(newestVersion);
    }

    public void setDataToSend(Boolean dataToSend) {
        this.dataToSend = dataToSend;
    }

    public final boolean isNewestExtractVersion() {
        return newestVersion;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public ValidationStatus getValidationStatus() {
        return validationStatus;
    }

    @Override
    public Integer getExtractVersion() {
        return extractVersion;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public String getExtractName() {
        return "TRANSAKCJE_E";
    }

    @Override
    public EventType getDeleteEventType() {
        return EventType.TRANSACTION_DELETE;
    }

    @Override
    public EventType getInsertEventType() {
        return EventType.TRANSACTION_INSERT;
    }

    @Override
    public EventType getModifyEventType() {
        return EventType.TRANSACTION_MODIFICATION;
    }

    // getters
    public EventType getAddMutationEventType() {
        return EventType.TRANSACTION_ADD_MUTATION;
    }

    public EventType getAddValuationEventType() {
        return EventType.TRANSACTION_ADD_VALUATION;
    }

    public TransactionDetails getTransactionDetails() {
        return transactionDetails;
    }

    public TransactionParty getTransactionParty() {
        return transactionParty;
    }

    public OriginalStatus getOriginalStatus() {
        return originalStatus;
    }

    public Protection getProtection() {
        return protection;
    }

    @Override
    public DataType getDataType() {
        return dataType;
    }

    public ProcessingStatus getProcessingStatus() {
        return processingStatus;
    }

    public Valuation getValuation() {
        return valuation;
    }

    @Override
    public Client getClient() {
        return client;
    }

    @Override
    public Client getClient2() {
        return client2;
    }

    public ContractDataDetailed getContractDetailedData() {
        return contractDetailedData;
    }

    public RiskReduce getRiskReduce() {
        return riskReduce;
    }

    public Boolean getDataToSend() {
        return dataToSend;
    }

    //getters
    public TransactionClearing getTransactionClearing() {
        return transactionClearing;
    }

    public Date getDateSupply() {
        return dateSupply;
    }

    public ConfirmedStatus getConfirmed() {
        return confirmed;
    }

    public BusinessEntityData getClient2Data() {
        return client2Data;
    }

    public BusinessEntityData getClientData() {
        return clientData;
    }

    public String getOriginalClientId() {
        return originalClientId;
    }

    public String getOriginalClientId2() {
        return originalClientId2;
    }

    public CurrencyTradeData getCurrencyTradeData() {
        return currencyTradeData;
    }

    @Override
    public String getOriginalId() {
        return originalId;
    }

    public PercentageRateData getPercentageRateData() {
        return percentageRateData;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public List<KdpwMsgItem> getRelatedItems() {
        return relatedItems;
    }

    public Long getVersion() {
        return version;
    }

    public Boolean getAlreadySent() {
        return alreadySent;
    }

    // setters
    public void setExtractVersion(Integer extractVersion) {
        this.extractVersion = extractVersion;
        setDataToSend();
    }

    public void setNewestVersion(Boolean newestVersion) {
        this.newestVersion = newestVersion;
        setDataToSend();
    }

    public void setFileName(final String value) {
        this.fileName = value;
    }

    public void setDateSupply(final Date value) {
        this.dateSupply = value;
    }

    public void setTransactionClearing(final TransactionClearing value) {
        this.transactionClearing = value;
    }

    public void setRiskReduce(final RiskReduce value) {
        this.riskReduce = value;
    }

    public void setContractDetailedData(final ContractDataDetailed value) {
        this.contractDetailedData = value;
    }

    public void setTransactionDate(final Date value) {
        this.transactionDate = value;
        setDataToSend();
    }

    public void setTransactionDetails(final TransactionDetails value) {
        this.transactionDetails = value;
    }

    public void setTransactionParty(final TransactionParty value) {
        this.transactionParty = value;
    }

    public void setOriginalStatus(final OriginalStatus value) {
        this.originalStatus = value;
    }

    public void setProtection(final Protection value) {
        this.protection = value;
    }

    public void setDataType(final DataType value) {
        this.dataType = value;
    }

    public void setProcessingStatus(final ProcessingStatus value) {
        this.processingStatus = value;
        setDataToSend();
    }

    public void setValidationStatus(final ValidationStatus value) {
        this.validationStatus = value;
        setDataToSend();
    }

    public void setValuation(final Valuation value) {
        this.valuation = value;
    }

    public void setClient(final Client value) {
        this.client = value;
    }

    public void setClient2(final Client value) {
        this.client2 = value;
    }

    public void setConfirmed(final ConfirmedStatus value) {
        this.confirmed = value;
    }

    public void setClient2Data(final BusinessEntityData value) {
        this.client2Data = value;
    }

    public void setClientData(final BusinessEntityData value) {
        this.clientData = value;
    }

    public void setCurrencyTradeData(final CurrencyTradeData value) {
        this.currencyTradeData = value;
    }

    public void setOriginalId(final String value) {
        this.originalId = value;
    }

    public void setPercentageRateData(final PercentageRateData value) {
        this.percentageRateData = value;
    }

    public void setRelatedItems(final List<KdpwMsgItem> values) {
        this.relatedItems = values;
    }

    public void setVersion(final Long value) {
        this.version = value;
    }

    public Boolean getNewestVersion() {
        return newestVersion;
    }

    public Integer getClientVersion() {
        return clientVersion;
    }

    public Integer getClient2Version() {
        return client2Version;
    }

    public void setClient2Version(Integer client2Version) {
        this.client2Version = client2Version;
    }
    
    public void setClientVersion(Integer clientVersion) {
        this.clientVersion = clientVersion;
    }

    @Override
    public Transaction getTransaction() {
        return this;
    }

    public String getActionTypeDetails() {
        return actionTypeDetails;
    }

    public void setActionTypeDetails(String actionTypeDetails) {
        this.actionTypeDetails = actionTypeDetails;
    }

}
