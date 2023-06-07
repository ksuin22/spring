<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사원등록</h2>
	<form action="empUpdate" method="post" name="frm">
		번호<input name="employeeId" readonly="readonly"
			value="${emp.employeeId }"><br> 이름<input name="lastName"
			value="${emp.lastName}"><br> 이메일<input name="email"
			value="${emp.email}"><br> 입사일<input name="hireDate"
			value="${emp.hireDate}"><br> 직업 <select name="jobId">
			<option value="">--선택--
				<c:forEach items="${ jobs}" var="job">
					<option value="${job.jobId }">${job.jobTitle }</option>
				</c:forEach>
			</option>
		</select> <br> 부서<br>
		<c:forEach items="${ dept}" var="dept">
			<input type="radio" name="departmentId"
				value="${dept.DEPARTMENT_ID }"
				<c:if test="${dept.DEPARTMENT_ID ==emp.departmentId}">checked</c:if>>${dept.DEPARTMENT_NAME }<br>
		</c:forEach>


		<button>저장</button>
	</form>
	
	<script>
		frm.jobId.value = "${emp.jobId}"
	</script>
	
</body>
</html>