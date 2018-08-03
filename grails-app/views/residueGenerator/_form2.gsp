<%@ page import="residueGenerator.ResidueGenerator" %>

<div class="fieldcontain ${hasErrors(bean: residueGeneratorInstance, field: 'cnpj', 'error')} required">
	<label for="cnpj">
		<g:message code="residueGenerator.cnpj.label" default="cnpj" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="cnpj" required="" value="${residueGeneratorInstance?.cnpj}"/>
</div>