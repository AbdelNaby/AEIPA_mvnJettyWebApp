package org.acil.aeipa.AEIPA_mvnJettyWebApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.Container;



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
	DockerClient docker = new DefaultDockerClient("unix:///var/run/docker.sock");

	try {
            writer.println( "Pinging" ) ;
            String pingResult = docker.ping() ;
            writer.println( "Ping result " + pingResult ) ;
        } catch (DockerException e) {
            writer.println( "Docker exception " + e.getMessage() ) ;
            e.printStackTrace(System.out);
        } catch (InterruptedException e) {
            writer.println( "Interrupted exception " + e.getMessage() ) ;
            e.printStackTrace(System.out);
            e.printStackTrace();
        }
        try {
            writer.println( "Listing Containers" ) ;
            final List<Container> containers = docker.listContainers() ;
            writer.println( "" + containers.size() + " containers ") ;
            for( Container c : containers ) {
                writer.println( "ID : " + c.id() ) ;
                writer.println( "Image : " + c.image() ) ;
            }
        } catch (DockerException e) {
            writer.println( "Docker exception " + e.getMessage() ) ;
            e.printStackTrace(System.out);
            e.printStackTrace();
        } catch (InterruptedException e) {
            writer.println( "Interrupted exception " + e.getMessage() ) ;
            e.printStackTrace(System.out);
            e.printStackTrace();
        }
        writer.println( "Bye" ) ;
		writer.close();
	}

}
