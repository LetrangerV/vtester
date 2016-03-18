<html>
<head></head>
<body>
    <div class="table-bordered table-responsive">
    <table class="table student-quizzes-assigned">
      <th>
        <td>Тест</td>
        <#--<td>Крайний срок выполнения</td>-->
      </th>
    <#list assignedQuizzes as aQuiz>
        <tr>
          <td>${aQuiz.title}</td>
          <#--<td>${aQuiz.deadline}</td>-->
        </tr>
    </#list>
    </table>
    </div>

    <div class="table-bordered table-responsive">
    <table class="table student-quizzes-past">
      <th>
        <td>Тест</td>
        <td>Оценка</td>
      </th>
    <#--<#list passedQuizzes as pQuiz>-->
      <#--<tr>-->
        <#--<td>${pQuiz.title}</td>-->
        <#--<td>${pQuiz.mark}</td>-->
      <#--</tr>-->
    <#--</#list>-->
    </table>
    </div>
</body>
</html>