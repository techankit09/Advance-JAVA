<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>

<style>
	body {
		margin: 0;
		padding: 0;
		background-image: url('8.jpg');
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

	<div class="centered-container">
		<div>
			<h1>User Registration</h1>

			<%
				if (successMsg != null) {
			%>
			<b style="color: green; font-size: 30px"><%=successMsg%></b>
			<%
				}
			%>

			<%
				if (errorMsg != null) {
			%>
			<h3 style="color: red; font-size: 30px"><%=errorMsg%></h3>
			<%
				}
			%>

			<form action="UserRegistrationCtl" method="post">
				<table>
					<tr>
						<th>First Name</th>
						<td><input type="text" name="firstName" placeholder="enter first name"></td>
					</tr>
					<tr>
						<th>Last Name</th>
						<td><input type="text" name="lastName" placeholder="enter last name"></td>
					</tr>
					<tr>
						<th>Login</th>
						<td><input type="email" name="login" placeholder="enter your login"></td>
					</tr>
					<tr>
						<th>Password</th>
						<td><input type="password" name="password" placeholder="enter your password"></td>
					</tr>
					<tr>
						<th>DOB</th>
						<td><input type="date" name="dob"></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="submit" name="operation" value="signUp"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<%@ include file="Footer.jsp"%>
</body>
</html>
