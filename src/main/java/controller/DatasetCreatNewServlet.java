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
 * Servlet implementation class DatasetCreatNewServlet
 */
public class DatasetCreatNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatasetCreatNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String datasetname = request.getParameter("datasetname");
		String dataSeqsetname = request.getParameter("dataSeqsetname");
		String inputdatasetdescription = request.getParameter("inputdatasetdescription");
		String inputdatasetevaldescr = request.getParameter("inputdatasetevaldescr");
		String Keywords = request.getParameter("Keywords");
		String groundTruthdatasetdescription = request.getParameter("groundTruthdatasetdescription");
		String groundTruthdatasetevaldescr = request.getParameter("groundTruthdatasetevaldescr");
		String groundTruthdatasetResultType = request.getParameter("groundTruthdatasetResultType");
		
		// String inputdatasettype = request.getParameter("inputdatasettype");

		//////////////////////////////////////// GroundTruth dataset creation
		GroundTruthDTO groundTruthDTO = new GroundTruthDTO(dataSeqsetname, datasetname, username);
		PrintWriter writer = response.getWriter();
		//groundTruthDTO.setUserName(username);
		groundTruthDTO.setKeyWords(Keywords);
		groundTruthDTO.setDescription(groundTruthdatasetdescription);
		groundTruthDTO.setEvaluationDescription(groundTruthdatasetevaldescr);
		groundTruthDTO.setResultType(groundTruthdatasetResultType);
		
		DatasetService groundTruthService = new DatasetService();
		if (!datasetname.isEmpty()) {
			if (groundTruthService.createNew(groundTruthDTO)) {
			// String fullPath = iPA.getFullPath();
			// session.setAttribute("fullPath", fullPath);
			System.out.println("inside (InputDatasetCreatNewServlet) groundTruth has been created successfully !!!");
		} else {
			writer.println("Please Enter valid data, input dataset is not created successfully");
		}
		} else {
			writer.println("Please Enter GroundTruth Dataset name, input dataset is not created successfully");
		}
		InputDTO inputDatasetDTO = new InputDTO(dataSeqsetname, datasetname, username);
		if (!datasetname.isEmpty() && !username.isEmpty()) {
				//inputDatasetDTO.setUserName(username);
				inputDatasetDTO.setDescription(inputdatasetdescription);
				inputDatasetDTO.setEvaluationDescription(inputdatasetevaldescr);
				inputDatasetDTO.setKeyWords(Keywords);
				DatasetService datasetService = new DatasetService();
				if (datasetService.createNew(inputDatasetDTO)) {
					// String fullPath = iPA.getFullPath();
					// session.setAttribute("fullPath", fullPath);
					System.out.println(
							"inside (InputDatasetCreatNewServlet) Input Dataset has been created successfully !!!");
					session.setAttribute("inputDataset", inputDatasetDTO);
					session.setAttribute("groundTruth", groundTruthDTO);
					response.sendRedirect("DatasetUpload.jsp");
				} else {
					writer.println("Please Enter valid data, input dataset is not created successfully");
				}		
		} else {
			writer.println("Please enter valid: input dataset Name  !");
		}
	}

}
