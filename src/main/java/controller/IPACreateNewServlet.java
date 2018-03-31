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
 * Servlet implementation class IPACreateNewServlet
 */
public class IPACreateNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IPACreateNewServlet() {
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
		String ipaname = request.getParameter("ipaname");
		String description = request.getParameter("description");
		String ipatype = request.getParameter("ipatype");
		String mainfilename = request.getParameter("mainfilename");
		String proglanguagename = request.getParameter("proglanguagename");
		String proglanguagenum = request.getParameter("proglanguagenum");
		PrintWriter writer = response.getWriter();
		IPADTO iPA = null;
		if (!ipaname.isEmpty() && !ipatype.isEmpty() && !username.isEmpty()) {
			if (ipatype.equalsIgnoreCase("Matching")) {
				iPA = new IPA_MatchingDTO(ipaname);
			} else {
				if (ipatype.equalsIgnoreCase("Edge_Detection")) {
					iPA = new IPA_Edge_DetectionDTO(ipaname);
				}
			}

			iPA.setUserName(username);
			iPA.setDescription(description);
			iPA.setMainFileName(mainfilename);
			System.out.println("Here is the mainfilename in the IPAcreateservlet: " + iPA.getMainFileName());
			iPA.setProgLanguageName(proglanguagename);
			iPA.setProgLanguageNum(proglanguagenum);

			IPAService iPAService = new IPAService();

			if (iPAService.createNew(iPA)) {
				//String fullPath = iPA.getFullPath();
		        //session.setAttribute("fullPath", fullPath);
		        session.setAttribute("currentIPA", iPA);
				response.sendRedirect("ipaupload.jsp");
			} else {
				writer.println("Please Enter Valid Data, IPA is not created successfully");
			}

		} else {
			writer.println("Please enter valid: IPA Name - IPA Type - UserName !");
		}

	}

}
