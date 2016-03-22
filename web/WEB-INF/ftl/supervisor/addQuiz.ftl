<html>
<head>
  <title></title>
  <link rel="stylesheet" href="css/question.css"/>
  <link
    rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
    integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
    crossorigin="anonymous">
  <script type="text/javascript" src="option1.js" defer></script>
  <script type="text/javascript" src="question1.js" defer></script>
</head>
<body>

<form action="quiz" method="POST" onsubmit="return validateAllQuestions();">
  <div>
    <span>Название теста</span>
    <input type="text" name="title" placeholder="Тест" required/>
    <span>Число вопросов</span>
    <input class="init-questions" type="number" value="10" max="50" min="0"/>    <!--TODO user still can break manually-->
    <%--function forceNumeric(){--%>
    <%--var $input = $(this);--%>
    <%--$input.val($input.val().replace(/[^\d]+/g,''));--%>
    <%--}--%>
    <%--$('body').on('propertychange input', 'input[type="number"]', forceNumeric);--%>
    <span>Число вариантов ответа</span>
    <input class="init-options" type="number" value="4" max="10" min="0"/>
    <span class="add-question-btn green glyphicon glyphicon-plus-sign"></span>

  </div>
  <input class="submit-quiz" type="submit" value="Сохранить тест"/>
  <div class="questions">
  </div>
</form>

</body>
</html>