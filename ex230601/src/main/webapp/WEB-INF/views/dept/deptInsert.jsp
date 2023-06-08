<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>   
<body>
	<form action="deptInsert" method="POST">
		<h2>부서 등록</h2>
		<div>
			<label for="id">부서명</label> <input type="text" id="name"
				name="departmentName" required>
		</div>
		<div>
			<label for="id">매니저</label> <input type="number" id="mId"
				name="managerId">
		</div>
		<div>
			<label for="id">위치</label> <input type="number" id="lId"
				name="locationId">
		</div>
		<br>
		<button type="submit">등록</button>
		<button type="button" onclick="location.href='deptList'">목록</button>
	</form>
</body>
</html>

