<%@ page import="com.ABET.Worksheet"
 %>

<%
  def personCont = grailsApplication.classLoader.loadClass("com.ABET.PersonController").newInstance()
 %>



<div class="fieldcontain ${hasErrors(bean: worksheetInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="worksheet.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${worksheetInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: worksheetInstance, field: 'owner', 'error')} required">
	<label for="owner">
		<g:message code="worksheet.owner.label" default="Owner" />
		<span class="required-indicator">*</span>
	</label>
    
    <select name="owner">
        <g:each in="${personCont.getPersons()}" var="opt">
            <g:if test="${personInstance?.roleId==opt[0]}">
                <option selected="selected" value="${opt[0] }">${opt[1] }</option>            
            </g:if>
            <g:else>
                <option value="${opt[0] }">${opt[1] }</option>
            </g:else>
        </g:each>
    </select>
    
</div>

<div class="fieldcontain ${hasErrors(bean: worksheetInstance, field: 'program', 'error')} required">
	<label for="program">
		<g:message code="worksheet.program.label" default="Program" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="program" name="program.id" from="${com.ABET.Program.list()}" optionKey="id" required="" value="${worksheetInstance?.program?.id}" class="many-to-one"/>

</div>

