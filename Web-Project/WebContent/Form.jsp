<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter Your Details</title>
</head>
<body bgcolor = 80868C>
	<div align="center">
   <marquee behavior = alternate scrollamount = 40><img  src="1.jpg" height = 300px align = "center"></marquee>
	<marquee behavior = alternate scrollamount = 1>	<h1>User Form</h1> </marquee>

		<form action="GetForm.jsp">

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
						placeholder="enter your email"></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="password" value=""
						placeholder="enter your password"></td>
				</tr>
				<tr>
					<th>DOB</th>
					<td><input type="date" name="dob" value=""></td>
				</tr>
				<tr>
					<th></th>
					<td><marquee scrollamount= 10><input type="submit" value="save" name="operation"></marquee></td>
				</tr>
			</table>

		</form>

	</div>

</body>
</html>