//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.09 at 11:10:33 AM CEST 
//


package kdpw.xsd.trar_sts_001;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Specifies time and type of contract confirmation.
 * 
 * <p>Java class for TradeConfirmation_TR complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TradeConfirmation_TR"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Tp" type="{urn:kdpw:xsd:trar.sts.001.03}TradeConfirmationType_RT" minOccurs="0"/&gt;
 *         &lt;element name="TmStmp" type="{urn:kdpw:xsd:trar.sts.001.03}ISONormalisedDateTime" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeConfirmation_TR", propOrder = {
    "tp",
    "tmStmp"
})
public class TradeConfirmationTR {

    @XmlElement(name = "Tp")
    @XmlSchemaType(name = "string")
    protected TradeConfirmationTypeRT tp;
    @XmlElement(name = "TmStmp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tmStmp;

    /**
     * Gets the value of the tp property.
     * 
     * @return
     *     possible object is
     *     {@link TradeConfirmationTypeRT }
     *     
     */
    public TradeConfirmationTypeRT getTp() {
        return tp;
    }

    /**
     * Sets the value of the tp property.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeConfirmationTypeRT }
     *     
     */
    public void setTp(TradeConfirmationTypeRT value) {
        this.tp = value;
    }

    /**
     * Gets the value of the tmStmp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTmStmp() {
        return tmStmp;
    }

    /**
     * Sets the value of the tmStmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTmStmp(XMLGregorianCalendar value) {
        this.tmStmp = value;
    }

}
