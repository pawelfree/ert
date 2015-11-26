//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.26 at 01:49:47 PM CET 
//


package kdpw.xsd.trar_ins_001;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Informacje o wycenie i zabezpieczeniach
 * 
 * <p>Java class for ValuationAndCollateralInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValuationAndCollateralInformation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ValtnInf" type="{urn:kdpw:xsd:trar.ins.001.02}ValuationInformation" minOccurs="0"/&gt;
 *         &lt;element name="CollInf" type="{urn:kdpw:xsd:trar.ins.001.02}CollateralInformation" minOccurs="0"/&gt;
 *         &lt;element name="CtrPtySd" type="{urn:kdpw:xsd:trar.ins.001.02}Max1Text"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValuationAndCollateralInformation", propOrder = {
    "valtnInf",
    "collInf",
    "ctrPtySd"
})
public class ValuationAndCollateralInformation {

    @XmlElement(name = "ValtnInf")
    protected ValuationInformation valtnInf;
    @XmlElement(name = "CollInf")
    protected CollateralInformation collInf;
    @XmlElement(name = "CtrPtySd", required = true)
    protected String ctrPtySd;

    /**
     * Gets the value of the valtnInf property.
     * 
     * @return
     *     possible object is
     *     {@link ValuationInformation }
     *     
     */
    public ValuationInformation getValtnInf() {
        return valtnInf;
    }

    /**
     * Sets the value of the valtnInf property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValuationInformation }
     *     
     */
    public void setValtnInf(ValuationInformation value) {
        this.valtnInf = value;
    }

    /**
     * Gets the value of the collInf property.
     * 
     * @return
     *     possible object is
     *     {@link CollateralInformation }
     *     
     */
    public CollateralInformation getCollInf() {
        return collInf;
    }

    /**
     * Sets the value of the collInf property.
     * 
     * @param value
     *     allowed object is
     *     {@link CollateralInformation }
     *     
     */
    public void setCollInf(CollateralInformation value) {
        this.collInf = value;
    }

    /**
     * Gets the value of the ctrPtySd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCtrPtySd() {
        return ctrPtySd;
    }

    /**
     * Sets the value of the ctrPtySd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCtrPtySd(String value) {
        this.ctrPtySd = value;
    }

}
