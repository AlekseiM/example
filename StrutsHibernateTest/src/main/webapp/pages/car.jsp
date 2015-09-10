<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>StrutsHibernateTest</title>
</head>
<body>
	<h1>StrutsHibernateTest</h1>

	<h2>Add Car</h2>
	<s:form action="saveOrUpdateCarAction">
		<s:textfield name="brand" label="Brand" />
		<s:textfield name="releaseYear" label="Release Year" />
		<s:textfield name="cost" label="Cost" />
		<s:submit />
	</s:form>

	<h2>All Car</h2>

	<s:if test="carList.size() > 0">
		<table border="1px" cellpadding="8px">
			<tr>
				<th>Car Id</th>
				<th>Brand</th>
				<th>Release Year</th>
				<th>Cost</th>
				<th>Created Date</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<s:iterator value="carList" status="userStatus">
				<tr>
					<td><s:property value="carId" /></td>
					<td><s:property value="brand" /></td>
					<td><s:property value="releaseYear" /></td>
					<td><s:property value="cost" /></td>
					<td><s:date name="createdDate" format="dd/MM/yyyy" /></td>
					<td><s:url id="editURL" action="editCar">
							<s:param name="carId" value="%{carId}"></s:param>
						</s:url> <s:a href="%{editURL}">Edit</s:a></td>
					<td><s:url id="deleteURL" action="deleteCar">
							<s:param name="carId" value="%{carId}"></s:param>
						</s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
				</tr>
			</s:iterator>
		</table>
	</s:if>
	<br />
	<br />

</body>
</html>