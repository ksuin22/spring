<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>전체 부서 관리</title>
</head>

<body>
	<div>
		<h2>부서 관리</h2>
		<span style="background: yellow"> <a href="deptInsert">등록</a>
		</span> <br> <br>
		<button id="checkDel" type="submit">선택삭제</button>
		<table border="1">
			<tr>
				<th><input type="checkbox"></th>
				<th>부서번호</th>
				<th>부서이름</th>
				<th>매니저번호</th>
				<th>지역번호</th>
				<th>삭제</th>
			</tr>
			<c:forEach items="${deptList}" var="dept">
				<!-- items는 컨트롤러> model.addAttribute("deptList") 에서 가져옴 -->
				<!--<tr onclick="location.href='deptInfo?departmentId=${dept.departmentId}'">-->
				<tr onclick="findDeptInfo(event, ${dept.departmentId})">
					<td><input type="checkbox"></td>
					<td>${dept.departmentId }</td>
					<td>${dept.departmentName }</td>
					<td>${dept.managerId }</td>
					<td>${dept.locationId }</td>
					<td><button type="button" id="delBtn">삭제</button></td>
				</tr>
			</c:forEach>
		</table>
		<form name="del" action="deptDelete" method="post"></form>
	</div>
	<script>
		//알람창	
		let result = "${departmentId}";
		if (result != "") {
			alert(result);
		}
		
		//tr이벤트 체크박스에서 막기
		function findDeptInfo(event, deptNo){
			console.log(event)
			if(event.target.tagName != 'INPUT' && event.target.tagName != 'BUTTON')
				location.href='deptInfo?departmentId='+deptNo;

		}
		
		//한개삭제
		let delBtnList = Array.from(document.getElementsByTagName('button'))
		.filter(item => item.id != 'checkDel');
		
		delBtnList.forEach(el => {
			el.addEventListener('click', function(e){
				let tdList = this.parentElement.parentElement.children;
				let deptNo = tdList[1].textContent;
				
				insertDeptInfo(0,deptNo);
				del.submit();
								
			})
						
		})
		

		
		//선택삭제 버튼 기능
		document.getElementById('checkDel').addEventListener('click',function(e) {
		let checked = document.querySelectorAll('input[type="checkbox"]:checked');
			for (let i = 0; i < checked.length; i++) {
				let deptNo = checked[i].parentElement.nextElementSibling.textContent;
				insertDeptInfo(i, deptNo);
			}
			del.submit();
		});

		function insertDeptInfo(index, deptNo) {
			let inputTag = document.createElement('input');
			inputTag.type = 'hidden';
			inputTag.name = 'deptList[' + index + '].departmentId';
			inputTag.value = deptNo;

			let formTag = document.getElementsByName('del')[0];
			formTag.append(inputTag);
		}
		
	</script>
</body>

</html>
