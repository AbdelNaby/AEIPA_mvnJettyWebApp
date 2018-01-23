/**
 * 
 */
package model.db;

/**
 * @author acil
 *
 */
public class ResultDatasetDTO extends DatasetDTO {

	/**
	 * 
	 */
	public ResultDatasetDTO() {
		// Just for enabling creating objects without any mandatory parameters
	}

	/**
	 * @param folderName
	 */
	public ResultDatasetDTO(String folderName) {
		super(folderName);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see model.db.DatasetDTO#datasetSubType()
	 */
	@Override
	protected String datasetSubType() {
		return "ResultDataset/";
	}


}
