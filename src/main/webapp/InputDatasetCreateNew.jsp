<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Creating New Input Dataset</title>
</head>
<body bgcolor="#669900">
	<form method="post" action="InputDatasetCreatNewServlet">
		<center>
			<table border="1" width="30%" cellpadding="5">
				<thead>
					<tr>
						<th colspan="2">Please fill in the Input Dataset information
							below</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td nowrap>Input Dataset Name *</td>
						<td><input type="text" name="inputdatasetname" value=""
							required /></td>
					</tr>
					<tr>
						<td nowrap>Input Dataset Description</td>
						<td><input type="text" name="inputdatasetdescription"
							value="" /></td>
					</tr>
					<tr>
						<td>Input Dataset Evaluation Description</td>
						<td><input type="text" name="inputdatasetevaldescr" value="" /></td>
					</tr>
					<tr>
						<td nowrap>The corresponding Benchmark Dataset Name *</td>
						<td><input type="text" name="benchmarkdatasetname" value=""
							required /></td>
					</tr>
					<tr>
						<td>Benchmark Dataset Description</td>
						<td><input type="text" name="benchmarkdatasetdescription"
							value="" /></td>
					</tr>
					<tr>
						<td nowrap>Benchmark Dataset Evaluation Description</td>
						<td><input type="text" name="benchmarkdatasetevaldescr"
							value="" /></td>
					</tr>
					<tr>
						<td nowrap>Benchmark Dataset Type</td>
						<td><select id="benchmarkdatasettype" name = "benchmarkdatasettype"
							onchange="enableLabelingSheet(this);">
								<option value="GroundTruth">GroundTruth</option>
								<option value="BoundingBox">Bounding Box</option>
								<option value="BoundingBoxLabeled">Labeled Bounding Box</option>
						</select></td>
					</tr>
					<tr>
						<td nowrap>Labeling Sheet Name</td>
						<td><input type="text" id="XYLABEL_SHEETNAME"
							name="XYLABEL_SHEETNAME" value="" disabled /></td>
					</tr>

					<script>
						function enableLabelingSheet(that) {
							if (that.value == "BoundingBoxLabeled") {
								//alert("check");
								//document.getElementById("ifYes").style.display = "block";
								document.getElementById("XYLABEL_SHEETNAME").disabled = false;
								document.getElementById("XYLABEL_SHEETNAME").color = "#000";
							} else {
								//document.getElementById("ifYes").style.display = "none";
								document.getElementById("XYLABEL_SHEETNAME").disabled = true;
								document.getElementById("XYLABEL_SHEETNAME").color = "#888";
							}
						}
					</script>

					</tr>
					<tr>
						<td><input type="submit" value="Submit"
							name="Create a new Input Dataset" /></td>
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