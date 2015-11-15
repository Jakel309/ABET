<%
def rCont = grailsApplication.classLoader.loadClass("com.ABET.RubricController").newInstance()
 %>

<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
</head>
<body>
    <g:link action="newRubric">Create New Rubric</g:link>
    <br />
    <g:link action="selectRubric">Select Rubric to Fill Out</g:link>
    <br/>
    <g:each in="${rCont.getWorksheets() }" var="worksheet">
        <%-- <a href="${createLink(action:'renderWorksheet', params:[id:worksheet['ID']])}">${worksheet['NAME'] }</a>--%>
        <g:link controller="rubric" action="renderWorksheet" params="[id:'1']">${worksheet['NAME'] }</g:link>
    </g:each>
</body>
</html>