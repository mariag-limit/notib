<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/notib" prefix="not"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
	<title><spring:message code="enviament.info.titol"/></title>
	<script src="<c:url value="/webjars/datatables.net/1.10.11/js/jquery.dataTables.min.js"/>"></script>
	<script src="<c:url value="/webjars/datatables.net-bs/1.10.11/js/dataTables.bootstrap.min.js"/>"></script>
	<link href="<c:url value="/webjars/datatables.net-bs/1.10.11/css/dataTables.bootstrap.min.css"/>" rel="stylesheet"></link>
	<script src="<c:url value="/webjars/jsrender/1.0.0-rc.70/jsrender.min.js"/>"></script>
	<script src="<c:url value="/js/webutil.common.js"/>"></script>
	<script src="<c:url value="/js/webutil.datatable.js"/>"></script>
	<script src="<c:url value="/js/webutil.modal.js"/>"></script>
	<not:modalHead/>
<script type="text/javascript">
var eventTipus = [];
<c:forEach var="tipus" items="${eventTipus}">
eventTipus["${tipus.value}"] = "<spring:message code="${tipus.text}"/>";
</c:forEach>
$(document).ready(function() {
	$('#events').on('rowinfo.dataTable', function(e, td, rowData) {
		$(td).empty();
    	$(td).append('<textarea style="width:100%" rows="10">' + rowData['errorDescripcio'] + '</textarea>');
	});
	$('#events').on('draw.dt', function(e, settings) {
		var api = new $.fn.dataTable.Api(settings);
		api.rows().every(function (rowIdx, tableLoop, rowLoop) {
			var data = this.data();
			if (!data.error) {
				$('td:last-child', this.node()).empty();
			}
		});
	});
});
</script>
</head>
<body>
	<c:if test="${enviament.notificacio.notificaError}">
		<div class="alert alert-danger well-sm">
			<span class="fa fa-warning text-danger"></span>
			<spring:message code="enviament.info.error.titol"/>
			<button class="btn btn-default btn-xs pull-right" data-toggle="collapse" data-target="#collapseError" aria-expanded="false" aria-controls="collapseError">
				<span class="fa fa-bars"></span>
			</button>
			<div id="collapseError" class="collapse">
				<br/>
				<textarea rows="10" style="width:100%">${fn:escapeXml(enviament.notificacio.notificaErrorDescripcio)}</textarea>
			</div>
		</div>
	</c:if>
	<ul class="nav nav-tabs" role="tablist">
		<li role="presentation"<c:if test="${pipellaActiva == 'dades'}"> class="active"</c:if>>
			<a href="#dades" aria-controls="dades" role="tab" data-toggle="tab">
				<spring:message code="enviament.info.tab.dades"/>
			</a>
		</li>
		<li role="presentation"<c:if test="${pipellaActiva == 'estatNotifica'}"> class="active"</c:if>>
			<a href="#estatNotifica" aria-controls="estatNotifica" role="tab" data-toggle="tab">
				<spring:message code="enviament.info.tab.estat.notifica"/>
			</a>
		</li>
		<li role="presentation"<c:if test="${pipellaActiva == 'estatSeu'}"> class="active"</c:if>>
			<a href="#estatSeu" aria-controls="estatSeu" role="tab" data-toggle="tab">
				<spring:message code="enviament.info.tab.estat.registre"/>
			</a>
		</li>
		<li role="presentation"<c:if test="${pipellaActiva == 'events'}"> class="active"</c:if>>
			<a href="#events" aria-controls="events" role="tab" data-toggle="tab">
				<spring:message code="enviament.info.tab.events"/>
			</a>
		</li>
	</ul>
	<div class="tab-content">
		<div role="tabpanel" class="tab-pane<c:if test="${pipellaActiva == 'dades'}"> active</c:if>" id="dades">
			<br/>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<strong><spring:message code="enviament.info.seccio.dades"/></strong>
					</h3>
 				</div>
				<table class="table table-bordered" style="width:100%">
				<tbody>
					<tr>
						<td width="30%"><strong><spring:message code="enviament.info.dada.identificadors"/></strong></td>
						<c:choose>
							<c:when test="${not empty enviament.notificacio.id}">
								<td width="1%"><strong>NOTIB</strong></td>
								<td>${enviament.referencia}</td>
								<td width="1%"><strong>Notific@</strong></td>
								<td>${enviament.notificacio.id}</td>
							</c:when>
							<c:otherwise>
								<td colspan="2" width="1%"><strong>NOTIB</strong></td>
								<td colspan="2">${enviament.notificaReferencia}</td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<td><strong><spring:message code="enviament.info.dada.deh.nif"/></strong></td>
						<td colspan="4">${enviament.entregaDeh.nif}</td>
					</tr>
					<tr>
						<td><strong><spring:message code="enviament.info.dada.deh.procediment"/></strong></td>
						<td colspan="4">${enviament.entregaDeh.procedimentCodi}</td>
					</tr>
					<tr>
						<td><strong><spring:message code="enviament.info.dada.deh.obligada"/></strong></td>
						<td colspan="4">
							<c:choose>
								<c:when test="${enviament.entregaDeh.obligat}"><spring:message code="comu.si"/></c:when>
								<c:otherwise><spring:message code="comu.no"/><</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td><strong><spring:message code="enviament.info.dada.servei.tipus"/></strong></td>
						<c:choose><c:when test="${not empty enviament.serveiTipus}"><c:set var="envTip" value="${enviament.serveiTipus}"/></c:when><c:otherwise><c:set var="envTip" value="NORMAL"/></c:otherwise></c:choose>
						<td colspan="4"><spring:message code="es.caib.notib.core.api.dto.NotificaServeiTipusEnumDto.${envTip}"/></td>
					</tr>
					<tr>
						<td width="30%"><strong><spring:message code="enviament.info.dada.estat"/></strong></td>
						<td colspan="4"><spring:message code="es.caib.notib.core.api.dto.NotificacioEnviamentEstatEnumDto.${enviament.notificacio.estat}"/></td>
					</tr>
				</tbody>
				</table>
			</div>
			<div class="row">
				<c:set var="titularColSize" value="12"/>
				<c:if test="${not empty enviament.titular.nif}"><c:set var="titularColSize" value="6"/></c:if>
				<div class="col-sm-${titularColSize}">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">
								<strong><spring:message code="enviament.info.seccio.titular"/></strong>
							</h3>
		 				</div>
						<table class="table table-bordered" style="width:100%">
						<tbody>
							<tr>
								<td><strong><spring:message code="enviament.info.titular.nif"/></strong></td>
								<td>${enviament.titular.nif}</td>
							</tr>
							<c:if test="${not empty enviament.titular.nom}">
								<tr>
									<td width="30%"><strong><spring:message code="enviament.info.titular.nom"/></strong></td>
									<td>${enviament.titular.nom}</td>
								</tr>
							</c:if>
							<c:if test="${not empty enviament.titular.llinatge1}">
								<tr>
									<td><strong><spring:message code="enviament.info.titular.llinatges"/></strong></td>
									<td>${enviament.titular.llinatge1}</td>
									<c:if test="${not empty titular.llinatge2}">
										<td>${titular.llinatge2}</td>
									</c:if>
								</tr>
							</c:if>
							<c:if test="${not empty enviament.titular.telefon}">
								<tr>
									<td><strong><spring:message code="enviament.info.titular.telefon"/></strong></td>
									<td>${enviament.titular.telefon}</td>
								</tr>
							</c:if>
							<c:if test="${not empty enviament.titular.email}">
								<tr>
									<td><strong><spring:message code="enviament.info.titular.email"/></strong></td>
									<td>${enviament.titular.email}</td>
								</tr>
							</c:if>
						</tbody>
						</table>
					</div>
				</div>
				<c:forEach var="destinatari" items="${enviament.destinataris}" varStatus="loop">
					<c:if test="${not empty destinatari.nif}">
						<div class="col-sm-6">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">
										<strong><spring:message code="enviament.info.seccio.destinatari"/> nº ${loop.index+1}</strong>
									</h3>
				 				</div>
								<table class="table table-bordered" style="width:100%">
								<tbody>
									<tr>
										<td><strong><spring:message code="enviament.info.destinatari.nif"/></strong></td>
										<td>${destinatari.nif}</td>
									</tr>
									<c:if test="${not empty destinatari.nom}">
										<tr>
											<td width="30%"><strong><spring:message code="enviament.info.destinatari.nom"/></strong></td>
											<td>${destinatari.nom}</td>
										</tr>
									</c:if>
									<c:if test="${not empty destinatari.llinatge1}">
										<tr>
											<td><strong><spring:message code="enviament.info.destinatari.llinatges"/></strong></td>
											<td>${destinatari.llinatge1}</td>
											<c:if test="${not empty destinatari.llinatge2}">
												<td>${destinatari.llinatge2}</td>
											</c:if>
										</tr>
									</c:if>
									<c:if test="${not empty destinatari.telefon}">
										<tr>
											<td><strong><spring:message code="enviament.info.destinatari.telefon"/></strong></td>
											<td>${destinatari.telefon}</td>
										</tr>
									</c:if>
									<c:if test="${not empty destinatari.email}">
										<tr>
											<td><strong><spring:message code="enviament.info.destinatari.email"/></strong></td>
											<td>${destinatari.email}</td>
										</tr>
									</c:if>
								</tbody>
								</table>
							</div>
						</div>
					</c:if>
				</c:forEach>
			</div>
			<c:if test="${not empty enviament.entregaPostal.ConcretTipus}">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<strong><spring:message code="enviament.info.seccio.domicili"/></strong>
						</h3>
	 				</div>
					<table class="table table-bordered" style="width:100%">
					<tbody>
						<tr>
							<td width="30%"><strong><spring:message code="enviament.info.domicili.tipus"/></strong></td>
							<td>${enviament.entregaPostal.tipus}</td>
						</tr>
						<tr>
							<td><strong><spring:message code="enviament.info.domicili.tipus.concret"/></strong></td>
							<td>${enviament.entregaPostal.concretTipus}</td>
						</tr>
						<tr>
							<td><strong><spring:message code="enviament.info.domicili.via"/></strong></td>
							<td>${enviament.entregaPostal.viaTipus} ${enviament.entregaPostal.viaNom}</td>
						</tr>
						<tr>
							<td><strong><spring:message code="enviament.info.domicili.numeracio"/></strong></td>
							<td>
								${enviament.entregaPostal.numeracioTipus}
								${enviament.entregaPostal.numeracioNumero}
								${enviament.entregaPostal.numeracioPuntKm}
								${enviament.entregaPostal.apartatCorreus}
							</td>
						</tr>
						<tr>
							<td><strong><spring:message code="enviament.info.domicili.bloc"/></strong></td>
							<td>${enviament.entregaPostal.bloc}</td>
						</tr>
						<tr>
							<td><strong><spring:message code="enviament.info.domicili.portal"/></strong></td>
							<td>${enviament.entregaPostal.portal}</td>
						</tr>
						<tr>
							<td><strong><spring:message code="enviament.info.domicili.escala"/></strong></td>
							<td>${enviament.entregaPostal.escala}</td>
						</tr>
						<tr>
							<td><strong><spring:message code="enviament.info.domicili.planta"/></strong></td>
							<td>${enviament.entregaPostal.planta}</td>
						</tr>
						<tr>
							<td><strong><spring:message code="enviament.info.domicili.porta"/></strong></td>
							<td>${enviament.entregaPostal.porta}</td>
						</tr>
						<tr>
							<td><strong><spring:message code="enviament.info.domicili.complement"/></strong></td>
							<td>${enviament.entregaPostal.complement}</td>
						</tr>
						<tr>
							<td><strong><spring:message code="enviament.info.domicili.poblacio"/></strong></td>
							<td>${enviament.entregaPostal.poblacio}</td>
						</tr>
						<tr>
							<td><strong><spring:message code="enviament.info.domicili.codi.postal"/></strong></td>
							<td>${enviament.entregaPostal.codiPostal}</td>
						</tr>
						<tr>
							<td><strong><spring:message code="enviament.info.domicili.municipi"/></strong></td>
							<td>${enviament.entregaPostal.municipiNom} (${enviament.entregaPostal.MunicipiCodiIne})</td>
						</tr>
						<tr>
							<td><strong><spring:message code="enviament.info.domicili.provincia"/></strong></td>
							<td>${enviament.entregaPostal.provinciaNom} (${enviament.entregaPostal.ProvinciaCodi})</td>
						</tr>
						<tr>
							<td><strong><spring:message code="enviament.info.domicili.pais"/></strong></td>
							<td>${enviament.entregaPostal.paisNom} (${enviament.entregaPostal.PaisCodiIso})</td>
						</tr>
						<tr>
							<td><strong><spring:message code="enviament.info.domicili.linea1"/></strong></td>
							<td>${enviament.entregaPostal.linea1}</td>
						</tr>
						<tr>
							<td><strong><spring:message code="enviament.info.domicili.linea2"/></strong></td>
							<td>${enviament.entregaPostal.linea2}</td>
						</tr>
						<tr>
							<td><strong><spring:message code="enviament.info.domicili.cie"/></strong></td>
							<td>${enviament.entregaPostal.cie}</td>
						</tr>
					</tbody>
					</table>
				</div>
			</c:if>
		</div>
		<div role="tabpanel" class="tab-pane<c:if test="${pipellaActiva == 'estatNotifica'}"> active</c:if>" id="estatNotifica">
			<c:if test="${enviament.notificacio.estat == 'PENDENT'}">
				<div class="alert alert-warning well-sm" role="alert" style="margin-top: 1em">
					<spring:message code="enviament.info.notifica.no.enviada"/>
				</div>
			</c:if>
			<c:if test="${enviament.notificacio.estat != 'PENDENT'}">
				<p class="text-right" style="margin-top: 1em">
					<a href="<not:modalUrl value="/notificacio/${notificacioId}/enviament/${enviamentId}/refrescarEstatNotifica"/>" class="btn btn-default">
						<span class="fa fa-refresh"></span>
						<spring:message code="enviament.info.accio.refrescar.estat"/>
					</a>
				</p>
				<div class="row">
					<c:set var="datatColSize" value="12"/>
					<c:if test="${not empty enviament.notificaCertificacioData}"><c:set var="datatColSize" value="6"/></c:if>
					<div class="col-sm-${datatColSize}">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<strong><spring:message code="enviament.info.seccio.notifica.datat"/></strong>
								</h3>
			 				</div>
							<table class="table table-bordered" style="width:100%">
							<tbody>
								<tr>
									<td width="30%"><strong><spring:message code="enviament.info.notifica.estat"/></strong></td>
									<td><spring:message code="es.caib.notib.core.api.dto.NotificacioEnviamentEstatEnumDto.${enviament.notificaEstat}"/></td>
								</tr>
								<tr>
									<td><strong><spring:message code="enviament.info.notifica.estat.data"/></strong></td>
									<td><fmt:formatDate value="${enviament.notificaEstatData}" pattern="dd/MM/yyyy HH:mm:ss"/></td>
								</tr>
								<c:if test="${not empty enviament.notificaDatatErrorDescripcio}">
									<tr>
										<td><strong><spring:message code="enviament.info.notifica.estat.descripcio"/></strong></td>
										<td>${enviament.notificaEstatDescripcio}</td>
									</tr>
								</c:if>
								<c:if test="${not empty enviament.notificaDatatOrigen}">
									<tr>
										<td><strong><spring:message code="enviament.info.notifica.datat.origen"/></strong></td>
										<td><spring:message code="enviament.datat.origen.enum.${enviament.notificaDatatOrigen}"/> (${enviament.notificaDatatOrigen})</td>
									</tr>
								</c:if>
								<c:if test="${not empty enviament.notificaDatatReceptorNif}">
									<tr>
										<td><strong><spring:message code="enviament.info.notifica.datat.receptor.nif"/></strong></td>
										<td>${enviament.notificaDatatReceptorNif}</td>
									</tr>
								</c:if>
								<c:if test="${not empty enviament.notificaDatatNumSeguiment}">
									<tr>
										<td><strong><spring:message code="enviament.info.notifica.datat.receptor.nom"/></strong></td>
										<td>${enviament.notificaDatatReceptorNom}</td>
									</tr>
								</c:if>
								<c:if test="${not empty enviament.notificaDatatNumSeguiment}">
									<tr>
										<td><strong><spring:message code="enviament.info.notifica.datat.num.seguiment"/></strong></td>
										<td>${enviament.notificaDatatNumSeguiment}</td>
									</tr>
								</c:if>
								<c:if test="${not empty enviament.notificaDatatErrorDescripcio}">
									<tr>
										<td><strong><spring:message code="enviament.info.notifica.datat.error.desc"/></strong></td>
										<td>${enviament.notificaDatatErrorDescripcio}</td>
									</tr>
								</c:if>
							</tbody>
							</table>
						</div>
					</div>
					<c:if test="${not empty enviament.notificaCertificacioData}">
						<div class="col-sm-6">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">
										<strong><spring:message code="enviament.info.seccio.notifica.certificacio"/></strong>
									</h3>
				 				</div>
								<table class="table table-bordered" style="width:100%">
								<tbody>
									<tr>
										<td width="30%"><strong><spring:message code="enviament.info.notifica.certificacio.data"/></strong></td>
										<td><fmt:formatDate value="${enviament.notificaCertificacioData}" pattern="dd/MM/yyyy HH:mm:ss"/></td>
									</tr>
									<tr>
										<td><strong><spring:message code="enviament.info.notifica.certificacio.mime"/></strong></td>
										<td>${enviament.notificaCertificacioMime}</td>
									</tr>
									<tr>
										<td><strong><spring:message code="enviament.info.notifica.certificacio.origen"/></strong></td>
										<td><spring:message code="enviament.datat.origen.enum.${enviament.notificaCertificacioOrigen}"/> (${enviament.notificaCertificacioOrigen})</td>
									</tr>
									<c:if test="${not empty enviament.notificaCertificacioMetadades}">
										<tr>
											<td><strong><spring:message code="enviament.info.notifica.certificacio.metadades"/></strong></td>
											<td>${enviament.notificaCertificacioMetadades}</td>
										</tr>
									</c:if>
									<c:if test="${not empty enviament.notificaCertificacioCsv}">
										<tr>
											<td><strong><spring:message code="enviament.info.notifica.certificacio.csv"/></strong></td>
											<td>${enviament.notificaCertificacioCsv}</td>
										</tr>
									</c:if>
									<c:if test="${not empty enviament.notificaCertificacioTipus}">
										<tr>
											<td><strong><spring:message code="enviament.info.notifica.certificacio.tipus"/></strong></td>
											<td>${enviament.notificaCertificacioTipus}</td>
										</tr>
									</c:if>
									<c:if test="${not empty enviament.notificaCertificacioArxiuTipus}">
										<tr>
											<td><strong><spring:message code="enviament.info.notifica.certificacio.arxiu.tipus"/></strong></td>
											<td>${enviament.notificaCertificacioArxiuTipus}</td>
										</tr>
									</c:if>
									<c:if test="${not empty enviament.notificaCertificacioNumSeguiment}">
										<tr>
											<td><strong><spring:message code="enviament.info.notifica.certificacio.num.seguiment"/></strong></td>
											<td>${enviament.notificaCertificacioNumSeguiment}</td>
										</tr>
									</c:if>
									<tr>
										<td><strong><spring:message code="enviament.info.notifica.certificacio.document"/></strong></td>
										<td>
											${enviament.notificaCertificacioArxiuNom}
											<a href="<not:modalUrl value="/notificacio/${notificacioId}/enviament/${enviamentId}/certificacioDescarregar"/>" class="btn btn-default btn-sm pull-right" title="<spring:message code="notificacio.info.document.descarregar"/>"><span class="fa fa-download"></span></a>
										</td>
									</tr>
								</tbody>
								</table>
							</div>
						</div>
					</c:if>
				</div>
			</c:if>
		</div>
		<div role="tabpanel" class="tab-pane<c:if test="${pipellaActiva == 'estatSeu'}"> active</c:if>" id="estatSeu">
			<c:if test="${empty enviament.notificacio.seuRegistreNumero}">
				<div class="alert alert-warning well-sm" role="alert" style="margin-top: 1em">
					<spring:message code="enviament.info.estat.registre.no.enviada"/>
				</div>
				<c:if test="${enviament.notificacio.estat != 'PENDENT'}">
					<c:if test="${notificacio.enviamentTipus == 'COMUNICACIO'}">
						<p class="well well-sm text-right" style="margin-top: 1em">
							<a href="<not:modalUrl value="/notificacio/${notificacioId}/enviament/${enviamentId}/comunicacioSeu"/>" class="btn btn-default">
								<span class="fa fa-check-square-o"></span>
								<spring:message code="enviament.info.accio.seu.informar.obertura"/>
							</a>
						</p>
					</c:if>
					<c:if test="${notificacio.enviamentTipus == 'NOTIFICACIO'}">
						<form action="<not:modalUrl value="/notificacio/${notificacioId}/enviament/${enviamentId}/certificacioSeu"/>" class="well well-sm text-right" style="margin-top: 1em" method="post" enctype="multipart/form-data">
							<input type="file" name="certificat" class="pull-left"/>
							<button type="submit" class="btn btn-default">
								<span class="fa fa-send-o"></span>
								<spring:message code="enviament.info.accio.seu.enviar.certificacio"/>
							</button>
						</form>
					</c:if>
				</c:if>
			</c:if>
			<c:if test="${not empty enviament.notificacio.seuRegistreNumero}">
				<p class="text-right" style="margin-top: 1em">
					<a href="<not:modalUrl value="/notificacio/${notificacioId}/enviament/${enviamentId}/refrescarEstatSeu"/>" class="btn btn-default">
						<span class="fa fa-refresh"></span>
						<spring:message code="enviament.info.accio.refrescar.estat"/>
					</a>
				</p>
				<div class="panel panel-default">
					<table class="table table-bordered" style="width:100%">
					<tbody>
						<tr>
							<td width="30%"><strong><spring:message code="enviament.info.seu.registre.num"/></strong></td>
							<td>${enviament.notificacio.seuRegistreNumero}</td>
						</tr>
						<tr>
							<td><strong><spring:message code="enviament.info.seu.registre.data"/></strong></td>
							<td><fmt:formatDate value="${enviament.notificacio.seuRegistreData}" pattern="dd/MM/yyyy HH:mm:ss"/></td>
						</tr>
						<tr>
							<td><strong><spring:message code="enviament.info.seu.data.fi"/></strong></td>
							<td>${enviament.seuDataFi}</td>
						</tr>
						<tr>
							<td><strong><spring:message code="enviament.info.seu.data.enviament"/></strong></td>
							<td><fmt:formatDate value="${enviament.notificacio.seuDataEnviament}" pattern="dd/MM/yyyy HH:mm:ss"/></td>
						</tr>
						<tr>
							<td><strong><spring:message code="enviament.info.seu.estat"/></strong></td>
							<td><spring:message code="es.caib.notib.core.api.dto.NotificacioEnviamentEstatEnumDto.${enviament.seuEstat}"/></td>
						</tr>
					</tbody>
					</table>
				</div>
			</c:if>
		</div>
		<div role="tabpanel" class="tab-pane<c:if test="${pipellaActiva == 'events'}"> active</c:if>" id="events">
			<table
				id="events"
				data-toggle="datatable"
				data-url="<c:url value="/notificacio/${notificacioId}/enviament/${enviamentId}/event"/>"
				data-search-enabled="false"
				data-paging="false"
				data-info="false"
				data-row-info="true"
				class="table table-striped table-bordered"
				style="width:100%">
			<thead>
				<tr>
					<th data-col-name="id" data-visible="false">#</th>
					<th data-col-name="enviamentAssociat" data-visible="false"></th>
					<th data-col-name="errorDescripcio" data-visible="false"></th>
					<%--th data-col-name="createdBy.nom" data-orderable="false"><spring:message code="notificacio.event.list.columna.usuari"/></th--%>
					<th data-col-name="data" data-converter="datetime" data-orderable="false"><spring:message code="enviament.event.list.columna.data"/></th>
					<th data-col-name="tipus" data-template="#cellTipus" data-orderable="false">
						<spring:message code="enviament.event.list.columna.tipus"/>
						<script id="cellTipus" type="text/x-jsrender">
							{{:~eval('eventTipus["' + tipus + '"]')}}
							{{if enviamentAssociat}}<span class="label label-default pull-right" title="<spring:message code="notificacio.event.list.info.associat"/>">E</span>{{/if}}
						</script>
					</th>
					<th data-col-name="error" data-template="#cellResultat" data-orderable="false">
						<spring:message code="notificacio.event.list.columna.estat"/>
						<script id="cellResultat" type="text/x-jsrender">
							{{if error}}
								<span class="fa fa-warning text-danger" title="<spring:message code="enviament.event.list.processat.error"/>"></span>
							{{else}}
								<span class="fa fa-check text-success" title="<spring:message code="enviament.event.list.processat.ok"/>"></span>
							{{/if}}
						</script>
					</th>
				</tr>
			</thead>
			</table>
		</div>
	</div>
	<div id="modal-botons" class="text-right">
		<a href="<c:url value="/notificacions"/>" class="btn btn-default" data-modal-cancel="true"><spring:message code="comu.boto.tancar"/></a>
	</div>
</body>
</html>
