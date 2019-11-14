/**
 * 
 */
package es.caib.notib.core.api.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Informació d'una anotació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class NotificacioDtoV2 extends AuditoriaDto {

	private Long id;
	private String emisorDir3Codi;
	private NotificaEnviamentTipusEnumDto enviamentTipus;
	private String concepte;
	private String descripcio;
	private Date enviamentDataProgramada;
	private Integer retard;
	protected int notificaEnviamentIntent;
	private Date caducitat;
	private DocumentDto document;
	private String csv_uuid;
	private ProcedimentDto procediment;
	private String procedimentCodiNotib;
	private GrupDto grup;
	private String grupCodi;
	private NotificacioEstatEnumDto estat;
	private Date notificaErrorData;
	private String notificaErrorDescripcio;
	private String serveiTipus;
	private List<NotificacioEnviamentDtoV2> enviaments = new ArrayList<NotificacioEnviamentDtoV2>();
	private String usuariCodi;
	private String motiu;
	private String numExpedient;
	private boolean permisProcessar;
	private EntitatDto entitat;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmisorDir3Codi() {
		return emisorDir3Codi;
	}
	public void setEmisorDir3Codi(String emisorDir3Codi) {
		this.emisorDir3Codi = emisorDir3Codi;
	}
	public NotificaEnviamentTipusEnumDto getEnviamentTipus() {
		return enviamentTipus;
	}
	public void setEnviamentTipus(NotificaEnviamentTipusEnumDto enviamentTipus) {
		this.enviamentTipus = enviamentTipus;
	}
	public String getConcepte() {
		return concepte;
	}
	public void setConcepte(String concepte) {
		this.concepte = concepte;
	}
	public String getDescripcio() {
		return descripcio;
	}
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}
	public Date getCaducitat() {
		return caducitat;
	}
	public void setCaducitat(Date caducitat) {
		this.caducitat = caducitat;
	}
	public DocumentDto getDocument() {
		return document;
	}
	public void setDocument(DocumentDto document) {
		this.document = document;
	}
	public String getCsv_uuid() {
		return csv_uuid;
	}
	public void setCsv_uuid(String csv_uuid) {
		this.csv_uuid = csv_uuid;
	}
	public ProcedimentDto getProcediment() {
		return procediment;
	}
	public void setProcediment(ProcedimentDto procediment) {
		this.procediment = procediment;
	}
	public String getProcedimentCodiNotib() {
		return procedimentCodiNotib;
	}
	public void setProcedimentCodiNotib(String procedimentCodiNotib) {
		this.procedimentCodiNotib = procedimentCodiNotib;
	}
	public GrupDto getGrup() {
		return grup;
	}
	public void setGrup(GrupDto grup) {
		this.grup = grup;
	}
	public String getGrupCodi() {
		return grupCodi;
	}
	public void setGrupCodi(String grupCodi) {
		this.grupCodi = grupCodi;
	}
	public NotificacioEstatEnumDto getEstat() {
		return estat;
	}
	public void setEstat(NotificacioEstatEnumDto estat) {
		this.estat = estat;
	}
	public Date getNotificaErrorData() {
		return notificaErrorData;
	}
	public void setNotificaErrorData(Date notificaErrorData) {
		this.notificaErrorData = notificaErrorData;
	}
	public String getNotificaErrorDescripcio() {
		return notificaErrorDescripcio;
	}
	public void setNotificaErrorDescripcio(String notificaErrorDescripcio) {
		this.notificaErrorDescripcio = notificaErrorDescripcio;
	}
	public String getServeiTipus() {
		return serveiTipus;
	}
	public void setServeiTipus(String serveiTipus) {
		this.serveiTipus = serveiTipus;
	}
	public String getMotiu() {
		return motiu;
	}
	public void setMotiu(String motiu) {
		this.motiu = motiu;
	}
	public boolean isNotificaError() {
		return notificaErrorData != null;
	}
	public Date getEnviamentDataProgramada() {
		return enviamentDataProgramada;
	}
	public void setEnviamentDataProgramada(Date enviamentDataProgramada) {
		this.enviamentDataProgramada = enviamentDataProgramada;
	}
	public Integer getRetard() {
		return retard;
	}
	public void setRetard(Integer retard) {
		this.retard = retard;
	}
	public List<NotificacioEnviamentDtoV2> getEnviaments() {
		return enviaments;
	}
	public void setEnviaments(List<NotificacioEnviamentDtoV2> enviaments) {
		this.enviaments = enviaments;
	}
	public String getNumExpedient() {
		return numExpedient;
	}
	public void setNumExpedient(String numExpedient) {
		this.numExpedient = numExpedient;
	}
	public boolean isPermisProcessar() {
		return permisProcessar;
	}
	public void setPermisProcessar(boolean permisProcessar) {
		this.permisProcessar = permisProcessar;
	}
	public EntitatDto getEntitat() {
		return entitat;
	}
	public void setEntitat(EntitatDto entitat) {
		this.entitat = entitat;
	}
	public String getUsuariCodi() {
		return usuariCodi;
	}
	public void setUsuariCodi(String usuariCodi) {
		this.usuariCodi = usuariCodi;
	}
	public int getNotificaEnviamentIntent() {
		return notificaEnviamentIntent;
	}
	public void setNotificaEnviamentIntent(int notificaEnviamentIntent) {
		this.notificaEnviamentIntent = notificaEnviamentIntent;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	private static final long serialVersionUID = -139254994389509932L;

}
