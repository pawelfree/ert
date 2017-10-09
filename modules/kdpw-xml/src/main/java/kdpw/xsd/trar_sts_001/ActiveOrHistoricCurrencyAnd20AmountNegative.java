//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.09 at 11:10:33 AM CEST 
//


package kdpw.xsd.trar_sts_001;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * A number of monetary units specified in an active or a historic currency where the unit of currency is explicit and compliant with ISO 4217.
 * 
 * <p>Java class for ActiveOrHistoricCurrencyAnd20Amount_Negative complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActiveOrHistoricCurrencyAnd20Amount_Negative"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;urn:kdpw:xsd:trar.sts.001.03&gt;ActiveOrHistoricCurrencyAnd20Amount_SimpleType_N"&gt;
 *       &lt;attribute name="Ccy" use="required" type="{urn:kdpw:xsd:trar.sts.001.03}ActiveOrHistoricCurrencyCode" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActiveOrHistoricCurrencyAnd20Amount_Negative", propOrder = {
    "value"
})
public class ActiveOrHistoricCurrencyAnd20AmountNegative {

    @XmlValue
    protected BigDecimal value;
    @XmlAttribute(name = "Ccy", required = true)
    protected String ccy;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * Gets the value of the ccy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCcy() {
        return ccy;
    }

    /**
     * Sets the value of the ccy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCcy(String value) {
        this.ccy = value;
    }

}
