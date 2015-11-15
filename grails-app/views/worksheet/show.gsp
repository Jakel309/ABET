
<%@ page import="com.ABET.Worksheet" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'worksheet.label', default: 'Worksheet')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-worksheet" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-worksheet" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list worksheet">
			
				<g:if test="${worksheetInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="worksheet.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${worksheetInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${worksheetInstance?.owner}">
				<li class="fieldcontain">
					<span id="owner-label" class="property-label"><g:message code="worksheet.owner.label" default="Owner" /></span>
					
						<span class="property-value" aria-labelledby="owner-label"><g:fieldValue bean="${worksheetInstance}" field="owner"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${worksheetInstance?.program}">
				<li class="fieldcontain">
					<span id="program-label" class="property-label"><g:message code="worksheet.program.label" default="Program" /></span>
					
						<span class="property-value" aria-labelledby="program-label"><g:link controller="program" action="show" id="${worksheetInstance?.program?.id}">${worksheetInstance?.program?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${worksheetInstance?.results}">
				<li class="fieldcontain">
					<span id="results-label" class="property-label"><g:message code="worksheet.results.label" default="Results" /></span>
					
						<span class="property-value" aria-labelledby="results-label"><g:link controller="results" action="show" id="${worksheetInstance?.results?.id}">${worksheetInstance?.results?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${worksheetInstance?.wsResults}">
				<li class="fieldcontain">
					<span id="wsResults-label" class="property-label"><g:message code="worksheet.wsResults.label" default="Ws Results" /></span>
					
						<span class="property-value" aria-labelledby="wsResults-label"><g:fieldValue bean="${worksheetInstance}" field="wsResults"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:worksheetInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${worksheetInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
