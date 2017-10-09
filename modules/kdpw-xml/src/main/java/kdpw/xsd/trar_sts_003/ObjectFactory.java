//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.09 at 11:10:34 AM CEST 
//


package kdpw.xsd.trar_sts_003;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the kdpw.xsd.trar_sts_003 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _KDPWDocument_QNAME = new QName("urn:kdpw:xsd:trar.sts.003.02", "KDPWDocument");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: kdpw.xsd.trar_sts_003
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link KDPWDocument }
     * 
     */
    public KDPWDocument createKDPWDocument() {
        return new KDPWDocument();
    }

    /**
     * Create an instance of {@link CounterpartyTR }
     * 
     */
    public CounterpartyTR createCounterpartyTR() {
        return new CounterpartyTR();
    }

    /**
     * Create an instance of {@link CounterpartyOtherTR }
     * 
     */
    public CounterpartyOtherTR createCounterpartyOtherTR() {
        return new CounterpartyOtherTR();
    }

    /**
     * Create an instance of {@link DateAndDateTimeChoice }
     * 
     */
    public DateAndDateTimeChoice createDateAndDateTimeChoice() {
        return new DateAndDateTimeChoice();
    }

    /**
     * Create an instance of {@link GeneralInformation }
     * 
     */
    public GeneralInformation createGeneralInformation() {
        return new GeneralInformation();
    }

    /**
     * Create an instance of {@link Linkages }
     * 
     */
    public Linkages createLinkages() {
        return new Linkages();
    }

    /**
     * Create an instance of {@link OrganisationIdentification3Choice1 }
     * 
     */
    public OrganisationIdentification3Choice1 createOrganisationIdentification3Choice1() {
        return new OrganisationIdentification3Choice1();
    }

    /**
     * Create an instance of {@link Reason }
     * 
     */
    public Reason createReason() {
        return new Reason();
    }

    /**
     * Create an instance of {@link ReportDetails1 }
     * 
     */
    public ReportDetails1 createReportDetails1() {
        return new ReportDetails1();
    }

    /**
     * Create an instance of {@link Status }
     * 
     */
    public Status createStatus() {
        return new Status();
    }

    /**
     * Create an instance of {@link TradeReference }
     * 
     */
    public TradeReference createTradeReference() {
        return new TradeReference();
    }

    /**
     * Create an instance of {@link TradeTransaction113 }
     * 
     */
    public TradeTransaction113 createTradeTransaction113() {
        return new TradeTransaction113();
    }

    /**
     * Create an instance of {@link TrarSts00302 }
     * 
     */
    public TrarSts00302 createTrarSts00302() {
        return new TrarSts00302();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KDPWDocument }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:kdpw:xsd:trar.sts.003.02", name = "KDPWDocument")
    public JAXBElement<KDPWDocument> createKDPWDocument(KDPWDocument value) {
        return new JAXBElement<KDPWDocument>(_KDPWDocument_QNAME, KDPWDocument.class, null, value);
    }

}
