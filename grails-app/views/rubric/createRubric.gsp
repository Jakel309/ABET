<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
</head>
<body>
    <div id='login' class='container'>
    <g:form action="createRubric" name="createRubric" class='form-signin'>
        <h2 class="form-signin-heading">Form Details</h2>
        <p>
            <label for='form-name' class="sr-only">Form Name: </label>
            <input type='text' class='form-control' name='name' placeholder="Form Name" required></input>
        </p>
        <p>
            <label for='num-questions' class="sr-only">Number of Ranked Questions: </label>
            <input type='text' class='form-control' name='numComp' placeholder='Number of Rubric Questions' required>
        </p>
        <g:submitButton name="createRubric" value="Create Rubric" class="btn btn-lg btn-primary btn-block" />
    </g:form>
    </div>
</body>
</html>