<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
</head>
<body>

	<div class="nav container" role="navigation">
				<div class='col-md-1'><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/> </a></div>
	</div>
		
    <div class='container'>
    <g:form action="addQuestions" name="addQuestions" class='form-signin questions'>
        <h2 class="form-signin-heading">Rubric Questions</h2>
        <g:each var='i' in="${1..numComp }">
            <p>
            	<label for='form-name' class="sr-only">Question ${i}</label>
            	<input type='text' class='form-control' name="question${i}" placeholder="question ${i}" required></input>
            </p>
        </g:each>
        <input type="hidden" name="id" value="${id }"/>
        <input type="hidden" name="numComp" value="${numComp }"/>
        <input type="hidden" name="w_id" value="${w_id }">
        <g:submitButton name="addQuestions" value="Add Questions" class="btn btn-lg btn-primary btn-block"/>
    </g:form>
    </div>
</body>
</html>