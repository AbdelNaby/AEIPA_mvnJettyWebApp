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
	<br /> Please select the IPA(s) that you want to execute and compare
	together:
	<br />
	<br />
	<form>
		<table border="1">
			<thead>
				<tr>
					<th>IPA Name</th>
					<th>Description</th>
					<th>Type</th>
					<th>Main File Name</th>
					<th>Programing Language</th>
					<th>Programing Language Version</th>
					<th>User Name</th>
				</tr>
			</thead>
			<c:forEach var="iPADTO" items="${listiPA}">
				<tr>
					<td><input type="checkbox" id="ipacheckbox" name="ipacheckbox"
						value="${iPADTO.name}" onclick="iPAFunction(this)">${iPADTO.name}
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
		<br> Please select the Dataset(s) that you want to execute with
		each IPA: <br> <br>
	</form>
	<form action="IPAJavaDockerExecuteServlet" method="post">
		<table border="1">
			<thead>
				<tr>
					
					<th>Input Dataset Sequence Name</th>
					<th>Dataset Name</th>
					<th>Input Dataset Description</th>
					<th>Input Dataset Evaluation Description</th>
					<th>Keywords</th>
					<th>Dataset Type</th>
					<th>User Name</th>
				</tr>
			</thead>
			<c:forEach var="datasetDTO" items="${inputDatasetDTOList}">
				<tr>
					<td><input type="checkbox" id="datasetcheckbox"
						name="datasetcheckbox" value="${datasetDTO.name}"
						onclick="datasetFunction(this)">${datasetDTO.name}</td>
						<td>${datasetDTO.datasetName}</td>
					<td>${datasetDTO.description}</td>
					<td>${datasetDTO.evaluationDescription}</td>
					<td>${datasetDTO.keyWords}</td>
					<td>${datasetDTO.type}</td>
					<td>${datasetDTO.userName}</td>
					<td><a href="editEmployee?id=${employee.id}">Edit</a> <a
						href="deleteEmployee?id=${employee.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Execute IPA(s) using each Dataset">


		<br>
		<br> <input type="hidden" id="selectedIPAList"
			name="selectedIPAList" size="200"> 
			<input type="hidden"
			id="selectedDatasetList" name="selectedDatasetList" size="200">
	</form>

	<script>
		function iPAFunction(that) {
			var IPAlist = document.forms[0];
			var selectedIPAList = "";
			var i;
			for (i = 0; i < IPAlist.length; i++) {
				if (IPAlist[i].checked) {
					selectedIPAList = selectedIPAList + IPAlist[i].value
							+ " @nd# ";
				}
			}
			document.getElementById("selectedIPAList").value = selectedIPAList;
		}

		function datasetFunction(that) {
			var Datasetlist = document.forms[1];
			var selectedDatasetList = "";
			var i;
			for (i = 0; i < Datasetlist.length; i++) {
				if (Datasetlist[i].checked) {
					selectedDatasetList = selectedDatasetList
							+ Datasetlist[i].value + " @nd# ";
				}
			}
			document.getElementById("selectedDatasetList").value = selectedDatasetList;
		}
	</script>

</body>
</html>