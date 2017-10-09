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
 * Specifies the identification of a person or an organisation.
 * 
 * <p>Java class for PersonOrOrganisation2Choice_TR complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonOrOrganisation2Choice_TR"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="LEI" type="{urn:kdpw:xsd:trar.ins.001.03}LEIIdentifier"/&gt;
 *           &lt;element name="Prsn" type="{urn:kdpw:xsd:trar.ins.001.03}PersonIdentification10__1"/&gt;
 *           &lt;element name="ShrtCd" type="{urn:kdpw:xsd:trar.ins.001.03}ShortCode"/&gt;
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
@XmlType(name = "PersonOrOrganisation2Choice_TR", propOrder = {
    "lei",
    "prsn",
    "shrtCd"
})
public class PersonOrOrganisation2ChoiceTR {

    @XmlElement(name = "LEI")
    protected String lei;
    @XmlElement(name = "Prsn")
    protected PersonIdentification101 prsn;
    @XmlElement(name = "ShrtCd")
    protected String shrtCd;

    /**
     * Gets the value of the lei property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLEI() {
        return lei;
    }

    /**
     * Sets the value of the lei property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLEI(String value) {
        this.lei = value;
    }

    /**
     * Gets the value of the prsn property.
     * 
     * @return
     *     possible object is
     *     {@link PersonIdentification101 }
     *     
     */
    public PersonIdentification101 getPrsn() {
        return prsn;
    }

    /**
     * Sets the value of the prsn property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonIdentification101 }
     *     
     */
    public void setPrsn(PersonIdentification101 value) {
        this.prsn = value;
    }

    /**
     * Gets the value of the shrtCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShrtCd() {
        return shrtCd;
    }

    /**
     * Sets the value of the shrtCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShrtCd(String value) {
        this.shrtCd = value;
    }

}
