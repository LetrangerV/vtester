<%--
  Created by IntelliJ IDEA.
  User: vstrokan
  Date: 2/29/16
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <div class="question">
    <select name="question_type">
      <option value="one_answer" selected>Выбор 1 варианта ответа</option>
      <option value="multi_answer">Выбор нескольких ответов</option>
      <option value="mapping">Установить соответствие</option>
      <option value="user_input">Свободный ответ</option>
    </select>
    <input type="text" name="question_text"/>     <!--TODO ADD LABELS-->
    <input type="text" name="option_text"/>
    <input type="radio" name="is-right"/>
    <input type="submit" value="Добавить вопрос"/>
  </div>
  </body>
</html>