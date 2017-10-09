//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.09 at 11:10:33 AM CEST 
//


package kdpw.xsd.trar_sts_001;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CounterpartyTradeNature_TR.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CounterpartyTradeNature_TR"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="F"/&gt;
 *     &lt;enumeration value="N"/&gt;
 *     &lt;enumeration value="C"/&gt;
 *     &lt;enumeration value="O"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CounterpartyTradeNature_TR")
@XmlEnum
public enum CounterpartyTradeNatureTR {


    /**
     * Nature of the reporting counterparty's company activities. 
     * 
     */
    F,

    /**
     * Indicates that reporting counterparty is a financial institution.
     * 
     */
    N,

    /**
     * Indicates that reporting party is a central counterparty.
     * 
     */
    C,

    /**
     * Indicates that reporting party is other type of counterparty.
     * 
     */
    O;

    public String value() {
        return name();
    }

    public static CounterpartyTradeNatureTR fromValue(String v) {
        return valueOf(v);
    }

}
