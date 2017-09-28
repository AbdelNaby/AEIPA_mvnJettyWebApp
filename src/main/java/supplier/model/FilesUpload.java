/**
 * 
 */
package supplier.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.fileupload.FileItem;

/**
 * @author acil
 *
 */
public class FilesUpload {
	
	
	private String uploadFilePath;
	private List<String> uploadedFilesNames;
//	listStrings.add("One");
//	listStrings.add("Two");
//	listStrings.add("Three");
//	listStrings.add("Four");
//	System.out.println(listStrings);
	

	
	public String getUploadFilePath() {
		return uploadFilePath;
	}


	public void setUploadFilePath(String uploadFilePath) {
		this.uploadFilePath = uploadFilePath;
	}


	public FilesUpload(String uploadFilePath, List<FileItem> multifiles) {
		// TODO Auto-generated method stub
		this.uploadFilePath = uploadFilePath;
		setUploadedFilesNames(new ArrayList<String>());
		for(FileItem item:multifiles)
		{
			FileUpload(item);				 
		}
			
	}
	
	protected void FileUpload(FileItem item)  {
		// TODO Auto-generated method stub

		try {
			

			item.write(new File(getUploadFilePath() + item.getName()));
			System.out.println("Done Uploading File .. " + item.getName());	
			getUploadedFilesNames().add(item.getName());

		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("Failed due to .. ");
			System.out.println( "Interrupted exception " + e.getMessage() ) ;
            e.printStackTrace(System.out);
            e.printStackTrace();
			
			
		}
	}


	public List<String> getUploadedFilesNames() {
		return uploadedFilesNames;
	}


	private void setUploadedFilesNames(List<String> uploadedFilesNames) {
		this.uploadedFilesNames = uploadedFilesNames;
	}
	

}
