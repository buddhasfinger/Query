<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
	</head>
	<body>
		<ul>
		<c:choose>
			<c:when test="${session_flag ==null || session_flag =='fail' }">
				<h3>로그인을 해주세요</h3>
				<li><a href="login.html">로그인</a> </li>
				<li><a href="join.do">회원가입</a> </li>
			</c:when>
		<c:otherwise>
				<h3>${session_nName}님 접속을 환영합니다.</h3>
				<li><a href="logout.jsp">로그아웃</a> </li>
				<li><a href="modify.do">회원정보수정</a> </li>
				<li><a href="view.do">내 정보보기</a> </li>
				<li><a href="list.do">게시판리스트</a> </li>
		</c:otherwise>
		</c:choose>
		</ul>
	</body>
</html>