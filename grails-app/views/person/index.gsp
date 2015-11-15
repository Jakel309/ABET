
<%@ page import="com.ABET.Person" %>
<%
  def pCont = grailsApplication.classLoader.loadClass('com.ABET.PersonController').newInstance()
 %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-person" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="username" title="${message(code: 'person.username.label', default: 'Username')}" />
					
						<g:sortableColumn property="accountExpired" title="${message(code: 'person.accountExpired.label', default: 'Account Expired')}" />
					
						<g:sortableColumn property="accountLocked" title="${message(code: 'person.accountLocked.label', default: 'Account Locked')}" />
					
						<g:sortableColumn property="enabled" title="${message(code: 'person.enabled.label', default: 'Enabled')}" />
					
						<g:sortableColumn property="passwordExpired" title="${message(code: 'person.passwordExpired.label', default: 'Password Expired')}" />
						
						<g:sortableColumn property="roleId" title="${message(code: 'person.roleId.label', default: 'Role')}" />
						
						<g:sortableColumn property="email" title="${message(code: 'person.email.label', default: 'Email')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${personInstanceList}" status="i" var="personInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="edit" id="${personInstance.id}">${fieldValue(bean: personInstance, field: "username")}</g:link></td>
					
						<td><g:formatBoolean boolean="${personInstance.accountExpired}" /></td>
					
						<td><g:formatBoolean boolean="${personInstance.accountLocked}" /></td>
					
						<td><g:formatBoolean boolean="${personInstance.enabled}" /></td>
					
						<td><g:formatBoolean boolean="${personInstance.passwordExpired}" /></td>
						
						<td>${pCont.translateRole(personInstance.roleId)}</td>
						
						<td>${personInstance.email }</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${personInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
