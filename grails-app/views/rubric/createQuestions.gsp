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
        <input type="text" name="id" value="${id }" hidden="true"/>
        <input type="text" name="numComp" value="${numComp }" hidden="true"/>
        <g:submitButton name="addQuestions" value="Add Questions" class="btn btn-lg btn-primary btn-block"/>
    </g:form>
    </div>
</body>
</html>