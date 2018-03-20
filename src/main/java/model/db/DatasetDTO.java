/**
 * 
 */
package model.db;

import java.util.ArrayList;

/**
 * @author  acilA POJO Class
 */
public abstract class DatasetDTO extends FolderDTO{

	private String evaluationDescription;
	private ArrayList<String> datasetImageList;
	protected String xYLabelSheetName;
	protected String benchmarkDatasetName;
	/**
	 * @return the xYLabelSheetName
	 */
	public String getxYLabelSheetName() {
		return xYLabelSheetName;
	}

	/**
	 * @param xYLabelSheetName the xYLabelSheetName to set
	 */
	public void setxYLabelSheetName(String xYLabelSheetName) {
		this.xYLabelSheetName = xYLabelSheetName;
	}
	public DatasetDTO()
	{
		// Just for enabling creating objects without any mandatory parameters
	}
	public DatasetDTO(String folderName) {
		super(folderName);
		// TODO Auto-generated constructor stub
	}
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
	/**
	 * @return the datasetImageList
	 */
	public ArrayList<String> getDatasetImageList() {
		return datasetImageList;
	}
	/**
	 * @param datasetImageList the datasetImageList to set
	 */
	public void setDatasetImageList(ArrayList<String> datasetImageList) {
		this.datasetImageList = datasetImageList;
	}

	/**
	 * @return the benchmarkDatasetNAME
	 */
	protected String getBenchmarkDatasetNAME() {
		return benchmarkDatasetName;
	}

	/**
	 * @param benchmarkDatasetNAME the benchmarkDatasetNAME to set
	 */
	protected void setBenchmarkDatasetNAME(String benchmarkDatasetNAME) {
		benchmarkDatasetNAME = benchmarkDatasetNAME;
	}
	
}
