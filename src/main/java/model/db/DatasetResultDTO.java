/**
 * 
 */
package model.db;

/**
 * @author acil
 *
 */
public class DatasetResultDTO extends DatasetDTO {

	/**
	 * 
	 */
	public DatasetResultDTO() {
		// Just for enabling creating objects without any mandatory parameters
	}

	/**
	 * @param folderName
	 */
	public DatasetResultDTO(String folderName) {
		super(folderName);
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
