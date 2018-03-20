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
	public String userName;
	public String name;
	private ArrayList<String> filesNameList = new ArrayList<String>();
	public String 	type;
	private String defaultPath;
	private String fullPath;
	public String description;

	FolderDTO()
	{
		// Just for enabling creating objects without any mandatory parameters
		setDefaultPath();
		setType();
		setFullPath();
	}
	FolderDTO(String folderName)
	{
		//Dataset/IPA/EvaluationDatase/Resultset/Report
		//Basic folder path is static, only the folder name and files type are needed
		setDefaultPath();
		setName(folderName);
		setType();
		this.setFullPath();
	}
	/**
	 * @return the defaultPath
	 */
	private String getDefaultPath() {
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
	public void setName(String name) {
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
	protected void setFullPath() {
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
	/**
	 * @return the filesNameList
	 */
	public ArrayList<String> getFilesNameList() {
		return filesNameList;
	}
	/**
	 * @param filesNameList the filesNameList to set
	 */
	public void setFilesNameList(String newFileNametobeAdded) {
		this.filesNameList.add(newFileNametobeAdded);
	}

}
