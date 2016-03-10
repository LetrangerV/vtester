<div class="question">
  <select name="question_type">
    <option value="one_answer" selected>Выбор 1 варианта ответа</option>
    <option value="multi_answer">Выбор нескольких ответов</option>
    <option value="mapping">Установить соответствие</option>
    <option value="user_input">Свободный ответ</option>
  </select>
  <span class="delete-question red glyphicon glyphicon-remove-sign"></span>
  <div>
    <label>Текст вопроса</label>
    <input type="text" name="question_text" required placeholder="Your text"/>
    <span class="add-option green glyphicon glyphicon-plus"></span>
  </div>
  <div class="question-options">
  </div>
  <input type="hidden" class="options-count" name="options-count"/>
</div>