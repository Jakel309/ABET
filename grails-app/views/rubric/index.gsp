<%
def rCont = grailsApplication.classLoader.loadClass("com.ABET.RubricController").newInstance()
 %>

<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
</head>
<body>
    <div class='container'>
        <div class='form-signin spacer'>
		    <g:link action="newRubric" class='btn btn-lg btn-primary btn-block'>Create New Rubric</g:link>
		    <br />
		    <g:link action="selectRubric" class='btn btn-lg btn-primary btn-block'>Select Rubric to Fill Out</g:link>
		    <br/>
		    <g:each in="${rCont.getWorksheets() }" var="worksheet">
		        <%-- <a href="${createLink(action:'renderWorksheet', params:[id:worksheet['ID']])}">${worksheet['NAME'] }</a>--%>
		        <g:link controller="rubric" action="renderWorksheet" params="[id:'1']" class='btn btn-lg btn-primary btn-block'>${worksheet['NAME'] }</g:link>
		    </g:each>
	    </div>
    </div>
</body>
</html>