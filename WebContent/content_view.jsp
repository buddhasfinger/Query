<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>뷰페이지</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/read.css">
  <style type="text/css">
  	.mouseCursor {cursor:pointer;}
  </style>
  <script type="text/javascript">
  	function delete_check(){
  		if(confirm("삭제 하시겠습니까?")){
  			location.href="delete.do?page=${page }&bId=${dto.bId }";
  			
  		}else{
  			return false;
  		}	
  	}
  </script>
</head>
<body>
<section>
    <h1>NOTICE</h1>

    <table>
      <colgroup>
        <col width="80%">
        <col width="10%">
        <col width="10%">
        
      </colgroup>
      <tr>
        <th colspan="3">제목</th>
      </tr>
      <tr>
        <td colspan="3"><strong>${dto.bTitle }</strong></td>
      </tr>
      <tr>
        <td>${dto.bName }</td>
        <td>조회수</td>
        <td>${dto.bHit }</td>
      </tr>
      <tr>
        <td colspan="3" class="article">${dto.bContent }</td>
      </tr>
      <tr>
        <td colspan="3"><strong>다음글</strong> <span class="separator">|</span> [키즈잼] 2월 프로그램 안내</td>
      </tr>
      <tr>
        <td colspan="3"><strong>이전글</strong> <span class="separator">|</span> [키즈잼] 2020년 1분기 정기 휴관일 안내</td>
      </tr>
    </table>

    <a href="list.do?page=${page }"><div class="list">목록</div></a>
    <div class="list mouseCursor"  onclick="delete_check()">삭제</div>
    <a href="bModify_view.do?page=${page}&bId=${dto.bId}"><div class="list">수정</div></a>
    <a href="bReplyView.do?page=${page}&bId=${dto.bId}"><div class="list">답변달기</div></a>
  </section>
</body>
</html>