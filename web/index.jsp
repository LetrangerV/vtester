<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
  <script type="text/javascript" src="option.js" defer></script>
  <script type="text/javascript" src="question1.js" defer></script>
</head>
<body>

<div>
  <span>Число вопросов</span>
  <input type="number" value="10"/>
  <span>Число вариантов ответа</span>
  <input type="number" value="4"/>
</div>
<div>
  <button class="add-question-btn" type="button">Добавить вопрос</button>    <!--todo maybe predefine number of questions or variants -->
</div>                                  <!--TODO remove 1 default question, implement templating logic instead. Make radiobtn check required-->
<form action="quiz" method="POST">
<div class="questions">
  <%--<div class="question">--%>
    <%--<select name="question_type">--%>
      <%--<option value="one_answer" selected>Выбор 1 варианта ответа</option>--%>
      <%--<option value="multi_answer">Выбор нескольких ответов</option>--%>
      <%--<option value="mapping">Установить соответствие</option>--%>
      <%--<option value="user_input">Свободный ответ</option>--%>
    <%--</select>--%>
    <%--<span class="delete-question">Delete question</span>--%>
    <%--<div>--%>
      <%--<label>Текст вопроса</label>--%>
      <%--<input type="text" name="question_text"/>--%>
    <%--</div>--%>
    <%--<div class="question-options">--%>
      <%--<div class="question-option">--%>
        <%--<span>--%>
          <%--<label>Вариант ответа</label>--%>
          <%--<input type="text" name="option_text"/>--%>
        <%--</span>--%>
        <%--<span>--%>
          <%--<label>Правильный ответ?</label>--%>
          <%--<input type="radio" name="is-right"/>--%>
        <%--</span>--%>
        <%--<span class="delete-option">Удалить</span>--%>
      <%--</div>--%>
    <%--</div>--%>
    <%--<div>--%>
      <%--<button class="add-option" type="button">Добавить вариант ответа</button>--%>
    <%--</div>--%>
  <%--</div>--%>
</div>
  <input class="submit-quiz" type="submit" value="Сохранить тест"/>
</form>

</body>
</html>