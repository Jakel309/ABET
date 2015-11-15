<%@ page import="com.ABET.WSQuestions" %>



<div class="fieldcontain ${hasErrors(bean: WSQuestionsInstance, field: 'question', 'error')} required">
	<label for="question">
		<g:message code="WSQuestions.question.label" default="Question" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="question" required="" value="${WSQuestionsInstance?.question}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: WSQuestionsInstance, field: 'isActive', 'error')} ">
	<label for="isActive">
		<g:message code="WSQuestions.isActive.label" default="Is Active" />
		
	</label>
	<g:checkBox name="isActive" value="${WSQuestionsInstance?.isActive}" />

</div>

