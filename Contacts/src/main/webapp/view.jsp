<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>Contacts list</h3>


	<table border="1px" cellpadding="8px">
		<tr>
			<th>name</th>
			<th>surName</th>
			<th>login</th>
			<th>email</th>
			<th>phoneNumber</th>

		</tr>
		<c:forEach var="elem" items="${contactsList}" varStatus="status">
			<tr>
				<td><c:out value="${elem.name}" /></td>
				<td><c:out value="${elem.surName}" /></td>
				<td><c:out value="${elem.login}" /></td>
				<td><c:out value="${elem.email}" /></td>
				<td><c:out value="${elem.phoneNumber}" /></td>

			</tr>
		</c:forEach>
	</table>

	<form method="post" action="ViewServlet">
		<table>
			<tr>
				<th><input type="submit" name="page" value="next" /></th>

				<th><input type="submit" name="page" value="previous" /></th>
			</tr>
		</table>

	</form>

	<form method="post" action="ViewServlet">
		<h5>Sort by</h5>

		<p>
			<input type="radio" name="order" value="name">name<Br> <input
				type="radio" name="order" value="surName">surName<Br> <input
				type="radio" name="order" value="login">login<Br> <input
				type="radio" name="order" value="email">email<Br> <input
				type="radio" name="order" value="phoneNumber">phoneNumber<Br>
		</p>
		<p>
			<input type="submit" value="Enter">
		</p>

	</form>



	<a href="menu.jsp">Return to menu</a>

</body>
</html>