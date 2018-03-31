/**
 * 
 */
package model.db;

import java.util.ArrayList;

/**
 * @author acil
 *
 */

public abstract class FolderDTO extends GenericDTO {
	protected String userName;
	protected String name;
	protected ArrayList<String> filesNameList = new ArrayList<String>();
	protected String 	type;
	protected String defaultPath;
	protected String fullPath;
	protected String description;

	protected FolderDTO()
	{
		// Just for enabling creating objects without any mandatory parameters
		init();
	}
	public FolderDTO(String folderName)
	{
		//Dataset/IPA/EvaluationDatase/Resultset/Report
		//Basic folder path is static, only the folder name and files type are needed
		
		this.setName(folderName);
		init();
	}
	/**
	 * This method is for initializing the DefaultPath, Type, and FullPath
	 */
	protected void init()
	{
		this.setDefaultPath();
		this.setType();
		this.setFullPath();
	}
	/**
	 * @return the defaultPath
	 */
	protected String getDefaultPath() {
		return defaultPath;
	}
	/**
	 * @param defaultPath the defaultPath to set
	 */
	private void setDefaultPath() {
		this.defaultPath = "/home/acil/eclipse-workspace/UploadedFiles/";
	}
	/**
	 * To set the Type of the folder
	 */
	public abstract void setType();
	/**
	 * @return the type 
	 * returning the last type in the folders
	 * Used to know the type of an object
	 */

	public String getType()
	{
		// Return the last Type in the Hierarchy
	    System.out.println("Folder Type is: " + type);    
	    String[] paths = type.split("/");
	    System.out.println("Folder Type splitted is: " + paths[paths.length-1]); 
		return paths[paths.length-1];
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	protected void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the fullPath
	 */
	public String getFullPath() {
		return fullPath;
	}
	/**
	 * @param fullPath the fullPath to set
	 */
	public void setFullPath() {
		this.fullPath = defaultPath + type +"/" + name +"/";
		System.out.println("The fullPath is : " + fullPath);
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
//	/**
//	 * @return the setFileNameList
//	 */
//	public String getFileNameList() {
//		return fileNameList;
//	}
//	/**
//	 * @param setFileNameList the setFileNameList to set
//	 */
//	public void setFileNameList(String fileNames) {
//		this.fileNameList = fileNames;
//	}
//	/**
//	 * @return the filesNameList
//	 */
//	public ArrayList<String> getFilesNameList() {
//		File folder = new File(fullPath);
//		File[] listOfFiles = folder.listFiles();
//		ArrayList<String> fillesList = new ArrayList<String>();
//		    for (int i = 0; i < listOfFiles.length; i++) {
//		      if (listOfFiles[i].isFile()) {
//		        System.out.println("List of Files: File: " + listOfFiles[i].getName());
//		        fillesList.add(listOfFiles[i].getName());
//		      } else if (listOfFiles[i].isDirectory()) {
//		        System.out.println("There are directories inside the folder: Directory: " + listOfFiles[i].getName());
//		      }
//		    }
//		return fillesList;
//	}
//	/**
//	 * @return the foldersNameList
//	 */
//	public ArrayList<String> getFoldersNameList() {
//		File folder = new File(fullPath);
//		File[] listOfFolders = folder.listFiles();
//		ArrayList<String> foldersList = new ArrayList<String>();
//		    for (int i = 0; i < listOfFolders.length; i++) {
//		      if (listOfFolders[i].isFile()) {
//		        System.out.println("List of Files: File: " + listOfFolders[i].getName());
//		      } else if (listOfFolders[i].isDirectory()) {
//		        System.out.println("There are directories inside the folder: Directory: " + listOfFolders[i].getName());
//		        foldersList.add(listOfFolders[i].getName());
//		      }
//		    }
//		return foldersList;
//	}
	/**
	 * @param filesNameList the filesNameList to set
	 */
	public void addtoFilesNameList(String newFileNametobeAdded) {
		this.filesNameList.add(newFileNametobeAdded);
	}
	/**
	 * @param filesNameList the filesNameList to set
	 */
	public void setFilesNameList(ArrayList<String> filesNameList) {
		this.filesNameList = filesNameList;
	}


}
