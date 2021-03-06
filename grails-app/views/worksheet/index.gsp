
<%@ page import="com.ABET.Worksheet"%>
         
<%
  def personCont = grailsApplication.classLoader.loadClass("com.ABET.PersonController").newInstance()
 %>
 
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'worksheet.label', default: 'Worksheet')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<div class="nav container" role="navigation">
				<div class='col-md-1'><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></div>
				<div class='col-md-2'><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></div>
		</div>
		<div class='container'>

		<div id="list-worksheet" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class='table table-striped'>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'worksheet.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="owner" title="${message(code: 'worksheet.owner.label', default: 'Owner')}" />
					
						<th><g:message code="worksheet.program.label" default="Program" /></th>
						
						<th style="text-align:center;">Actions</th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${worksheetInstanceList}" status="i" var="worksheetInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${worksheetInstance.id}">${fieldValue(bean: worksheetInstance, field: "name")}</g:link></td>
					
						<td>${personCont.translatePerson(worksheetInstance?.owner)}</td>
					
						<td>${fieldValue(bean: worksheetInstance, field: "program")}</td>
						
						<td>
						  <g:if test="${worksheetInstance.wsResults}">
						      <g:link action="displayResults" class="btn btn-lg btn-primary btn-block" params='[w_id:"${worksheetInstance.id}"]'>View Worksheet</g:link>
						  </g:if>
						  <g:link action="delete" class="btn btn-lg btn-primary btn-block" params='[worksheetInstance:"${worksheetInstance}"]'>Delete Worksheet</g:link>
						</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${worksheetInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
