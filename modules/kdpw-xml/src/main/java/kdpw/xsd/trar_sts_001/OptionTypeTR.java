//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.31 at 04:37:18 PM CEST 
//


package kdpw.xsd.trar_sts_001;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OptionType_TR.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OptionType_TR"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="C"/&gt;
 *     &lt;enumeration value="P"/&gt;
 *     &lt;enumeration value="O"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "OptionType_TR")
@XmlEnum
public enum OptionTypeTR {


    /**
     * Right to buy a quantity of an asset for an agreed price at exercise date.
     * 
     */
    C,

    /**
     * Right to sell a quantity of an asset for an agreed price at exercise date.
     * 
     */
    P,

    /**
     * Right where the holder of the option decides whether the option is put or call.
     * 
     */
    O;

    public String value() {
        return name();
    }

    public static OptionTypeTR fromValue(String v) {
        return valueOf(v);
    }

}
