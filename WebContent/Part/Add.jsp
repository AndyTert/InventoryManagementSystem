<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Part!</title>
</head>
<body>
	<a href="/InventoryManagementSystem/ManagePart.jsp">Back</a>
	<hr>
	
<form action="/InventoryManagementSystem/AddPartServlet" method="post">
	<table>
		<tr>
			<td>Part Name:</td>
			<td>
				<input type="text" name="partName" placeholder="Part Name"/>
			</td>
		</tr>
		<tr>
			<td>Quantity:</td>
			<td>
				<input type="text" name="partQuantity" maxlength="8" placeholder="Quantity #"/>
			</td>
		</tr>
		<tr>
			<td>Price:</td>
			<td>
				<input type="text" name="partPrice" maxlength="8" placeholder="i.e: $5.99"/>
			</td>
		</tr>
	</table>
	<input type="submit"/>
</form>
</body>
</html>