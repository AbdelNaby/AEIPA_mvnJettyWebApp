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
public abstract class FolderOLDDDService <T extends FolderDTO> 
	extends GenericService<FolderDTO> {

	private String folderPath;
	private ArrayList<String> uploadedFilesNameList;
	/**
	 * 
	 */
	public FolderOLDDDService(FolderDTO dto) {
		// TODO Auto-generated constructor stub
		super(dto);
	}

	/* (non-Javadoc)
	 * @see model.db.GenericService#dTOMapper(java.util.ArrayList)
	 */
	@Override
	public abstract FolderDTO dTOMapper(ArrayList<String> dTOvaluesList);

	/* (non-Javadoc)
	 * @see model.db.GenericService#dTOMapper(model.db.GenericDTO)
	 */
	@Override
	public ArrayList<String> dTOMapper(FolderDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 
	 * Uploading multiple files to a specific folder path
	 * @param uploadFilePath is the folder path that
	 * will contain all the uploaded files
	 * @param multifiles the files to be uploaded
	 */
	public ArrayList<String> filesUpload(String folderPath, List<FileItem> multifiles) {
		this.folderPath = folderPath;
		setUploadedFilesNames(new ArrayList<String>());
		for(FileItem item:multifiles)
		{
			oneFileUpload(item);				 
		}
		return uploadedFilesNameList;
	}
	
	protected void oneFileUpload(FileItem item)  {
		try {
			item.write(new File(folderPath + item.getName()));
			System.out.println("Done Uploading File .. " + item.getName());	
			uploadedFilesNameList.add(item.getName());
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("Uploading ... Failed due to .. ");
			System.out.println( "Interrupted exception " + e.getMessage() ) ;
            e.printStackTrace(System.out);
            e.printStackTrace();
		}
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

	/**
	 * @return the uploadedFilesNames
	 */
	public ArrayList<String> getUploadedFilesNames() {
		return uploadedFilesNameList;
	}

	/**
	 * @param uploadedFilesNames the uploadedFilesNames to set
	 */
	protected void setUploadedFilesNames(ArrayList<String> uploadedFilesNameList) {
		this.uploadedFilesNameList = uploadedFilesNameList;
	}

	public abstract boolean add();
	public abstract boolean update(FolderDTO newFolderDTO );
	public abstract boolean delete();
}
