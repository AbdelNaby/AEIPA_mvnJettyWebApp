<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IPA and Dataset Select</title>
</head>
<body bgcolor="#669900" onload="iPASelectedValues()">


	<form method="post" action="IPAJavaDockerExecuteServlet">
		<center>
			<table border="1" width="30%" cellpadding="5" id="iPATable">
				<thead>
					<tr>
						<th colspan="7">The Selected IPAs</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td nowrap>IPA Name</td>
						<td nowrap>Description</td>
						<td nowrap>IPA Type</td>
						<td nowrap>Main File Name</td>
						<td nowrap>Programing Language</td>
						<td nowrap>Programing Language Version</td>
						<td nowrap>UserName</td>
						
					</tr>


				</tbody>
			</table>
		</center>
	</form>


<script type="text/javascript">
function iPASelectedValues() {
	   var ipatable = document.getElementById("iPATable");
	   var iPAarraylist = session.getAttribute("currentIPAList");
	   var iPAarraylistlen = iPAarraylist.length;
	   
	   document.write("Hello inside function iPASelectedValues() ! ");
	   for (i = 0, j=0; i < iPAarraylistlen; i++, j++) {
		   
		   var row = ipatable.insertRow(i+1);
		   
		   var cell1 = row.insertCell(i);
		   cell1.innerHTML = iPAarraylist[i++];
		   var cell2 = row.insertCell(i);
		   cell2.innerHTML = iPAarraylist[i++];
		   var cell3 = row.insertCell(i);
		   cell3.innerHTML = iPAarraylist[i++];
		   var cell4 = row.insertCell(i);
		   cell4.innerHTML = iPAarraylist[i++];
		   var cell5 = row.insertCell(i);
		   cell5.innerHTML = iPAarraylist[i++];
		   var cell6 = row.insertCell(i);
		   cell6.innerHTML = iPAarraylist[i++];
		   var cell7 = row.insertCell(i);
		   cell7.innerHTML = iPAarraylist[i++];
		}
}
</script>

	<script type="text/javascript">
		var iPAList = new Array();
		iPAList = new Array('<s:property value="%{currentIPAList}"/>');
		var iPAValues = iPAList.toString();
		iPAValues = carter.replace("[", "");
		iPAValues = carter.replace("]", "");
		iPAValues = carter.split(",");
		document.body.innerHTML = iPAValues;
		document.body.innerHTML = "Hello";
	</script>
	Welcome
	<%=session.getAttribute("currentIPAList")%>
	To
	<form action="IPAJavaDockerExecuteServlet" method="post">
		<input type="checkbox" name="vehicle" value="Bike"> I have a
		bike<br> <input type="checkbox" name="vehicle" value="Car"
			checked="checked"> I have a car<br> <input type="submit"
			value="Submit">

		<script type="text/javascript">
			document.write("Hello There ! ");
					document.write(iPAValues);
      </script>
	</form>

</body>
</html>