/**
 * Created with IntelliJ IDEA.
 * User: vstrokan
 * Date: 3/3/16
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */

var addQuestionButton = document.querySelector(".add-question-btn");
var deleteQuestionElements = document.querySelectorAll(".delete-question");
var initialQuestionCounter = document.querySelector("input.init-questions");
var initialOptionCounter = document.querySelector("input.init-options");
var cachedQuestion;          //todo cache all 4 types of questions. decide how. maybe EhCache, then don't cache on js side
var quiz = [];

var questionJson = {
    "question_type" : "",
    "question_text" : "",
    "options" : []
};

var optionJson = {
    "option_text" : "",
    "is_right" : false
}; //todo add and remove questions and options on events

for (var i = 0; i < deleteQuestionElements.length; i++) {
    registerListeners(i);
}

['input', 'onkeyup'].forEach(function(e){
    initialQuestionCounter.addEventListener(e, initQuestionsHandler, false);
    initialOptionCounter.addEventListener(e, initOptionsHandler, false);
});

function initQuestionsHandler(e) {
    var questionCnt = e.target.value;
    redraw(cachedQuestion, questionCnt);
}

function initOptionsHandler(e) {
    //todo
}

function redraw(question, totalNumber) {
    var questions = document.querySelector(".questions");
    while(questions.lastChild) {
        questions.removeChild(questions.lastChild);
    }

    for (var i = 0; i < totalNumber; i++) {
        insertNewQuestion(questions, question);
    }
}

function registerListeners(i) {
    deleteQuestionElements[i].addEventListener("click", deleteQuestionParent, false);
}

addQuestionButton.addEventListener("click", addQuestion, false);

function addQuestion() {
    var questions = document.querySelector(".questions");
    var resourceUrl = "/question";
    //noinspection JSUnresolvedFunction
    getResource(resourceUrl).then(
        function(responseText) {
            insertNewQuestion(questions, responseText);
        },
        displayError
    );
}

function insertNewQuestion(questions, question) {
        questions.insertAdjacentHTML('beforeend', question);
        var deleteQuestionElements = questions.querySelectorAll(".delete-question");
        deleteQuestionElements[deleteQuestionElements.length - 1].addEventListener("click", deleteQuestionParent, false);

        var deleteOptionElements = questions.querySelectorAll(".delete-option");
        if (deleteOptionElements && deleteOptionElements.length > 0) {
            deleteOptionElements[deleteOptionElements.length - 1].addEventListener("click", deleteOptionParent, false);
        }

        var addOptionButtons = questions.querySelectorAll(".add-option");
        if (addOptionButtons && addOptionButtons.length > 0) {
            addOptionButtons[addOptionButtons.length - 1].addEventListener("click", addOption, false);
        }
}

function getResource(url) {
    //noinspection JSUnresolvedFunction
    return new Promise(function(resolve, reject) {
        var xhr = new XMLHttpRequest();
        xhr.open('GET', url);
        xhr.onload = function() {
            if (xhr.status == 200) {
                resolve(xhr.responseText);
            } else {
                var error = new Error(xhr.statusText);
                error.code = xhr.status;
                reject(error);
            }
        };

        xhr.onerror = function() {
            reject(new Error("Network error."));
        };
        xhr.send();
    });
}

function deleteQuestionParent() {
    var parent = this.parentNode;
    parent.parentNode.removeChild(parent);
}

function displayError(error) {
    alert(error.code + ' ' + error);
}

function validateSingleAnswer(option) {
    //todo check if question has no options
    var optionCheckboxes = option.querySelectorAll("input[type=checkbox]");
    var hiddenCheckboxesValues = option.querySelectorAll("input.is-right");

    var isOk = false;

    for (var i = 0; i < optionCheckboxes.length; i++) {
        var checkBox = optionCheckboxes[i];
        hiddenCheckboxesValues[i].value = checkBox.checked;

        if (checkBox.checked) {
            isOk = true;
        }
    }

    if (!isOk) {
        if (option.classList.contains("alert-success")) {
            option.classList.remove("alert-success");
            option.classList.remove("alert");
        }
        option.classList.add("alert-danger");
        option.classList.add("alert");
        isOk = false;
    } else {
        if (option.classList.contains("alert-danger")) {
            option.classList.remove("alert-danger");
            option.classList.remove("alert");
        }
        option.classList.add("alert-success");
        option.classList.add("alert");
    }

    return isOk;
}

function validateAllQuestions() {
    var optsWrapper = document.querySelectorAll("div.question-options");
    var isValid = true;
    var optionsCountFields = document.querySelectorAll("input.options-count");

    for (var i = 0; i < optsWrapper.length; i++) {
        optionsCountFields[i].value = optsWrapper[i].children.length;
        if (!validateSingleAnswer(optsWrapper[i])) {
            isValid = false;
        }
    }

    return isValid;
}