function formChk(){
	//아이디확인
	var idPtn = /^[a-z][a-zA-Z]{3,10}$/;
	if(idPtn.test($("#id").val()) !=true){
		alert('! 첫글자 반드시 영어 소문자,\n영어 대/소문자 조합의 3~10자리로 입력해 주시기 바랍니다.')
		$("#id").next().text("다시 입력해 주세요");
		$("#id").val("");
		return false;
	}
	
	//패스워드확인
	var pwPtn = /^(?=.*[~`!@#$%^&*()_\-+={}\[\]\\\|:;"\'<>,.?\/])(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{4,}$/;
	if(pwPtn.test($("#pw").val()) !=true ){
		alert("특수문자,영문소대문자,숫자 1개이상 포함한 4자리수 이상 비밀번호 설정해주세요");
		$("#pw").next().text('다시 입력해 주세요');
		$("#pw").val("");
		$("#pw2").val("");
		return false;		
	}
	
	//패스워드 일치 확인
	if($("#pw").val() != $("#pw2").val()){
		alert('비밀번호가 일치하지 않습니다.');
		$("#pw2").val("");
		return false;
	}
	
	//이름 확인하기
	var namePtn= /^[가-힣a-zA-Z\s]{1,}$/;
	if(namePtn.test($("#name").val()) !=true){
		alert('한 글자 이상의 이름을 넣어주세요');
		$("#name").next().text('다시 입력해주세요');
		$("#name").val("");
		return false;
	}
	
	//닉네임 확인
	var nNamePtn=/^[가-힣a-zA-Z0-9]{3,10}$/;
	if(nNamePtn.test($("#nName").val()) !=true){
		alert('특수문자 제외 3-10자 내로 입력해주세요');
		$("#nName").next().text('다시 입력해 주세요');
		$("#nName").val("");
		return false;
	}
	
	//전화번호 확인
	var telPtn = /^\d{2,3}\-\d{3,4}\-\d{4}$/;
	if(telPtn.test($("#tel").val()) != true){
		alert('전화번호(- 포함)를 입력해 주세요!');
		$("#tel").next().text('다시 입력해 주세요');
		$("#tel").val("");
		return false;
	}
	
	
	
	document.form1.submit();
	
}
	
	//jQuery 호출
$(function(){
	
	//모든 input에 공통적용하기
	$("input").focus(function(){
		$(this).css("background", "orange");
		$(this).next().text("");
	});
	$("input").blur(function(){
		$(this).css("background","white");
	});	
	
	
});