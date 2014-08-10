<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="/InventoryManagementSystem/LoginServlet" method="post">
	<table>
		<tr>
			<td>Email</td>
			<td>
				<input type="text" placeholder="Email" name="email">
			</td>
		</tr>
		<tr>
			<td>Password
			</td>
			<td>
				<input type="password" placeholder="password"  name="password">
			</td>
		</tr>
	</table>
	<input type="submit"/>
</form>
<a href="Register.jsp">Register</a>
</body>
</html>