<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/notib" prefix="not"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:choose>
	<c:when test="${empty procedimentCommand.codi}"><c:set var="titol"><spring:message code="procediment.form.titol.crear"/></c:set></c:when>
	<c:otherwise><c:set var="titol"><spring:message code="procediment.form.titol.modificar"/></c:set></c:otherwise>
</c:choose>
<html>
<head>
	<title>${titol}</title>
	<script src="<c:url value="/webjars/datatables.net/1.10.11/js/jquery.dataTables.min.js"/>"></script>
	<script src="<c:url value="/webjars/datatables.net-bs/1.10.11/js/dataTables.bootstrap.min.js"/>"></script>
	<link href="<c:url value="/webjars/datatables.net-bs/1.10.11/css/dataTables.bootstrap.min.css"/>" rel="stylesheet"></link>
	<link href="<c:url value="/webjars/select2/4.0.1/dist/css/select2.min.css"/>" rel="stylesheet"/>
	<link href="<c:url value="/webjars/select2-bootstrap-theme/0.1.0-beta.4/dist/select2-bootstrap.min.css"/>" rel="stylesheet"/>
	<script src="<c:url value="/webjars/select2/4.0.1/dist/js/select2.min.js"/>"></script>
	<script src="<c:url value="/webjars/select2/4.0.1/dist/js/i18n/${requestLocale}.js"/>"></script>
	<link href="<c:url value="/webjars/bootstrap-datepicker/1.6.1/dist/css/bootstrap-datepicker.min.css"/>" rel="stylesheet"/>
	<script src="<c:url value="/webjars/bootstrap-datepicker/1.6.1/dist/js/bootstrap-datepicker.min.js"/>"></script>
	<script src="<c:url value="/webjars/bootstrap-datepicker/1.6.1/dist/locales/bootstrap-datepicker.${requestLocale}.min.js"/>"></script>
	<script src="<c:url value="/webjars/jsrender/1.0.0-rc.70/jsrender.min.js"/>"></script>
	<script src="<c:url value="/js/webutil.common.js"/>"></script>
	<script src="<c:url value="/js/webutil.datatable.js"/>"></script>
	<script src="<c:url value="/js/webutil.modal.js"/>"></script>
	
	<not:modalHead/>
<script type="text/javascript">


</script>	

</head>
<body>
	<c:set var="formAction"><not:modalUrl value="/enviament/visualitzar/save"/></c:set>
	<form:form action="${formAction}" method="post" cssClass="form-horizontal" commandName="columnesCommand" role="form">
		<form:hidden path="id"/>
		<div class="row">
			<div class="row col-md-6">
				<div class="col-md-3">
					<not:inputCheckbox name="dataProgramada" textKey="enviament.list.dataprogramada" />
				</div>
				<div class="col-md-2">
					<not:inputCheckbox name="notIdentificador" textKey="enviament.list.codinotifica"/>
				</div>
				<div class="col-md-3">
					<not:inputCheckbox name="proCodi" textKey="enviament.list.codiprocediment"/>
				</div>
				<div class="col-md-3">
					<not:inputCheckbox name="grupCodi" textKey="enviament.list.codigrup"/>
				</div>
				<div class="col-md-3">
					<not:inputCheckbox name="dir3Codi" textKey="enviament.list.dir3codi"/>
				</div>
				<div class="col-md-3">
					<not:inputCheckbox name="usuari" textKey="enviament.list.usuari"/>
				</div>
				<div class="col-md-2">
					<not:inputCheckbox name="enviamentTipus" textKey="enviament.list.tipusenviament"/>
				</div>
				<div class="col-md-3">
					<not:inputCheckbox name="concepte" textKey="enviament.list.concepte"/>
				</div>
				<div class="col-md-3">
					<not:inputCheckbox name="descripcio" textKey="enviament.list.descripcio"/>
				</div>
				<div class="col-md-2">
					<not:inputCheckbox name="titularNif" textKey="enviament.list.niftitular"/>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<not:inputCheckbox name="titularNomLlinatge" textKey="enviament.list.nomLlinatgetitular"/>
				</div>
				<div class="col-md-2">
					<not:inputCheckbox name="titularEmail" textKey="enviament.list.emailtitular"/>
				</div>
				<div class="col-md-3">
					<not:inputCheckbox name="destinataris" textKey="enviament.list.destinataris"/>
				</div>
				<div class="col-md-3">
					<not:inputCheckbox name="llibreRegistre" textKey="enviament.list.llibreregistre"/>
				</div>
				<div class="col-md-2">
					<not:inputCheckbox name="numeroRegistre" textKey="enviament.list.numeroregistre"/>
				</div>
				<div class="col-md-3">
					<not:inputCheckbox name="dataRegistre" textKey="enviament.list.dataregistre"/>
				</div>
				<div class="col-md-3">
					<not:inputCheckbox name="dataCaducitat" textKey="enviament.list.datacaducitat"/>
				</div>
				<div class="col-md-2">
					<not:inputCheckbox name="codiNotibEnviament" textKey="enviament.list.codinotibenviament"/>
				</div>
				<div class="col-md-3">
					<not:inputCheckbox name="numCertificacio" textKey="enviament.list.numerocertificatcorreus"/>
				</div>
				<div class="col-md-3">
					<not:inputCheckbox name="csvUuid" textKey="enviament.list.codicsvuuid"/>
				</div>
				<div class="col-md-2">
					<not:inputCheckbox name="estat" textKey="enviament.list.estat"/>
				</div>
			</div>
			<div id="modal-botons">
				<button id="" type="submit" class="btn btn-success"><span class="fa fa-save"></span> <spring:message code="comu.boto.guardar"/></button>
				<a href="<c:url value="/enviament"/>" class="btn btn-default" data-modal-cancel="true"><spring:message code="comu.boto.cancelar"/></a>
			</div>	
		</div>
	</form:form>
	
</body>