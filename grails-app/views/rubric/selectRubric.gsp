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
    <form action="chooseRubric" name="chooseRubric" class="form-signin">
    <h2 class="form-signin-heading">Existing Rubric</h2>
        <select name='id' class="form-control input-lg">
            <g:each in="${rows }" var="rubric">
                <option value="${rubric["ID"] }">${rubric["NAME"] }</option>
            </g:each>
        </select>
        <g:submitButton name="chooseRubric" value="Choose" class="create-btn btn btn-lg btn-primary btn-block" />
    </form>
    </div>
</body>
</html>