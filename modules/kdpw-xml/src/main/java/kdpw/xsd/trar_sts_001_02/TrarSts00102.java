//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.30 at 11:11:04 AM GMT 
//


package kdpw.xsd.trar_sts_001_02;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Komunikat ze statusem zgłoszenia do Repozytorium
 * 
 * <p>Java class for trar.sts.001.02 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trar.sts.001.02"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GnlInf" type="{urn:kdpw:xsd:trar.sts.001.02}GeneralInformation"/&gt;
 *         &lt;element name="Sts" type="{urn:kdpw:xsd:trar.sts.001.02}Status"/&gt;
 *         &lt;element name="CtrPtyInf" type="{urn:kdpw:xsd:trar.sts.001.02}CounterpartyInformation" maxOccurs="2" minOccurs="0"/&gt;
 *         &lt;element name="ValtnAndCollInf" type="{urn:kdpw:xsd:trar.sts.001.02}ValuationAndCollateralInformation" maxOccurs="2" minOccurs="0"/&gt;
 *         &lt;element name="TradDtls" type="{urn:kdpw:xsd:trar.sts.001.02}TradeDetails" minOccurs="0"/&gt;
 *         &lt;element name="RcrdSts" type="{urn:kdpw:xsd:trar.sts.001.02}Max1Text" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trar.sts.001.02", propOrder = {
    "gnlInf",
    "sts",
    "ctrPtyInf",
    "valtnAndCollInf",
    "tradDtls",
    "rcrdSts"
})
public class TrarSts00102 {

    @XmlElement(name = "GnlInf", required = true)
    protected GeneralInformation gnlInf;
    @XmlElement(name = "Sts", required = true)
    protected Status sts;
    @XmlElement(name = "CtrPtyInf")
    protected List<CounterpartyInformation> ctrPtyInf;
    @XmlElement(name = "ValtnAndCollInf")
    protected List<ValuationAndCollateralInformation> valtnAndCollInf;
    @XmlElement(name = "TradDtls")
    protected TradeDetails tradDtls;
    @XmlElement(name = "RcrdSts")
    protected String rcrdSts;

    /**
     * Gets the value of the gnlInf property.
     * 
     * @return
     *     possible object is
     *     {@link GeneralInformation }
     *     
     */
    public GeneralInformation getGnlInf() {
        return gnlInf;
    }

    /**
     * Sets the value of the gnlInf property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneralInformation }
     *     
     */
    public void setGnlInf(GeneralInformation value) {
        this.gnlInf = value;
    }

    /**
     * Gets the value of the sts property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getSts() {
        return sts;
    }

    /**
     * Sets the value of the sts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setSts(Status value) {
        this.sts = value;
    }

    /**
     * Gets the value of the ctrPtyInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ctrPtyInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCtrPtyInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CounterpartyInformation }
     * 
     * 
     */
    public List<CounterpartyInformation> getCtrPtyInf() {
        if (ctrPtyInf == null) {
            ctrPtyInf = new ArrayList<CounterpartyInformation>();
        }
        return this.ctrPtyInf;
    }

    /**
     * Gets the value of the valtnAndCollInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valtnAndCollInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValtnAndCollInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValuationAndCollateralInformation }
     * 
     * 
     */
    public List<ValuationAndCollateralInformation> getValtnAndCollInf() {
        if (valtnAndCollInf == null) {
            valtnAndCollInf = new ArrayList<ValuationAndCollateralInformation>();
        }
        return this.valtnAndCollInf;
    }

    /**
     * Gets the value of the tradDtls property.
     * 
     * @return
     *     possible object is
     *     {@link TradeDetails }
     *     
     */
    public TradeDetails getTradDtls() {
        return tradDtls;
    }

    /**
     * Sets the value of the tradDtls property.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeDetails }
     *     
     */
    public void setTradDtls(TradeDetails value) {
        this.tradDtls = value;
    }

    /**
     * Gets the value of the rcrdSts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRcrdSts() {
        return rcrdSts;
    }

    /**
     * Sets the value of the rcrdSts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRcrdSts(String value) {
        this.rcrdSts = value;
    }

}
