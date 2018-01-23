/**
 * 
 */
package model.db;

/**
 * @author acil
 *
 */
public class BenchmarkDatasetDTO_BoundingBoxLabeled extends BenchmarkDatasetDTO {

	protected String xYLabelSheetName;
	public BenchmarkDatasetDTO_BoundingBoxLabeled()
	{
		// Just for enabling creating objects without any mandatory parameters
		
	}
	/**
	 * @param folderName
	 */
	public BenchmarkDatasetDTO_BoundingBoxLabeled(String folderName, String xYLabelSheetName ) {
		super(folderName);
		setxYLabelSheetName(xYLabelSheetName);
	}

	/* (non-Javadoc)
	 * @see model.db.EvaluationDtatasetDTO#evaluationDtatasetSubType()
	 */
	@Override
	protected String benchmarkDatasetSubType() {
		// TODO Auto-generated method stub
		return "BoundingBoxLabeled/";
	}

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

}
