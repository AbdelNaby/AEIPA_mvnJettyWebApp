/**
 * 
 */
package model.db;

/**
 * @author acil
 *
 */
public class OLD_DatasetResultDTO extends OLD_DatasetDTO {

	/**
	 * 
	 */
	public OLD_DatasetResultDTO() {
		// Just for enabling creating objects without any mandatory parameters
	}

	/**
	 * @param folderName
	 */
	public OLD_DatasetResultDTO(String folderName) {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see model.db.DatasetDTO#datasetSubType()
	 */
	@Override
	protected String datasetSubType() {
		return "DatasetResult";
	}


}
