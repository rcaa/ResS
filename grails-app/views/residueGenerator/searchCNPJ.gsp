<%@ page import="residueGenerator.ResidueGenerator" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'residueGenerator.label', default: 'ResidueGenerator')}" />
		<title>Residue Generator Search</title>
	</head>
	<body>
		<a href="#search-residueGenerator" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		
		
		<div id="search-residueGenerator" class="content scaffold-create" role="main">
			<h1>Search Residue Generator</h1>
			
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${residueGeneratorInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${residueGeneratorInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			
			<g:form action="searchCNPJ" >
				<fieldset class="form">
					<g:render template="form2"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="search" class="searchCNPJ" value="${message(code: 'default.button.search.label', default: 'Search')}" />
				</fieldset>
			</g:form>
			
		</div>		
	</body>
</html>
