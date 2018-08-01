<%@ page import="HistoricoDeColeta.Coleta" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'coleta.label', default: 'User')}" />
		<title>Collect Search</title>
	</head>
	<body>
		<a href="#search-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		
		<div id="search-collect" class="content scaffold-create" role="main">
			<g:form action="searchColeta">
				<fieldset class="form">
					<g:render template="formSearch"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="search" class="searchColeta" value="${message(code: 'default.button.search.label', default: 'Search')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
