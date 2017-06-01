/**
 * 
 */
package es.caib.notib.core.ejb;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import es.caib.notib.core.api.dto.NotificacioDestinatariDto;
import es.caib.notib.core.api.dto.NotificacioDto;
import es.caib.notib.core.api.dto.NotificacioEventDto;
import es.caib.notib.core.api.dto.NotificacioFiltreDto;
import es.caib.notib.core.api.dto.PaginaDto;
import es.caib.notib.core.api.dto.PaginacioParamsDto;
import es.caib.notib.core.api.service.NotificacioService;

/**
 * Implementació de EntitatService com a EJB que empra una clase
 * delegada per accedir a la funcionalitat del servei.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class NotificacioServiceBean implements NotificacioService {

	@Autowired
	NotificacioService delegate;

	@Override
	@RolesAllowed({"NOT_ADMIN", "NOT_REP"})
	public NotificacioDto findById(Long id) {
		return delegate.findById(id);
	}

	@Override
	@RolesAllowed({"NOT_ADMIN"})
	public PaginaDto<NotificacioDto> findByFiltrePaginat(
			NotificacioFiltreDto filtre,
			PaginacioParamsDto paginacioParams) {
		return delegate.findByFiltrePaginat(
				filtre,
				paginacioParams);
	}

	@Override
	@RolesAllowed({"NOT_REP"})
	public PaginaDto<NotificacioDto> findByEntitatIFiltrePaginat(
			Long entitatId,
			NotificacioFiltreDto filtre,
			PaginacioParamsDto paginacioParams) {
		return delegate.findByEntitatIFiltrePaginat(
				entitatId,
				filtre,
				paginacioParams);
	}

	@Override
	@RolesAllowed({"NOT_ADMIN", "NOT_REP"})
	public PaginaDto<NotificacioDestinatariDto> destinatariFindByNotificacioPaginat(
			Long notificacioId,
			PaginacioParamsDto paginacioParams) {
		return delegate.destinatariFindByNotificacioPaginat(
				notificacioId,
				paginacioParams);
	}

	@Override
	@RolesAllowed({"NOT_ADMIN", "NOT_REP"})
	public List<NotificacioDestinatariDto> destinatariFindByNotificacio(
			Long notificacioId) {
		return delegate.destinatariFindByNotificacio(notificacioId);
	}

	@Override
	@RolesAllowed({"NOT_ADMIN", "NOT_REP"})
	public NotificacioDestinatariDto destinatariFindById(
			Long destinatariId) {
		return delegate.destinatariFindById(destinatariId);
	}

	@Override
	@RolesAllowed({"NOT_ADMIN", "NOT_REP"})
	public NotificacioDestinatariDto destinatariFindByReferencia(
			String referencia) {
		return delegate.destinatariFindByReferencia(referencia);
	}

	@Override
	@RolesAllowed({"NOT_ADMIN", "NOT_REP"})
	public List<NotificacioEventDto> eventFindByNotificacio(
			Long notificacioId) {
		return delegate.eventFindByNotificacio(notificacioId);
	}

	@Override
	@RolesAllowed({"NOT_ADMIN", "NOT_REP"})
	public List<NotificacioEventDto> eventFindByNotificacioIDestinatari(
			Long notificacioId,
			Long destinatariId) {
		return delegate.eventFindByNotificacioIDestinatari(
				notificacioId,
				destinatariId);
	}

	@Override
	public void seuEnviamentsPendents() {
		delegate.seuEnviamentsPendents();
	}

	@Override
	public void seuJustificantsPendents() {
		delegate.seuJustificantsPendents();
	}

	@Override
	public void seuNotificaComunicarEstatPendents() {
		delegate.seuNotificaComunicarEstatPendents();
	}

}
