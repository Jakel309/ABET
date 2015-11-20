<%
def rCont = grailsApplication.classLoader.loadClass("com.ABET.RubricController").newInstance()
 %>

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
        <div class='form-signin spacer'>
		    <g:each in="${rCont.getWorksheets() }" var="worksheet">
		        <g:link controller="rubric" action="renderWorksheet" params='[w_id:"${worksheet['ID']}"]' class='btn btn-lg btn-primary btn-block'>${worksheet['NAME'] }</g:link>
		    </g:each>
	    </div>
    </div>
</body>
</html>