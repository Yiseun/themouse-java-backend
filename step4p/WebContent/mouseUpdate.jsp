<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Mouse 정보 수정</h2>
	<form action="board" method="POST">
		?? 수정버튼을 눌렀을때 프론트 컨트롤러가 해당 요청이 수정에 대한 요청인지 구분해야하니깐
		<input type="hidden" name="command" value="update"/><br/>
		<table>
				<tr>
					<th>ID</th>
					<td><input type="text" name="id" value="${requestScope.mouse.id}"/></td>
				</tr>
				<tr>
					<th>이름(name)</th>
					<td><input type="text" name="name" value="${requestScope.mouse.name}"></td>
				</tr>
				<tr>
					<th>국적(country)</th>
					<td><input type="text" name="country" value="${requestScope.mouse.country}"></td>
				</tr>
				<tr>
					<th>주소(address)</th>
					<td><input type="text" name="address" value="${requestScope.mouse.address}"></td>
				</tr>
		</table>
		<input type="submit" value="수정">
	</form>
</body>
</html>