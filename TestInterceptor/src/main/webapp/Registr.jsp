<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>

	<h2>Регистрация пользователя</h2>
	<s:form action="Registr" method="post">

		<s:textfield label="Ваше Имя" name="name"></s:textfield>
		<s:textfield label="Логин" name="login"></s:textfield>
		<s:password label="Пароль" name="password" />
		<s:submit value="Отправить"></s:submit>
	</s:form>
	<p>
		<a href="<s:url action="Login"/>">Войти в систему</a>
	</p>


</body>
</html>