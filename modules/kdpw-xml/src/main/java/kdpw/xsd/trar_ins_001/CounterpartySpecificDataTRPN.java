//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.09 at 11:10:30 AM CEST 
//


package kdpw.xsd.trar_ins_001;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Data related specifically to counterparty.
 * 
 * <p>Java class for CounterpartySpecificData_TR_P_N complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CounterpartySpecificData_TR_P_N"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CtrPty" type="{urn:kdpw:xsd:trar.ins.001.03}Counterparty_TR_P_N"/&gt;
 *         &lt;element name="Valtn" type="{urn:kdpw:xsd:trar.ins.001.03}ContractValuationData_TR_N" minOccurs="0"/&gt;
 *         &lt;element name="Coll" type="{urn:kdpw:xsd:trar.ins.001.03}TradeCollateralReport_TR_N" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CounterpartySpecificData_TR_P_N", propOrder = {
    "ctrPty",
    "valtn",
    "coll"
})
public class CounterpartySpecificDataTRPN {

    @XmlElement(name = "CtrPty", required = true)
    protected CounterpartyTRPN ctrPty;
    @XmlElement(name = "Valtn")
    protected ContractValuationDataTRN valtn;
    @XmlElement(name = "Coll")
    protected TradeCollateralReportTRN coll;

    /**
     * Gets the value of the ctrPty property.
     * 
     * @return
     *     possible object is
     *     {@link CounterpartyTRPN }
     *     
     */
    public CounterpartyTRPN getCtrPty() {
        return ctrPty;
    }

    /**
     * Sets the value of the ctrPty property.
     * 
     * @param value
     *     allowed object is
     *     {@link CounterpartyTRPN }
     *     
     */
    public void setCtrPty(CounterpartyTRPN value) {
        this.ctrPty = value;
    }

    /**
     * Gets the value of the valtn property.
     * 
     * @return
     *     possible object is
     *     {@link ContractValuationDataTRN }
     *     
     */
    public ContractValuationDataTRN getValtn() {
        return valtn;
    }

    /**
     * Sets the value of the valtn property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractValuationDataTRN }
     *     
     */
    public void setValtn(ContractValuationDataTRN value) {
        this.valtn = value;
    }

    /**
     * Gets the value of the coll property.
     * 
     * @return
     *     possible object is
     *     {@link TradeCollateralReportTRN }
     *     
     */
    public TradeCollateralReportTRN getColl() {
        return coll;
    }

    /**
     * Sets the value of the coll property.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeCollateralReportTRN }
     *     
     */
    public void setColl(TradeCollateralReportTRN value) {
        this.coll = value;
    }

}