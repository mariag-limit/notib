package es.caib.notib.core.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.caib.notib.core.entity.PagadorCieEntity;
import es.caib.notib.core.entity.PagadorCieFormatSobreEntity;

/**
 * Definició dels mètodes necessaris per a gestionar una entitat de base
 * de dades del tipus pagador cie.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface PagadorCieFormatSobreRepository extends JpaRepository<PagadorCieFormatSobreEntity, Long> {

	Page<PagadorCieFormatSobreEntity> findByPagadorCie(
			PagadorCieEntity pagadorCie,
			Pageable pageable);
	
	List<PagadorCieFormatSobreEntity> findByPagadorCie(
			PagadorCieEntity pagadorCie);
}
