package org.acil.aeipa.AEIPA_mvnJettyWebApp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spotify.docker.client.exceptions.DockerException;

import supplier.model.IPADockerClient;



/**
 * Servlet implementation class DockerClientServlet
 */
public class DockerClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DockerClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String yourName = request.getParameter("yourName");
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Hello ooooooooooooooo " + yourName + "</h1>");
		
        writer.println( "Hello World!" );
        writer.println( "Hello World 223344!" );
//
//        IPADockerClient IPAdc = new IPADockerClient();
//        try {
//			IPAdc.createJavaContainer();
//		} catch (DockerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
	
	
	
	

}
