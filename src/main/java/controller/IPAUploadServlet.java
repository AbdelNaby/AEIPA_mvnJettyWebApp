package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.db.IPADTO;
import model.db.IPAService;
import supplier.model.FilesUpload;

/**
 * Servlet implementation class IPAUploadServlet
 */
public class IPAUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IPAUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	 
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
	    HttpSession session =request.getSession();
	    //String uploadedIPAFilePath = (String) session.getAttribute("fullPath");
	    IPADTO currentIPA = (IPADTO) session.getAttribute("currentIPA");
	    System.out.println("IPA to be uploaded to: " + currentIPA.getFullPath());
	    IPAService iPAService = new IPAService();
		try {
			List<FileItem> multifiles = sf.parseRequest(request);
			iPAService.uploadFiles(multifiles, currentIPA);
			//PrintWriter writer = response.getWriter();
			response.sendRedirect("home.jsp");
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
