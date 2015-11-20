
<%@ page import="com.ABET.WorksheetQuestions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="General Criterion" />
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
		
		<div id="list-WorksheetQuestions" class="content scaffold-list" role="main">
			<h1>General Criterion</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class='table table-striped'>
			<thead>
					<tr>
					
						<g:sortableColumn property="question" title="${message(code: 'WorksheetQuestions.question.label', default: 'Question')}" />
					
						<g:sortableColumn property="isActive" title="${message(code: 'WorksheetQuestions.isActive.label', default: 'Is Active')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${worksheetQuestionsInstanceList}" status="i" var="worksheetQuestionsInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="edit" id="${worksheetQuestionsInstance.id}">${fieldValue(bean: worksheetQuestionsInstance, field: "question")}</g:link></td>
					
						<td><g:formatBoolean boolean="${worksheetQuestionsInstance.isActive}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${worksheetQuestionsInstanceCount ?: 0}" />
			</div>
		</div>
		</div>
	</body>
</html>
