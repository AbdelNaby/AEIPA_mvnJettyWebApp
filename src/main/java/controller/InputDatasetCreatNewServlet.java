package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.db.*;

/**
 * Servlet implementation class InputDatasetCreatNewServlet
 */
public class InputDatasetCreatNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InputDatasetCreatNewServlet() {
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
		String inputdatasetname = request.getParameter("inputdatasetname");
		String inputdatasetdescription = request.getParameter("inputdatasetdescription");
		String inputdatasetevaldescr = request.getParameter("inputdatasetevaldescr");
		String benchmarkdatasetname = request.getParameter("benchmarkdatasetname");
		String benchmarkdatasetdescription = request.getParameter("benchmarkdatasetdescription");
		String benchmarkdatasetevaldescr = request.getParameter("benchmarkdatasetevaldescr");
		String benchmarkdatasettype = request.getParameter("benchmarkdatasettype");
		
		// String inputdatasettype = request.getParameter("inputdatasettype");

		//////////////////////////////////////// Benchmark dataset creation
		DatasetDTO benchmarkDatasetDTO = null;
		// 1.checking benchmark type
		if (benchmarkdatasettype.equals("GroundTruth")) {
			benchmarkDatasetDTO = new BenchmarkDatasetDTO_GroundTruth(benchmarkdatasetname);
		} else if (benchmarkdatasettype.equals("BoundingBox")) {
			benchmarkDatasetDTO = new BenchmarkDatasetDTO_BoundingBox(benchmarkdatasetname);
		} else
		// it means it is BenchmarkDatasetDTO_BoundingBoxLabeled
		{
			String XYLABEL_SHEETNAME = request.getParameter("XYLABEL_SHEETNAME");
			benchmarkDatasetDTO = new BenchmarkDatasetDTO_BoundingBoxLabeled(benchmarkdatasetname, XYLABEL_SHEETNAME);
		}
		PrintWriter writer = response.getWriter();
		benchmarkDatasetDTO.setUserName(username);
		benchmarkDatasetDTO.setName(benchmarkdatasetname);
		benchmarkDatasetDTO.setDescription(benchmarkdatasetdescription);
		benchmarkDatasetDTO.setEvaluationDescription(benchmarkdatasetevaldescr);
		DatasetService benchmarkDatasetService = new DatasetService();
		if (!benchmarkdatasetname.isEmpty()) {
			if (benchmarkDatasetService.createNew(benchmarkDatasetDTO)) {
			// String fullPath = iPA.getFullPath();
			// session.setAttribute("fullPath", fullPath);
			System.out
					.println("inside (InputDatasetCreatNewServlet) benchmarkDataset has been created successfully !!!");
			
			
		} else {
			writer.println("Please Enter valid data, input dataset is not created successfully");
		}
		} else {
			writer.println("Please Enter Benchmark Dataset name, input dataset is not created successfully");
		}
		InputDatasetDTO inputDatasetDTO = new InputDatasetDTO(inputdatasetname, benchmarkdatasetname);
		if (!inputdatasetname.isEmpty() && !username.isEmpty()) {
				inputDatasetDTO.setUserName(username);
				inputDatasetDTO.setName(inputdatasetname);
				inputDatasetDTO.setDescription(inputdatasetdescription);
				inputDatasetDTO.setEvaluationDescription(inputdatasetevaldescr);
				DatasetService datasetService = new DatasetService();
				if (datasetService.createNew(inputDatasetDTO)) {
					// String fullPath = iPA.getFullPath();
					// session.setAttribute("fullPath", fullPath);
					System.out.println(
							"inside (InputDatasetCreatNewServlet) Input Dataset has been created successfully !!!");
					session.setAttribute("inputDataset", inputDatasetDTO);
					System.out.println("Inside inputDatasetDTO.benchmarkDataset.getFullPath " + inputDatasetDTO.benchmarkDataset.getFullPath());
					session.setAttribute("benchmarkDataset", benchmarkDatasetDTO);
					response.sendRedirect("DatasetUpload.jsp");
				} else {
					writer.println("Please Enter valid data, input dataset is not created successfully");
				}		
		} else {
			writer.println("Please enter valid: input dataset Name  !");
		}
	}
}
