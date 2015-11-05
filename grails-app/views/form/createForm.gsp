<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
</head>
<body>
	<g:form action="createForm" name="createForm">
		<p>
			Form Name: <input type='text' name='name' required></input>
		</p>
		<p>
			Number of Ranked Questions: <input type='text' name='numComp' required>
		</p>
		<g:submitButton name="createForm" value="Create Form" />
	</g:form>
</body>
</html>