//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.09 at 11:10:32 AM CEST 
//


package kdpw.xsd.trar_ntf_001;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Information related to counterparty identification.
 * 
 * <p>Java class for CounterpartyOther_TR complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CounterpartyOther_TR"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{urn:kdpw:xsd:trar.ntf.001.02}OrganisationIdentification3Choice__1"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CounterpartyOther_TR", propOrder = {
    "id"
})
public class CounterpartyOtherTR {

    @XmlElement(name = "Id", required = true)
    protected OrganisationIdentification3Choice1 id;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link OrganisationIdentification3Choice1 }
     *     
     */
    public OrganisationIdentification3Choice1 getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganisationIdentification3Choice1 }
     *     
     */
    public void setId(OrganisationIdentification3Choice1 value) {
        this.id = value;
    }

}