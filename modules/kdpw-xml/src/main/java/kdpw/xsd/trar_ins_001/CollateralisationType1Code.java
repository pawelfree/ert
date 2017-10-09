//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.09 at 11:10:30 AM CEST 
//


package kdpw.xsd.trar_ins_001;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CollateralisationType1Code.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CollateralisationType1Code"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="FC"/&gt;
 *     &lt;enumeration value="OC"/&gt;
 *     &lt;enumeration value="PC"/&gt;
 *     &lt;enumeration value="U"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CollateralisationType1Code")
@XmlEnum
public enum CollateralisationType1Code {


    /**
     * Fully collateralised
     * 
     */
    FC,

    /**
     * One Way Collateralised
     * 
     */
    OC,

    /**
     * Partially Collateralised
     * 
     */
    PC,

    /**
     * uncollateralised
     * 
     */
    U;

    public String value() {
        return name();
    }

    public static CollateralisationType1Code fromValue(String v) {
        return valueOf(v);
    }

}