<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Welcome to Grails</title>
        <style type="text/css" media="screen">
        </style>
    </head>
    <body>
        <div class='container'>
	       <div class="form-signin spacer">
	           <sec:ifAllGranted roles="ROLE_ADMIN">
		           <g:link controller="person" class="btn btn-lg btn-primary btn-block">Create New User</g:link>
		           <br/>
		           <g:link controller="program" class="btn btn-lg btn-primary btn-block">Create New Program</g:link>
		           <br/>
		           <g:link controller="WSQuestions" class="btn btn-lg btn-primary btn-block">Manage Worksheet Questions</g:link>
		           <br/>
		           <g:link controller="worksheet" class="btn btn-lg btn-primary btn-block">Create And Distribute Worksheets</g:link>
		           <br/>
	           </sec:ifAllGranted>
	           <g:link controller="rubric" class="btn btn-lg btn-primary btn-block">Rubric Management</g:link>
	           <br/>
	           <g:link controller="logout" class="btn btn-lg btn-primary btn-block">Logout</g:link>
	       </div>
        </div>
    </body>
</html>
