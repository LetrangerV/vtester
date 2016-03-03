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
    addOptionButtons[i].addEventListener("click", addOption, false);
}

function addOption() {
    var options = document.querySelectorAll(".question-options");
    var lastOption = options[options.length - 1];
    var form = lastOption.children[0];

    getResource("/res/option.html").then(
        function(responseText) {
            form.insertAdjacentHTML('beforeend', responseText);
            var deleteOptionElements = lastOption.querySelectorAll(".delete-option");
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