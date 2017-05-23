/**
 * 
 */
package es.caib.notib.core.api.ws.notificacio;

import java.io.Serializable;

import es.caib.notib.core.api.dto.NotificaServeiTipusEnumDto;

/**
 * Enumerat que indica el tipus de servei per a un destinatari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public enum ServeiTipusEnum implements Serializable {
	
	NORMAL,
	URGENT;
	
	
	public NotificaServeiTipusEnumDto toServeiTipusEnumDto() {
		
		switch( this ) {
			case NORMAL: return NotificaServeiTipusEnumDto.NORMAL;
			case URGENT: return  NotificaServeiTipusEnumDto.URGENTE;
		}
		
		return null;
	}
	
	public static ServeiTipusEnum toServeiTipusEnum(NotificaServeiTipusEnumDto dto) {
		
		switch( dto ) {
			case NORMAL: return ServeiTipusEnum.NORMAL;
			case URGENTE: return ServeiTipusEnum.URGENT;
		}
		
		return null;
	}
	
}
