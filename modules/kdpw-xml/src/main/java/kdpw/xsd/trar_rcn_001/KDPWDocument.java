//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.31 at 04:37:18 PM CEST 
//


package kdpw.xsd.trar_rcn_001;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * KDPW_TR system message 
 * 
 * <p>Java class for KDPWDocument complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KDPWDocument"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="trar.rcn.001.03" type="{urn:kdpw:xsd:trar.rcn.001.03}trar.rcn.001.03" maxOccurs="10000"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Sndr" use="required" type="{urn:kdpw:xsd:trar.rcn.001.03}KDPWMemberIdentifier" /&gt;
 *       &lt;attribute name="Rcvr" use="required" type="{urn:kdpw:xsd:trar.rcn.001.03}KDPWMemberIdentifier" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KDPWDocument", propOrder = {
    "trarRcn00103"
})
public class KDPWDocument {

    @XmlElement(name = "trar.rcn.001.03", required = true)
    protected List<TrarRcn00103> trarRcn00103;
    @XmlAttribute(name = "Sndr", required = true)
    protected String sndr;
    @XmlAttribute(name = "Rcvr", required = true)
    protected String rcvr;

    /**
     * Gets the value of the trarRcn00103 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trarRcn00103 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrarRcn00103().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrarRcn00103 }
     * 
     * 
     */
    public List<TrarRcn00103> getTrarRcn00103() {
        if (trarRcn00103 == null) {
            trarRcn00103 = new ArrayList<TrarRcn00103>();
        }
        return this.trarRcn00103;
    }

    /**
     * Gets the value of the sndr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSndr() {
        return sndr;
    }

    /**
     * Sets the value of the sndr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSndr(String value) {
        this.sndr = value;
    }

    /**
     * Gets the value of the rcvr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRcvr() {
        return rcvr;
    }

    /**
     * Sets the value of the rcvr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRcvr(String value) {
        this.rcvr = value;
    }

}
