<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<c:choose>
			  <c:when test="${flag eq '-1' }">
			 	 <script type="text/javascript">
			 	 	alert('프로그램 오류로 인한 저장이 되지 않았습니다. 다시 입력하세요.');
			 	 </script>
			  		<c:redirect url ="/write_view.do" />
			 </c:when> 
			  <c:otherwise>
			  	<script type="text/javascript">
			  		alert('데이터가 정상적으로 저장되었습니다!');
			  		alert("page데이터값: " +${page});
			  	</script>
			  		<c:redirect url ="/list.do" />
<%-- 			  			<c:param name="page" value="${page }"> </c:param> --%>
<%-- 			  		<%response.sendRedirect("list.do") %> --%>
			  </c:otherwise>
		</c:choose>
		<meta charset="UTF-8">
		<title>글쓰기 체크</title>
	</head>
	<body>
		
	</body>
</html>