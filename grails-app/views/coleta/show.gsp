
<%@ page import="HistoricoDeColeta.Coleta" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'coleta.label', default: 'Coleta')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-coleta" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link class="list" action="totalVolume"><g:message code="default.total.volume.label" /></g:link></li>
			</ul>
		</div>
		<div id="show-coleta" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list coleta">
			
				<g:if test="${coletaInstance?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="coleta.nome.label" default="Nome do estabelecimento" /></span>
					
						<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${coletaInstance}" field="nome"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${coletaInstance?.dataColeta}">
				<li class="fieldcontain">
					<span id="dataColeta-label" class="property-label"><g:message code="coleta.dataColeta.label" default="Data Coleta" /></span>
					
						<span class="property-value" aria-labelledby="dataColeta-label"><g:formatDate date="${coletaInstance?.dataColeta}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${coletaInstance?.volume}">
				<li class="fieldcontain">
					<span id="volume-label" class="property-label"><g:message code="coleta.volume.label" default="Volume" /></span>
					
						<span class="property-value" aria-labelledby="volume-label"><g:fieldValue bean="${coletaInstance}" field="volume"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:coletaInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${coletaInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
