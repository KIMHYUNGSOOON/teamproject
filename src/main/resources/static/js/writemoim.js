window.onload = function(){

    //input type="file" 리스트로서 저장
    const files = document.querySelectorAll("input[type='file']");

    console.log("files 값 => ", files)

    for(let i = 0 ; i<files.length ; i++){
        console.log("for 값 => ", files[i]);


        files[i].addEventListener('change',function(event){
            //input type="file" 태그 하나하나 이벤트리스너 적용


            console.log("event 값 => ", event.target.files);


            if(event.target.files && event.target.files[0]){
                console.log("여기에 들어왕ㅆ다!");

                const reader = new FileReader()
                const previewImage =document.querySelector("img#" + event.target.id)
                console.log("previewImage => ", previewImage);
                // 이미지가 로드가 된 경우
                reader.onload = e => {
                    console.log("이미지 로드 => ")
                    previewImage.src = e.target.result
                }
                // reader가 이미지 읽도록 하기
                reader.readAsDataURL((event.target.files[0]));
            }
        });
    }
}