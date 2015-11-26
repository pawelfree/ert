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
 * Typ kontraktu
 * 
 * <p>Java class for ContractType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContractType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Txnm" type="{urn:kdpw:xsd:trar.ins.001.02}Max1Text"/&gt;
 *         &lt;element name="PrdctId1" type="{urn:kdpw:xsd:trar.ins.001.02}Max20Text"/&gt;
 *         &lt;element name="PrdctId2" type="{urn:kdpw:xsd:trar.ins.001.02}Max20Text" minOccurs="0"/&gt;
 *         &lt;element name="Undrlyg" type="{urn:kdpw:xsd:trar.ins.001.02}UnderlyingDefinition" minOccurs="0"/&gt;
 *         &lt;element name="TechUndrlyg" type="{urn:kdpw:xsd:trar.ins.001.02}Max20TextOrDelete" minOccurs="0"/&gt;
 *         &lt;element name="IssrCtry" type="{urn:kdpw:xsd:trar.ins.001.02}CountryCodeOrDelete" minOccurs="0"/&gt;
 *         &lt;element name="NtnlCcy1" type="{urn:kdpw:xsd:trar.ins.001.02}CurrencyCode" minOccurs="0"/&gt;
 *         &lt;element name="NtnlCcy2" type="{urn:kdpw:xsd:trar.ins.001.02}CurrencyCodeOrDelete" minOccurs="0"/&gt;
 *         &lt;element name="DlvrblCcy" type="{urn:kdpw:xsd:trar.ins.001.02}CurrencyCodeOrDelete" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContractType", propOrder = {
    "txnm",
    "prdctId1",
    "prdctId2",
    "undrlyg",
    "techUndrlyg",
    "issrCtry",
    "ntnlCcy1",
    "ntnlCcy2",
    "dlvrblCcy"
})
public class ContractType {

    @XmlElement(name = "Txnm", required = true)
    protected String txnm;
    @XmlElement(name = "PrdctId1", required = true)
    protected String prdctId1;
    @XmlElement(name = "PrdctId2")
    protected String prdctId2;
    @XmlElement(name = "Undrlyg")
    protected UnderlyingDefinition undrlyg;
    @XmlElement(name = "TechUndrlyg")
    protected Max20TextOrDelete techUndrlyg;
    @XmlElement(name = "IssrCtry")
    protected CountryCodeOrDelete issrCtry;
    @XmlElement(name = "NtnlCcy1")
    protected String ntnlCcy1;
    @XmlElement(name = "NtnlCcy2")
    protected CurrencyCodeOrDelete ntnlCcy2;
    @XmlElement(name = "DlvrblCcy")
    protected CurrencyCodeOrDelete dlvrblCcy;

    /**
     * Gets the value of the txnm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnm() {
        return txnm;
    }

    /**
     * Sets the value of the txnm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnm(String value) {
        this.txnm = value;
    }

    /**
     * Gets the value of the prdctId1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrdctId1() {
        return prdctId1;
    }

    /**
     * Sets the value of the prdctId1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrdctId1(String value) {
        this.prdctId1 = value;
    }

    /**
     * Gets the value of the prdctId2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrdctId2() {
        return prdctId2;
    }

    /**
     * Sets the value of the prdctId2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrdctId2(String value) {
        this.prdctId2 = value;
    }

    /**
     * Gets the value of the undrlyg property.
     * 
     * @return
     *     possible object is
     *     {@link UnderlyingDefinition }
     *     
     */
    public UnderlyingDefinition getUndrlyg() {
        return undrlyg;
    }

    /**
     * Sets the value of the undrlyg property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnderlyingDefinition }
     *     
     */
    public void setUndrlyg(UnderlyingDefinition value) {
        this.undrlyg = value;
    }

    /**
     * Gets the value of the techUndrlyg property.
     * 
     * @return
     *     possible object is
     *     {@link Max20TextOrDelete }
     *     
     */
    public Max20TextOrDelete getTechUndrlyg() {
        return techUndrlyg;
    }

    /**
     * Sets the value of the techUndrlyg property.
     * 
     * @param value
     *     allowed object is
     *     {@link Max20TextOrDelete }
     *     
     */
    public void setTechUndrlyg(Max20TextOrDelete value) {
        this.techUndrlyg = value;
    }

    /**
     * Gets the value of the issrCtry property.
     * 
     * @return
     *     possible object is
     *     {@link CountryCodeOrDelete }
     *     
     */
    public CountryCodeOrDelete getIssrCtry() {
        return issrCtry;
    }

    /**
     * Sets the value of the issrCtry property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryCodeOrDelete }
     *     
     */
    public void setIssrCtry(CountryCodeOrDelete value) {
        this.issrCtry = value;
    }

    /**
     * Gets the value of the ntnlCcy1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNtnlCcy1() {
        return ntnlCcy1;
    }

    /**
     * Sets the value of the ntnlCcy1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNtnlCcy1(String value) {
        this.ntnlCcy1 = value;
    }

    /**
     * Gets the value of the ntnlCcy2 property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCodeOrDelete }
     *     
     */
    public CurrencyCodeOrDelete getNtnlCcy2() {
        return ntnlCcy2;
    }

    /**
     * Sets the value of the ntnlCcy2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCodeOrDelete }
     *     
     */
    public void setNtnlCcy2(CurrencyCodeOrDelete value) {
        this.ntnlCcy2 = value;
    }

    /**
     * Gets the value of the dlvrblCcy property.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyCodeOrDelete }
     *     
     */
    public CurrencyCodeOrDelete getDlvrblCcy() {
        return dlvrblCcy;
    }

    /**
     * Sets the value of the dlvrblCcy property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyCodeOrDelete }
     *     
     */
    public void setDlvrblCcy(CurrencyCodeOrDelete value) {
        this.dlvrblCcy = value;
    }

}
