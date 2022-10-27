<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8"); // 한글깨짐 방지를 위해
	%>

	<h1>넘어온 id 데이터 = ${param.id }</h1>
	<c:if test="${not empty param.name}">
		<h1>넘어온 name 데이터 = ${param.name }</h1>
	</c:if>
	<h1>넘어온 password 데이터 = ${param.password}</h1>
	<c:forEach var="i" begin="1" end="10"> <!-- for문 -->
		2 * ${i } = ${2* i } <br/>
	</c:forEach>
	<c:choose>
		<c:when test="${empty param.id}">
			<h3>아이디값이 비어있다.</h3>
		</c:when>
		<c:when test="${empty param.name}">
			<h3>네임값이 비어있다.</h3>
		</c:when>
		<c:when test="${empty param.password}">
			<h3>패스워드값이 비어있다.</h3>
		</c:when>
		<c:otherwise>
			<h3>정상동작 되었습니다.</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>