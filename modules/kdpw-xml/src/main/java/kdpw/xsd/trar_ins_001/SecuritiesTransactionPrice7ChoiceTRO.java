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
 * Choice to define the price of the securities transaction.
 * 
 * <p>Java class for SecuritiesTransactionPrice7Choice_TR_O complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SecuritiesTransactionPrice7Choice_TR_O"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="Unit" type="{urn:kdpw:xsd:trar.ins.001.04}Amount20_SimpleType_Negative"/&gt;
 *           &lt;element name="Pctg" type="{urn:kdpw:xsd:trar.ins.001.04}PercentageRate"/&gt;
 *           &lt;element name="Yld" type="{urn:kdpw:xsd:trar.ins.001.04}PercentageRate"/&gt;
 *           &lt;element name="PdgPric" type="{urn:kdpw:xsd:trar.ins.001.04}IdentificationNotAvailable"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SecuritiesTransactionPrice7Choice_TR_O", propOrder = {
    "unit",
    "pctg",
    "yld",
    "pdgPric"
})
public class SecuritiesTransactionPrice7ChoiceTRO {

    @XmlElement(name = "Unit")
    protected BigDecimal unit;
    @XmlElement(name = "Pctg")
    protected BigDecimal pctg;
    @XmlElement(name = "Yld")
    protected BigDecimal yld;
    @XmlElement(name = "PdgPric")
    @XmlSchemaType(name = "string")
    protected IdentificationNotAvailable pdgPric;

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnit(BigDecimal value) {
        this.unit = value;
    }

    /**
     * Gets the value of the pctg property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPctg() {
        return pctg;
    }

    /**
     * Sets the value of the pctg property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPctg(BigDecimal value) {
        this.pctg = value;
    }

    /**
     * Gets the value of the yld property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getYld() {
        return yld;
    }

    /**
     * Sets the value of the yld property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setYld(BigDecimal value) {
        this.yld = value;
    }

    /**
     * Gets the value of the pdgPric property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationNotAvailable }
     *     
     */
    public IdentificationNotAvailable getPdgPric() {
        return pdgPric;
    }

    /**
     * Sets the value of the pdgPric property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationNotAvailable }
     *     
     */
    public void setPdgPric(IdentificationNotAvailable value) {
        this.pdgPric = value;
    }

}
