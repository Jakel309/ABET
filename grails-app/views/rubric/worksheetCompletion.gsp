<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
</head>
<body>
	<div class="nav container" role="navigation">
				<div class='col-md-1'><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/> </a></div>
	</div>
		
	<div class="container">
	<h1>Complete Rubric for Your Class</h1>
	Values in percent value of class total
	<form action="rubricSubmit" name="rubricSubmit">
	
	   <%def i=0 %>
	    <g:each in="${w_questions }" var="question">
	       <%i++ %>
	       ${question['Question'] }
	       <br/>
	       <input type="hidden" name="ws_question${i}" value="${question['QUESTION']}">
	       <input type="text" name="ws_question${i}-A" value="${ws_results?ws_results[question['QUESTION']]:'' }">
	       <br/>
	    </g:each>
	
		<table class='table table-striped'>
			<tr>
				<td>Question</td>
				<td>Unacceptable</td>
				<td>Marginal</td>
				<td>Expected</td>
				<td>Outstanding</td>
			</tr>
			<%i=0 %>
			<g:each in="${questions }" var="question">
				<%i++ %>
				<tr>
					<td>
						${question['QUESTION'] }
						<input type="hidden" name="question${i}" value="${question['QUESTION']}">
					</td>
					<g:if test="${r_results}">
						<td><input type="number" name="${i}-1" value="${r_results[question['QUESTION']]['Unacceptable']}">%</td>
						<td><input type="number" name="${i}-2" value="${r_results[question['QUESTION']]['Marginal']}">%</td>
						<td><input type="number" name="${i}-3" value="${r_results[question['QUESTION']]['Expected']}">%</td>
						<td><input type="number" name="${i}-4" value="${r_results[question['QUESTION']]['Outstanding']}">%</td>
					</g:if>
					<g:else>
					   <td><input type="number" name="${i}-1">%</td>
	                   <td><input type="number" name="${i}-2">%</td>
	                   <td><input type="number" name="${i}-3">%</td>
	                   <td><input type="number" name="${i}-4">%</td>
					</g:else>
				</tr>
			</g:each>
		</table>
		<g:if test="${r_results}">
		  <g:textArea name="comments" class="form-control comments" rows="3" placeholder="Comments..." value="${r_results['Comments'] }" />
		</g:if>
		<g:else>
		  <g:textArea name="comments" class="form-control comments" rows="3" placeholder="Comments..." />
		</g:else>
		<input type="hidden" name="r_id" value="${r_id}">
		<input type="hidden" name="w_id" value="${w_id}">
		<g:submitButton name="rubricSubmit" value="Submit Rubric" class="submit-btn btn btn-lg btn-primary btn-block" />
	</form>
</body>
</html>