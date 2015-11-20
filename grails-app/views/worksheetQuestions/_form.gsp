<%@ page import="com.ABET.WorksheetQuestions" %>



<div class="fieldcontain ${hasErrors(bean: worksheetQuestionsInstance, field: 'question', 'error')} required">
	<label for="question" class='sr-only'>
		<g:message code="worksheetQuestions.question.label" default="Question" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="question" required="" value="${worksheetQuestionsInstance?.question}" class='form-control required-indicator' placeholder="enter question*"/>

</div>

<div class="fieldcontain ${hasErrors(bean: worksheetQuestionsInstance, field: 'isActive', 'error')} ">
	<label for="isActive">
		<g:message code="worksheetQuestions.isActive.label" default="Is Active" />
		
	</label>
	<g:checkBox class='chk' name="isActive" value="${worksheetQuestionsInstance?.isActive}" />

</div>

