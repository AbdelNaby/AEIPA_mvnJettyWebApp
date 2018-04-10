<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.db.*"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Execution Results</title>
</head>
<body bgcolor="#669900">
	<center>
	<br/>
	<br/>
		<table border="1" width="30%" cellpadding="5">

			<tbody>
				<tr>


					<td rowspan="2"><b>Datasets</b></td>
					<td rowspan="2"><b>Dataset Sequences</b></td>
					<c:forEach var="executedIPAName" items="${executedIPANameList}">
						<td colspan="4"><b>${executedIPAName}</b></td>

					</c:forEach>
				</tr>

				<tr>
					<c:forEach var="executedIPAName" items="${executedIPANameList}">

						<td><b>TPR</b></td>
						<td><b>TNR</b></td>
						<td><b>FNR</b></td>
						<td><b>FPR</b></td>

					</c:forEach>
				</tr>

				<c:forEach var="iPAExecutionResultReportDTO"
					items="${iPAExecutionResultReportDTOList}">
					<tr>
						<td
							rowspan="${fn:length(iPAExecutionResultReportDTO.seqDatasetResultList)}">${iPAExecutionResultReportDTO.datasetName}</td>
						<c:forEach var="seqDatasetResult"
							items="${iPAExecutionResultReportDTO.seqDatasetResultList}">
							<tr>
								<td>${seqDatasetResult.datasetSeqName}</td>
								<td nowrap>${seqDatasetResult.tPR}</td>
								<td nowrap>${seqDatasetResult.tNR}</td>
								<td nowrap>${seqDatasetResult.fNR}</td>
								<td nowrap>${seqDatasetResult.fPR}</td>
							</tr>
						</c:forEach>
					</tr>
				</c:forEach>

				<!-- 
				<c:forEach var="datasetContainerDTO"
					items="${datasetContainerDTOList}">

					<c:forEach var="resultSequenceDatasettDTO"
						items="${datasetContainerDTO.resultSequenceDatasettDTOList}">
						<tr>
							<td>${resultSequenceDatasettDTO.datasetName}</td>
							<td>${resultSequenceDatasettDTO.name}</td>
							<td nowrap>${resultSequenceDatasettDTO.confusion_Matrix.tPR}</td>
							<td nowrap>${resultSequenceDatasettDTO.confusion_Matrix.tNR}</td>
							<td nowrap>${resultSequenceDatasettDTO.confusion_Matrix.fNR}</td>
							<td nowrap>${resultSequenceDatasettDTO.confusion_Matrix.fPR}</td>
						</tr>
					</c:forEach>

				</c:forEach>
 -->

				<tr>
					<td colspan="100">Back <a href="home.jsp">to AEIPA
							Homepage</a></td>
				</tr>
			</tbody>
		</table>
	</center>
</body>
</html>