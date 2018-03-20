<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Benchmark Dataset Upload Page</title>
</head>
<body bgcolor="#669900">
	<form action="BenchmarkDatasetUploadServlet" method="post"
		enctype="multipart/form-data">
		<center>
			<table border="1" width="30%" cellpadding="3">
				<thead>
					<tr>
						<th colspan="2">Uploading Benchmark Dataset</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="2">Uploading Benchmark Dataset</td>
					</tr>
					<tr>
						<td><input type="file" name="file" multiple /></td>
						<td><input type="submit" value="Upload" /></td>
					</tr>
				</tbody>
			</table>
		</center>
	</form>
</body>
</html>