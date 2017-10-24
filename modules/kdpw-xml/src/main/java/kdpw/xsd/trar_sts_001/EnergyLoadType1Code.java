//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.24 at 06:51:43 PM CEST 
//


package kdpw.xsd.trar_sts_001;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EnergyLoadType1Code.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EnergyLoadType1Code"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="BL"/&gt;
 *     &lt;enumeration value="GD"/&gt;
 *     &lt;enumeration value="BH"/&gt;
 *     &lt;enumeration value="OP"/&gt;
 *     &lt;enumeration value="OT"/&gt;
 *     &lt;enumeration value="PL"/&gt;
 *     &lt;enumeration value="SH"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EnergyLoadType1Code")
@XmlEnum
public enum EnergyLoadType1Code {


    /**
     * Base load.
     * 
     */
    BL,

    /**
     * Gas day.
     * 
     */
    GD,

    /**
     * Hour and block hours.
     * 
     */
    BH,

    /**
     * Off-Peak.
     * 
     * 
     */
    OP,

    /**
     * Other.
     * 
     */
    OT,

    /**
     * Peak load.
     * 
     */
    PL,

    /**
     * Shaped.
     * 
     */
    SH;

    public String value() {
        return name();
    }

    public static EnergyLoadType1Code fromValue(String v) {
        return valueOf(v);
    }

}
