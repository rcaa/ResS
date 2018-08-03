			<%@ page import="HistoricoDeColeta.Coleta" %>



<div class="fieldcontain ${hasErrors(bean: coletaInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="coleta.nome.label" default="Nome do Estabelecimento" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${coletaInstance?.nome}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: coletaInstance, field: 'dataColeta', 'error')} required">
	<label for="dataColeta">
		<g:message code="coleta.dataColeta.label" default="Data Coleta" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dataColeta" precision="day"  value="${coletaInstance?.dataColeta}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: coletaInstance, field: 'volume', 'error')} required">
	<label for="volume">
		<g:message code="coleta.volume.label" default="Volume" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="volume" type="number" value="${coletaInstance.volume}" required=""/>

</div>