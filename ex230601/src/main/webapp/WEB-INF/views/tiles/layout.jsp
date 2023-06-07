<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEB Site</title>
</head>
<body>
	<header>
		<tiles:insertAttribute name="header" />
	</header>
	<main>
		<tiles:insertAttribute name="content" />
	</main>
	<footer>
		<div style="text-align: center;">
		<hr>
			<h1>예담직업전문학교</h1>
		</div>
	</footer>
</body>
</html>
