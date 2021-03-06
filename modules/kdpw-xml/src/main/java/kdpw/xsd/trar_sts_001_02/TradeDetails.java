//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.30 at 11:11:04 AM GMT 
//


package kdpw.xsd.trar_sts_001_02;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Szczegóły transakcji
 * 
 * <p>Java class for TradeDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TradeDetails"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TradId" type="{urn:kdpw:xsd:trar.sts.001.02}TradeIdentification" minOccurs="0"/&gt;
 *         &lt;element name="CntrctTp" type="{urn:kdpw:xsd:trar.sts.001.02}ContractType" minOccurs="0"/&gt;
 *         &lt;element name="TradAddtlInf" type="{urn:kdpw:xsd:trar.sts.001.02}TradeAdditionalInformation" minOccurs="0"/&gt;
 *         &lt;element name="RskMtgtn" type="{urn:kdpw:xsd:trar.sts.001.02}RiskMitigation" minOccurs="0"/&gt;
 *         &lt;element name="ClrgInf" type="{urn:kdpw:xsd:trar.sts.001.02}ClearingInformation" minOccurs="0"/&gt;
 *         &lt;element name="IRTrad" type="{urn:kdpw:xsd:trar.sts.001.02}InterestRateTrade" minOccurs="0"/&gt;
 *         &lt;element name="FXTrad" type="{urn:kdpw:xsd:trar.sts.001.02}FXTrade" minOccurs="0"/&gt;
 *         &lt;element name="CmmdtyTrad" type="{urn:kdpw:xsd:trar.sts.001.02}CommodityTrade" minOccurs="0"/&gt;
 *         &lt;element name="OptnTrad" type="{urn:kdpw:xsd:trar.sts.001.02}OptionTrade" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeDetails", propOrder = {
    "tradId",
    "cntrctTp",
    "tradAddtlInf",
    "rskMtgtn",
    "clrgInf",
    "irTrad",
    "fxTrad"
})
public class TradeDetails {

    @XmlElement(name = "TradId")
    protected TradeIdentification tradId;
    @XmlElement(name = "CntrctTp")
    protected ContractType cntrctTp;
    @XmlElement(name = "TradAddtlInf")
    protected TradeAdditionalInformation tradAddtlInf;
    @XmlElement(name = "RskMtgtn")
    protected RiskMitigation rskMtgtn;
    @XmlElement(name = "ClrgInf")
    protected ClearingInformation clrgInf;
    @XmlElement(name = "IRTrad")
    protected InterestRateTrade irTrad;
    @XmlElement(name = "FXTrad")
    protected FXTrade fxTrad;

    /**
     * Gets the value of the tradId property.
     * 
     * @return
     *     possible object is
     *     {@link TradeIdentification }
     *     
     */
    public TradeIdentification getTradId() {
        return tradId;
    }

    /**
     * Sets the value of the tradId property.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeIdentification }
     *     
     */
    public void setTradId(TradeIdentification value) {
        this.tradId = value;
    }

    /**
     * Gets the value of the cntrctTp property.
     * 
     * @return
     *     possible object is
     *     {@link ContractType }
     *     
     */
    public ContractType getCntrctTp() {
        return cntrctTp;
    }

    /**
     * Sets the value of the cntrctTp property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractType }
     *     
     */
    public void setCntrctTp(ContractType value) {
        this.cntrctTp = value;
    }

    /**
     * Gets the value of the tradAddtlInf property.
     * 
     * @return
     *     possible object is
     *     {@link TradeAdditionalInformation }
     *     
     */
    public TradeAdditionalInformation getTradAddtlInf() {
        return tradAddtlInf;
    }

    /**
     * Sets the value of the tradAddtlInf property.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeAdditionalInformation }
     *     
     */
    public void setTradAddtlInf(TradeAdditionalInformation value) {
        this.tradAddtlInf = value;
    }

    /**
     * Gets the value of the rskMtgtn property.
     * 
     * @return
     *     possible object is
     *     {@link RiskMitigation }
     *     
     */
    public RiskMitigation getRskMtgtn() {
        return rskMtgtn;
    }

    /**
     * Sets the value of the rskMtgtn property.
     * 
     * @param value
     *     allowed object is
     *     {@link RiskMitigation }
     *     
     */
    public void setRskMtgtn(RiskMitigation value) {
        this.rskMtgtn = value;
    }

    /**
     * Gets the value of the clrgInf property.
     * 
     * @return
     *     possible object is
     *     {@link ClearingInformation }
     *     
     */
    public ClearingInformation getClrgInf() {
        return clrgInf;
    }

    /**
     * Sets the value of the clrgInf property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClearingInformation }
     *     
     */
    public void setClrgInf(ClearingInformation value) {
        this.clrgInf = value;
    }

    /**
     * Gets the value of the irTrad property.
     * 
     * @return
     *     possible object is
     *     {@link InterestRateTrade }
     *     
     */
    public InterestRateTrade getIRTrad() {
        return irTrad;
    }

    /**
     * Sets the value of the irTrad property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterestRateTrade }
     *     
     */
    public void setIRTrad(InterestRateTrade value) {
        this.irTrad = value;
    }

    /**
     * Gets the value of the fxTrad property.
     * 
     * @return
     *     possible object is
     *     {@link FXTrade }
     *     
     */
    public FXTrade getFXTrad() {
        return fxTrad;
    }

    /**
     * Sets the value of the fxTrad property.
     * 
     * @param value
     *     allowed object is
     *     {@link FXTrade }
     *     
     */
    public void setFXTrad(FXTrade value) {
        this.fxTrad = value;
    }

}
