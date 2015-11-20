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
	    <g:form action="chooseRubric" name="chooseRubric" class="form-signin">
	       <h2 class="form-signin-heading">Select an Existing Rubric</h2>
	       <select name='id' class="form-control input-lg">
	            <g:each in="${rows }" var="rubric">
	                <option value="${rubric["ID"] }">${rubric["NAME"] }</option>
	            </g:each>
	        </select>
	        <input type="hidden" name="w_id" value="${w_id }">
	        <g:submitButton name="chooseRubric" value="Choose Rubric" class="create-btn btn btn-lg btn-primary btn-block" />
	    </g:form>
	    <h2 class="form-signin-heading">Or Create a New Rubric</h2>
	    <g:link action="newRubric" params='[w_id:"${w_id}"]' class='create-btn btn btn-lg btn-primary btn-block'>Create New Rubric</g:link>
    </div>
</body>
</html>