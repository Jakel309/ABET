<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
</head>
<body>
	<g:form action="createRubric" name="createRubric">
		<p>
			Rubric Name: <input type='text' name='name' required></input>
		</p>
		<p>
			Number of Rubric Questions: <input type='text' name='numComp' required>
		</p>
		<g:submitButton name="createRubric" value="Create Rubric" />
	</g:form>
</body>
</html>