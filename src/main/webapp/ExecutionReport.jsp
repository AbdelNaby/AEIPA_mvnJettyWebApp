<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.db.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ExecutionReport</title>
</head>
<body bgcolor="#669900">
	<center>
		<table border="1" width="30%" cellpadding="5">
			<thead>
				<tr>
					<th colspan="2">Execution Results</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="executedIPAName" items="${executedIPANameList}">
					<tr>
						<td>${executedIPAName}</td>
					</tr>
				</c:forEach>
				<c:forEach var="executedDatasetName"
					items="${executedDatasetNameList}">
					<tr>
						<td>${executedDatasetName}</td>
					</tr>
				</c:forEach>
				<tr>
					<td><input type="submit" value="Submit"
						name="Create a new IPA" /></td>
					<td><input type="reset" value="Reset" /></td>
				</tr>
				<tr>
					<td colspan="2">Back <a href="home.jsp">to AEIPA Homepage</a></td>
				</tr>
			</tbody>
		</table>
	</center>
</body>
</html>