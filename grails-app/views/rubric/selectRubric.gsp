<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
</head>
<body>
    <form action="chooseRubric" name="chooseRubric">
        <select name='id'>
            <g:each in="${rows }" var="rubric">
                <option value="${rubric["ID"] }">${rubric["NAME"] }</option>
            </g:each>
        </select>
        <br />
        <g:submitButton name="chooseRubric" value="Choose Rubric" />
    </form>
</body>
</html>