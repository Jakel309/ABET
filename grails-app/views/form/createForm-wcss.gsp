<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
</head>
<body>
	<div id='login' class='container'>
	<g:form action="createForm" name="createForm" class='form-signin'>
		<h2 class="form-signin-heading">Form Details</h2>
		<p>
			<label for='form-name' class="sr-only">Form Name: </label>
			<input type='text' class='form-control' name='name' placeholder="form name" required></input>
		</p>
		<p>
			<label for='num-questions' class="sr-only">Number of Ranked Questions: </label>
			<input type='text' class='form-control' name='numComp' placeholder='number of ranked questions' required>
		</p>
		<g:submitButton name="createForm" value="Create Form" class="btn btn-lg btn-primary btn-block" />
	</g:form>
	</div>
</body>
</html>