<html>
<head>
  <script src="../../question1.js" defer></script>
  <script src="../../option1.js" defer></script>
  <title></title>
</head>
<body>

<div>
  <span>Название теста</span>
  <input type="text" name="title" placeholder="Тест" required/>
  <span>Число вопросов</span>
  <input type="number" value="10"/>
  <span>Число вариантов ответа</span>
  <input type="number" value="4"/>
</div>
  <div>
    <button class="add-question-btn" type="button">Добавить вопрос</button>    <!--todo maybe predefine number of questions or variants -->
  </div>                                  <!--TODO remove 1 default question, implement templating logic instead. Make radiobtn check required-->
  <div class="questions">
    <#--<div class="question">-->
      <#--<select name="question_type">-->
        <#--<option value="one_answer" selected>Выбор 1 варианта ответа</option>-->
        <#--<option value="multi_answer">Выбор нескольких ответов</option>-->
        <#--<option value="mapping">Установить соответствие</option>-->
        <#--<option value="user_input">Свободный ответ</option>-->
      <#--</select>-->
      <#--<span class="delete-question">Delete question</span>-->
      <#--<div>-->
        <#--<label>Текст вопроса</label>-->
        <#--<input type="text" name="question_text"/>-->
      <#--</div>-->
      <#--<div class="question-options">-->
        <#--<form class="option-form" action="">-->
          <#--<div class="question-option">-->
        <#--<span>-->
          <#--<label>Вариант ответа</label>-->
          <#--<input type="text" name="option_text"/>-->
        <#--</span>-->
        <#--<span>-->
          <#--<label>Правильный ответ?</label>-->
          <#--<input type="radio" name="is-right"/>-->
        <#--</span>-->
            <#--<span class="delete-option">Удалить</span>-->
          <#--</div>-->
        <#--</form>-->
      <#--</div>-->
      <#--<div>-->
        <#--<button class="add-option" type="button">Добавить вариант ответа</button>-->
        <#--<button class="submit-quiz" type="button">Сохранить тест</button>-->
      <#--</div>-->
    <#--</div>-->
  </div>


</body>
</html>