
<%@ page import="com.ABET.WSQuestions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'WSQuestions.label', default: 'WSQuestions')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<!-- <a href="#list-WSQuestions" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>   -->
		
		<div class="nav container" role="navigation">
				<div class='col-md-1'><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></div>
				<div class='col-md-2'><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></div>
		</div>
		<div class='container'>
		
		<div id="list-WSQuestions" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class='table table-striped'>
			<thead>
					<tr>
					
						<g:sortableColumn property="question" title="${message(code: 'WSQuestions.question.label', default: 'Question')}" />
					
						<g:sortableColumn property="isActive" title="${message(code: 'WSQuestions.isActive.label', default: 'Is Active')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${WSQuestionsInstanceList}" status="i" var="WSQuestionsInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${WSQuestionsInstance.id}">${fieldValue(bean: WSQuestionsInstance, field: "question")}</g:link></td>
					
						<td><g:formatBoolean boolean="${WSQuestionsInstance.isActive}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${WSQuestionsInstanceCount ?: 0}" />
			</div>
		</div>
		</div>
	</body>
</html>
