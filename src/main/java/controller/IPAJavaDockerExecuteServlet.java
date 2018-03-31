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
		

		ArrayList<String> selectedDatasetNameList = new ArrayList<String>(Arrays.asList(selectedDatasetList.split(" @nd# ")));
		ArrayList<String> selectedIPANameList = new ArrayList<String>(Arrays.asList(selectedIPAList.split(" @nd# ")));

		System.out.println(selectedDatasetNameList);
		System.out.println("Inside IPAJavaDockerExecuteServlet the First selectedIPANameList are: " + selectedIPANameList);

		System.out.println("Inside IPAJavaDockerExecuteServlet the first selectedDatasetNameList are: "+ selectedDatasetNameList);
		for (int i = 0; i < selectedIPANameList.size(); i++) {
			IPAService iPAService = new IPAService();
			IPADTO iPADTO = iPAService.retrieveInfobyName(selectedIPANameList.get(i));
			// preparing the input dataset
			for (int k = 0; k < selectedDatasetNameList.size(); k++) {
				DatasetService datasetService = new DatasetService();
				DatasetContainerDTO datasetContainerDTO = datasetService
						.retrieveDataset_InputDTOName(selectedDatasetNameList.get(k));
				System.out.println("****************"+ selectedIPANameList.size());
				System.out.println("****************"+ selectedDatasetNameList.size());
				System.out.println("****************");
				System.out.println("Providing to the IPA execution With Input Dataset Name: " + datasetContainerDTO.getInputSequenceDatasetDTOList().get(0).getName());
				System.out.println("****************");
				System.out.println("****************");
				System.out.println("****************");
				//inputDatasetDTO.getFilesNameList();
				// providing the input dataset to the execution
				iPAService.executeIPA(iPADTO, datasetContainerDTO, username);
			}
		}
		PrintWriter writer = response.getWriter();
		writer.println("All Done :) !");
		response.sendRedirect("ExecutionReport.jsp");
	}

}
