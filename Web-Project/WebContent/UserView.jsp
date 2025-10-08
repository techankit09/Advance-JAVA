<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	body {
		margin: 0;
		padding: 0;
		background-image: url('9.jpg');
		background-size: cover;
		background-repeat: no-repeat;
		background-position: center;
		font-family: Arial, sans-serif;
	}

	form {
		background-color: rgba(255, 255, 255, 0.9);
		padding: 20px;
		border-radius: 10px;
		box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
		width: 400px;
	}

	table {
		width: 100%;
	}

	th {
		text-align: left;
		padding: 8px;
	}

	td {
		padding: 8px;
	}

	h1 {
		color: #333;
	}
	.centered-container {
		display: flex;
		justify-content: center;
		align-items: center;
		min-height: 100vh;
	}
</style>
</head>
<body>
<%@ include file="Header.jsp"%>

	<%
		String successMsg = (String) request.getAttribute("successMsg");
		String errorMsg = (String) request.getAttribute("errorMsg");
	%>

	<div align="center">
		<h1>Add User</h1>

		<%
			if (successMsg != null) {
		%>
		<h3 style="color: green;"><%=successMsg%></h3>
		<%
			}
		%>

		<%
			if (errorMsg != null) {
		%>
		<h3 style="color: red;"><%=errorMsg%></h3>
		<%
			}
		%>

		<form action="UserCtl" method="post">

			<table>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstName" value=""
						placeholder="enter first name"></td>
				</tr>
				<tr>
					<th>Last Name</th>
					<td><input type="text" name="lastName" value=""
						placeholder="enter last name"></td>
				</tr>
				<tr>
					<th>Login</th>
					<td><input type="email" name="login" value=""
						placeholder="enter your login"></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="password" value=""
						placeholder="enter your password"></td>
				</tr>
				<tr>
					<th>Dob</th>
					<td><input type="date" name="dob" value=""></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="save"></td>
				</tr>
			</table>

		</form>

	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>