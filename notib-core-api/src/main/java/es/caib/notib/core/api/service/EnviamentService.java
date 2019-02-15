/**
 * 
 */
package es.caib.notib.core.api.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import es.caib.notib.core.api.dto.ColumnesDto;
import es.caib.notib.core.api.dto.FitxerDto;
import es.caib.notib.core.api.dto.NotificacioEnviamentDto;
import es.caib.notib.core.api.dto.NotificacioEnviamentDtoV2;
import es.caib.notib.core.api.dto.NotificacioEnviamentFiltreDto;
import es.caib.notib.core.api.dto.NotificacioEventDto;
import es.caib.notib.core.api.dto.PaginaDto;
import es.caib.notib.core.api.dto.PaginacioParamsDto;
import es.caib.notib.core.api.dto.UsuariDto;
import es.caib.notib.core.api.exception.NotFoundException;

/**
 * Declaració dels mètodes per a la consulta de notificacions i dels
 * destinataris i events associats.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface EnviamentService {


	/**
	 * Consulta la llista d'ids dels enviaments segons el filtre.
	 * 
	 * @param entitatId
	 *            Atribut id de l'entitat.
	 * @param filtre
	 *            Filtre per a la consulta.
	 * @return La llista amb els ids dels expedients.
	 * @throws NotFoundException
	 *             Si no s'ha trobat l'objecte amb l'id especificat.
	 */
	@PreAuthorize("hasRole('tothom')")
	public List<Long> findIdsAmbFiltre(
			Long entitatId,
			NotificacioEnviamentFiltreDto filtre) throws NotFoundException, ParseException;

	/**
	 * Consulta dels enviaments d'un usuari realitzats d'una notificació.
	 * 
	 * @param notificacioId
	 *            Atribut id de la notificació.
	 * @return els destinataris trobats.
	 */
	@PreAuthorize("hasRole('NOT_ADMIN')")
	public PaginaDto<NotificacioEnviamentDtoV2> enviamentFindByUserAndFiltre(
			NotificacioEnviamentFiltreDto filtre,
			PaginacioParamsDto paginacio) throws ParseException;
	
	/**
	 * Consulta dels enviaments d'una notificació.
	 * 
	 * @param notificacioId
	 *            Atribut id de la notificació.
	 * @return els destinataris trobats.
	 */
	@PreAuthorize("hasRole('NOT_ADMIN')")
	public List<NotificacioEnviamentDto> enviamentFindAmbNotificacio(
			Long notificacioId);

	/**
	 * Consulta d'un enviament donat el seu id.
	 * 
	 * @param enviamentId
	 *            Atribut id de l'enviament.
	 * @return el destinatari trobat.
	 */
	@PreAuthorize("hasRole('NOT_ADMIN')")
	public NotificacioEnviamentDto enviamentFindAmbId(
			Long enviamentId);

	/**
	 * Consulta dels events d'una notificació.
	 * 
	 * @param notificacioId
	 *            Atribut id de la notificació.
	 * @return els events trobats.
	 */
	@PreAuthorize("hasRole('NOT_ADMIN')")
	public List<NotificacioEventDto> eventFindAmbNotificacio(
			Long notificacioId);

	/**
	 * Genera un fitxer d'exportació amb la informació dels expedients.
	 * 
	 * @param entitatId 
	 *            Atribut id de l'entitat.
	 * @param metaExpedientId 
	 *            Atribut id del meta-expedient.
	 * @param expedientIds
	 *            Atribut id dels expedients a exportar.
	 * @param format
	 *            Format pel fitxer d'exportació ("ODS" o "CSV").
	 * @return El fitxer resultant de l'exportació.
	 * @throws IOException
	 *             Si ha sorgit algun problema exportant les dades.
	 * @throws NotFoundException
	 *             Si no s'ha trobat l'objecte amb l'id especificat.
	 */
	@PreAuthorize("hasRole('NOT_ADMIN')")
	public FitxerDto exportacio(
			Long entitatId,
			Collection<Long> enviamentIds,
			String format,
			NotificacioEnviamentFiltreDto filtreCommand) throws IOException, NotFoundException, ParseException;
	
	/**
	 * Crea les columnes s'han de mostrar
	 * 
	 * @param columnes
	 *            Attribut amb les columnes a visualitzar.
	 * @return columnes que s'han de visualitzar.
	 */
	@PreAuthorize("hasRole('NOT_ADMIN')")
	public void columnesCreate(
			UsuariDto usuaris,
			Long entitatId,
			ColumnesDto columnes);
	
	/**
	 * Actualitza les columnes s'han de mostrar
	 * 
	 * @param columnes
	 *            Attribut amb les columnes a visualitzar.
	 * @return columnes que s'han de visualitzar.
	 */
	@PreAuthorize("hasRole('NOT_ADMIN')")
	public void columnesUpdate(
			Long entitatId,
			ColumnesDto columnes);
	
	/**
	 * Obté les columnes visibles per un usuari i entitat
	 * 
	 * @param columnes
	 *            Attribut amb les columnes a visualitzar.
	 * @return columnes que s'han de visualitzar.
	 */
	@PreAuthorize("hasRole('NOT_ADMIN')")
	public ColumnesDto getColumnesUsuari(
			Long entitatId,
			UsuariDto usuari);

}
