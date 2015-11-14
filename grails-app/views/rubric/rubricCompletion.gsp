<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
</head>
<body>

	Values in percent value of class total
	<form action="rubricSubmit" name="rubricSubmit">
		<table>
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
		Add any comments here:
		<g:textArea name="comments" rows="5" cols="40" />
		<input type="text" name="id" value="${id}" hidden="true">
		<g:submitButton name="rubricSubmit" value="Rubric Submit" />
	</form>
</body>
</html>