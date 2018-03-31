/**
 * 
 */
package model.db;

/**
 * @author acil
 *
 */
public abstract class OLD_DataDTO extends FolderDTO {



	public OLD_DataDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param folderName
	 */
	public OLD_DataDTO(String folderName) {
		super(folderName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * To set the Type of the folder
	 */
	@Override
	public void setType() {
		// An Inputdataset under the Dataset type
		type = "DATA/"+ datasetSubType();
	}
	protected abstract String datasetSubType();

}
