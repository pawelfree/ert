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
 * Provides the identification of the organisation.
 * 
 * <p>Java class for OrganisationIdentification3Choice__1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganisationIdentification3Choice__1"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="LEI" type="{urn:kdpw:xsd:trar.ins.001.03}LEIIdentifier"/&gt;
 *           &lt;element name="ClntId" type="{urn:kdpw:xsd:trar.ins.001.03}ESMAMax50AlphaNumeric"/&gt;
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
@XmlType(name = "OrganisationIdentification3Choice__1", propOrder = {
    "lei",
    "clntId"
})
public class OrganisationIdentification3Choice1 {

    @XmlElement(name = "LEI")
    protected String lei;
    @XmlElement(name = "ClntId")
    protected String clntId;

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
     * Gets the value of the clntId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClntId() {
        return clntId;
    }

    /**
     * Sets the value of the clntId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClntId(String value) {
        this.clntId = value;
    }

}
