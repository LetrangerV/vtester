<html>
<head>
  <link
    rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
    integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
    crossorigin="anonymous">
  <link rel="stylesheet" href="/css/question.css"/>
</head>
<body>

<form action="/student/quiz" method="POST">
<#assign questionCounter = 0>
<#list questions as question>
<#--TODO table-->
<div class="question">
  <div>
    ${question.questionText}
  </div>
    <#list question.options as option>
        <div class="question-option">
        <span>${option.optionText}</span>
        <input type="radio" name="question${questionCounter}" value="${option.id}"/>
        </div>
    </#list>
    <#assign questionCounter = questionCounter + 1>
</div>
</#list>
  <input type="submit" value="Отправить"/>
</form>

</body>
</html>