<%@ page import="user.User" %>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'login', 'error')} required">
	<label for="login">
		<g:message code="user.login.label" default="login" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="login" required="" value="${userInstance?.login}"/>

</div>