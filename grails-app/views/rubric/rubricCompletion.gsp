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
		<table class='table table-striped'>
			<tr>
				<td>Question</td>
				<td>Unacceptable</td>
				<td>Marginal</td>
				<td>Expected</td>
				<td>Outstanding</td>
			</tr>
			<%def i=0 %>
			<g:each in="${questions }" var="question">
				<%i++ %>
				<tr>
					<td>
						${question['QUESTION'] }
						<input type="text" name="question${i}" value="${question['QUESTION']}" hidden="true">
					</td>
					<td><input type="number" name="${i}-1" required>%</td>
					<td><input type="number" name="${i}-2" required>%</td>
					<td><input type="number" name="${i}-3" required>%</td>
					<td><input type="number" name="${i}-4" required>%</td>
				</tr>
			</g:each>
		</table>
		<g:textArea name="comments" class="form-control comments" rows="3" placeholder="Comments..." />
		<input type="text" name="id" value="${id}" hidden="true">
		<g:submitButton name="rubricSubmit" value="Submit Rubric" class="submit-btn btn btn-lg btn-primary btn-block" />
	</form>
</body>
</html>