<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
</head>
<body>
    <div class='container'>
    <g:form action="addQuestions" name="addQuestions" class='form-signin'>
        <h2 class="form-signin-heading">Add Your Rubric Questions</h2>
        <g:each var='i' in="${1..numComp }">
            <p>
                Rubric Question ${i}:<input type="text" name="question${i}" size=200 height=250/>
            </p>
        </g:each>
        <input type="text" name="id" value="${id }" hidden="true"/>
        <input type="text" name="numComp" value="${numComp }" hidden="true"/>
        <g:submitButton name="addQuestions" value="Add Questions" class="btn btn-lg btn-primary btn-block"/>
    </g:form>
    </div>
</body>
</html>