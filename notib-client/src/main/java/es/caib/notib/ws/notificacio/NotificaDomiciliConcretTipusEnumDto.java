
package es.caib.notib.ws.notificacio;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para notificaDomiciliConcretTipusEnumDto.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="notificaDomiciliConcretTipusEnumDto">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NACIONAL"/>
 *     &lt;enumeration value="ESTRANGER"/>
 *     &lt;enumeration value="APARTAT_CORREUS"/>
 *     &lt;enumeration value="SENSE_NORMALITZAR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "notificaDomiciliConcretTipusEnumDto")
@XmlEnum
public enum NotificaDomiciliConcretTipusEnumDto {

    NACIONAL,
    ESTRANGER,
    APARTAT_CORREUS,
    SENSE_NORMALITZAR;

    public String value() {
        return name();
    }

    public static NotificaDomiciliConcretTipusEnumDto fromValue(String v) {
        return valueOf(v);
    }

}
