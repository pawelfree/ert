//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.26 at 01:49:47 PM CET 
//


package kdpw.xsd.trar_ins_001;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Tekst o maksymalnej długości 208 znaków
 * 
 * <p>Java class for Max208TextOrDelete complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Max208TextOrDelete"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;urn:kdpw:xsd:trar.ins.001.02&gt;Max208Text"&gt;
 *       &lt;attribute name="DeltnInd" type="{urn:kdpw:xsd:trar.ins.001.02}YesNoIndicator" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Max208TextOrDelete", propOrder = {
    "value"
})
public class Max208TextOrDelete {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "DeltnInd")
    protected YesNoIndicator deltnInd;

    public Max208TextOrDelete() {

    }

    public Max208TextOrDelete(String value) {
        this.value = value;
    }

    /**
     * Tekst o maksymalnej długości 208 znaków
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the deltnInd property.
     * 
     * @return
     *     possible object is
     *     {@link YesNoIndicator }
     *     
     */
    public YesNoIndicator getDeltnInd() {
        return deltnInd;
    }

    /**
     * Sets the value of the deltnInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNoIndicator }
     *     
     */
    public void setDeltnInd(YesNoIndicator value) {
        this.deltnInd = value;
    }

}
