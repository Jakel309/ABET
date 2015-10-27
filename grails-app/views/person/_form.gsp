<%@ page import="com.ABET.Person" %>

<%
  def personCont = grailsApplication.classLoader.loadClass("com.ABET.PersonController").newInstance()
 %>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="person.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${personInstance?.username}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="person.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${personInstance?.password}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'accountExpired', 'error')} ">
	<label for="accountExpired">
		<g:message code="person.accountExpired.label" default="Account Expired" />
		
	</label>
	<g:checkBox name="accountExpired" value="${personInstance?.accountExpired}" />

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'accountLocked', 'error')} ">
	<label for="accountLocked">
		<g:message code="person.accountLocked.label" default="Account Locked" />
		
	</label>
	<g:checkBox name="accountLocked" value="${personInstance?.accountLocked}" />

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'enabled', 'error')} ">
	<label for="enabled">
		<g:message code="person.enabled.label" default="Enabled" />
		
	</label>
	<g:checkBox name="enabled" value="${personInstance?.enabled}" />

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'passwordExpired', 'error')} ">
	<label for="passwordExpired">
		<g:message code="person.passwordExpired.label" default="Password Expired" />
		
	</label>
	<g:checkBox name="passwordExpired" value="${personInstance?.passwordExpired}" />

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'roleId', 'error')} ">
    <label for="roleId">
        <g:message code="person.roleId.label" default="Role ID" />
        
    </label>
    
    <select name="roleId">
        <g:each in="${personCont.getRoles()}" var="opt">
            <g:if test="${personInstance?.roleId==opt[0]}">
                <option selected="selected" value="${opt[0] }">${opt[1] }</option>            
            </g:if>
            <g:else>
                <option value="${opt[0] }">${opt[1] }</option>
            </g:else>
        </g:each>
    </select>
</div>