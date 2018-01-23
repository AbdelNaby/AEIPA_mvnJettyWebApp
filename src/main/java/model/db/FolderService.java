/**
 * 
 */
package model.db;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

/**
 * @author acil
 *
 */
public abstract class FolderService<T extends FolderDTO> extends GenericService<T>{
	protected T dto;
	/**
	 * @param dto
	 */

	public FolderService(T dto) {
		super(dto);
		this.dto = dto;
		//dto.getFullPath();
	}
	public FolderService() 	{
		// Just for enabling creating objects without any mandatory parameters
	}
	/**
	 * Upload files code is here
	 */
	/**
	 * 
	 * Uploading multiple files to a specific folder path
	 * @param uploadFilePath is the folder path that
	 * will contain all the uploaded files
	 * @param multifiles the files to be uploaded
	 */
	public void filesUpload(List<FileItem> multifiles) {
		//this.folderPath = folderPath;
		//setUploadedFilesNames(new ArrayList<String>());
		for(FileItem item:multifiles)
		{
			oneFileUpload(item);				 
		}
	}
	
	protected void oneFileUpload(FileItem item)  {
		try {
			item.write(new File(dto.getFullPath() + item.getName()));
			System.out.println("Done Uploading File .. "+ dto.getFullPath() + item.getName());	
			dto.setFilesNameList(item.getName());
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("Uploading ... Failed due to .. ");
			System.out.println( "Interrupted exception " + e.getMessage() ) ;
            e.printStackTrace(System.out);
            e.printStackTrace();
		}
	}
	// Not to be supported currently but the design is opened for adding this feature
	
	protected boolean renameFolder(String oldFolderPath, String newFolderName) {
	    File dir = new File(oldFolderPath);
	    if (!dir.isDirectory()) {
	      System.err.println("There is no directory @ given path");
	      return false;
	    }
	    File newDir = new File(dir.getParent() + "/" + newFolderName);
	    dir.renameTo(newDir);
	    System.out.println("Done renaming the folder to " + newFolderName);
	    return true;
	  }
	protected boolean deleteFolder(String folderPath) {
	    File dir = new File(folderPath);
	    if (!dir.isDirectory()) {
	      System.err.println("There is no directory @ given path");
	      return false;
	    }
	    dir.delete();
	    System.out.println("Done renaming the folder to " + folderPath);
	    return true;
	  }

	/**
	 * @return the uploadedFilesNames List
	 */
	public ArrayList<String> getUploadedFilesNames() {
		return dto.getFilesNameList();
	}
	public boolean validateData()
	{	
		if (name_IsValid()
				&& validateDatabyType())
			return true;
		return false;
	}
	protected abstract boolean validateDatabyType();
	
	public boolean name_IsValid()
	{
		IPADAO iPADAO= new IPADAO();
		String iPAName = dto.getName();
		//Checking Name has value
		if(iPAName.isEmpty())
		{
			System.out.println("IPA Name is mandatory. Please enter a value.");
			return false;
		}
		//Checking Name is unique
		if(iPADAO.display(iPADAO.getAttributeList().get(2), "=", iPAName) != null)
		{
			System.out.println("IPA Name: " + iPAName + " already exists, Please enter another name.");
			return false;
		}
		return true;
	}


//	{
//		validateData();
//		fillinData();
//		uploadFilestoServer();
//		SaveDatatoDB();
//		
//	}
}
