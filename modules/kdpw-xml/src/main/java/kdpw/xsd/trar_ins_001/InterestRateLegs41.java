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
 * Details related to interest rate attributes.
 * 
 * <p>Java class for InterestRateLegs4__1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InterestRateLegs4__1"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FrstLeg" type="{urn:kdpw:xsd:trar.ins.001.03}InterestRate11Choice__1" minOccurs="0"/&gt;
 *         &lt;element name="ScndLeg" type="{urn:kdpw:xsd:trar.ins.001.03}InterestRate11Choice__1" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InterestRateLegs4__1", propOrder = {
    "frstLeg",
    "scndLeg"
})
public class InterestRateLegs41 {

    @XmlElement(name = "FrstLeg")
    protected InterestRate11Choice1 frstLeg;
    @XmlElement(name = "ScndLeg")
    protected InterestRate11Choice1 scndLeg;

    /**
     * Gets the value of the frstLeg property.
     * 
     * @return
     *     possible object is
     *     {@link InterestRate11Choice1 }
     *     
     */
    public InterestRate11Choice1 getFrstLeg() {
        return frstLeg;
    }

    /**
     * Sets the value of the frstLeg property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterestRate11Choice1 }
     *     
     */
    public void setFrstLeg(InterestRate11Choice1 value) {
        this.frstLeg = value;
    }

    /**
     * Gets the value of the scndLeg property.
     * 
     * @return
     *     possible object is
     *     {@link InterestRate11Choice1 }
     *     
     */
    public InterestRate11Choice1 getScndLeg() {
        return scndLeg;
    }

    /**
     * Sets the value of the scndLeg property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterestRate11Choice1 }
     *     
     */
    public void setScndLeg(InterestRate11Choice1 value) {
        this.scndLeg = value;
    }

}
