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


/**
 * Identyfikator instytucji
 * 
 * <p>Java class for InstitutionCodeOrDelete complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InstitutionCodeOrDelete"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:kdpw:xsd:trar.ins.001.02}InstitutionCode"&gt;
 *       &lt;attribute name="DeltnInd" type="{urn:kdpw:xsd:trar.ins.001.02}YesNoIndicator" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InstitutionCodeOrDelete")
public class InstitutionCodeOrDelete
    extends InstitutionCode
{

    @XmlAttribute(name = "DeltnInd")
    protected YesNoIndicator deltnInd;

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
