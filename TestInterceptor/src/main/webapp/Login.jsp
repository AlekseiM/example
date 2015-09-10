<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<body>
	<h2>Введите ваши данные для входа в систему.</h2>
	<s:form action="Authentication" method="post">
		<s:actionerror />
		<s:textfield label="Логин" name="login" required="true"></s:textfield>
		<s:password label="Пароль" name="password" required="true" />
		<s:submit value="Войти"></s:submit>
	</s:form>
	<p>
		<a href="<s:url action="Registr"/>">Зарегистрироваться</a>
	</p>
</body>

</body>
</html>