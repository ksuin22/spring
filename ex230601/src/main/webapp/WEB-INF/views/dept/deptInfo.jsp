<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>단건조회</title>
</head>

<body>
	<h2>단건조회</h2>
	<form name="frm" onsubmit="return false">
		<div>
			<label for="id">부서ID</label> <input type="number" id="id"
				name="departmentId" value="${deptInfo.departmentId }" readonly>
		</div>
		<div>
			<label for="id">부서명</label> <input type="text" id="name"
				name="departmentName" value="${deptInfo.departmentName }">
		</div>
		<div>
			<label for="id">매니저</label> <input type="number" id="mId"
				name="managerId" value="${deptInfo.managerId }">
		</div>
		<div>
			<label for="id">위치</label> <input type="number" id="lId"
				name="locationId" value="${deptInfo.locationId }">
		</div>
		<br>
		<button type="submit">수정</button>
		<button type="button" onclick="location.href='deptList'">목록</button>

	</form>
	<script>
		let result= "${updateRes}";

			
		document.querySelector('button[type="submit"]')
				.addEventListener('click', function (e) {
			let data = {
				'departmentId': frm.departmentId.value,
				'departmentName': frm.departmentName.value,
				'managerId': frm.managerId.value,
				'locationId': frm.locationId.value
			}
			fetch('deptUpdate', {
					method: 'post',
					headers: {
						'content-type': 'application/json'
					},
					body: JSON.stringify(data)
				})
				.then(response => 
					if(result !="" &&result != null){
						result= JSON.parse(result);
						let msg = `결과 : ${result.result} \n 
								   성공 : ${result.success} \n
								   대상 : ${result.deptList[0]}`;
						alert(msg);					   
					})
				.catch(err => console.log(err))
			})
			
	</script>
</body>

</html>