
<%@ page import="HistoricoDeColeta.Coleta" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'coleta.label', default: 'Coleta')}" />
		<title>Coletas em Periodo de Tempo</title>
		<style type="text/css">
			#entrada {
				width: 250px;
				margin-left:100px;
				margin-top:-40px;
				}
			#entrada2 {
				width: 250px;
				margin-left:00px;
				margin-top:0px;
				}
			
			#labelPeriodo{
				margin-left:350px;
			}
			#labelA{
				margin-left:100px;
				margin-top:0px;
			}
			#botaoBuscar{
				background-color: #efefef;
				border: 0;
				color: #666666;
				cursor: pointer;
				display: inline-block;
				margin-left:50px;
				margin-top:0px;
				overflow: visible;
				padding: 0.45em 0.7em;
				text-decoration: none;
				width: 60px; 
				height: 30px;
				-moz-border-radius: 1.3em;
				-webkit-border-radius: 1.3em;
			        border-radius: 1.3em;
						
			}	
	
		</style>
	</head>
	<body>
		<a href="#list-coleta" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		<div>
		<h1 id="labelPeriodo">Informe o periodo</h1>
		<input type="input" id="entrada">
		    A
		<input type="input" id="entrada2">
		<Button name="Enviar" id = "botaoBuscar" controller= "ColetaController" action="paginaColetaPeriodoTempo" >Buscar</Button>
		</div>
		<div id="list-coleta" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="nome" title="${message(code: 'coleta.nome.label', default: 'Nome')}" />
						<g:sortableColumn property="data" title="${message(code: 'coleta.data.label', default: 'Data')}" />
						<g:sortableColumn property="volume" title="${message(code: 'coleta.volume.label', default: 'Volume')}" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${coletaInstanceList}" status="i" var="coletaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="show" id="${coletaInstance.id}">${fieldValue(bean: coletaInstance, field: "nome")}</g:link></td>
						<td><g:formatDate date="${coletaInstance.data}" /></td>
						<td>${fieldValue(bean: coletaInstance, field: "volume")}</td>
					</tr>
				</g:each>
				</tbody>
			</table>
		</div>
	</body>
</html>
