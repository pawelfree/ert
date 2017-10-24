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
 * <p>Java class for ProductType4Code.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ProductType4Code"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CRDT"/&gt;
 *     &lt;enumeration value="CURR"/&gt;
 *     &lt;enumeration value="EQUI"/&gt;
 *     &lt;enumeration value="INTR"/&gt;
 *     &lt;enumeration value="COMM"/&gt;
 *     &lt;enumeration value="OTHR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ProductType4Code")
@XmlEnum
public enum ProductType4Code {


    /**
     * Identifies categories of instruments that are credits.
     * 
     */
    CRDT,

    /**
     * Identifies categories of currency instruments.
     * 
     */
    CURR,

    /**
     * Identifies the nature or type of an equity.
     * 
     */
    EQUI,

    /**
     * Identifies categories of instruments that are interest rates based.
     * 
     */
    INTR,

    /**
     * Identifies categories of instruments that are commodities.
     * 
     */
    COMM,

    /**
     * The asset type is other.
     * 
     */
    OTHR;

    public String value() {
        return name();
    }

    public static ProductType4Code fromValue(String v) {
        return valueOf(v);
    }

}
