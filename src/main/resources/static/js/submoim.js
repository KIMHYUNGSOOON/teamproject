window.onload = function () {
    console.log("페이지가 로드되었습니다."); // 이 줄을 추가
    var textElements = document.querySelectorAll(".text");

    textElements.forEach(function (element) {
        var text = element.innerText;
        var maxLength = 30;

        if (text.length > maxLength) {
            var truncatedText = text.slice(0, maxLength) + "...";
            element.innerText = truncatedText;
        }
    });
};