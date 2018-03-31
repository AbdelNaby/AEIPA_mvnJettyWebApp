/**
 * 
 */
package model.db;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.exceptions.DockerException;

/**
 * @author acil
 *
 */
public class IPADockerExecute_Java extends IPADockerExecute {

	/**
	 * 
	 */
	public IPADockerExecute_Java() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.IPAExecute#executeIPA(model.db.IPADTO,
	 * model.db.DatasetContainerDTO)
	 */
	@Override
	public boolean executeIPA(IPADTO iPADTO, DatasetContainerDTO datasetContainerDTO, String userName) {
		if (iPADTO.getType() == "Detection") {
			// iPA type is known now, here we should define the evaluation type
		}
		for (int i = 0; i < datasetContainerDTO.getInputSequenceDatasetDTOList().size(); i++) {
			InputDTO inputDatasetDTO = datasetContainerDTO.getInputSequenceDatasetDTOList().get(i);
			GroundTruthDTO groundTruthDTO = datasetContainerDTO.getGroundTruthSequenceDatasetDTOList().get(i);
			DatasetService datasetService = new DatasetService();
			ResultDTO resultDTO = new ResultDTO(iPADTO, inputDatasetDTO, userName);
			
			System.out.println("+++++ ");
			System.out.println("+++++ ");
			System.out.println("+++++ ");
			System.out.println("+++++ ");
			if (!alreadyExecuted(resultDTO, datasetContainerDTO)) {
				if (datasetService.createNew(resultDTO)) {
					System.out.println("The Result Dataset has been created successfully...");

					try {
						createJavaContainer(iPADTO, inputDatasetDTO, resultDTO, groundTruthDTO);
					} catch (DockerException | InterruptedException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					datasetContainerDTO.addToResultDTOList(resultDTO);

				} else {
					System.out.println("The Result Dataset has NOT been created...");
				}
			} else {
				System.out.println("+++++ ");
				System.out.println("+++++ ");
				System.out.println("+++++ Theis Result Dataset been executed Before : " + resultDTO.getName());
				System.out.println("+++++ ");
			}
		}
		return true;
	}

	private boolean alreadyExecuted(ResultDTO resultDTO, DatasetContainerDTO datasetContainerDTO) {
		for (int i = 0; i < datasetContainerDTO.getResultSequenceDatasettDTOList().size(); i++) {
			System.out.println("+++++ Theis Result Dataset been executed Before : " + resultDTO.getName());
			System.out.println("+++++ Theis Result Dataset been executed Before : " + datasetContainerDTO.getResultSequenceDatasettDTOList().get(i).getName());
			System.out.println("+++++ "+ datasetContainerDTO.getResultSequenceDatasettDTOList().size());
			if (resultDTO.getName().equalsIgnoreCase(datasetContainerDTO.getResultSequenceDatasettDTOList().get(i).getName())) {
				// The result Dataset exists and has already been executed
				System.out.println("+++++ ");
				System.out.println("+++++ ");
				System.out.println("+++++ Theis Result Dataset been executed Before : " + resultDTO.getName());
				System.out.println("+++++ Theis Result Dataset been executed Before : " + datasetContainerDTO.getResultSequenceDatasettDTOList().get(i).getName());
				
				System.out.println("+++++ ");
				return true;
			}
		}
		return false;
	}

	// A container per each Dataset Sequence execution

	private void createJavaContainer(IPADTO iPADTO, InputDTO inputDatasetDTO, ResultDTO resultDTO, GroundTruthDTO groundTruthDTO)
			throws DockerException, InterruptedException, IOException {
		String mainFileFullPath = iPADTO.getFullPath() + iPADTO.getMainFileName();
		System.out.println("Hello from create DockerClient");
		DockerClient docker = new DefaultDockerClient("unix:///var/run/docker.sock");

		System.out.println("Pinging");
		String pingResult = docker.ping();
		System.out.println("Ping result " + pingResult);

		String dockerImageName = "dc1:8";
		DatasetService datasetService = new DatasetService();
		String resultFolder = resultDTO.getFullPath();
		String iPAGuestPath = iPADTO.getFullPath();
		String inputDatasetGuestPath = inputDatasetDTO.getFullPath();
		String resultGuestPath = resultFolder;
		// Host is my machine and the path from IPADTO.getFullPath()
		String iPAHostPath = getHostPath(iPADTO.getFullPath());
		String inputDatasetHostPath = getHostPath(inputDatasetDTO.getFullPath());
		String resultHostPath = getHostPath(resultFolder);
		System.out.println("");
		System.out.println("");
		System.out.println("Working directory is " + iPAHostPath + " on the host system.");
		System.out.println("Working directory is " + iPAHostPath + " on the host system.");

		String containerId = startContainer(docker, dockerImageName, iPAGuestPath, iPAHostPath, inputDatasetGuestPath,
				inputDatasetHostPath, resultGuestPath, resultHostPath);
		System.out.println("$$$$$$$**** ");
		System.out.println("$$$$$$$**** ");
		ArrayList<String> inputDatasetFiles = datasetService.getFilesNameList(inputDatasetDTO);
		System.out.println("$$$$$$$**** " + inputDatasetFiles.size());
		System.out.println("$$$$$$$**** ");
		// Providing the input files as Java arguments as whole
		for (int i = 0; i < inputDatasetFiles.size(); i++) {
			String currentFileName = inputDatasetFiles.get(i);
			System.out.println("$$$$$$$**** ");
			System.out.println("$$$$$$$**** ");
			System.out.println("$$$$$$$**** " + inputDatasetDTO.getFullPath());
			// javaWithArgument[i + 2] = inputDatasetDTO.getFullPath() +
			// inputDatasetFiles.get(i);

			System.out.println(
					"****####### resultFolder file*** to be created" + resultFolder + inputDatasetFiles.get(i));

			// System.out.println("**** javaWithArgument are: " + javaWithArgument);
			
			String[][] commands = new String[][] { new String[] { "ls", "-l" },
					new String[] { "javac", mainFileFullPath + ".java" },
					new String[] { "java", iPADTO.getMainFileName(),
							inputDatasetDTO.getFullPath() + inputDatasetFiles.get(i),
							resultFolder + currentFileName }
					// allDatasetFilesAarguments},
					// new String[] {"java", iPADTO.getMainFileName() , "TestooOoo"},
					, new String[] { "ls", "-l" } };

			StringBuffer lastOutput = new StringBuffer();
			AtomicInteger successCount = new AtomicInteger(0);
			int lastExitCode = runCommands(docker, containerId, commands, lastOutput, successCount);

			System.out.println("Number of commands run successfully is " + successCount);
			System.out.println("Last exit code is " + lastExitCode);
			System.out.println("Last output is: '" + lastOutput.toString() + "'");
			System.out.println("****resultFolder + inputDatasetFiles.get(i)*** has been created" + resultFolder
					+ currentFileName);
			
			Evaluation_Algo_ImgDiffPercent evaluation_Algo_ImgDiffPercent = new Evaluation_Algo_ImgDiffPercent();
			evaluation_Algo_ImgDiffPercent.evaluate(resultFolder+ currentFileName, groundTruthDTO.getFullPath() + currentFileName);
		}
		listContainers(docker);

		docker.stopContainer(containerId, 5);
		System.out.println("Stopped container " + containerId);

		listContainers(docker);

		System.out.println("Bye");

	}

}
