package controller;

import java.io.IOException;
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

import model.db.*;

/**
 * Servlet implementation class DatasetUploadServlet
 */
public class DatasetUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DatasetUploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		HttpSession session = request.getSession();
		// String uploadedIPAFilePath = (String) session.getAttribute("fullPath");
		DatasetDTO currentDataset = (DatasetDTO) session.getAttribute("inputDataset");
		System.out.println("Dataset to be uploaded to: " + currentDataset.getFullPath());
		DatasetService datasetService = new DatasetService();
		try {
			List<FileItem> multifiles = sf.parseRequest(request);
			datasetService.uploadFiles(multifiles, currentDataset);
			// PrintWriter writer = response.getWriter();
			response.sendRedirect("BenchmarkDatasetUpload.jsp");
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
