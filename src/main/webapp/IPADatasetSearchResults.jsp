<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.db.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IPA and Dataset Search Results</title>
</head>
<body bgcolor="#669900">
	<br />
	<br /> Please select the IPA(s) that you want to execute and compare
	together:
	<br />
	<br />
	<form action="IPAJavaDockerExecuteServlet" method="post">
		<table border="1">
			<thead>
				<tr>
					<th>IPA Name</th>
					<th>Description</th>
					<th>Type</th>
					<th>Main File Name</th>
					<th>Programing Language</th>
					<th nowrap>Programing Language Version</th>
					<th nowrap>User Name</th>
				</tr>
			</thead>

			<c:forEach var="iPADTO" items="${listiPA}">
				<tr>

					<td><input type="checkbox" id="box" name="box" value="${iPADTO.name}"
						onclick="myFunction()">${iPADTO.name}
					
						</td>
						

					<td>${iPADTO.description}</td>
					<td>${iPADTO.type}</td>
					<td>${iPADTO.mainFileName}</td>
					<td>${iPADTO.progLanguageName}</td>
					<td>${iPADTO.progLanguageNum}</td>
					<td>${iPADTO.userName}</td>
					<td><a href="editEmployee?id=${employee.id}">Edit</a> <a
						href="deleteEmployee?id=${employee.id}">Delete</a></td>

				</tr>
			</c:forEach>

		</table>
		<br><br>
		<input type="submit" value="Submit" >


<br><br>
<input type="hidden" id="selectedIPAList" name="selectedIPAList" size="200">

</form>

<script>
function myFunction() {
    var IPAlist = document.forms[0];
    var selectedIPAList = "";
    var i;
    for (i = 0; i < IPAlist.length; i++) {
        if (IPAlist[i].checked) {
        	selectedIPAList = selectedIPAList + IPAlist[i].value + " ";
        }
    }
    document.getElementById("selectedIPAList").value = selectedIPAList;
}
</script>
	
</body>
</html>