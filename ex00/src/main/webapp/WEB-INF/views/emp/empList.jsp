<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>
<style>
	table, tr, th, td {
		border : 1px solid black;
		margin : 0px;
		padding : 0px;
	}
</style>
<body>
	<div id="dataList">
	<button type="button" onclick="location.href='insertForm'">사원등록</button>
		<table>
			<thead>
				<tr>
					<th>사원번호</th>
					<th>성</th>
					<th>이름</th>
					<th>직업</th>
					<th>급여</th>
					<th>부서번호</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${empInfoList }" var="empInfo">
					<!-- <tr onclick="location.href='info?employeeId=${empInfo.employeeId }'"> -->
					<tr name="${empInfo.employeeId }">
						<td>${empInfo.employeeId }</td>
						<td>${empInfo.lastName }</td>
						<td>${empInfo.firstName }</td>
						<td>${empInfo.jobId }</td>
						<td>${empInfo.salary }</td>
						<td>${empInfo.departmentId }</td>
						<td><button>삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form id="input">
			<input type="hidden" name="employeeId">
		</form>
	</div>
	<script>
		let message = '${msg}';
		if(message != null && message != ''){
			alert(message);
		}
		
		$('#dataList td').click(function(){
			let empId = $(this).parent().attr('name');
			$('#input > input').val(empId);
			$('#input').prop('action', 'info')
					   .prop('method', 'get')
					   .submit();
		});
			
	       // 비동기식으로 처리해서 새로고침 해야된다.
	       $('#dataList td > button').click(function() {
	         // closest 자기 조상 중에 가장 가까운 태그를 찾아온다.
	         let empId = $(this).closest('tr').attr('name');
	         
	         $.ajax({
	                url : 'delete/' + empId,
	                // delete? employeeId=207
	                success : function(data) {
	                   console.log(data);
	                },
	                error : function(reject) {
	                   console.log(reject);
	                }
	             });
	         return false;
	      }) 
		<!--
		$('#dataList td').click(function(){
			let empId = $(this).parent().attr('name');
			$.ajax({
				url : 'info',
				data : { "employeeId" : empId},
				async : true,
				success : function(data) {
					$('body').html(data);
				},
				error : function(reject){
					console.log(reject);
				}
				
			})
		})
		-->
	</script>
	<!-- 
	<script type="text/javascript">
		let empList = [];
		let emp = {};
		<c:forEach items="${empInfoList}" var="empInfo">
			emp = {
					employeeId : '${empInfo.employeeId}',
					firstName : '${empInfo.firstName}',
					lastName : '${empInfo.lastName}',
					jobId : '${empInfo.jobId}',
					salary : '${empInfo.salary}',
					departmentId:'${empInfo.departmentId}'
				}
			
			empList.push(emp);
		</c:forEach>
		$('tbody').empty();
		let thTag = $('#dataList th');
		
		$(empList).each(function(idx, obj){
			let tr = $('<tr/>');
			$(tr).append($('<td/>').text(obj.employeeId));
			$(tr).append($('<td/>').text(obj.lastName));
			$(tr).append($('<td/>').text(obj.firstName));
			$(tr).append($('<td/>').text(obj.jobId));
			$(tr).append($('<td/>').text(obj.salary));
			$(tr).append($('<td/>').text(obj.departmentId));
			$('#dataList tbody').append(tr);
		});


		</script>
		 -->
</body>
</html>