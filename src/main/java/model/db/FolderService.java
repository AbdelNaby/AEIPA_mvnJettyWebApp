/**
 * 
 */
package model.db;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

import com.google.common.io.Files;

/**
 * @author acil
 *
 */
public abstract class FolderService<T extends FolderDTO> extends GenericService<T>{
//	protected T dto;
	/**
	 * @param dto
	 */

//	public FolderService(T dto) {
//		super(dto);
//		this.dto = dto;
//		//dto.getFullPath();
//	}
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
	public void uploadFiles(List<FileItem> multifiles, T dto) {
		//this.folderPath = folderPath;
		//setUploadedFilesNames(new ArrayList<String>());
		System.out.println("hello !!!");
//		for(int i=1;i<multifiles.size(); i++)
//		{
//			System.out.println("hellozz !!!");
//			FileItem item = multifiles.get(i);
//			oneFileUpload(item, dto);
//		}
		for(FileItem item:multifiles)
		{
			System.out.println("hellozz !!!");
			oneFileUpload(item, dto);				 
		}
	}
	
	protected void oneFileUpload(FileItem item, T dto)  {
		System.out.println("hellozz test !!!");
		try {
			item.write(new File(dto.getFullPath() + item.getName()));
			System.out.println("Have Done Uploading File .. "+ dto.getFullPath() + item.getName());	
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
	public ArrayList<String> getUploadedFilesNames(T dto) {
		return dto.getFilesNameList();
	}
	
	
	
	public boolean validateData(T dto)
	{	
		if (name_IsValid(dto.getName()) && type_IsValid(dto.getType())
				&& validateDatabyType(dto))
			return true;
		return false;
	}
	protected abstract boolean validateDatabyType(T dto);
	
	public boolean name_IsValid(String folderName)
	{
		//Checking Name has value
		if(folderName.isEmpty())
		{
			System.out.println("folder Name is mandatory. Please enter a value.");
			return false;
		}
		return true;
	}
	public boolean type_IsValid(String type)
	{
		//Checking Name has value
		if(type.isEmpty())
		{
			System.out.println("Type is mandatory. Please enter a value.");
			return false;
		}
		return true;
	}
	protected boolean createDirectory(String fullPath)
	{
		  File file = new File(fullPath);
	        if (!file.exists()) {
	            if (file.mkdirs()) {
	                System.out.println("Directory is created! " + file.getAbsolutePath());
					return true;
	            } else {
	                System.out.println("Failed to create directory! "  + file.getAbsolutePath());
					return false;
	            }
	        }
		
//		Path path = Paths.get(fullPath);
//        //if directory exists?
//        if (!Files.exists(path)) {
//            try {
//                Files.createDirectories(path);
//            } catch (IOException e) {
//                //fail to create directory
//                e.printStackTrace();
//            }
//        }
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
