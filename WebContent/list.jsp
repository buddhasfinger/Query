<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/notice_list.css">
</head>
<body>
	<section>
		<h1>NOTICE</h1>
		<div class="wrapper">
			<form action="/search" name="search" method="post">
				<select name="category" id="category">
					<option value="0">전체</option>
					<option value="title">제목</option>
					<option value="content">내용</option>
				</select>

				<div class="title">
					<input type="text" size="16">
				</div>

				<button type="submit">
					<i class="fas fa-search"></i>
				</button>
			</form>
		</div>

		<table>
			<colgroup>
				<col width="12%">
				<col width="44%">
				<col width="17%">
				<col width="17%">
				<col width="10%">
			</colgroup>
			<!-- 제목부분 -->
			<tr>
				<th>No.</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<!-- 내용부분 -->
			<c:forEach var="dto" items="${list }">
				<tr>
					<td><span class="table-notice">${dto.bId }</span></td>
					<td class="table-title"><c:forEach begin="1"
							end="${dto.bIndent }">└▶</c:forEach> <a href="content_view.do?bId=${dto.bId }&page=${page}">${dto.bTitle }</a>
					</td>
					<td>${dto.bName }</td>
					<td>${dto.bDate }</td>
					<td>${dto.bHit }</td>
				</tr>
			</c:forEach>
		</table>
		<!-- 페이지번호 넣기-->
			<ul class="page-num">
			<a href="list.do?page=1"></a>
			<li class="first"></li>
			</a>
			<c:choose>
				<c:when test="${page <=1 }">
					<li class="prev"></li>
				</c:when>
				<c:otherwise>
					<a href="list.do?page=${page-1 }"><li class="prev"></li></a>
				</c:otherwise>
			</c:choose>

			<!--번호반복 -->
			<c:forEach var="nowpage" begin="${startpage }" end="${endpage }">
				<c:choose>
					<c:when test="${page==nowpage }">
						<li class="num"><div>${nowpage }</div></li>
					</c:when>
					<c:otherwise>
						<a href="list.do?page=${nowpage }"><li class="num"><div>${nowpage }</div></li></a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<!--번호반복 -->

			<c:choose>
				<c:when test="${page >= maxpage }">
					<li class="next"></li>
				</c:when>
				<c:otherwise>
					<a href="list.do?page=${page+1 }"><li class="next"></li></a>
				</c:otherwise>
			</c:choose>


			<a href="list.do?page=${maxpage }"><li class="last"></li></a>
		</ul>

		<a href="write_view.do"><div class="write">쓰기</div></a>
	</section>

</body>
</html>