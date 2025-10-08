<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
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

	<%
		String errorMsg = (String) request.getAttribute("errorMsg");
		String successMsg = (String) request.getAttribute("successMsg");
	%>
	<%@  include file="Header.jsp"%>

	<div>
		<form action="ChangePasswordCtl" method="post">
			<%
				if (errorMsg != null) {
			%>
			<h3 style="color: red;">
				<%=errorMsg%>
				<%
					}
				%>
				
				<%
				if (successMsg != null) {
			%>
			<h3 style="color: Green;">
				<%=successMsg%>
				<%
					}
				%>
			</h3>

			<table>
				<tr>
					<th>Login</th>
					<td><input type="email" name="login" value=""
						placeholder="Enter Your Email"></td>
				</tr>

				<tr>
					<th>Oldpassword</th>
					<td><input type="password" name="oldPassword" value=""
						placeholder="Enter Your OldPassword"></td>
				</tr>

				<tr>
					<th>NewPassword</th>
					<td><input type="password" name="newPassword" value=""
						placeholder="Enter Your NewPassword"></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="Save"></td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>