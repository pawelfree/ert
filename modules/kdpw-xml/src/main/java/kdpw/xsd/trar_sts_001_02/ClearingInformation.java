//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.30 at 11:11:04 AM GMT 
//


package kdpw.xsd.trar_sts_001_02;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Rozliczanie
 * 
 * <p>Java class for ClearingInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClearingInformation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ClrOblgtn" type="{urn:kdpw:xsd:trar.sts.001.02}Max1Text"/&gt;
 *         &lt;element name="Clrd" type="{urn:kdpw:xsd:trar.sts.001.02}Max1Text" minOccurs="0"/&gt;
 *         &lt;element name="ClrDtTm" type="{urn:kdpw:xsd:trar.sts.001.02}DateAndDateTimeChoice" minOccurs="0"/&gt;
 *         &lt;element name="CCP" type="{urn:kdpw:xsd:trar.sts.001.02}Max20Text" minOccurs="0"/&gt;
 *         &lt;element name="Intrgrp" type="{urn:kdpw:xsd:trar.sts.001.02}Max1Text" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClearingInformation", propOrder = {
    "clrOblgtn",
    "clrd",
    "clrDtTm",
    "ccp",
    "intrgrp"
})
public class ClearingInformation {

    @XmlElement(name = "ClrOblgtn", required = true)
    protected String clrOblgtn;
    @XmlElement(name = "Clrd")
    protected String clrd;
    @XmlElement(name = "ClrDtTm")
    protected DateAndDateTimeChoice clrDtTm;
    @XmlElement(name = "CCP")
    protected String ccp;
    @XmlElement(name = "Intrgrp")
    protected String intrgrp;

    /**
     * Gets the value of the clrOblgtn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClrOblgtn() {
        return clrOblgtn;
    }

    /**
     * Sets the value of the clrOblgtn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClrOblgtn(String value) {
        this.clrOblgtn = value;
    }

    /**
     * Gets the value of the clrd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClrd() {
        return clrd;
    }

    /**
     * Sets the value of the clrd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClrd(String value) {
        this.clrd = value;
    }

    /**
     * Gets the value of the clrDtTm property.
     * 
     * @return
     *     possible object is
     *     {@link DateAndDateTimeChoice }
     *     
     */
    public DateAndDateTimeChoice getClrDtTm() {
        return clrDtTm;
    }

    /**
     * Sets the value of the clrDtTm property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateAndDateTimeChoice }
     *     
     */
    public void setClrDtTm(DateAndDateTimeChoice value) {
        this.clrDtTm = value;
    }

    /**
     * Gets the value of the ccp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCP() {
        return ccp;
    }

    /**
     * Sets the value of the ccp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCP(String value) {
        this.ccp = value;
    }

    /**
     * Gets the value of the intrgrp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntrgrp() {
        return intrgrp;
    }

    /**
     * Sets the value of the intrgrp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntrgrp(String value) {
        this.intrgrp = value;
    }

}
