<%--
  Created by IntelliJ IDEA.
  User: vstrokan
  Date: 3/3/16
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>

<form action="quiz" method="POST">

<div>
  <button class="add-question-btn" type="button">Добавить вопрос</button>    <!--todo maybe predefine number of questions or variants -->
</div>
<div class="questions">
  <div class="question">
    <select name="question_type">
      <option value="one_answer" selected>Выбор 1 варианта ответа</option>
      <option value="multi_answer">Выбор нескольких ответов</option>
      <option value="mapping">Установить соответствие</option>
      <option value="user_input">Свободный ответ</option>
    </select>
    <span class="delete-question">Delete question</span>
    <div>
      <label>Текст вопроса</label>
      <input type="text" name="question_text"/>
    </div>
    <div class="question-options">
      <form action="">
      <div class="question-option">
        <span>
          <label>Вариант ответа</label>
          <input type="text" name="option_text"/>
        </span>
        <span>
          <label>Правильный ответ?</label>
          <input type="radio" name="is-right"/>
        </span>
        <span class="delete-option">Удалить</span>
      </div>
      </form>
    </div>
    <div>
      <button class="add-option" type="button">Добавить вариант ответа</button>
      <input type="submit" value="Сохранить тест"/>
    </div>
  </div>
</div>
<%--<form action="quiz" method="POST">--%>
  <%--<input type="submit" value="Сохранить тест"/>--%>
</form>

<script src="question.js"></script>
<script src="option.js"></script>
</body>
</html>