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
 * Asset class specific details of a derivative.
 * 
 * <p>Java class for AssetClassAttributes1Choice__1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssetClassAttributes1Choice__1"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="Intrst" type="{urn:kdpw:xsd:trar.ins.001.03}DerivativeInterest2"/&gt;
 *           &lt;element name="FX" type="{urn:kdpw:xsd:trar.ins.001.03}DerivativeForeignExchange2"/&gt;
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
@XmlType(name = "AssetClassAttributes1Choice__1", propOrder = {
    "intrst",
    "fx"
})
public class AssetClassAttributes1Choice1 {

    @XmlElement(name = "Intrst")
    protected DerivativeInterest2 intrst;
    @XmlElement(name = "FX")
    protected DerivativeForeignExchange2 fx;

    /**
     * Gets the value of the intrst property.
     * 
     * @return
     *     possible object is
     *     {@link DerivativeInterest2 }
     *     
     */
    public DerivativeInterest2 getIntrst() {
        return intrst;
    }

    /**
     * Sets the value of the intrst property.
     * 
     * @param value
     *     allowed object is
     *     {@link DerivativeInterest2 }
     *     
     */
    public void setIntrst(DerivativeInterest2 value) {
        this.intrst = value;
    }

    /**
     * Gets the value of the fx property.
     * 
     * @return
     *     possible object is
     *     {@link DerivativeForeignExchange2 }
     *     
     */
    public DerivativeForeignExchange2 getFX() {
        return fx;
    }

    /**
     * Sets the value of the fx property.
     * 
     * @param value
     *     allowed object is
     *     {@link DerivativeForeignExchange2 }
     *     
     */
    public void setFX(DerivativeForeignExchange2 value) {
        this.fx = value;
    }

}
