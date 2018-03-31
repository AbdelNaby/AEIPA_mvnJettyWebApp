/**
 * 
 */
package model.db;

/**
 * @author acil
 *
 */
public class OLD_GroundTruthDatasetDTO123 extends OLD_DatasetDTO123 {

	/**
	 * 
	 */
	public OLD_GroundTruthDatasetDTO123() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param folderName
	 */
	public OLD_GroundTruthDatasetDTO123(String folderName) {
		super(folderName);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see model.db.DatasetDTO#datasetSubType()
	 */
	@Override
	protected String datasetSubType() {
		// TODO Auto-generated method stub
		return "GroundTruth";
	}

}
