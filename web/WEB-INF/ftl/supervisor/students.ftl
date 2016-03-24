<html>
<head></head>
<body>
<table>
  <tr>
    <#list quizzes as q>
        <th>${q.quiz.title}</th>
    </#list>
  </tr>
  <#list students as st>
  <tr>
  <#list st.assignedQuizzes as saq>
        <td>${saq.quiz.title} is ${saq.mark}</td>
      <#--<#if myOptionalVar??>when-present<#else>when-missing-->
    </#list>
  </tr>
  </#list>
</table>
</body>
</html>