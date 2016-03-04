<#ftl encoding="UTF-8">
<#--<div class="question${number}">-->
<div class="question<#if number??>${number}t<#else>0</#if>">
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
  </div>
  <div>
    <button class="add-option" type="button">Добавить вариант ответа</button>
  </div>
</div>