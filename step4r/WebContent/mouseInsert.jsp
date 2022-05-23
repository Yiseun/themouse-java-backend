<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		const joinCheck = () => {
			// 공백입력여부 유효성 검사 확인
			//if (document.join.id.value.trim() === ""){
			//	alert('ID를 입력하세요');
			//	return false;
			//}
			
			// 유효성 체크를 통과했다면 INSERT 수행
			// input type="submit"을 호출
			document.join.submit();		
		};
	</script>
</head>
<body>
	<h3>Mouse 등록</h3>
	
	<form action="board" name="join" method="POST">
		<input type="hidden" name="command" value="insert"/><br/>
		ID: <input type="text" id="id" name="id"><br/>
		이름 : <input type="text" id="name" name="name"><br/>
		국적 : <input type="text" id="country" name="country"><br/>
		주소 : <input type="text" id="address" name="address"><br/>
	</form>
		<button type="button" onclick="joinCheck()">등록</button>
</body>
</html>