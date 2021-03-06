
<%@ page import="com.ABET.Program" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'program.label', default: 'Program')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<!-- <a href="#show-program" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div> -->
		
		<div class="nav container" role="navigation">
				<div class='col-md-1'><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/> </a></div>
				<div class='col-md-2'><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></div>
				<div class='col-md-2'><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></div>
		</div>
		<div class='container'>
		<div class="form-signin spacer">
		<div id="show-program" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list program">
			
				<g:if test="${programInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="program.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${programInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:programInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit create-btn btn btn-lg btn-primary btn-block" action="edit" resource="${programInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete create-btn btn btn-lg btn-primary btn-block" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
		</div>
		</div>
	</body>
</html>
