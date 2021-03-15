if (typeof jQuery == 'undefined') {
alert("제이쿼리없음");
}else{
alert("제이쿼리없음있음");
}	

function pwChk(){
	if($("#pw").val()!=($("#pw2").val())){
		alert('비밀번호가 일치하지 않습니다.');
		$("#pw2").val('');
		$("#pw2").next().text('잘못 입력하셨습니다.');
		$("#pw2").css('background','orange');
		return false;
	}
	document.modifyForm.submit();
}

function modifyReset(){
	location.href="index.jsp";
}

	
$(function(){
	$("input").focus(function(){
	$("#pw2").next().text('');
});
	$("input").blur(function(){
	$("#pw2").css('background','white');	
		
	});
	
});


