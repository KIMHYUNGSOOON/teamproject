 $(document).ready(function(){

    $("#c_button").hover(function(){
        $(this).css("transform", "scale(1.2)");
    }, function(){
        $(this).css("transform", "scale(1.0)");
    });

    $("#g_button").hover(function(){
    $(this).css("transform", "scale(1.2)");
}, function(){
    $(this).css("transform", "scale(1.0)");
});

    $("#n_button").hover(function(){
    $(this).css("transform", "scale(1.2)");
}, function(){
    $(this).css("transform", "scale(1.0)");
});

    $("#k_button").hover(function(){
    $(this).css("transform", "scale(1.2)");
}, function(){
    $(this).css("transform", "scale(1.0)");
});

    $("#d_button").hover(function(){
    $(this).css("transform", "scale(1.2)");
}, function(){
    $(this).css("transform", "scale(1.0)");
});
});

    $(document).ready(function(){
    var subnavVisible = false;

    $(".location-icon").hover(function(){
    $(".subnav").css("display", "grid");
    subnavVisible = true;
}, function(){
    hideSubnav();
});

    $(".subnav").hover(function(){
    $(this).css("display", "grid");
    subnavVisible = true;
}, function(){
    hideSubnav();
});

    $(".item").hover(function(){
    subnavVisible = true;
}, function(){
    subnavVisible = false;
    hideSubnav();
});

    function hideSubnav() {
    subnavVisible = false;

    setTimeout(function() {
    if (!subnavVisible) {
    $(".subnav").css("display", "none");
}
}, 300);
}
});

    // HTML 요소 선택
    const daysTag = document.querySelector(".days"),
    currentDate = document.querySelector(".current-date"),
    prevNextIcon = document.querySelectorAll(".icons span");

    // 현재 날짜, 연도 및 월 가져오기
    let date = new Date(),
    currYear = date.getFullYear(),
    currMonth = date.getMonth();

    // 월 이름 배열
    const months = ["01", "02", "03", "04", "05", "06", "07",
    "08", "09", "10", "11", "12"];

    // 캘린더를 렌더링하는 함수
    const renderCalendar = () => {
    let firstDayofMonth = new Date(currYear, currMonth, 1).getDay(), // getting first day of month
    lastDateofMonth = new Date(currYear, currMonth + 1, 0).getDate(), // getting last date of month
    lastDayofMonth = new Date(currYear, currMonth, lastDateofMonth).getDay(), // getting last day of month
    lastDateofLastMonth = new Date(currYear, currMonth, 0).getDate(); // getting last date of previous month
    // 캘린더 날짜를 위한 HTML 생성
    let liTag = "";

    for (let i = firstDayofMonth; i > 0; i--) { // creating li of previous month last days
    liTag += `<li class="inactive">${lastDateofLastMonth - i + 1}</li>`;
}

    for (let i = 1; i <= lastDateofMonth; i++) { // creating li of all days of current month
    // adding active class to li if the current day, month, and year matched
    let isToday = i === date.getDate() && currMonth === new Date().getMonth()
    && currYear === new Date().getFullYear() ? "active" : "";
    liTag += `<li class="${isToday}" onclick="highlightDate(this)">${i}</li>`;

    // 현재 날짜 표시 업데이트
    currentDate.innerText = `${currYear}년 ${months[currMonth]}`;
    daysTag.innerHTML = liTag;
}

    for (let i = lastDayofMonth; i < 6; i++) { // creating li of next month first days
    liTag += `<li class="inactive">${i - lastDayofMonth + 1}</li>`
}
    currentDate.innerText = ` ${currYear} ${months[currMonth]}`; // passing current mon and yr as currentDate text
    daysTag.innerHTML = liTag;


}
    // 캘린더 초기 렌더링
    renderCalendar();

    // 선택한 날짜 강조 함수
    const highlightDate = (element) => {
    // 이전에 선택된 날짜의 강조 제거
    const selectedDate = document.querySelector(".selected");
    if (selectedDate) {
    selectedDate.classList.remove("selected");
}
    // 클릭한 날짜에 강조 스타일 추가
    element.classList.add("selected");
};

    // 내비게이션 아이콘에 클릭 이벤트 리스너 추가
    prevNextIcon.forEach(icon => {
    icon.addEventListener("click", () => {// adding click event on both icons
        // if clicked icon is previous icon then decrement current month by 1 else increment it by 1
        currMonth = icon.id === "prev" ? currMonth - 1 : currMonth + 1;

        if(currMonth < 0 || currMonth > 11) { // if current month is less than 0 or greater than 11
            // creating a new date of current year & month and pass it as date value
            date = new Date(currYear, currMonth, new Date().getDate());
            currYear = date.getFullYear(); // updating current year with new date year
            currMonth = date.getMonth(); // updating current month with new date month
        } else {
            date = new Date(); // pass the current date as date value
        }
        // renderCalendar 함수 호출
        renderCalendar(); // calling renderCalendar function
    });

});


    $(document).ready(function() {
    let wrapperVisible = false; // wrapper의 가시성 상태를 나타내는 변수

    // calendar-icon에 마우스가 올라갔을 때
    $(".calendar-icon").hover(function() {
    $(".wrapper").show(); // wrapper를 표시
    wrapperVisible = true; // wrapper가 표시됨을 나타내는 플래그 설정
});

    // date-input2에 마우스가 올라갔을 때
    $(".date-input2").hover(function() {
    $(".wrapper").show(); // wrapper를 표시
    wrapperVisible = true; // wrapper가 표시됨을 나타내는 플래그 설정
});

    // wrapper 영역에 마우스가 나갔을 때
    $(".wrapper").mouseleave(function() {
    // wrapper가 표시되었고 마우스가 영역을 벗어났을 때만 숨김
    if (wrapperVisible) {
    $(".wrapper").hide(); // wrapper를 숨김
    wrapperVisible = false; // wrapper가 숨겨짐을 나타내는 플래그 설정
}
});
});
 document.addEventListener('DOMContentLoaded', function() {
     // 모든 "banners" 클래스 요소에 클릭 이벤트 리스너를 추가합니다.
     const banners = document.querySelectorAll('.banners');

     banners.forEach(function(banner, index) {
         banner.addEventListener('click', function() {
             // 새 창을 열고 새로운 HTML 파일을 로드합니다.
             window.open('sublodging.html', '_blank');
         });
     });
 });
