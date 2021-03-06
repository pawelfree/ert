//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.30 at 11:11:04 AM GMT 
//


package kdpw.xsd.trar_sts_001_02;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="Ccy2" type="{urn:kdpw:xsd:trar.sts.001.02}CurrencyCode" minOccurs="0"/&gt;
 *         &lt;element name="XchgRate1" type="{urn:kdpw:xsd:trar.sts.001.02}Max10Dec5Signed" minOccurs="0"/&gt;
 *         &lt;element name="FrwrdXchgRate" type="{urn:kdpw:xsd:trar.sts.001.02}Max10Dec5Signed" minOccurs="0"/&gt;
 *         &lt;element name="XchgRateBsis" type="{urn:kdpw:xsd:trar.sts.001.02}Max10Text" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
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

    @XmlElement(name = "Ccy2")
    protected String ccy2;
    @XmlElement(name = "XchgRate1")
    protected BigDecimal xchgRate1;
    @XmlElement(name = "FrwrdXchgRate")
    protected BigDecimal frwrdXchgRate;
    @XmlElement(name = "XchgRateBsis")
    protected String xchgRateBsis;

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
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getXchgRate1() {
        return xchgRate1;
    }

    /**
     * Sets the value of the xchgRate1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setXchgRate1(BigDecimal value) {
        this.xchgRate1 = value;
    }

    /**
     * Gets the value of the frwrdXchgRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFrwrdXchgRate() {
        return frwrdXchgRate;
    }

    /**
     * Sets the value of the frwrdXchgRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFrwrdXchgRate(BigDecimal value) {
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

}
