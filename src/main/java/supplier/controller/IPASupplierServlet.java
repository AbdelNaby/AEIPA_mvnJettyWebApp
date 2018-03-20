package supplier.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.spotify.docker.client.exceptions.DockerException;

import supplier.model.FilesUpload;
import supplier.model.IPADockerClient;
import aeipa.database.*;
/**
 * Servlet implementation class IPASupplierServlet
 */
public class IPASupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String uploadedIPAFilePath = "/home/acil/eclipse-workspace/UploadedFiles/";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IPASupplierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		try {
			List<FileItem> multifiles = sf.parseRequest(request);
			FilesUpload uploadingIPA = new FilesUpload(uploadedIPAFilePath, multifiles);
//			CrunchifyMySQLDBTutorial dbTest = new CrunchifyMySQLDBTutorial();
//			System.out.println("==========> Database done !!!!");
			
			
			PrintWriter writer = response.getWriter();
			writer.println("<h1>Hello ooooooooooooooo " + "</h1>");
			
	        writer.println( "Hello World!" );
	        
	        
	        
			// Docker Client Code:
			List<String> uploadedIPAfiles = uploadingIPA.getUploadedFilesNames();
			  try {
			        String[][] commands = new String[][] {
		                new String[] {"ls", "-l" },
		                new String[] {"javac", "testMain.java" },
		                new String[] {"java", "Main" },
		                new String[] {"ls", "-l" },
		                new String[] {"cat", "hello" } 
		        } ;
			
//			for (int i =0; i< uploadedIPAfiles.size(); i++)//String s : uploadedIPAfiles)
//			{
//				commands[i][1] = uploadedIPAfiles.get(i);
//			}
			
		        commands[1][1] = uploadedIPAfiles.get(0);
	      
	        IPADockerClient IPAdc = new IPADockerClient();
			IPAdc.createJavaContainer(commands);
			
			System.out.println("\n ===> Done executing the uploaded IPA!");
			writer.println( "\n ===> Done executing the uploaded IPA!" );
			
			} catch (DockerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				//CrunchifyMySQLDBTutorial dbTest = new CrunchifyMySQLDBTutorial();
				System.out.println("\n ====> Database queries are done !!!!");
				writer.println( "\n==========> Database done !!!!" );
				
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	

}
