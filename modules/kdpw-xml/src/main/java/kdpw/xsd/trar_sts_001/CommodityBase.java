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
 * <p>Java class for CommodityBase.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommodityBase"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="AG"/&gt;
 *     &lt;enumeration value="EN"/&gt;
 *     &lt;enumeration value="FR"/&gt;
 *     &lt;enumeration value="ME"/&gt;
 *     &lt;enumeration value="IN"/&gt;
 *     &lt;enumeration value="EV"/&gt;
 *     &lt;enumeration value="EX"/&gt;
 *     &lt;enumeration value="OT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CommodityBase")
@XmlEnum
public enum CommodityBase {


    /**
     * AG
     * 
     */
    AG,

    /**
     * EN
     * 
     */
    EN,

    /**
     * FR
     * 
     */
    FR,

    /**
     * ME
     * 
     */
    ME,

    /**
     * IN
     * 
     */
    IN,

    /**
     * EV
     * 
     */
    EV,

    /**
     * EX
     * 
     */
    EX,

    /**
     * OT
     * 
     */
    OT;

    public String value() {
        return name();
    }

    public static CommodityBase fromValue(String v) {
        return valueOf(v);
    }

}
