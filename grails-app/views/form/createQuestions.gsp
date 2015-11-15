<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
</head>
<body>
	<div class='container'>
    <g:form action="addQuestions" name="addQuestions" class='form-signin'>
    	<h2 class="form-signin-heading">Add Your Questions</h2>
        <g:each var='i' in="${1..numComp }">
        <p>
            <label for='question' ${i} class="sr-only">Question ${i}</label>
            <input type="text" name="question${i}" class='form-control' id='question${i} inputQ${i}' placeholder='question ${i}'/>
        </p>
        </g:each>
        <input type="text" name="name" value="${name }" hidden="true"/>
        <input type="text" name="numComp" value="${numComp }" hidden="true"/>
        <g:submitButton name="addQuestions" value="Add Questions" class="btn btn-lg btn-primary btn-block"/>
    </g:form>
    </div>
</body>
</html>