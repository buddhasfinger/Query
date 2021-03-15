<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
		<c:choose>
			  <c:when test="${session_flag ==null || session_flag =='fail' }">
			 	 <script type="text/javascript">
			 	 	alert('아이디와 패스워드가 일치 하지 않습니다 다시 입력하세요!');
			 	 	location.href="login.html";
			 	 </script>
			 </c:when> 
			  <c:otherwise>
			  	<script type="text/javascript">
			  		alert('로그인 성공!');
			  		location.href="index.jsp";
			  	</script>
			  </c:otherwise>
		</c:choose>
		<meta charset="UTF-8">
		<title>로그인 체크</title>
	</head>
	<body>
		
		
		
		
	</body>
</html>