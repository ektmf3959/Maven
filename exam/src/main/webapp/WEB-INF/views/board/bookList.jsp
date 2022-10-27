<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<style>
	table, tr, th, td {
		border : 1px solid black;
		margin : 0px;
		padding : 0px;
	}
</style>
</head>
<body>
	<form action="bookList">
		<div align="center">
			<table>
				<thead>
					<tr>
						<th>도서번호</th>
						<th>도서명</th>
						<th>표지</th>
						<th>출판일자</th>
						<th>금액</th>
						<th>출판사</th>
						<th>도서소개</th>
					<tr>
				</thead>
				<tbody>
					<c:forEach items="${bookList }" var="Info">
						<tr>
							<td>${Info.bookName}</td>
							<td><img src="<c:url value='/resources/images/${Info.bookCovering}'/>" alt="이미지"></td>
							<td><fmt:formatDate value="${Info.bookDate }" pattern="yyyy/MM/dd" /></td>
							<td>${Info.bookPrice}</td>
							<td>${Info.bookPublisher}</td>
							<td>${Info.bookInfo}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
</body>
<script>
	let message = '${msg}';
	if (message != null && message != '') {
		alert(message);
	}
</script>
</html>