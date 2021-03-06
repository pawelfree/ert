//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.31 at 04:37:17 PM CEST 
//


package kdpw.xsd.trar_ins_001;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Describes how interest rates are reported.
 * 
 * <p>Java class for InterestRateContractTerm2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InterestRateContractTerm2"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Unit" type="{urn:kdpw:xsd:trar.ins.001.04}RateBasis1Code"/&gt;
 *         &lt;element name="Val" type="{urn:kdpw:xsd:trar.ins.001.04}Max3Number"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InterestRateContractTerm2", propOrder = {
    "unit",
    "val"
})
public class InterestRateContractTerm2 {

    @XmlElement(name = "Unit", required = true)
    @XmlSchemaType(name = "string")
    protected RateBasis1Code unit;
    @XmlElement(name = "Val", required = true)
    protected BigDecimal val;

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link RateBasis1Code }
     *     
     */
    public RateBasis1Code getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link RateBasis1Code }
     *     
     */
    public void setUnit(RateBasis1Code value) {
        this.unit = value;
    }

    /**
     * Gets the value of the val property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVal() {
        return val;
    }

    /**
     * Sets the value of the val property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVal(BigDecimal value) {
        this.val = value;
    }

}
