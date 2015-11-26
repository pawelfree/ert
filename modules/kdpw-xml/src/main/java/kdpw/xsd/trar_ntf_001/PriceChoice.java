//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.26 at 01:49:49 PM CET 
//


package kdpw.xsd.trar_ntf_001;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Cena wyrażona w walucie lub stawka procentowa.
 * 			 
 * 
 * <p>Java class for PriceChoice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PriceChoice"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PricRt" type="{urn:kdpw:xsd:trar.ntf.001.01}Max20Dec5Signed"/&gt;
 *         &lt;element name="PricNot" type="{urn:kdpw:xsd:trar.ntf.001.01}Max3Text"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PriceChoice", propOrder = {
    "pricRt",
    "pricNot"
})
public class PriceChoice {

    @XmlElement(name = "PricRt", required = true)
    protected BigDecimal pricRt;
    @XmlElement(name = "PricNot", required = true)
    protected String pricNot;

    /**
     * Gets the value of the pricRt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPricRt() {
        return pricRt;
    }

    /**
     * Sets the value of the pricRt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPricRt(BigDecimal value) {
        this.pricRt = value;
    }

    /**
     * Gets the value of the pricNot property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPricNot() {
        return pricNot;
    }

    /**
     * Sets the value of the pricNot property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPricNot(String value) {
        this.pricNot = value;
    }

}
