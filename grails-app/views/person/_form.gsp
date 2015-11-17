<%@ page import="com.ABET.Person" %>

<%
  def personCont = grailsApplication.classLoader.loadClass("com.ABET.PersonController").newInstance()
 %>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'username', 'error')} required">
	<label for="username" class="sr-only">
		<g:message code="person.username.label" default="Username" />
		<!--   <span class="required-indicator">*</span> -->
	</label>
	<g:textField name="username" required="" value="${personInstance?.username}" default="Username" class='form-control required-indicator' placeholder="username*"/>


</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'password', 'error')} required">
	<label for="password" class='sr-only'>
		<g:message code="person.password.label" default="Password" />
		<!--   <span class="required-indicator">*</span> -->
	</label>
	<g:passwordField name="password" required="" default="password" class='form-control required-indicator' placeholder="password*"/>

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'accountExpired', 'error')} ">
	<label for="accountExpired">
		<g:message code="person.accountExpired.label" default="Account Expired" />
		
	</label>
	<g:checkBox class='chk' name="accountExpired" value="${personInstance?.accountExpired}" />

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'accountLocked', 'error')} ">
	<label for="accountLocked">
		<g:message code="person.accountLocked.label" default="Account Locked" />
		
	</label>
	<g:checkBox class='chk' name="accountLocked" value="${personInstance?.accountLocked}" />

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'enabled', 'error')} ">
	<label for="enabled">
		<g:message code="person.enabled.label" default="Enabled" />
		
	</label>
	<g:checkBox class='chk' name="enabled" value="${personInstance?.enabled}" />

</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'passwordExpired', 'error')} ">
	<label for="passwordExpired">
		<g:message code="person.passwordExpired.label" default="Password Expired" />
		
	</label>
	<g:checkBox class='chk' name="passwordExpired" value="${personInstance?.passwordExpired}" />

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

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'email', 'error')} required">
    <label for="email">
        <g:message code="person.email.label" default="Email" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="email" required="" value="${personInstance?.email}" default="email" class='form-control required-indicator' placeholder="email*"/>
</div>