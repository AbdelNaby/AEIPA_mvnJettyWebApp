/**
 * 
 */
package model.db;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import java.util.*;
import org.apache.commons.fileupload.*;

/**
 * @author acil
 *
 */
public class UploadFileService extends GenericService {

	private String uploadFilePath;
	private ArrayList<String> uploadedFilesNames;
	/**
	 * 
	 * Uploading multiple files to a specific folder path
	 * @param uploadFilePath is the folder path that
	 * will contain all the uploaded files
	 * @param multifiles the files to be uploaded
	 */
	public void UploadFileService(String uploadFilePath, List<FileItem> multifiles) {
		this.uploadFilePath = uploadFilePath;
		setUploadedFilesNames(new ArrayList<String>());
		for(FileItem item:multifiles)
		{
			FileUpload(item);				 
		}		
	}
	
	protected void FileUpload(FileItem item)  {
		try {
			item.write(new File(getUploadFilePath() + item.getName()));
			System.out.println("Done Uploading File .. " + item.getName());	
			uploadedFilesNames.add(item.getName());
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("Uploading ... Failed due to .. ");
			System.out.println( "Interrupted exception " + e.getMessage() ) ;
            e.printStackTrace(System.out);
            e.printStackTrace();
		}
	}
	/**
	 * @return the uploadFilePath
	 */
	public String getUploadFilePath() {
		return uploadFilePath;
	}
	/**
	 * @param uploadFilePath the uploadFilePath to set
	 */
	public void setUploadFilePath(String uploadFilePath) {
		this.uploadFilePath = uploadFilePath;
	}
	/**
	 * @return the uploadedFilesNames
	 */
	public List<String> getUploadedFilesNames() {
		return uploadedFilesNames;
	}
	/**
	 * @param uploadedFilesNames the uploadedFilesNames to set
	 */
	private void setUploadedFilesNames(ArrayList<String> uploadedFilesNames) {
		this.uploadedFilesNames = uploadedFilesNames;
	}
	
	public boolean renameFolder(String oldFolderPath, String newFolderName) {
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

	@Override
	protected GenericDTO dTOMapper(ArrayList dTOvaluesList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ArrayList dTOMapper(GenericDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
