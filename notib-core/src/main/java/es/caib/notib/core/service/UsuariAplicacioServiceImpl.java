/**
 * 
 */
package es.caib.notib.core.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.caib.notib.core.api.dto.AplicacioDto;
import es.caib.notib.core.api.dto.PaginaDto;
import es.caib.notib.core.api.dto.PaginacioParamsDto;
import es.caib.notib.core.api.exception.NotFoundException;
import es.caib.notib.core.api.service.UsuariAplicacioService;
import es.caib.notib.core.entity.AplicacioEntity;
import es.caib.notib.core.helper.ConversioTipusHelper;
import es.caib.notib.core.helper.EntityComprovarHelper;
import es.caib.notib.core.helper.PaginacioHelper;
import es.caib.notib.core.repository.AplicacioRepository;

/**
 * Implementació del servei de gestió d'entitats.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class UsuariAplicacioServiceImpl implements UsuariAplicacioService {
	
	@Resource
	private AplicacioRepository aplicacioRepository;
	@Resource
	private EntityComprovarHelper entityComprovarHelper;
	@Resource
	private ConversioTipusHelper conversioTipusHelper;
	@Resource
	private PaginacioHelper paginacioHelper;
	
	
	@Override
	@Transactional
	public AplicacioDto create(AplicacioDto aplicacio) {
		
		logger.debug("Creant una nova aplicació (aplicació=" + aplicacio.toString() + ")");
		
		entityComprovarHelper.comprovarPermisos(
				null,
				true,
				false );
		
		AplicacioEntity entity = AplicacioEntity.getBuilder(
				aplicacio.getUsuariCodi(),
				aplicacio.getCallbackUrl()
				).build();
		
		return conversioTipusHelper.convertir(
				aplicacioRepository.save(entity),
				AplicacioDto.class);
		
	}
	
	@Override
	@Transactional
	public AplicacioDto update(AplicacioDto aplicacio) throws NotFoundException {
		
		logger.debug("Actualitzant l'aplicació existent (aplicacio=" + aplicacio.toString() + ")");
		
		entityComprovarHelper.comprovarPermisos(
				null,
				true,
				false );
		
		AplicacioEntity entity = aplicacioRepository.findOne(aplicacio.getId());
		
		entity.update(
				aplicacio.getUsuariCodi(),
				aplicacio.getCallbackUrl());
		
		return conversioTipusHelper.convertir(
				entity,
				AplicacioDto.class);
		
	}
	
	@Override
	@Transactional
	public AplicacioDto delete(Long id) throws NotFoundException {
		
		logger.debug("Esborrant aplicacio (id=" + id +  ")");
		
		entityComprovarHelper.comprovarPermisos(
				null,
				true,
				false );
		
		AplicacioEntity entity = aplicacioRepository.findOne( id );
		
		aplicacioRepository.delete(entity);
		
		return conversioTipusHelper.convertir(
				entity,
				AplicacioDto.class);
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public AplicacioDto findById(Long aplicacioId) {
		
		logger.debug("Consulta una aplicació amb id = " + aplicacioId.toString());
		
		entityComprovarHelper.comprovarPermisos(
				null,
				true,
				false );
		
		AplicacioEntity entity = aplicacioRepository.findOne(aplicacioId);
		
		return conversioTipusHelper.convertir(
				entity,
				AplicacioDto.class);
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public AplicacioDto findByUsuariCodi(String usuariCodi) {

		logger.debug("Consulta una aplicació amb codi = " + usuariCodi);
		
		entityComprovarHelper.comprovarPermisos(
				null,
				true,
				false );
		
		AplicacioEntity entity = aplicacioRepository.findByUsuariCodi(usuariCodi);
		
		return conversioTipusHelper.convertir(
				entity,
				AplicacioDto.class);
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public PaginaDto<AplicacioDto> findPaginat(PaginacioParamsDto paginacioParams) {
		
		logger.debug("Consulta de un llistat paginat de totes les aplicacions");
		
		entityComprovarHelper.comprovarPermisos(
				null,
				true,
				false );
		
		Page<AplicacioEntity> aplicacions = aplicacioRepository.findAll(
				paginacioHelper.toSpringDataPageable(paginacioParams)
				);
		
		return paginacioHelper.toPaginaDto(
				aplicacions,
				AplicacioDto.class);
		
	}
	
	
	private static final Logger logger = LoggerFactory.getLogger(UsuariAplicacioServiceImpl.class);
	
	
}
