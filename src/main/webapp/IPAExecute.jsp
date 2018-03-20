<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<center>
			<table border="1" width="30%" cellpadding="5">
				<thead>
					<tr>
						<th colspan="2">Please fill in Image Processing Algorithm
							information below</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td nowrap>IPA Name * </td>
						<td><input type="text" name="ipaname" value="" required /></td>
					</tr>
					<tr>
						<td nowrap>Description</td>
						<td><input type="text" name="description" value="" /></td>
					</tr>
					<tr>
						<td nowrap>IPA Type</td>
						<td><select id="ipatype" name="ipatype">
								<option value="Matching" selected>Image Matching</option>
								<option value="Edge_Detection">Edge Detection</option>
						</select></td>
					</tr>
					<tr>
						<td nowrap>Main File Name * </td>
						<td><input type="text" name="mainfilename" value="" /></td>
					</tr>
					<tr>
						<td nowrap>Programing Language</td>
						<td><select id="proglanguagename" name="proglanguagename">
								<option value="Java" selected>Java</option>
								<option value="Matlab">Matlab</option>
						</select></td>
					</tr>
					<tr>
						<td nowrap>Programing Language Version</td>
						<td><select id="proglanguagenum" name="proglanguagenum">
								<option value="Javac 1.8.0_151" selected>Javac 1.8.0_151</option>
								<option value="Matlab_7">Matlab 7</option>
						</select></td>
					</tr>

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