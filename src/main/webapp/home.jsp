<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AEIPA Home</title>
</head>
<body bgcolor="#669900">
	<center>
		<table border="1" width="30%" cellpadding="3">
			<thead>
				<tr>
					<th colspan="2">Welcome to AEIPA</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<form name="f1" method="post" action="IPACreateNew.jsp">
							<input id="IPACreateNew" type="submit" name="Create a new IPA"
								value="Create a new IPA">
						</form>
					</td>
					<td>
						<form name="f2" method="post" action="InputDatasetCreateNew.jsp">
							<input id="InputDatasetCreatNewServlet" type="submit"
								name="Create a new Input Dataset" value="Create a new Dataset">
						</form>
					</td>
				</tr>
				<tr>
					<td>
						<form name="f3" method="post" action="IPAUpdateInfo.jsp">
							<input id="IPAExecute" type="submit"
								name="Update IPA Information" value="Update IPA Information">
						</form>
					</td>
					<td>
						<form name="f4" method="post" action="DatasetUpdateInfo.jsp">
							<input id="DatasetUpdateInfo" type="submit"
								name="Update Dataset Information"
								value="Update Dataset Information">
						</form>
					</td>
				<tr>
					<td>
						<form name="f5" method="post" action="IPADelete.jsp">
							<input id="IPADelete" type="submit" name="Delete IPA"
								value="Delete IPA">
						</form>
					</td>
					<td>
						<form name="f6" method="post" action="DatasetDelete.jsp">
							<input id="DatasetDelete" type="submit" name="Delete Dataset"
								value="Delete Dataset">
						</form>
					</td>
				</tr>
				<tr>
					<td>
						<form name="f7" method="post" action="IPADatasetSearch.jsp">
							<input id="IPAExecute" type="submit" name="Execute IPA"
								value="Execute IPA">
						</form>
					</td>
					<td>
						<form name="f8" method="post" action="IPAExecute.jsp">
							<input id="IPAExecute" type="submit" name="Execute IPA"
								value="Execute IPA">
						</form>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<%
							if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
						%> You are not logged in <br /> <a href="index.jsp">Please
							Login</a> <%
						 	} else {
						 %> Welcome <%=session.getAttribute("username")%> To <a
												href='logout.jsp'>Logout</a> <%
						 	}
						 %>
					
				</tr>
				<tr>
					<td colspan="2">New User: <a href="register.jsp">Register
							Here</a></td>
				</tr>
			</tbody>
		</table>
	</center>
</body>
</html>