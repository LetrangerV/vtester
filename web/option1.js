/**
 * Created with IntelliJ IDEA.
 * User: vstrokan
 * Date: 3/3/16
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 */
var deleteOptionElements = document.querySelectorAll(".delete-option");
var addOptionButtons = document.querySelectorAll(".add-option");
for (var i = 0; i < deleteOptionElements.length; i++) {
    registerListeners(i);
}

function registerListeners(i) {
    deleteOptionElements[i].addEventListener("click", deleteOptionParent, false);
    addOptionButtons[i].addEventListener("click", function(event) {addOption(event);}, false);
}

function addOption(event) {
    var targetBtn = event.target;
    var targetQuestion = targetBtn.parentNode.parentNode;
    var options = targetQuestion.querySelector(".question-options");

    //noinspection JSUnresolvedFunction
    getResource("/option").then(
        function(responseText) {
            options.insertAdjacentHTML('beforeend', responseText);
            var deleteOptionElements = targetQuestion.querySelectorAll(".delete-option");
            var deleteOptionElement = deleteOptionElements[deleteOptionElements.length - 1];
            deleteOptionElement.addEventListener("click", deleteOptionParent, false);
        },
        displayError
    );
}

function deleteOptionParent() {
    var parent = this.parentNode;
    parent.parentNode.removeChild(parent);
}