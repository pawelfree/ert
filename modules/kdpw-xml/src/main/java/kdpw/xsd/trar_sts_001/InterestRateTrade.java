//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.26 at 01:49:48 PM CET 
//


package kdpw.xsd.trar_sts_001;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Stopy procentowe.
 * 				Sekcja wypełniania/raportowana  dla kontraktów na stopę procentową walutę; jeśli UPI jest raportowane i zawiera wszystkie informacje wskazane poniżej, to ta sekcja nie jest wypełniania /raportowana.
 * 			 
 * 
 * <p>Java class for InterestRateTrade complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InterestRateTrade"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FxdRateLg1" type="{urn:kdpw:xsd:trar.sts.001.02}Max20Dec5Signed" minOccurs="0"/&gt;
 *         &lt;element name="FxdRateLg2" type="{urn:kdpw:xsd:trar.sts.001.02}Max20Dec5Signed" minOccurs="0"/&gt;
 *         &lt;element name="FxdRateDayCnt" type="{urn:kdpw:xsd:trar.sts.001.02}Max10Text" minOccurs="0"/&gt;
 *         &lt;element name="FxdLgPmtFrqcy" type="{urn:kdpw:xsd:trar.sts.001.02}Max10Text" minOccurs="0"/&gt;
 *         &lt;element name="FltgLgPmtFrqcy" type="{urn:kdpw:xsd:trar.sts.001.02}Max10Text" minOccurs="0"/&gt;
 *         &lt;element name="FltgRateRstFrqcy" type="{urn:kdpw:xsd:trar.sts.001.02}Max10Text" minOccurs="0"/&gt;
 *         &lt;element name="FltgRateLg1" type="{urn:kdpw:xsd:trar.sts.001.02}Max20Text" minOccurs="0"/&gt;
 *         &lt;element name="FltgRateLg2" type="{urn:kdpw:xsd:trar.sts.001.02}Max20Text" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InterestRateTrade", propOrder = {
    "fxdRateLg1",
    "fxdRateLg2",
    "fxdRateDayCnt",
    "fxdLgPmtFrqcy",
    "fltgLgPmtFrqcy",
    "fltgRateRstFrqcy",
    "fltgRateLg1",
    "fltgRateLg2"
})
public class InterestRateTrade {

    @XmlElement(name = "FxdRateLg1")
    protected BigDecimal fxdRateLg1;
    @XmlElement(name = "FxdRateLg2")
    protected BigDecimal fxdRateLg2;
    @XmlElement(name = "FxdRateDayCnt")
    protected String fxdRateDayCnt;
    @XmlElement(name = "FxdLgPmtFrqcy")
    protected String fxdLgPmtFrqcy;
    @XmlElement(name = "FltgLgPmtFrqcy")
    protected String fltgLgPmtFrqcy;
    @XmlElement(name = "FltgRateRstFrqcy")
    protected String fltgRateRstFrqcy;
    @XmlElement(name = "FltgRateLg1")
    protected String fltgRateLg1;
    @XmlElement(name = "FltgRateLg2")
    protected String fltgRateLg2;

    /**
     * Gets the value of the fxdRateLg1 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFxdRateLg1() {
        return fxdRateLg1;
    }

    /**
     * Sets the value of the fxdRateLg1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFxdRateLg1(BigDecimal value) {
        this.fxdRateLg1 = value;
    }

    /**
     * Gets the value of the fxdRateLg2 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFxdRateLg2() {
        return fxdRateLg2;
    }

    /**
     * Sets the value of the fxdRateLg2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFxdRateLg2(BigDecimal value) {
        this.fxdRateLg2 = value;
    }

    /**
     * Gets the value of the fxdRateDayCnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFxdRateDayCnt() {
        return fxdRateDayCnt;
    }

    /**
     * Sets the value of the fxdRateDayCnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFxdRateDayCnt(String value) {
        this.fxdRateDayCnt = value;
    }

    /**
     * Gets the value of the fxdLgPmtFrqcy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFxdLgPmtFrqcy() {
        return fxdLgPmtFrqcy;
    }

    /**
     * Sets the value of the fxdLgPmtFrqcy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFxdLgPmtFrqcy(String value) {
        this.fxdLgPmtFrqcy = value;
    }

    /**
     * Gets the value of the fltgLgPmtFrqcy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFltgLgPmtFrqcy() {
        return fltgLgPmtFrqcy;
    }

    /**
     * Sets the value of the fltgLgPmtFrqcy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFltgLgPmtFrqcy(String value) {
        this.fltgLgPmtFrqcy = value;
    }

    /**
     * Gets the value of the fltgRateRstFrqcy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFltgRateRstFrqcy() {
        return fltgRateRstFrqcy;
    }

    /**
     * Sets the value of the fltgRateRstFrqcy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFltgRateRstFrqcy(String value) {
        this.fltgRateRstFrqcy = value;
    }

    /**
     * Gets the value of the fltgRateLg1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFltgRateLg1() {
        return fltgRateLg1;
    }

    /**
     * Sets the value of the fltgRateLg1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFltgRateLg1(String value) {
        this.fltgRateLg1 = value;
    }

    /**
     * Gets the value of the fltgRateLg2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFltgRateLg2() {
        return fltgRateLg2;
    }

    /**
     * Sets the value of the fltgRateLg2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFltgRateLg2(String value) {
        this.fltgRateLg2 = value;
    }

}
