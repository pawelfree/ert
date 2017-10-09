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
 * Information related to contract and transaction details.
 * 
 * <p>Java class for CommonTradeDataReport_TR_P_N complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommonTradeDataReport_TR_P_N"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CtrctData" type="{urn:kdpw:xsd:trar.ins.001.03}ContractType3__1"/&gt;
 *         &lt;element name="TxData" type="{urn:kdpw:xsd:trar.ins.001.03}TradeTransaction_TR_P_N"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommonTradeDataReport_TR_P_N", propOrder = {
    "ctrctData",
    "txData"
})
public class CommonTradeDataReportTRPN {

    @XmlElement(name = "CtrctData", required = true)
    protected ContractType31 ctrctData;
    @XmlElement(name = "TxData", required = true)
    protected TradeTransactionTRPN txData;

    /**
     * Gets the value of the ctrctData property.
     * 
     * @return
     *     possible object is
     *     {@link ContractType31 }
     *     
     */
    public ContractType31 getCtrctData() {
        return ctrctData;
    }

    /**
     * Sets the value of the ctrctData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractType31 }
     *     
     */
    public void setCtrctData(ContractType31 value) {
        this.ctrctData = value;
    }

    /**
     * Gets the value of the txData property.
     * 
     * @return
     *     possible object is
     *     {@link TradeTransactionTRPN }
     *     
     */
    public TradeTransactionTRPN getTxData() {
        return txData;
    }

    /**
     * Sets the value of the txData property.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeTransactionTRPN }
     *     
     */
    public void setTxData(TradeTransactionTRPN value) {
        this.txData = value;
    }

}
