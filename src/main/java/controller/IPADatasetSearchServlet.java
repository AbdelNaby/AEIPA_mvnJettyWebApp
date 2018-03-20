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
import model.db.IPADTO;
import model.db.IPAService;
import model.db.IPA_Edge_DetectionDTO;
import model.db.IPA_MatchingDTO;

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
			if (ipatype.equalsIgnoreCase("Matching")) {
				iPADTOList = iPAService.retrieveInfobyType("Matching");
			} else {
				if (ipatype.equalsIgnoreCase("Edge_Detection")) {
					iPADTOList = iPAService.retrieveInfobyType("Edge_Detection");
				}
			}
			ArrayList<String> iPAArrayList = new ArrayList<String>();
			for (int i = 0; i < iPADTOList.size(); i++) {
				iPAArrayList.add(iPAService.dTOMapper(iPADTOList.get(i)).toString());
			}
			System.out.println("Here is the retrievedIPA List: " + iPAArrayList);
//			for (int i = 0; i < iPAArrayList.size(); i++) {
//				session.setAttribute("iPAName", iPAArrayList.get(i++));
//			}
			//List<IPADTO> listiPA = iPADTOList;
			session.setAttribute("listiPA", iPADTOList);
//			session.setAttribute("IPAListSize", iPAArrayList.size());
			// System.out.println("<table>");
			// ArrayList dataList = new ArrayList();
			// // add some data in it....
			//// for (Iterator iter = iPAArrayList.iterator(); iter.hasNext();) {
			//// System.out.println("<tr><td>" + (String)(iPAArrayList.next()) +
			// "</td></tr>");
			//// }
			// for (int i=0; i< iPAArrayList.size(); i++)
			// {
			// System.out.println("<tr><td>" + iPAArrayList.get(i).toString() +
			// "</td></tr>");
			// }
			// System.out.println("</table>");
			response.sendRedirect("IPADatasetSearchResults.jsp");
		} else {
			writer.println("Please Enter Valid Type and username, IPA is not retrieved successfully");
		}
	}

}

//
//
//
//<%  
//// retrieve your list from the request, with casting 
//ArrayList<IPADTO> list = (ArrayList<IPADTO>) request.getAttribute("currentIPAList");
//
//// print the information about every category of the list
//for(IPADTO iPADTO : list) {
//    out.println(iPADTO.getName());
//    out.println(iPADTO.getDescription());
//    out.println(iPADTO.getType());
//    out.println(iPADTO.getMainFileName());
//    out.println(iPADTO.getProgLanguageName());
//    out.println(iPADTO.getProgLanguageNum());
//    out.println(iPADTO.getUserName());
//}
//  
//
//%>
