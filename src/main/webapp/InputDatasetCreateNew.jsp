<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Creating New Dataset</title>
</head>
<body bgcolor="#669900">
	<form method="post" action="DatasetCreatNewServlet">
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
						<td nowrap>Dataset Name *</td>
						<td><input type="text" name="datasetname" value="" required /></td>
					</tr>
					<tr>
						<td nowrap>Dataset Sequence Name *</td>
						<td><input type="text" name="dataSeqsetname" value="" required /></td>
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
						<td nowrap>Keywords</td>
						<td><input type="text" name="Keywords" value="" /></td>
					</tr>
					<tr>
						<td>GroundTruth Dataset Description</td>
						<td><input type="text" name="groundTruthdatasetdescription"
							value="" /></td>
					</tr>
					<tr>
						<td nowrap>GroundTruth Dataset Evaluation Description</td>
						<td><input type="text" name="groundTruthdatasetevaldescr"
							value="" /></td>
					</tr>

					<tr>
						<td nowrap>GroundTruth Dataset Result Type</td>
						<td><select id="groundTruthdatasetResultType"
							name="groundTruthdatasetResultType"
							onchange="enableLabelingSheet(this);">
								<option value="BOUNDING_BOX">Bounding Box</option>
								<option value="LABELLED_BOUNDING_BOX">Labeled Bounding Box</option>
						</select></td>
					</tr>
					<tr>
						<td nowrap>Labeling Sheet Name</td>
						<td><input type="text" id="XYLABEL_SHEETNAME"
							name="XYLABEL_SHEETNAME" value="" disabled /></td>
					</tr>

					<tr>
						<td><input type="submit" value="Submit"
							name="Create a new Dataset" /></td>
						<td><input type="reset" value="Reset" /></td>
					</tr>
					<tr>
						<td colspan="2">Back <a href="home.jsp">to AEIPA Homepage</a></td>
					</tr>
				</tbody>
			</table>
		</center>
	</form>
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
</body>
</html>