/**
 * 
 */
package es.caib.notib.core.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.caib.notib.core.api.dto.NotificaEnviamentTipusEnumDto;
import es.caib.notib.core.api.dto.NotificacioComunicacioTipusEnumDto;
import es.caib.notib.core.api.dto.NotificacioEstatEnumDto;
import es.caib.notib.core.entity.NotificacioEntity;

/**
 * Definició dels mètodes necessaris per a gestionar una entitat de base
 * de dades del tipus entitat.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface NotificacioRepository extends JpaRepository<NotificacioEntity, Long> {

	Page<NotificacioEntity> findByEntitatActiva(
			boolean activa,
			Pageable paginacio);

	List<NotificacioEntity> findByEntitatId(
			Long entitatId);

	List<NotificacioEntity> findByCreatedBy_Codi(
			String userCodi);
	
	List<NotificacioEntity> findByEstatOrderByCreatedDateAsc(
			NotificacioEstatEnumDto estat,
			Pageable pageable);

	@Query(
			"from " +
			"    NotificacioEntity " +
			"where " +
			"    comunicacioTipus = es.caib.notib.core.api.dto.NotificacioComunicacioTipusEnumDto.ASINCRON " +
			"and estat = es.caib.notib.core.api.dto.NotificacioEstatEnumDto.PENDENT " +
			"and notificaEnviamentIntent < :maxReintents " +
			"and notificaEnviamentData is not null " +
			"order by " +
			"    notificaEnviamentData ASC")
	List<NotificacioEntity> findByNotificaEstatPendent(@Param("maxReintents")Integer maxReintents, Pageable pageable);

	@Query(	"from " +
			"     NotificacioEntity ntf " +
			"where " +
			"    (:isEntitatIdNull = true or ntf.entitat.id = :entitatId) " +
			"and (:isComunicacioTipusNull = true or ntf.comunicacioTipus = :comunicacioTipus) " +
			"and (:isEnviamentTipusNull = true or ntf.enviamentTipus = :enviamentTipus) " +
			"and (:isConcepteNull = true or lower(ntf.concepte) like concat('%', lower(:concepte), '%')) " +
			"and (:isEstatNull = true or ntf.estat = :estat) " +
			"and (:isDatesNull = true or ntf.createdDate between :dataInici and :dataFi) " +
			"and (:isTitularNull = true or (" +
			"    select count(env.id) " +
			"    from ntf.enviaments env " +
			"    where " +
			"       lower(concat(env.titularNom, ' ', env.titularLlinatge1, ' ', env.destinatariLlinatge2)) like concat('%', lower(:titular), '%') " +
			"    or lower(env.titularNif) like concat('%', lower(:titular), '%') " +
			"    ) > 0) ")
	public Page<NotificacioEntity> findAmbFiltre(
			@Param("isEntitatIdNull") boolean isEntitatIdNull,
			@Param("entitatId") Long entitatId,
			@Param("isComunicacioTipusNull") boolean isComunicacioTipusNull,
			@Param("comunicacioTipus") NotificacioComunicacioTipusEnumDto comunicacioTipus,
			@Param("isEnviamentTipusNull") boolean isEnviamentTipusNull,
			@Param("enviamentTipus") NotificaEnviamentTipusEnumDto enviamentTipus,
			@Param("isConcepteNull") boolean isConcepteNull,
			@Param("concepte") String concepte,
			@Param("isEstatNull") boolean isEstatNull,
			@Param("estat") NotificacioEstatEnumDto estat,
			@Param("isDatesNull") boolean isDatesNull,
			@Param("dataInici") Date dataInici,
			@Param("dataFi") Date dataFi,
			@Param("isTitularNull") boolean isTitularNull,
			@Param("titular") String titular,
			Pageable paginacio);

}
