<html>
<head>
  <script src="" defer></script>
</head>
<body>
<div>Классы</div>
<#--<select class="classes">-->
  <#--<#list classes as class>-->
    <#--<option><a href="/supervisor/students/${class.name}">${class.name}</a></option>-->
  <#--</#list>-->
<#--</select>-->
<ul class="classes">
<#list classes as class>
  <li><a href="/supervisor/students/${class.name}">${class.name}</a></li>
</#list>
</ul>
Link

<table>
  <#--AJAX to /supervisor/students-->
  <tr>
    <th>ИФ</th>
    <th>quiz1</th>
    <th>quiz2</th>
  </tr>
    <#--<#list passedQuizzes as quiz>-->
      <#--<tr>-->
      <#--${quiz.mark}-->
      <#--</tr>-->
    <#--</#list>-->
</table>
</body>
</html>