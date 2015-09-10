<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Результат</title>
</head>

<body>
	<h4>Cписок участников</h4>
	<br>
	<%-- Вывести список участников --%>
	<table>
		<c:forEach var="elem" items="${persons}" varStatus="status">
			<tr>
				<td><c:out value="${status.count}" /></td>
				<td><c:out value="${elem}" /></td>
			</tr>
		</c:forEach>
	</table>
	<h5>Kоличество посетивших страницу - ${allVisit}</h5>
</body>
</html>