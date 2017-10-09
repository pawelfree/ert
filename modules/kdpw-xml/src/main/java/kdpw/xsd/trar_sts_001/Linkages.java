//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.09 at 11:10:33 AM CEST 
//


package kdpw.xsd.trar_sts_001;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Linkages to related messages
 * 
 * <p>Java class for Linkages complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Linkages"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PrvsSndrMsgRef" type="{urn:kdpw:xsd:trar.sts.001.03}Max16Text"/&gt;
 *         &lt;element name="TradRefId" type="{urn:kdpw:xsd:trar.sts.001.03}TradeReference" maxOccurs="2" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Linkages", propOrder = {
    "prvsSndrMsgRef",
    "tradRefId"
})
public class Linkages {

    @XmlElement(name = "PrvsSndrMsgRef", required = true)
    protected String prvsSndrMsgRef;
    @XmlElement(name = "TradRefId")
    protected List<TradeReference> tradRefId;

    /**
     * Gets the value of the prvsSndrMsgRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrvsSndrMsgRef() {
        return prvsSndrMsgRef;
    }

    /**
     * Sets the value of the prvsSndrMsgRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrvsSndrMsgRef(String value) {
        this.prvsSndrMsgRef = value;
    }

    /**
     * Gets the value of the tradRefId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tradRefId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTradRefId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TradeReference }
     * 
     * 
     */
    public List<TradeReference> getTradRefId() {
        if (tradRefId == null) {
            tradRefId = new ArrayList<TradeReference>();
        }
        return this.tradRefId;
    }

}
