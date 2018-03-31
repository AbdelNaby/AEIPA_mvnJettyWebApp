/**
 * 
 */
package model.db;

/**
 * @author acil
 *
 */
public class InputDTO extends DatasetDTO implements DataDTO{

	protected InputDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param folderName
	 */
	public InputDTO(String folderName, String datasetName, String userName) {
		super (folderName, datasetName, userName);
		
		//this.setDatasetName("INPUT" +"_"+ folderName);
	}

	/* (non-Javadoc)
	 * @see model.db.Data#datasetSubType()
	 */
	@Override
	protected String datasetSubType() {
		// TODO Auto-generated method stub
		return "INPUT";
	}

}
