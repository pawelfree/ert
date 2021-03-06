//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.31 at 04:37:19 PM CEST 
//
package kdpw.xsd.trar_ack_001;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import kdpw.xsd.IKDPWDocument;

/**
 * Komunikat systemu KDPW
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
 *         &lt;element name="trar.ack.001.01" type="{urn:kdpw:xsd:trar.ack.001.01}trar.ack.001.01" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Sndr" use="required" type="{urn:kdpw:xsd:trar.ack.001.01}KDPWMemberIdentifier" /&gt;
 *       &lt;attribute name="Rcvr" use="required" type="{urn:kdpw:xsd:trar.ack.001.01}KDPWMemberIdentifier" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlRootElement(name = "KDPWDocument")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KDPWDocument", propOrder = {
    "trarAck00101"
})
public class KDPWDocument implements IKDPWDocument {

    @XmlElement(name = "trar.ack.001.01", required = true)
    protected List<TrarAck00101> trarAck00101;
    @XmlAttribute(name = "Sndr", required = true)
    protected String sndr;
    @XmlAttribute(name = "Rcvr", required = true)
    protected String rcvr;

    /**
     * Gets the value of the trarAck00101 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trarAck00101 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrarAck00101().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrarAck00101 }
     * 
     * 
     */
    public List<TrarAck00101> getTrarAck00101() {
        if (trarAck00101 == null) {
            trarAck00101 = new ArrayList<TrarAck00101>();
        }
        return this.trarAck00101;
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
