/**
 * 
 */
package model.db;

import java.io.File;
import java.util.ArrayList;

/**
 * @author acil
 *
 */
public abstract class  BenchmarkDatasetDTO extends DatasetDTO {

	private ArrayList<String> resultFolderNameList = new ArrayList<String>();
//	private ArrayList<DatasetResultDTO> datasetResultDTO = new ArrayList<DatasetResultDTO>();
	public BenchmarkDatasetDTO()
	{
		// Just for enabling creating objects without any mandatory parameters
	}
	public BenchmarkDatasetDTO(String folderName) {
		super(folderName);
	}
	// As the IPA Name and the input dataset name are unique, the result folder name will be unique
	public String createResultFolder(String IPAName, String inputDatasetName) {
		String resultFolder = this.getFullPath()+IPAName+"_"+inputDatasetName+"/";
		File file = new File(resultFolder);
        if (!file.exists()) {
            if (file.mkdirs()) {
                System.out.println("Directory is created! " + file.getAbsolutePath());
				return resultFolder;
            } else {
                System.out.println("Failed to create directory! "  + file.getAbsolutePath());
				return null;
            }
        }
		return resultFolder;	
	}

	@Override
	protected String datasetSubType() {
		return "BenchmarkDtataset/" + benchmarkDatasetSubType();
	}
	protected abstract String benchmarkDatasetSubType();
	/**
	 * @return the resultFolderNameList
	 */
	public ArrayList<String> getResultFolderNameList() {
		File folder = new File(this.getFullPath());
		File[] listOfFiles = folder.listFiles();
		//ArrayList<String> allFilesList = new ArrayList<String>();
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isDirectory()) {
		    	  resultFolderNameList.add(listOfFiles[i].getName());
		    	  System.out.println("There are directories inside the folder: Directory: " + listOfFiles[i].getName());
		      }
		    }
		return resultFolderNameList;
	}
	/**
	 * No need for this now
	 * @param resultFolderNameList the resultFolderNameList to set
	 */
	private void setResultFolderNameList(ArrayList<String> resultFolderNameList) {
		this.resultFolderNameList = resultFolderNameList;
	}
}
