<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My First Jsp File</title>
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
	<div align="center">
		<h1>Hello User</h1>
	</div>
</body>
</html>