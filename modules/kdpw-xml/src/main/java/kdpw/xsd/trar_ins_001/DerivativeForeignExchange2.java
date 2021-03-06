//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.31 at 04:37:17 PM CEST 
//


package kdpw.xsd.trar_ins_001;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Attributes of non-financial instrument of type foreign exchange as underlying.
 * 
 * <p>Java class for DerivativeForeignExchange2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DerivativeForeignExchange2"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OthrNtnlCcy" type="{urn:kdpw:xsd:trar.ins.001.04}ActiveOrHistoricCurrencyCode"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DerivativeForeignExchange2", propOrder = {
    "othrNtnlCcy"
})
public class DerivativeForeignExchange2 {

    @XmlElement(name = "OthrNtnlCcy", required = true)
    protected String othrNtnlCcy;

    /**
     * Gets the value of the othrNtnlCcy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOthrNtnlCcy() {
        return othrNtnlCcy;
    }

    /**
     * Sets the value of the othrNtnlCcy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOthrNtnlCcy(String value) {
        this.othrNtnlCcy = value;
    }

}
