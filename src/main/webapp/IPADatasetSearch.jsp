<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IPA and Dataset Search</title>
</head>
<body bgcolor="#669900">
	<form method="post" action="IPADatasetSearchServlet">
		<center>
			<table border="1" width="30%" cellpadding="5">
				<thead>
					<tr>
						<th colspan="2">Select the needed types</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td nowrap>IPA Type</td>
						<td><select id="ipatype" name="ipatype" onchange="iPATypeSelected(this.value)">
								<option value="Matching" selected>Image Matching</option>
								<option value="Edge_Detection">Edge Detection</option>
						</select></td>

					</tr>
					<tr>
						<td nowrap>Dataset Evaluation Type</td>
						<td><select id="datasetType" name="datasetType">
								<option value="BOUNDING_BOX" selected>Bounding Box</option>
								<option value="LABELLED_BOUNDING_BOX">Labeled Bounding Box</option>
						</select></td>
					</tr>

					<tr>
						<td><input type="submit" value="Submit" name="Search" /></td>
						<td><input type="reset" value="Reset" /></td>
					</tr>
					<tr>
						<td colspan="2">Back <a href="home.jsp">to AEIPA Homepage</a></td>
					</tr>
				</tbody>
			</table>
		</center>
	</form>
	
</body>
</html>