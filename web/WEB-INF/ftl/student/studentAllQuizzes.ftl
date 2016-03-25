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

<div class="datagrid">
  <table class="student-quizzes-assigned">
    <caption>Назначенные тесты</caption>
    <thead>
    <tr>
      <th>Тест</th>
    <#--<th>Крайний срок выполнения</th>-->
    </tr>
    </thead>
    <tbody>
<#if assignedQuizzes??>
    <#list assignedQuizzes as aQuiz>
    <tr class='${["alt", ""][aQuiz_index%2]}'>
      <td><a href="/student/pass/${aQuiz.id}">${aQuiz.quiz.title}</a></td>
    <#--<td>${aQuiz.deadline}</td>-->
    </tr>
    </#list>
</#if>
    </tbody>
  </table>
</div>

<div class="datagrid">
  <table class="student-quizzes-past">
    <caption>Пройденные тесты</caption>
      <thead>
    <tr>
      <th>Тест</th>
      <th>Оценка</th>
    </tr>
      </thead>
    <tbody>
    <#if passedQuizzes??>
        <#list passedQuizzes as pQuiz>
        <tr class='${["alt", ""][pQuiz_index%2]}'>
          <td>${pQuiz.quiz.title}</td>
          <td>${pQuiz.mark}</td>
        </tr>
        </#list>
    </#if>
    </tbody>
  </table>
</div>
</body>
</html>

