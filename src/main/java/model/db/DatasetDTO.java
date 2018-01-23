/**
 * 
 */
package model.db;

/**
 * @author  acilA POJO Class
 */
public abstract class DatasetDTO extends FolderDTO{

	
	public DatasetDTO()
	{
		// Just for enabling creating objects without any mandatory parameters
	}
	public DatasetDTO(String folderName) {
		super(folderName);
		// TODO Auto-generated constructor stub
	}

	private String evaluationDescription;
	/**
	 * @return the evaluationDescription
	 */
	public String getEvaluationDescription() {
		return evaluationDescription;
	}

	/**
	 * @param evaluationDescription the evaluationDescription to set
	 */
	public void setEvaluationDescription(String evaluationDescription) {
		this.evaluationDescription = evaluationDescription;
	}
	
	/**
	 * To set the Type of the folder
	 */
	@Override
	public void setType() {
		// An Inputdataset under the Dataset type
		type = "Dataset/"+ datasetSubType();
	}
	protected abstract String datasetSubType();
	
}
