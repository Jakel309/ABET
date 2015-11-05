<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
</head>
<body>
    <g:form action="addQuestions" name="addQuestions">
        <g:each var='i' in="${1..numComp }">
            <p>
                Question ${i}:<input type="text" name="question${i}" size=200 height=250/>
            </p>
        </g:each>
        <input type="text" name="name" value="${name }" hidden="true"/>
        <input type="text" name="numComp" value="${numComp }" hidden="true"/>
        <g:submitButton name="addQuestions" value="Add Questions" />
    </g:form>
</body>
</html>