<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
		List list = (List) request.getAttribute("list");
		List nextList = (List) request.getAttribute("nextList");
		String successMsg = (String) request.getAttribute("successMsg");
		String errorMsg = (String) request.getAttribute("errorMsg");
		int pageNo = (int) request.getAttribute("pageNo");
		int index = ((pageNo - 1) * 5) + 1;
	%>

	<%@ include file="Header.jsp"%>
	<div align="center">

		<h3>User List</h3>
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
		<form action="UserListCtl" method="post">

			<table>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstName" value=""
						placeholder="search by first name">&nbsp;</td>

					<th>Dob</th>
					<td><input type="date" name="dob" value=""></td>

					<td><input type="submit" name="operation" value="search"></td>
				</tr>
			</table>

			<table border="1px" width="100%">

				<tr style="background-color: skyblue">
					<th>Delete</th>
					<th>S.NO</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Login</th>
					<th>DOB</th>
					<th>Edit</th>
				</tr>

				<%
					Iterator<UserBean> it = list.iterator();
				%>

				<%
					while (it.hasNext()) {
						UserBean bean = it.next();
				%>
				<tr align="center" style="background-color: #D3D3D3">
					<td><input type="checkbox" value="<%=bean.getId()%>"
						name="ids"></td>
					<td><%=index++%></td>
					<td><%=bean.getFirstName()%></td>
					<td><%=bean.getLastName()%></td>
					<td><%=bean.getLogin()%></td>
					<td><%=bean.getDob()%></td>
					<td><a href="UserCtl?id=<%=bean.getId()%>">edit</a></td>
				</tr>
				<%
					}
				%>
			</table>

			<table width="100%">
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="previous"
						<%=pageNo == 1 ? "disabled" : ""%>></td>
					<td><input type="submit" name="operation" value="delete"></td>
					<td align="right"><input type="submit" name="operation"
						value="next" <%=nextList.size() == 0 ? "disabled" : ""%>></td>
				</tr>
			</table>
			<input type="hidden" name="pageNo" value="<%=pageNo%>">
		</form>
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>