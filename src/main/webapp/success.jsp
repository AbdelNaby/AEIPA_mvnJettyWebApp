<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AEIPA Login Page</title>
</head>
<body bgcolor="#669900">
	<h1>AEIPA : Automated Evaluation of Image Processing Algorithms</h1>

	<%
		if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
	%>
	You are not logged in
	<br />
	<a href="index.jsp">Please Login</a>
	<%
		} else {
	%>
	Welcome
	<%=session.getAttribute("username")%>
	To
	<a href='logout.jsp'>Logout</a>
	<%
		}
	%>
	<form action="IPACreateNewServlet" method="post"
		enctype="multipart/form-data">
		<input type="file" name="file" multiple /> <input type="submit" />
		Adding a new Image Processing Algorithm 
		Please select the IPA's Type: 

	</form>
		<h1>Uploading an IPA: </h1>
	<form action="IPACreateNewServlet" method="post"
		enctype="multipart/form-data">

		<select id="IPAType" name="IPAType">
			<option value="Matching">Image Matching</option>
			<option value="Edge_Detection">Edge Detection</option>
		</select> 
		<input type="file" name="file" multiple /> <input type="submit"
			value="Upload" />

	</form>
</body>
</html>
