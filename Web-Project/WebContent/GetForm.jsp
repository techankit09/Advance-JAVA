<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String dob = request.getParameter("dob");
	%>

	<h1>
		<%=firstName%>
	</h1>
	<h1>
		<%=lastName%>
	</h1>
	<h1>
		<%=login%>
	</h1>
	<h1>
		<%=password%>
	</h1>
	<h1>
		<%=dob%>
	</h1>


</body>
</html>