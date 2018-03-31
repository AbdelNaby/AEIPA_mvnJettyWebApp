/**
 * 
 */
package model.db;

/**
 * @author acil
 *
 */
public class ResultDTO extends DatasetDTO implements DataDTO{
	
	
	// to be used locally for the result child objects
	
	protected ResultDTO() {
		super();
	}
	protected ResultDTO(String folderName) {
		super (folderName);	
		this.setDatasetName("RESULT" +"_"+ folderName);
	}
	/**
	 * @param algoDTO
	 * @param inputDTO
	 * @param resultType
	 */
	public ResultDTO(AlgorithmDTO algoDTO, InputDTO inputDTO , String userName) {
		super(inputDTO.getName() +"_"+ algoDTO.getName(), inputDTO.getDatasetName(), userName);
		//super(inputDTO.getName() +"_"+ algoDTO.getName());
		//this.setDatasetName(datasetName);
		this.setResultType(inputDTO.getResultType());
	
		
		// TODO Auto-generated constructor stub
	}

	public ResultDTO(String folderName, String datasetName, String userName) {
		super(folderName, datasetName, userName);
	}
	/* (non-Javadoc)
	 * @see model.db.DataDTO#datasetSubType()
	 */
	@Override
	protected String datasetSubType() {
		// TODO Auto-generated method stub
		return "RESULT";
	}
}
