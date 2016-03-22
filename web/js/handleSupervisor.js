var usersMarksSpan = document.querySelector(".users-marks");
var testsSpan = document.querySelector(".tests");
var addTestSpan = document.querySelector(".add-test");

function addTestCallback() {
    var url = "/quiz/add";
    getContent(url);
}

function usersMarksCallback() {
    var url = "/student/marks";
    getContent(url);
}

function testsCallback() {
    var url = "/quiz/all";
    getContent(url);
}

function getContent(url) {
    getResource(url).then(
        function(responseText) {
            var content = document.querySelector(".content");
            content.innerHTML = "";
            content.insertAdjacentHTML('beforeend', responseText);
        },
        function() {
            alert(error.code + ' ' + error);
        }
    );
}

usersMarksSpan.addEventListener("click", usersMarksCallback, false);
testsSpan.addEventListener("click", testsCallback, false);
addTestSpan.addEventListener("click", addTestCallback, false);

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