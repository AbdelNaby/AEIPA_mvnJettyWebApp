package supplier.model;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger ;
 
import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.DockerClient.ExecCreateParam;
import com.spotify.docker.client.LogStream;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.Container;
import com.spotify.docker.client.messages.ContainerConfig;
import com.spotify.docker.client.messages.ContainerCreation;
import com.spotify.docker.client.messages.ExecCreation;
import com.spotify.docker.client.messages.ExecState;
import com.spotify.docker.client.messages.HostConfig;
import com.spotify.docker.client.messages.HostConfig.Bind;

 
public class IPADockerClient {
 
    
	  public void createJavaContainer( String[][] commands) 
			  throws DockerException, InterruptedException, IOException {
	        System.out.println( "Hello from create DockerClient" ) ;
	        DockerClient docker = 
	        		new DefaultDockerClient("unix:///var/run/docker.sock");
	         
	        System.out.println( "Pinging" ) ;
	        String pingResult = docker.ping() ;
	        System.out.println( "Ping result " + pingResult ) ;
	 
	        String imageName = "dc1:8" ;
	        String guestPath = "/IPAResult" ;
	        String hostPath = getHostPath( "IPAResult" ) ;
	        System.out.println( "Working directory is " 
	        		+ hostPath + " on the host system.") ;
	         
	        String containerId = startContainer(docker, imageName, 
	        		guestPath, hostPath);
	         
//	        commands = new String[][] {
//	                new String[] {"ls", "-l" },
//	                new String[] {"javac", "Main.java" },
//	                new String[] {"java", "Main" },
//	                new String[] {"ls", "-l" },
//	                new String[] {"cat", "hello" } 
//	        } ;
	         
	        StringBuffer lastOutput = new StringBuffer() ;
	        AtomicInteger successCount = new AtomicInteger(0 ) ;
	        int lastExitCode = runCommands( docker, containerId, commands, lastOutput, successCount ) ;
	         
	        System.out.println( "Number of commands run successfully is " + successCount ) ;
	        System.out.println( "Last exit code is " + lastExitCode ) ;
	        System.out.println( "Last output is: '" +lastOutput.toString()+ "'" ) ;
	         
	        listContainers(docker) ;
	         
	        docker.stopContainer(containerId, 5);
	        System.out.println( "Stopped container "+containerId )  ;
	         
	        listContainers(docker) ;
	         
	        System.out.println( "Bye" ) ;
	    }
	 
	    /**  Start a Docker container.
	     * The directory at hostPath mapped on the host machine will be mapped to
	     * to path guestPath within the container.  For example if hostPath
	     * is /hello/world and guestPath is /bonjour then directory /hello/world
	     * on the host machine can be accessed as /bonjour by processes running within
	     * the container.  Further more the guestPath is used as the initial current working
	     * directory for commands run on the container.
	     * 
	     * Preconditions:
	     * <ul>
	     *   <li>The docker client is connected to a docker server.
	     *   <li> The imageName is the name of an image on that server.
	     *   <li> hostPath should be the name of an existing directory on the host machine.
	     *   <li> guestPath and hostPath should be valid absolute path names.
	     * </ul>
	     * Postcondition: If no exceptions are thrown, the result should be the id
	     * of a new Docker container which has been started.
	     * 
	     * @param docker -- A docker client. 
	     * @param imageName  -- The name of an image.
	     * @param guestPath
	     * @param hostPath
	     * @return the id of the new container
	     * @throws DockerException
	     * @throws InterruptedException
	     */
	    private static String startContainer(
	        DockerClient docker, 
	        String imageName,
	        String guestPath,
	        String hostPath)
	    throws DockerException, InterruptedException {
	         
	    	System.out.println( "In startContainer  imageName: " + imageName + "  guestPath : "+ guestPath + "  hostPath: "+ hostPath ); 
	        // First we need a host configuration that specifies the mapping from host volumes to guest volumes
	        final HostConfig hostConfig =
	                  HostConfig.builder()
	                    .appendBinds(Bind.from(hostPath)
	                               .to(guestPath)
	                               .readOnly(false)
	                               .build())
	                    .build();
	        System.out.println( "In startContainer HostConfig done !!");
	        // Next we need a container configuration.
	        ContainerConfig containerConfig
	        = ContainerConfig.builder()
	                   .image( imageName )
	                   .workingDir( guestPath )
	                   .hostConfig( hostConfig )
	                            .build( ) ;
	        System.out.println( "In startContainer containerConfig done !!");
	        // Now create the container.
	        ContainerCreation containerCreation ;
	        containerCreation = docker.createContainer( containerConfig ) ;
	        System.out.println( "In startContainer containerCreation done !!");
	        String containerId ;
	        containerId = containerCreation.id() ;
	        System.out.println( "======> Created container "+containerId )  ;
	         
	        docker.startContainer( containerId );
	        System.out.println( "===========> Started container "+containerId )  ;
	        return containerId;
	    }
	     
	    /** Run a sequence of one or more commands on a docker container.
	     * 
	     * The commands will be run one after another (starting with command 0) until
	     * either a command exits with a nonzero exit status or all commands have
	     * executed.
	     * 
	     * 
	     * Preconditions:
	     * <ul>
	     *   <li> The docker client is connected to a docker server.
	     *   <li> The containerId is the id of a container started on that server.
	     *   <li> commands is not null and all of its items are not null and not empty.
	     *   <li> lastOutput != null 
	     *   <li> failingCommand != null
	     * </ul>
	     * 
	     * Postconditions:
	     * 
	     * <ul>
	     *   <li> The first command was run on the container
	     *   <li> The second command (if there is one) was then run unless the first had an exit code not equal to 0.
	     *   <li> And so on.
	     *   <li> failingCommand code is set to the number of successfully executed commands (i.e. commands with exitCode != 0).
	     *   <li> lastOutput has had the output of the last command (successful or not) to run appended to it.
	     *   <li> the result is the exit code of the last command to run
	     * </ul>
	     * 
	     * Thus all commands ran successfully iff result 0.  (Equivalently all commands ran successfully
	     * iff the value of failingCommand is the length of commands.)
	     * 
	     * And if the result is not 0, then the index of the command that failed is
	     * the value of failingCommand.
	     * 
	     * 
	     * @param docker -- a docker client
	     * @param containerId -- a container on that client
	     * @param commands -- an array of commands to execute @see{runCommand}
	     * @param lastOutput -- a StringBuffer to receive the output of the last command to run.
	     * @param failingCommand -- an AtomicInteger to receive the numer of commands run successfully.
	     * @return the exit code of the last command to run
	     * @throws DockerException
	     * @throws InterruptedException
	     */
	    private static int runCommands(
	            DockerClient docker,
	            String containerId,
	            String[][] commands,
	            StringBuffer lastOutput,
	            AtomicInteger failingCommand)
	    throws DockerException, InterruptedException {
	        StringBuffer outBuf = null;
	        int exitCode  = 0;
	        int count  ;
	        for( count = 0 ; count < commands.length; ++count ) {
	            outBuf = new StringBuffer() ;
	            exitCode = runCommand( docker, containerId, commands[count], outBuf ) ; 
	            System.out.println( "==> Exit code is " + exitCode ) ;
	            System.out.println( "==> Output is: '" +outBuf.toString()+ "'" ) ;
	            if( exitCode != 0 ) break ;
	        }
	        lastOutput.append( outBuf.toString() ) ;
	        failingCommand.set( count ); 
	        return exitCode ;
	    }
	 
	    /** Run one command in a docker container.
	     * 
	     * Preconditions:
	     * <ul>
	     *   <li> The docker client is connected to a docker server.
	     *   <li> The containerId is the id of a container started on that server.
	     *   <li> command is not null and not empty.
	     *   <li> output != null 
	     * </ul>
	     * 
	     * The command is an nonempty array of strings.  The first item is the name of the command
	     * and must be on the PATH.  The remaining items are the arguments to the command.
	     * 
	     * No shell intervenes, so there is no redirection of stdin, stdout, and stderr.
	     * And shell built-ins like "cd" can not be commands.
	     * 
	     * Postconditions:
	     * 
	     * <ul>
	     *   <li> An attempt has been made to run the command.
	     *   <li> If no exception is thrown the result is the exit code of the command
	     *        and the output of the command has been appended to the output StringBuffer.
	     * </ul>
	     * 
	     * Note the output of the command is a mixture of the standard output and the standard
	     * error streams.
	     * 
	     * @param docker
	     * @param containerId
	     * @param command
	     * @param output
	     * @return
	     * @throws DockerException
	     * @throws InterruptedException
	     */
	    private static int runCommand(
	            DockerClient docker, String containerId,
	            String[] command,
	            StringBuffer output )
	    throws DockerException, InterruptedException {
	        System.out.print( "========> Running Commands: " ) ;
	        for( String str : command ) System.out.print( str + " ") ;
	        System.out.println() ;
	         
	        ExecCreation execCreation ;
	        ExecCreateParam [] execParams = {
	                ExecCreateParam.attachStdout(true),
	                ExecCreateParam.attachStderr(true)
	        };
	         
	        execCreation = docker.execCreate(containerId, command, execParams ) ;
	        System.out.println( "execution created: " + execCreation) ;
	         
	        LogStream logStream = docker.execStart(execCreation.id()  ) ;
	        System.out.println( "execution started: " + execCreation) ;
	         
	        ExecState state0 = docker.execInspect(execCreation.id());
	        System.out.println( "execution inspected: " + execCreation) ;
	        System.out.println( "execution running: " + state0.running() ) ;
	 
	         
	        listContainers(docker) ;
	         
	        // The next line forces this process to wait until 
	        // the docker container has finished executing.
	        
	        System.out.println( "Starting to streamContentsStr !!");
	        String streamContentsStr = logStream.readFully() ;
	 
	        ExecState state1 = docker.execInspect(execCreation.id());
	         
	        System.out.println( "execution inspected: " + execCreation) ;
	        System.out.println( "execution running: " + state1.running() ) ; 
	        
	        System.out.println( "execution exitCode: " + state1.exitCode() ) ;
	 
	        output.append( streamContentsStr ) ;
	        return state1.exitCode() ;
	    }
	 
	     
	    private static void listContainers( DockerClient docker ) throws DockerException, InterruptedException {
	        System.out.println( "Listing Containers" ) ;
	        final List<Container> containers = docker.listContainers() ;
	        System.out.println( "" + containers.size() + " containers ") ;
	        for( Container c : containers ) {
	            System.out.println( "ID : " + c.id() ) ;
	            System.out.println( "Image : " + c.image() ) ;
	        }
	        
	        System.out.println( "========> listContainers is done !!"); 
	    }
	 
	    private static String getHostPath(String name ) throws IOException {
	        File cwd = new File(".") ;
	        if( ! cwd.exists() ) throw new IOException("No . directory!!!") ;
	        File hostDir = new File(cwd, name ) ;
	        if( ! hostDir.exists() ) {
	            boolean ok = hostDir.mkdir() ;
	            if( !ok ) throw new IOException( "Couldn't make ./" + name + " directory" ) ;
	        }
	         
	        return hostDir.getCanonicalPath() ;
	    }
}
