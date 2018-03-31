/**
 * 
 */
package model.db;

/**
 * @author acil
 * @param <T>
 *
 */
public class GroundTruthDTO extends ResultDTO implements DataDTO {

	protected GroundTruthDTO() {
		super();
	}
	/**
	 * 
	 */
	public GroundTruthDTO(String folderName, String datasetName, String userName) {
		super (folderName, datasetName, userName);
		//super ("GROUNDTRUTH" +"_"+ folderName, folderName );
	}
	
	/* (non-Javadoc)
	 * @see model.db.DataDTO#datasetSubType()
	 */
	@Override
	protected String datasetSubType() {
		// TODO Auto-generated method stub
		return "GROUNDTRUTH";
	}
}
