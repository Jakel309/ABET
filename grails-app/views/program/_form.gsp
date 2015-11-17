<%@ page import="com.ABET.Program" %>



<div class="fieldcontain ${hasErrors(bean: programInstance, field: 'name', 'error')} required">
	<label for="name" class='sr-only'>
		<g:message code="program.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" default="password" class='form-control' placeholder="program name" value="${programInstance?.name}"/>

</div>

