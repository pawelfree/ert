//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.26 at 01:49:47 PM CET 
//


package kdpw.xsd.trar_ins_001;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Identyfikacja transakcji
 * 
 * <p>Java class for TradeIdentification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TradeIdentification"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{urn:kdpw:xsd:trar.ins.001.02}Max52Text"/&gt;
 *         &lt;element name="PrvsId" type="{urn:kdpw:xsd:trar.ins.001.02}Max52TextOrDelete" minOccurs="0"/&gt;
 *         &lt;element name="TradRefNb" type="{urn:kdpw:xsd:trar.ins.001.02}Max40Text" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeIdentification", propOrder = {
    "id",
    "prvsId",
    "tradRefNb"
})
public class TradeIdentification {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "PrvsId")
    protected Max52TextOrDelete prvsId;
    @XmlElement(name = "TradRefNb")
    protected String tradRefNb;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the prvsId property.
     * 
     * @return
     *     possible object is
     *     {@link Max52TextOrDelete }
     *     
     */
    public Max52TextOrDelete getPrvsId() {
        return prvsId;
    }

    /**
     * Sets the value of the prvsId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max52TextOrDelete }
     *     
     */
    public void setPrvsId(Max52TextOrDelete value) {
        this.prvsId = value;
    }

    /**
     * Gets the value of the tradRefNb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTradRefNb() {
        return tradRefNb;
    }

    /**
     * Sets the value of the tradRefNb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTradRefNb(String value) {
        this.tradRefNb = value;
    }

}
