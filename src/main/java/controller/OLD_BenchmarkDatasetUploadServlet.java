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

import model.db.DatasetDTO;
import model.db.DatasetService;

/**
 * Servlet implementation class BenchmarkDatasetUploadServlet
 */
public class OLD_BenchmarkDatasetUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OLD_BenchmarkDatasetUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		HttpSession session = request.getSession();
		// String uploadedIPAFilePath = (String) session.getAttribute("fullPath");
		DatasetDTO benchmarkDataset = (DatasetDTO) session.getAttribute("benchmarkDataset");
		System.out.println("Dataset to be uploaded to: " + benchmarkDataset.getFullPath());
		DatasetService datasetService = new DatasetService();
		try {
			List<FileItem> multifiles = sf.parseRequest(request);
			datasetService.uploadFiles(multifiles, benchmarkDataset);
			// PrintWriter writer = response.getWriter();
			response.sendRedirect("home.jsp");
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
