package controller;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.db.*;

/**
 * Servlet implementation class IPAJavaDockerExecuteServlet
 */
public class IPAJavaDockerExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IPAJavaDockerExecuteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String selectedIPAList = request.getParameter("selectedIPAList");
		System.out.println("Inside IPAJavaDockerExecuteServlet selectedIPAListis : " + selectedIPAList);
		String selectedDatasetList = request.getParameter("selectedDatasetList");
		System.out.println("Inside IPAJavaDockerExecuteServlet selectedDatasetList : " + selectedDatasetList);

		//String[] selectedIPANameList = selectedIPAList.split(" @nd# ");
		
		//String[] selectedDatasetNameList = selectedDatasetList.split(" @nd# ");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		

		ArrayList<String> executedDatasetNameList = new ArrayList<String>(Arrays.asList(selectedDatasetList.split(" @nd# ")));
		ArrayList<String> executedIPANameList = new ArrayList<String>(Arrays.asList(selectedIPAList.split(" @nd# ")));
//		ArrayList<String> executedinputDatasetDTOList = new ArrayList<String>();
		ArrayList<DatasetContainerDTO> datasetContainerDTOList = new ArrayList<DatasetContainerDTO>();
		System.out.println(executedDatasetNameList);
		System.out.println("Inside IPAJavaDockerExecuteServlet the First selectedIPANameList are: " + executedIPANameList);

		System.out.println("Inside IPAJavaDockerExecuteServlet the first selectedDatasetNameList are: "+ executedDatasetNameList);
		ArrayList<ResultDTO> resultDTOList = new ArrayList<ResultDTO>();
		DatasetService datasetService = new DatasetService();
		for (int k = 0; k < executedDatasetNameList.size(); k++) {
			DatasetContainerDTO datasetContainerDTO = datasetService.retrievebyDatasetName(executedDatasetNameList.get(k));
			datasetContainerDTOList.add(datasetContainerDTO);
			System.out.println("****************");
			System.out.println("****************");
			System.out.println("****************");
			System.out.println("****************");
			System.out.println("DatasetName is: " + datasetContainerDTO.getInputSequenceDatasetDTOList().get(0).getDatasetName());
		}
		ArrayList<IPAExecutionResultReportDTO> iPAExecutionResultReportDTOList = new ArrayList<IPAExecutionResultReportDTO>();
		
		for (int i = 0; i < executedIPANameList.size(); i++) {
			IPAService iPAService = new IPAService();
			IPADTO iPADTO = iPAService.retrieveInfobyName(executedIPANameList.get(i));
			// preparing the input dataset
			for (int k = 0; k < datasetContainerDTOList.size(); k++) {
				DatasetContainerDTO datasetContainerDTO = datasetContainerDTOList.get(k);
				//inputDatasetDTO.getFilesNameList();
				// providing the input dataset to the execution
				//System.out.println("The Dataset is: " + datasetContainerDTO.getInputSequenceDatasetDTOList().get(0).getDatasetName());
				ArrayList<ResultDTO> tempResultDTOList = new ArrayList<ResultDTO>();
				tempResultDTOList.addAll(iPAService.executeIPA(iPADTO, datasetContainerDTO, username));
				
				
				IPAExecutionResultReportDTO tempIPAExecutionResultReportDTO = new IPAExecutionResultReportDTO();
				tempIPAExecutionResultReportDTO.setDatasetName(datasetContainerDTOList.get(k).getResultSequenceDatasettDTOList().get(0).getDatasetName());
				

				for(int j=0; j< tempResultDTOList.size() ; j++)
				{
//					resultStr.add(datasetContainerDTOList.get(i).getResultSequenceDatasettDTOList().get(j).getConfusion_Matrix().gettPR());
//					resultStr.add(datasetContainerDTOList.get(i).getResultSequenceDatasettDTOList().get(j).getConfusion_Matrix().gettPR());
//					resultStr.add(datasetContainerDTOList.get(i).getResultSequenceDatasettDTOList().get(j).getConfusion_Matrix().gettPR());
//					resultStr.add(datasetContainerDTOList.get(i).getResultSequenceDatasettDTOList().get(j).getConfusion_Matrix().gettPR());
					SeqDatasetResult tempSeqDatasetResult = new SeqDatasetResult();

					tempSeqDatasetResult.settPR(tempResultDTOList.get(j).getConfusion_Matrix().gettPR());
					tempSeqDatasetResult.settNR(tempResultDTOList.get(j).getConfusion_Matrix().gettNR());
					tempSeqDatasetResult.setfNR(tempResultDTOList.get(j).getConfusion_Matrix().getfNR());
					tempSeqDatasetResult.setfPR(tempResultDTOList.get(j).getConfusion_Matrix().getfPR());
					tempSeqDatasetResult.setDatasetSeqName(tempResultDTOList.get(j).getName());
					tempIPAExecutionResultReportDTO.getSeqDatasetResultList().add(tempSeqDatasetResult);
					
					System.out.println("  --> --> --> ");
					System.out.println("  --> --> --> ");
					System.out.println("  --> --> --> i: "+ i);
					System.out.println("  --> --> --> j: " + j);
					System.out.println("  --> --> --> " + tempSeqDatasetResult.getDatasetSeqName());
				}
				iPAExecutionResultReportDTOList.add(tempIPAExecutionResultReportDTO);
				resultDTOList.addAll(tempResultDTOList);
			}
		}
//		ArrayList<String> resultStr = new ArrayList<String>();
//		for(int i=0; i<datasetContainerDTOList.size(); i++)
//		{
//			
//			
//		}
//		for(int i=0; i< executedDatasetNameList.size() ; i++)
//		{
//			executedinputDatasetDTOList.add(executedDatasetNameList.get(i).get);
//		}
		
		session.setAttribute("executedIPANameList", executedIPANameList);
		session.setAttribute("iPAExecutionResultReportDTOList", iPAExecutionResultReportDTOList);
		//session.setAttribute("resultDTOList", resultDTOList);
		//PrintWriter writer = response.getWriter();
		//writer.println("All Done :) !");
		response.sendRedirect("ResultsReport.jsp");
	}

}
