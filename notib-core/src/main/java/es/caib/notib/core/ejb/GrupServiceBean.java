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

import es.caib.notib.core.api.dto.GrupDto;
import es.caib.notib.core.api.dto.GrupFiltreDto;
import es.caib.notib.core.api.dto.PaginaDto;
import es.caib.notib.core.api.dto.PaginacioParamsDto;
import es.caib.notib.core.api.dto.ProcedimentGrupDto;
import es.caib.notib.core.api.exception.NotFoundException;
import es.caib.notib.core.api.service.GrupService;

/**
 * Implementació de GrupService com a EJB que empra una clase
 * delegada per accedir a la funcionalitat del servei.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class GrupServiceBean implements GrupService {

	@Autowired
	GrupService delegate;

	@Override
	@RolesAllowed({"NOT_ADMIN", "NOT_SUPER"})
	public GrupDto create(
			Long entitatId, 
			GrupDto grup) {
		return delegate.create(
				entitatId,
				grup);
	}

	@Override
	@RolesAllowed({"NOT_ADMIN", "NOT_SUPER"})
	public GrupDto update(GrupDto grup) throws NotFoundException {
		return delegate.update(grup);
	}

	@Override
	@RolesAllowed({"NOT_ADMIN", "NOT_SUPER"})
	public GrupDto delete(Long id) throws NotFoundException {
		return delegate.delete(id);
	}

	@Override
	@RolesAllowed({"NOT_ADMIN", "NOT_SUPER", "NOT_USER"})
	public List<GrupDto> deleteGrupsProcediment(List<GrupDto> grups) throws NotFoundException {
		return delegate.deleteGrupsProcediment(grups);
	}

	@Override
	@RolesAllowed({"NOT_ADMIN", "NOT_SUPER", "NOT_USER", "NOT_APL"})
	public GrupDto findById(Long entitatId, Long id) {
		return delegate.findById(entitatId, id);
	}

	@Override
	@RolesAllowed({"NOT_ADMIN", "NOT_SUPER", "NOT_USER", "NOT_APL"})
	public PaginaDto<ProcedimentGrupDto> findByProcediment(
			Long entitatId, 
			Long procedimentId) {
		return delegate.findByProcediment(
				entitatId, 
				procedimentId);
	}

	@Override
	@RolesAllowed({"NOT_ADMIN", "NOT_SUPER", "NOT_USER", "NOT_APL"})
	public List<GrupDto> findByProcedimentGrups(Long procedimentId) {
		return delegate.findByProcedimentGrups(procedimentId);
	}

	@Override
	@RolesAllowed({"NOT_ADMIN", "NOT_SUPER", "NOT_USER", "NOT_APL"})
	public ProcedimentGrupDto findProcedimentGrupById(
			Long entitatId, 
			Long procedimentGrupId) {
		return delegate.findProcedimentGrupById(
				entitatId, 
				procedimentGrupId);
	}

	@Override
	@RolesAllowed({"NOT_ADMIN", "NOT_SUPER", "NOT_USER", "NOT_APL"})
	public List<GrupDto> findByEntitat(Long entitatId) {
		return delegate.findByEntitat(entitatId);
	}

	@Override
	@RolesAllowed({"NOT_ADMIN", "NOT_SUPER", "NOT_USER"})
	public PaginaDto<GrupDto> findAmbFiltrePaginat(
			Long entitatId, 
			GrupFiltreDto filtre,
			PaginacioParamsDto paginacioParams) {
		return delegate.findAmbFiltrePaginat(
				entitatId, 
				filtre, 
				paginacioParams);
	}

	@Override
	@RolesAllowed({"NOT_ADMIN", "NOT_SUPER", "NOT_USER", "NOT_APL"})
	public List<GrupDto> findAll() {
		return delegate.findAll();
	}

	@Override
	@RolesAllowed({"NOT_ADMIN", "NOT_SUPER", "NOT_USER"})
	public PaginaDto<GrupDto> findAllPaginat(PaginacioParamsDto paginacioParams) {
		return delegate.findAllPaginat(paginacioParams);
	}

	@Override
	@RolesAllowed({"NOT_ADMIN", "NOT_SUPER", "NOT_USER", "NOT_APL"})
	public GrupDto findByCodi(String grupCodi) {
		return delegate.findByCodi(grupCodi);
	}

}
