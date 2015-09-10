<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Регистрация</title>
</head>

<body>
	<h2>Мероприятие</h2>
	<br>

	<h3>Заполни свои данные</h3>

	<%-- Форма заполнения данных --%>
	<form name="form1" method="POST" action="ServletTestJsp1">

		Имя: <input type="text" name="name" /><br> E-mail: <input
			type="text" name="email" /><br> <br> <br> <input
			type="submit" name="button" value="Внести в список участников" />
	</form>

</body>
</html>