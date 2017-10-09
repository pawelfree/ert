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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Information related to contract attributes.
 * 
 * <p>Java class for ContractType4__2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContractType4__2"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CtrctTp" type="{urn:kdpw:xsd:trar.ins.001.03}FinancialInstrumentContractType2Code" minOccurs="0"/&gt;
 *         &lt;element name="AsstClss" type="{urn:kdpw:xsd:trar.ins.001.03}ProductType4Code__1" minOccurs="0"/&gt;
 *         &lt;element name="CtrctDtls" type="{urn:kdpw:xsd:trar.ins.001.03}ContractDetails_TR_M" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContractType4__2", propOrder = {
    "ctrctTp",
    "asstClss",
    "ctrctDtls"
})
public class ContractType42 {

    @XmlElement(name = "CtrctTp")
    @XmlSchemaType(name = "string")
    protected FinancialInstrumentContractType2Code ctrctTp;
    @XmlElement(name = "AsstClss")
    @XmlSchemaType(name = "string")
    protected ProductType4Code1 asstClss;
    @XmlElement(name = "CtrctDtls")
    protected ContractDetailsTRM ctrctDtls;

    /**
     * Gets the value of the ctrctTp property.
     * 
     * @return
     *     possible object is
     *     {@link FinancialInstrumentContractType2Code }
     *     
     */
    public FinancialInstrumentContractType2Code getCtrctTp() {
        return ctrctTp;
    }

    /**
     * Sets the value of the ctrctTp property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialInstrumentContractType2Code }
     *     
     */
    public void setCtrctTp(FinancialInstrumentContractType2Code value) {
        this.ctrctTp = value;
    }

    /**
     * Gets the value of the asstClss property.
     * 
     * @return
     *     possible object is
     *     {@link ProductType4Code1 }
     *     
     */
    public ProductType4Code1 getAsstClss() {
        return asstClss;
    }

    /**
     * Sets the value of the asstClss property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductType4Code1 }
     *     
     */
    public void setAsstClss(ProductType4Code1 value) {
        this.asstClss = value;
    }

    /**
     * Gets the value of the ctrctDtls property.
     * 
     * @return
     *     possible object is
     *     {@link ContractDetailsTRM }
     *     
     */
    public ContractDetailsTRM getCtrctDtls() {
        return ctrctDtls;
    }

    /**
     * Sets the value of the ctrctDtls property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractDetailsTRM }
     *     
     */
    public void setCtrctDtls(ContractDetailsTRM value) {
        this.ctrctDtls = value;
    }

}
