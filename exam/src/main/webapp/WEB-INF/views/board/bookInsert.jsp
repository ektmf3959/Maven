<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>
<body>
	<form action="bookInsert" method="post" onsubmit="return formOption()">
		<div align="center">
			<div>
				<h2 style="text-align: center">도서 등록 정보</h2>
			</div>
			<table>
				<tr>
					<th>도서번호</th>
					<td><input type="number" name="bookNo" value="${no }" readonly></td>
				</tr>
				<tr>
					<th>도서명</th>
					<td><input type="text" name="bookName"></td>
				</tr>
				<tr>
					<th>도서표지</th>
					<td><input type="text" name="bookCovering"></td>
				</tr>
				<tr>
					<th>출판일자</th>
					<td><input type="date" id="bookDate" name="bookDate"></td>
				</tr>
				<tr>
					<th>금액</th>
					<td><input type="number" name="bookPrice"></td>
				</tr>
				<tr>
					<th>출판사</th>
					<td><input type="text" name="bookPublisher"></td>
				</tr>
				<tr>
					<th>도서소개</th>
					<td><textarea name="bookInfo"></textarea></td>
				</tr>
			</table>
			<button type="submit">등록</button>
			<button type="button">조회</button>
		</div>
	</form>
	<script>
		$(document).ready(function() {
			//$('button[type="submit"]').click(formOption);
			$('button:contains("목록")').click(function() {
				location.href = 'list';
			})
		});
		
		function formOption(){
			let bookName = $('input[name="bookName"]');
			
			if(bookName.val() == ""){
				alert("도서명이 입력되지 않았습니다.");
				bookName.focus();
				return false;
			}			
			return true;
		};
		
	</script>
</body>
</html>