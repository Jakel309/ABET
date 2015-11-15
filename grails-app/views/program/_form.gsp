<%@ page import="com.ABET.Program" %>



<div class="fieldcontain ${hasErrors(bean: programInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="program.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${programInstance?.name}"/>

</div>

