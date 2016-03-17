<html>
<head></head>
<body>
    <table class="table table-responsive student-quizzes-assigned">
      <th>
        <td>Тест</td>
        <td>Крайний срок выполнения</td>
      </th>
    <#list assignedQuizzes as aQuiz>
        <tr>
          <td>${aQuiz.title}</td>
          <td>${aQuiz.deadline}</td>
        </tr>
    </#list>
    </table>

    <table class="table table-responsive student-quizzes-past">
      <th>
        <td>Тест</td>
        <td>Оценка</td>
      </th>
    <#list passedQuizzes as pQuiz>
      <tr>
        <td>${pQuiz.title}</td>
        <td>${pQuiz.mark}</td>
      </tr>
    </#list>
    </table>
</body>
</html>