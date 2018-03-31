/**
 * 
 */
package model.db;

/**
 * @author acil
 *
 */
public class OLD_ResultDatasetDTO extends DatasetDTO {

	String resultDatasetFolderPath;
	public OLD_ResultDatasetDTO()
	{
		//This constructor is for retrieving object from the database
	}
	/**
	 * @param iPADTO
	 * @param inputDatasetDTO
	 */
	public OLD_ResultDatasetDTO(IPADTO iPADTO, OLD_InputDatasetDTO inputDatasetDTO) {
		this.name = iPADTO.getName() + "_" + inputDatasetDTO.getName();
		resultDatasetFolderPath = inputDatasetDTO.type+"/" + inputDatasetDTO.getName() +"/";
		//inputDatasetDTO.resultDatasetDTO.add(this);
	}

	/* (non-Javadoc)
	 * @see model.db.DatasetDTO#datasetSubType()
	 */
	@Override
	protected String datasetSubType() {
		// TODO Auto-generated method stub
		return resultDatasetFolderPath + resultdatasetSubType() ;
	}
	protected String resultdatasetSubType() {
		// TODO Auto-generated method stub
		return "ResultDataset";
	}
}
