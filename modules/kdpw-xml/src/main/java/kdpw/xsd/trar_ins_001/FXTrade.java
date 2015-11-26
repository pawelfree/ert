//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.26 at 01:49:47 PM CET 
//


package kdpw.xsd.trar_ins_001;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Transakcje walutowe.
 * 				Sekcja wypełniania  dla kontraktów na walutę; jeśli UPI jest raportowane i zawiera wszystkie informacje wskazane poniżej, to ta sekcja nie jest wypełniania /raportowana.
 * 			 
 * 
 * <p>Java class for FXTrade complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FXTrade"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Ccy2" type="{urn:kdpw:xsd:trar.ins.001.02}CurrencyCode"/&gt;
 *         &lt;element name="XchgRate1" type="{urn:kdpw:xsd:trar.ins.001.02}Max10Dec5SignedOrDelete" minOccurs="0"/&gt;
 *         &lt;element name="FrwrdXchgRate" type="{urn:kdpw:xsd:trar.ins.001.02}Max10Dec5SignedOrDelete" minOccurs="0"/&gt;
 *         &lt;element name="XchgRateBsis" type="{urn:kdpw:xsd:trar.ins.001.02}Max10Text"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="DeltnInd" type="{urn:kdpw:xsd:trar.ins.001.02}YesNoIndicator" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FXTrade", propOrder = {
    "ccy2",
    "xchgRate1",
    "frwrdXchgRate",
    "xchgRateBsis"
})
public class FXTrade {

    @XmlElement(name = "Ccy2", required = true)
    protected String ccy2;
    @XmlElement(name = "XchgRate1")
    protected Max10Dec5SignedOrDelete xchgRate1;
    @XmlElement(name = "FrwrdXchgRate")
    protected Max10Dec5SignedOrDelete frwrdXchgRate;
    @XmlElement(name = "XchgRateBsis", required = true)
    protected String xchgRateBsis;
    @XmlAttribute(name = "DeltnInd")
    protected YesNoIndicator deltnInd;

    /**
     * Gets the value of the ccy2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCcy2() {
        return ccy2;
    }

    /**
     * Sets the value of the ccy2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCcy2(String value) {
        this.ccy2 = value;
    }

    /**
     * Gets the value of the xchgRate1 property.
     * 
     * @return
     *     possible object is
     *     {@link Max10Dec5SignedOrDelete }
     *     
     */
    public Max10Dec5SignedOrDelete getXchgRate1() {
        return xchgRate1;
    }

    /**
     * Sets the value of the xchgRate1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max10Dec5SignedOrDelete }
     *     
     */
    public void setXchgRate1(Max10Dec5SignedOrDelete value) {
        this.xchgRate1 = value;
    }

    /**
     * Gets the value of the frwrdXchgRate property.
     * 
     * @return
     *     possible object is
     *     {@link Max10Dec5SignedOrDelete }
     *     
     */
    public Max10Dec5SignedOrDelete getFrwrdXchgRate() {
        return frwrdXchgRate;
    }

    /**
     * Sets the value of the frwrdXchgRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max10Dec5SignedOrDelete }
     *     
     */
    public void setFrwrdXchgRate(Max10Dec5SignedOrDelete value) {
        this.frwrdXchgRate = value;
    }

    /**
     * Gets the value of the xchgRateBsis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXchgRateBsis() {
        return xchgRateBsis;
    }

    /**
     * Sets the value of the xchgRateBsis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXchgRateBsis(String value) {
        this.xchgRateBsis = value;
    }

    /**
     * Gets the value of the deltnInd property.
     * 
     * @return
     *     possible object is
     *     {@link YesNoIndicator }
     *     
     */
    public YesNoIndicator getDeltnInd() {
        return deltnInd;
    }

    /**
     * Sets the value of the deltnInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNoIndicator }
     *     
     */
    public void setDeltnInd(YesNoIndicator value) {
        this.deltnInd = value;
    }

}
