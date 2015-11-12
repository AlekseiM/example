<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload</title>
</head>
<body>
	<center>
		<h3>File Upload</h3>
		<form name="csvread" method="post" action="ReadCsvServlet"
			enctype="multipart/form-data">


			Select file to upload: <input type="file" name="file" size="60" /><br />
			<br /> <input type="submit" name="upload" value="Upload" />



		</form>

		<form name="create" method="post" action="ViewServlet">
			<p>
				<input type="submit" name="create" value="create table" />
			</p>


		</form>


		<a href="menu.jsp">Return to menu</a>
	</center>



</body>
</html>