/**
 * Created with IntelliJ IDEA.
 * User: vstrokan
 * Date: 3/3/16
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */

var addQuestionButton = document.querySelector(".add-question-btn");
var deleteQuestionElements = document.querySelectorAll(".delete-question");
var addOptionButtons = document.querySelectorAll(".add-option");

for (var i = 0; i < deleteQuestionElements.length; i++) {
    registerListeners(i);
}

//TODO: highlight questions without selected true answer. maybe before submitting form.
//TODO: refactor
//FIXME: now options are added only to last created question
//TODO pass parameters to POST request

function registerListeners(i) {
    deleteQuestionElements[i].addEventListener("click", deleteQuestionParent, false);
//    addOptionButtons[i].addEventListener("click", addOption, false);
}

addQuestionButton.addEventListener("click", addQuestion, false);

function addQuestion() {
    var questions = document.querySelector(".questions");

    getResource("/res/question.html").then(
        function(responseText) {
            questions.insertAdjacentHTML('beforeend', responseText);
            var deleteQuestionElements = questions.querySelectorAll(".delete-question");
            deleteQuestionElements[deleteQuestionElements.length - 1].addEventListener("click", deleteQuestionParent, false);

            var deleteOptionElements = questions.querySelectorAll(".delete-option");
            deleteOptionElements[deleteOptionElements.length - 1].addEventListener("click", deleteOptionParent, false);

            var addOptionButtons = questions.querySelectorAll(".add-option");
            console.log("add option cnt " + addOptionButtons.length);
            addOptionButtons[addOptionButtons.length - 1].addEventListener("click", addOption, false);
        },
        displayError
    );
}

function getResource(url) {
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
        }

        xhr.onerror = function() {
            reject(new Error("Network error."));
        }
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