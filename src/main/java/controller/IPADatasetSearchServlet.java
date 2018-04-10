package controller;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javassist.bytecode.Descriptor.Iterator;
import model.db.*;

/**
 * Servlet implementation class IPADatasetSearchServlet
 */
public class IPADatasetSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IPADatasetSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Retrieve the IPAs
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String ipatype = request.getParameter("ipatype");
		ArrayList<IPADTO> iPADTOList = new ArrayList<IPADTO>();
		IPAService iPAService = new IPAService();
		PrintWriter writer = response.getWriter();
		if (!ipatype.isEmpty() && !username.isEmpty()) {
			if (!(ipatype.equalsIgnoreCase("Matching") || ipatype.equalsIgnoreCase("Edge_Detection"))) {
				System.out.println("The IPA Types doesn't match the ones in the IPA DAOs");
			} else {
				iPADTOList = iPAService.retrieveInfobyType(ipatype);
			}

			ArrayList<String> iPAArrayList = new ArrayList<String>();
			for (int i = 0; i < iPADTOList.size(); i++) {
				iPAArrayList.add(iPAService.dTOMapper(iPADTOList.get(i)).toString());
			}
			System.out.println("Here is the retrievedIPA List: " + iPAArrayList);
			session.setAttribute("listiPA", iPADTOList);

		} else {
			writer.println("Please Enter Valid Type and username, IPA is not retrieved successfully");
		}
		// 2. Retrieve the Datasets
		String datasetType = request.getParameter("datasetType");
		ArrayList<DatasetContainerDTO> datasetContainerDTOList = new ArrayList<DatasetContainerDTO>();
		DatasetService datasetService = new DatasetService();
		if (!datasetType.isEmpty() && !username.isEmpty()) {
			datasetContainerDTOList = datasetService.retrieveDatasetbyResultType(datasetType);
			ArrayList<DatasetDTO> inputDatasetDTOList = new ArrayList<DatasetDTO>();

			for (int i = 0; i < datasetContainerDTOList.size(); i++) {
				inputDatasetDTOList.add(datasetContainerDTOList.get(i).getInputSequenceDatasetDTOList().get(0));
			}

			// // Retrieving only the input datasets associated with benchmarkdatasets with
			// the selected type
			// for(int i=0; i< datasetContainerDTOList.size(); i++)
			// {
			// ArrayList<DatasetDTO> inputDatasetDTOListTemp = new ArrayList<DatasetDTO>();
			// inputDatasetDTOListTemp =
			// datasetService.retrieveInfobyResultType(benchmarkDatasetDTOList.get(i).getResultType());
			// for(int k=0; k< inputDatasetDTOListTemp.size(); k++)
			// {
			// inputDatasetDTOList.add(inputDatasetDTOListTemp.get(k));
			// }
			// }
			session.setAttribute("inputDatasetDTOList", inputDatasetDTOList);
			
			response.sendRedirect("IPADatasetSearchResults.jsp");
		} else {
			writer.println("Please Enter Valid Type and username, Dataset is not retrieved successfully");
		}
	}
}

//
//
//
// <%
//// retrieve your list from the request, with casting
// ArrayList<IPADTO> list = (ArrayList<IPADTO>)
// request.getAttribute("currentIPAList");
//
//// print the information about every category of the list
// for(IPADTO iPADTO : list) {
// out.println(iPADTO.getName());
// out.println(iPADTO.getDescription());
// out.println(iPADTO.getType());
// out.println(iPADTO.getMainFileName());
// out.println(iPADTO.getProgLanguageName());
// out.println(iPADTO.getProgLanguageNum());
// out.println(iPADTO.getUserName());
// }
//
//
// %>
