<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/notib" prefix="not"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:choose>
	<c:when test="${empty permisCommand.id}"><c:set var="titol"><spring:message code="entitat.permis.form.titol.crear"/></c:set></c:when>
	<c:otherwise><c:set var="titol"><spring:message code="entitat.permis.form.titol.modificar"/></c:set></c:otherwise>
</c:choose>
<html>
<head>
	<title>${titol}</title>
	<link href="<c:url value="/webjars/select2/4.0.6-rc.1/dist/css/select2.min.css"/>" rel="stylesheet"/>
	<link href="<c:url value="/webjars/select2-bootstrap-theme/0.1.0-beta.4/dist/select2-bootstrap.min.css"/>" rel="stylesheet"/>
	<script src="<c:url value="/webjars/select2/4.0.6-rc.1/dist/js/select2.min.js"/>"></script>
	<script src="<c:url value="/webjars/select2/4.0.6-rc.1/dist/js/i18n/${requestLocale}.js"/>"></script>
	<script src="<c:url value="/js/webutil.common.js"/>"></script>
	<link href="<c:url value="/css/permisos.css"/>" rel="stylesheet" type="text/css">
	<not:modalHead/>
	<script>
		$(document).ready(function() {
			$("#modal-botons button[type='submit']").on('click', function() {
				$("form#permisCommand *:disabled").attr('readonly', 'readonly');
				$("form#permisCommand *:disabled").removeAttr('disabled');
			});
			
			<c:if test="${empty permisCommand.id}">
				disableGuardarIfNoneChecked();
				$("input[type='checkbox']").change(function( index, element ) { 
					disableGuardarIfNoneChecked();
				});
			</c:if>		
		});
		
		function disableGuardarIfNoneChecked(){
			var anyChecked=false;
			$("input[type='checkbox']").each(function( index, element ) { 
				if ($( element ).is(':checked')){
				anyChecked=true;			
				}
			}); 
			if(anyChecked==true){
				$(".submitDialog",parent.document).prop('disabled',false)
				$(".submitDialog").prop('disabled',false)

			} else {
				$(".submitDialog",parent.document).prop('disabled',true)
				$(".submitDialog").prop('disabled',true)

			}
		}
	</script>
</head>
<body>
	<c:set var="formAction"><not:modalUrl value="/entitat/${entitat.id}/permis"/></c:set>
	<form:form action="${formAction}" method="post" cssClass="form-horizontal" commandName="permisCommand">
		<form:hidden path="id"/>
		<not:inputSelect name="tipus" textKey="entitat.permis.form.camp.tipus" disabled="true" optionEnum="TipusEnumDto" />
		<not:inputText name="principal" textKey="entitat.permis.form.camp.principal" readonly="${not empty permisCommand.id}"/>
		<not:inputCheckbox name="usuari" textKey="entitat.permis.form.camp.usuari"/>
		<not:inputCheckbox name="administrador" textKey="entitat.permis.form.camp.administrador"/>
		<not:inputCheckbox name="administradorEntitat" textKey="entitat.permis.form.camp.administradorentitat"/>
		<not:inputCheckbox name="aplicacio" textKey="entitat.permis.form.camp.aplicacio"/>
		<div id="modal-botons" class="col-xs-12 text-right">
			<button type="submit" class="btn btn-success"><span class="fa fa-save"></span>&nbsp;<spring:message code="comu.boto.guardar"/></button>
			<a href="<c:url value="/entitats/${entitatId}/permis"/>" class="btn btn-default" data-modal-cancel="true"><spring:message code="comu.boto.cancelar"/></a>
		</div>
	</form:form>
</body>
</html>
