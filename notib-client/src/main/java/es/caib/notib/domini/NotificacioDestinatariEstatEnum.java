/**
 * 
 */
package es.caib.notib.domini;

import java.io.Serializable;

/**
 * Enumerat que indica l'estat d'una notificació per a un destinatari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public enum NotificacioDestinatariEstatEnum implements Serializable {
	NOTIB_PENDENT,
	NOTIB_ENVIADA,
	ABSENT,
	ADRESA_INCORRECTA,
	DESCONEGUT,
	ENVIADA_CI,
	ENVIADA_DEH,
	ENVIAMENT_PROGRAMAT,
	ENTREGADA_OP,
	ERROR_ENTREGA,
	EXPIRADA,
	EXTRAVIADA,
	MORT,
	LLEGIDA,
	NOTIFICADA,
	PENDENT_ENVIAMENT,
	PENDENT_CIE,
	PENDENT_DEH,
	REBUTJADA,
	SENSE_INFORMACIO;
}
