<%@ page import="com.ABET.WSQuestions" %>



<div class="fieldcontain ${hasErrors(bean: WSQuestionsInstance, field: 'question', 'error')} required">
	<label for="question" class='sr-only'>
		<g:message code="WSQuestions.question.label" default="Question" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="question" required="" value="${WSQuestionsInstance?.question}" default="password" class='form-control required-indicator' placeholder="enter question*"/>

</div>

<div class="fieldcontain ${hasErrors(bean: WSQuestionsInstance, field: 'isActive', 'error')} ">
	<label for="isActive">
		<g:message code="WSQuestions.isActive.label" default="Is Active" />
		
	</label>
	<g:checkBox class='chk' name="isActive" value="${WSQuestionsInstance?.isActive}" />

</div>

