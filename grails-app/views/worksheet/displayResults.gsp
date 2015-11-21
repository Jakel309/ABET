<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
</head>
<body>
    <div class="nav container" role="navigation">
                <div class='col-md-1'><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/> </a></div>
    </div>
        
    <div class="container">
    <h1>Complete Rubric for Your Class</h1>
    Values in percent value of class total
    
       <%def i=0 %>
        <g:each in="${w_questions }" var="question">
           <%i++ %>
           ${question['Question'] }
           <br/>
           ${ws_results?ws_results[question['QUESTION']]:'' }
           <br/>
        </g:each>
    
        <table class='table table-striped'>
            <tr>
                <td>Question</td>
                <td>Unacceptable</td>
                <td>Marginal</td>
                <td>Expected</td>
                <td>Outstanding</td>
            </tr>
            <%i=0 %>
            <g:each in="${questions }" var="question">
                <%i++ %>
                <tr>
                    <td>
                        ${question['QUESTION'] }
                    </td>
                    <td>${r_results[question['QUESTION']]['Unacceptable']}%</td>
                    <td>${r_results[question['QUESTION']]['Marginal']}%</td>
                    <td>${r_results[question['QUESTION']]['Expected']}%</td>
                    <td>${r_results[question['QUESTION']]['Outstanding']}%</td>
                </tr>
            </g:each>
        </table>
        ${r_results['Comments'] }
</body>
</html>