<%@ page import="harvestCompany.HarvestCompany" %>



<div class="fieldcontain ${hasErrors(bean: harvestCompanyInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="harvestCompany.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${harvestCompanyInstance?.name}"/>

</div>

