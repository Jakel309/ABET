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
<<<<<<< HEAD:grails-app/views/form/createQuestions.gsp
        <p>
            <label for='question' ${i} class="sr-only">Question ${i}</label>
            <input type="text" name="question${i}" class='form-control' id='question${i} inputQ${i}' placeholder='question ${i}'/>
        </p>
=======
            <p>
                Rubric Question ${i}:<input type="text" name="question${i}" size=200 height=250/>
            </p>
>>>>>>> 86b8e48d3b8188ab62e74b0451d087d1345d1bcc:grails-app/views/rubric/createQuestions.gsp
        </g:each>
        <input type="text" name="id" value="${id }" hidden="true"/>
        <input type="text" name="numComp" value="${numComp }" hidden="true"/>
        <g:submitButton name="addQuestions" value="Add Questions" class="btn btn-lg btn-primary btn-block"/>
    </g:form>
    </div>
</body>
</html>