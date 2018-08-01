<%@ page import="HistoricoDeColeta.Coleta" %>

<div class="fieldcontain ${hasErrors(bean: coletaInstance, field: 'nome', 'error')} required">
	<label for="nome coleta">
		<g:message code="coleta.nome.label" default="nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${coletaInstance?.nome}"/>
</div>