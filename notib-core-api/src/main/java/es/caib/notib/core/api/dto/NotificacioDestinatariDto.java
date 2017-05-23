/**
 * 
 */
package es.caib.notib.core.api.dto;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import es.caib.notib.core.api.ws.notificacio.NotificacioEstatEnum;

/**
 * Informació d'un destinatari d'una anotació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class NotificacioDestinatariDto extends AuditoriaDto {
	
	private Long id;
	private String titularNom;
	private String titularLlinatges;
	private String titularNif;
	private String titularTelefon;
	private String titularEmail;
	private String destinatariNom;
	private String destinatariLlinatges;
	private String destinatariNif;
	private String destinatariTelefon;
	private String destinatariEmail;
	private NotificaDomiciliTipusEnumDto domiciliTipus;
	private NotificaDomiciliConcretTipusEnumDto domiciliConcretTipus;
	private String domiciliViaTipus;
	private String domiciliViaNom;
	private NotificaDomiciliNumeracioTipusEnumDto domiciliNumeracioTipus;
	private String domiciliNumeracioNumero;
	private String domiciliNumeracioPuntKm;
	private String domiciliApartatCorreus;
	private String domiciliBloc;
	private String domiciliPortal;
	private String domiciliEscala;
	private String domiciliPlanta;
	private String domiciliPorta;
	private String domiciliComplement;
	private String domiciliPoblacio;
	private String domiciliMunicipiCodiIne;
	private String domiciliMunicipiNom;
	private String domiciliCodiPostal;
	private String domiciliProvinciaCodi;
	private String domiciliProvinciaNom;
	protected String domiciliPaisCodiIso;
	protected String domiciliPaisNom;
	protected String domiciliLinea1;
	protected String domiciliLinea2;
	private Integer domiciliCie;
	private boolean dehObligat;
	private String dehNif;
	private String dehProcedimentCodi;
	private NotificaServeiTipusEnumDto serveiTipus;
	private int retardPostal;
	private Date caducitat;
	private String referencia;
	private String notificaIdentificador;
	private NotificaEstatEnumDto notificaEstat;
	private Date notificaEstatData;
	private String notificaEstatReceptorNom;
	private String notificaEstatReceptorNif;
	private String notificaEstatOrigen;
	private String notificaEstatNumSeguiment;
	private NotificaCertificacioTipusEnumDto notificaCertificacioTipus;
	private NotificaCertificacioArxiuTipusEnumDto notificaCertificacioArxiuTipus;
	private String notificaCertificacioArxiuId;
	private String notificaCertificacioNumSeguiment;
	private Date notificaCertificacioDataActualitzacio;
	
//	private List<NotificacioEventDto> events;
	private boolean notificaError;
	private NotificacioEventDto notificaErrorEvent;
	private String seuRegistreNumero;
	private Date seuRegistreData;
	private Date seuDataFi;
	private NotificacioSeuEstatEnumDto seuEstat;
	private boolean seuError;
	private NotificacioEventDto seuErrorEvent;
	
	private NotificacioDto notificacio;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitularNom() {
		return titularNom;
	}
	public void setTitularNom(String titularNom) {
		this.titularNom = titularNom;
	}
	public String getTitularLlinatges() {
		return titularLlinatges;
	}
	public void setTitularLlinatges(String titularLlinatges) {
		this.titularLlinatges = titularLlinatges;
	}
	public String getTitularNif() {
		return titularNif;
	}
	public void setTitularNif(String titularNif) {
		this.titularNif = titularNif;
	}
	public String getTitularTelefon() {
		return titularTelefon;
	}
	public void setTitularTelefon(String titularTelefon) {
		this.titularTelefon = titularTelefon;
	}
	public String getTitularEmail() {
		return titularEmail;
	}
	public void setTitularEmail(String titularEmail) {
		this.titularEmail = titularEmail;
	}
	public String getDestinatariNom() {
		return destinatariNom;
	}
	public void setDestinatariNom(String destinatariNom) {
		this.destinatariNom = destinatariNom;
	}
	public String getDestinatariLlinatges() {
		return destinatariLlinatges;
	}
	public void setDestinatariLlinatges(String destinatariLlinatges) {
		this.destinatariLlinatges = destinatariLlinatges;
	}
	public String getDestinatariNif() {
		return destinatariNif;
	}
	public void setDestinatariNif(String destinatariNif) {
		this.destinatariNif = destinatariNif;
	}
	public String getDestinatariTelefon() {
		return destinatariTelefon;
	}
	public void setDestinatariTelefon(String destinatariTelefon) {
		this.destinatariTelefon = destinatariTelefon;
	}
	public String getDestinatariEmail() {
		return destinatariEmail;
	}
	public void setDestinatariEmail(String destinatariEmail) {
		this.destinatariEmail = destinatariEmail;
	}
	public NotificaDomiciliTipusEnumDto getDomiciliTipus() {
		return domiciliTipus;
	}
	public void setDomiciliTipus(NotificaDomiciliTipusEnumDto domiciliTipus) {
		this.domiciliTipus = domiciliTipus;
	}
	public NotificaDomiciliConcretTipusEnumDto getDomiciliConcretTipus() {
		return domiciliConcretTipus;
	}
	public void setDomiciliConcretTipus(NotificaDomiciliConcretTipusEnumDto domiciliConcretTipus) {
		this.domiciliConcretTipus = domiciliConcretTipus;
	}
	public String getDomiciliViaTipus() {
		return domiciliViaTipus;
	}
	public void setDomiciliViaTipus(String domiciliViaTipus) {
		this.domiciliViaTipus = domiciliViaTipus;
	}
	public String getDomiciliViaNom() {
		return domiciliViaNom;
	}
	public void setDomiciliViaNom(String domiciliViaNom) {
		this.domiciliViaNom = domiciliViaNom;
	}
	public NotificaDomiciliNumeracioTipusEnumDto getDomiciliNumeracioTipus() {
		return domiciliNumeracioTipus;
	}
	public void setDomiciliNumeracioTipus(NotificaDomiciliNumeracioTipusEnumDto domiciliNumeracioTipus) {
		this.domiciliNumeracioTipus = domiciliNumeracioTipus;
	}
	public String getDomiciliNumeracioNumero() {
		return domiciliNumeracioNumero;
	}
	public void setDomiciliNumeracioNumero(String domiciliNumeracioNumero) {
		this.domiciliNumeracioNumero = domiciliNumeracioNumero;
	}
	public String getDomiciliNumeracioPuntKm() {
		return domiciliNumeracioPuntKm;
	}
	public void setDomiciliNumeracioPuntKm(String domiciliNumeracioPuntKm) {
		this.domiciliNumeracioPuntKm = domiciliNumeracioPuntKm;
	}
	public String getDomiciliApartatCorreus() {
		return domiciliApartatCorreus;
	}
	public void setDomiciliApartatCorreus(String domiciliApartatCorreus) {
		this.domiciliApartatCorreus = domiciliApartatCorreus;
	}
	public String getDomiciliBloc() {
		return domiciliBloc;
	}
	public void setDomiciliBloc(String domiciliBloc) {
		this.domiciliBloc = domiciliBloc;
	}
	public String getDomiciliPortal() {
		return domiciliPortal;
	}
	public void setDomiciliPortal(String domiciliPortal) {
		this.domiciliPortal = domiciliPortal;
	}
	public String getDomiciliEscala() {
		return domiciliEscala;
	}
	public void setDomiciliEscala(String domiciliEscala) {
		this.domiciliEscala = domiciliEscala;
	}
	public String getDomiciliPlanta() {
		return domiciliPlanta;
	}
	public void setDomiciliPlanta(String domiciliPlanta) {
		this.domiciliPlanta = domiciliPlanta;
	}
	public String getDomiciliPorta() {
		return domiciliPorta;
	}
	public void setDomiciliPorta(String domiciliPorta) {
		this.domiciliPorta = domiciliPorta;
	}
	public String getDomiciliComplement() {
		return domiciliComplement;
	}
	public void setDomiciliComplement(String domiciliComplement) {
		this.domiciliComplement = domiciliComplement;
	}
	public String getDomiciliPoblacio() {
		return domiciliPoblacio;
	}
	public void setDomiciliPoblacio(String domiciliPoblacio) {
		this.domiciliPoblacio = domiciliPoblacio;
	}
	public String getDomiciliMunicipiCodiIne() {
		return domiciliMunicipiCodiIne;
	}
	public void setDomiciliMunicipiCodiIne(String domiciliMunicipiCodiIne) {
		this.domiciliMunicipiCodiIne = domiciliMunicipiCodiIne;
	}
	public String getDomiciliMunicipiNom() {
		return domiciliMunicipiNom;
	}
	public void setDomiciliMunicipiNom(String domiciliMunicipiNom) {
		this.domiciliMunicipiNom = domiciliMunicipiNom;
	}
	public String getDomiciliCodiPostal() {
		return domiciliCodiPostal;
	}
	public void setDomiciliCodiPostal(String domiciliCodiPostal) {
		this.domiciliCodiPostal = domiciliCodiPostal;
	}
	public String getDomiciliProvinciaCodi() {
		return domiciliProvinciaCodi;
	}
	public void setDomiciliProvinciaCodi(String domiciliProvinciaCodi) {
		this.domiciliProvinciaCodi = domiciliProvinciaCodi;
	}
	public String getDomiciliProvinciaNom() {
		return domiciliProvinciaNom;
	}
	public void setDomiciliProvinciaNom(String domiciliProvinciaNom) {
		this.domiciliProvinciaNom = domiciliProvinciaNom;
	}
	public String getDomiciliPaisCodiIso() {
		return domiciliPaisCodiIso;
	}
	public void setDomiciliPaisCodiIso(String domiciliPaisCodiIso) {
		this.domiciliPaisCodiIso = domiciliPaisCodiIso;
	}
	public String getDomiciliPaisNom() {
		return domiciliPaisNom;
	}
	public void setDomiciliPaisNom(String domiciliPaisNom) {
		this.domiciliPaisNom = domiciliPaisNom;
	}
	public String getDomiciliLinea1() {
		return domiciliLinea1;
	}
	public void setDomiciliLinea1(String domiciliLinea1) {
		this.domiciliLinea1 = domiciliLinea1;
	}
	public String getDomiciliLinea2() {
		return domiciliLinea2;
	}
	public void setDomiciliLinea2(String domiciliLinea2) {
		this.domiciliLinea2 = domiciliLinea2;
	}
	public Integer getDomiciliCie() {
		return domiciliCie;
	}
	public void setDomiciliCie(Integer domiciliCie) {
		this.domiciliCie = domiciliCie;
	}
	public boolean isDehObligat() {
		return dehObligat;
	}
	public void setDehObligat(boolean dehObligat) {
		this.dehObligat = dehObligat;
	}
	public String getDehNif() {
		return dehNif;
	}
	public void setDehNif(String dehNif) {
		this.dehNif = dehNif;
	}
	public String getDehProcedimentCodi() {
		return dehProcedimentCodi;
	}
	public void setDehProcedimentCodi(String dehProcedimentCodi) {
		this.dehProcedimentCodi = dehProcedimentCodi;
	}
	public NotificaServeiTipusEnumDto getServeiTipus() {
		return serveiTipus;
	}
	public void setServeiTipus(NotificaServeiTipusEnumDto serveiTipus) {
		this.serveiTipus = serveiTipus;
	}
	public int getRetardPostal() {
		return retardPostal;
	}
	public void setRetardPostal(int retardPostal) {
		this.retardPostal = retardPostal;
	}
	public Date getCaducitat() {
		return caducitat;
	}
	public void setCaducitat(Date caducitat) {
		this.caducitat = caducitat;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getNotificaIdentificador() {
		return notificaIdentificador;
	}
	public void setNotificaIdentificador(String notificaIdentificador) {
		this.notificaIdentificador = notificaIdentificador;
	}
	public NotificaEstatEnumDto getNotificaEstat() {
		return notificaEstat;
	}
	public void setNotificaEstat(NotificaEstatEnumDto notificaEstat) {
		this.notificaEstat = notificaEstat;
	}
	public Date getNotificaEstatData() {
		return notificaEstatData;
	}
	public void setNotificaEstatData(Date notificaEstatData) {
		this.notificaEstatData = notificaEstatData;
	}
	public String getNotificaEstatReceptorNom() {
		return notificaEstatReceptorNom;
	}
	public void setNotificaEstatReceptorNom(String notificaEstatReceptorNom) {
		this.notificaEstatReceptorNom = notificaEstatReceptorNom;
	}
	public String getNotificaEstatReceptorNif() {
		return notificaEstatReceptorNif;
	}
	public void setNotificaEstatReceptorNif(String notificaEstatReceptorNif) {
		this.notificaEstatReceptorNif = notificaEstatReceptorNif;
	}
	public String getNotificaEstatOrigen() {
		return notificaEstatOrigen;
	}
	public void setNotificaEstatOrigen(String notificaEstatOrigen) {
		this.notificaEstatOrigen = notificaEstatOrigen;
	}
	public String getNotificaEstatNumSeguiment() {
		return notificaEstatNumSeguiment;
	}
	public void setNotificaEstatNumSeguiment(String notificaEstatNumSeguiment) {
		this.notificaEstatNumSeguiment = notificaEstatNumSeguiment;
	}
	public NotificaCertificacioTipusEnumDto getNotificaCertificacioTipus() {
		return notificaCertificacioTipus;
	}
	public void setNotificaCertificacioTipus(NotificaCertificacioTipusEnumDto notificaCertificacioTipus) {
		this.notificaCertificacioTipus = notificaCertificacioTipus;
	}
	public NotificaCertificacioArxiuTipusEnumDto getNotificaCertificacioArxiuTipus() {
		return notificaCertificacioArxiuTipus;
	}
	public void setNotificaCertificacioArxiuTipus(NotificaCertificacioArxiuTipusEnumDto notificaCertificacioArxiuTipus) {
		this.notificaCertificacioArxiuTipus = notificaCertificacioArxiuTipus;
	}
	public String getNotificaCertificacioArxiuId() {
		return notificaCertificacioArxiuId;
	}
	public void setNotificaCertificacioArxiuId(String notificaCertificacioArxiuId) {
		this.notificaCertificacioArxiuId = notificaCertificacioArxiuId;
	}
	public String getNotificaCertificacioNumSeguiment() {
		return notificaCertificacioNumSeguiment;
	}
	public void setNotificaCertificacioNumSeguiment(String notificaCertificacioNumSeguiment) {
		this.notificaCertificacioNumSeguiment = notificaCertificacioNumSeguiment;
	}
	public Date getNotificaCertificacioDataActualitzacio() {
		return notificaCertificacioDataActualitzacio;
	}
	public void setNotificaCertificacioDataActualitzacio(Date notificaCertificacioDataActualitzacio) {
		this.notificaCertificacioDataActualitzacio = notificaCertificacioDataActualitzacio;
	}
	
	public boolean isNotificaError() {
		return notificaError;
	}
	public void setNotificaError(boolean notificaError) {
		this.notificaError = notificaError;
	}
	public NotificacioEventDto getNotificaErrorEvent() {
		return notificaErrorEvent;
	}
	public void setNotificaErrorEvent(NotificacioEventDto notificaErrorEvent) {
		this.notificaErrorEvent = notificaErrorEvent;
	}
	public String getSeuRegistreNumero() {
		return seuRegistreNumero;
	}
	public void setSeuRegistreNumero(String seuRegistreNumero) {
		this.seuRegistreNumero = seuRegistreNumero;
	}
	public Date getSeuRegistreData() {
		return seuRegistreData;
	}
	public void setSeuRegistreData(Date seuRegistreData) {
		this.seuRegistreData = seuRegistreData;
	}
	public Date getSeuDataFi() {
		return seuDataFi;
	}
	public void setSeuDataFi(Date seuDataFi) {
		this.seuDataFi = seuDataFi;
	}
	public NotificacioSeuEstatEnumDto getSeuEstat() {
		return seuEstat;
	}
	public void setSeuEstat(NotificacioSeuEstatEnumDto seuEstat) {
		this.seuEstat = seuEstat;
	}
	public boolean isSeuError() {
		return seuError;
	}
	public void setSeuError(boolean seuError) {
		this.seuError = seuError;
	}
	public NotificacioEventDto getSeuErrorEvent() {
		return seuErrorEvent;
	}
	public void setSeuErrorEvent(NotificacioEventDto seuErrorEvent) {
		this.seuErrorEvent = seuErrorEvent;
	}
	public NotificacioDto getNotificacio() {
		return notificacio;
	}
	public void setNotificacio(NotificacioDto notificacio) {
		this.notificacio = notificacio;
	}

//	public List<NotificacioEventDto> getEvents() {
//		return events;
//	}
//	public void setEvents(List<NotificacioEventDto> events) {
//		this.events = events;
//	}
	
	
	public String getDestinatari() {
		
		return destinatariNom + " " + destinatariLlinatges + " ( " + destinatariNif + " ) ";
	}
	
	public NotificacioEstatEnum getEstatUnificat() {
		
		switch(seuEstat) {
			case ENVIADA: return NotificacioEstatEnum.PENDENT_COMPAREIXENSA;
			case LLEGIDA: return NotificacioEstatEnum.LLEGIDA;
			case REBUTJADA: return NotificacioEstatEnum.REBUTJADA;
			default:
				if(notificaEstat == null) return NotificacioEstatEnum.SENSE_INFORMACIO;
				return NotificacioEstatEnum.toNotificacioEstatEnum(notificaEstat);
		}
	}
	
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	private static final long serialVersionUID = -139254994389509932L;

}
