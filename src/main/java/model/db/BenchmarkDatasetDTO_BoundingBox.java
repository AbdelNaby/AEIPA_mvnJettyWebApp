/**
 * 
 */
package model.db;

/**
 * @author acil
 *
 */
public class BenchmarkDatasetDTO_BoundingBox extends BenchmarkDatasetDTO {

	public BenchmarkDatasetDTO_BoundingBox()
	{
		// Just for enabling creating objects without any mandatory parameters
		
	}
	/**
	 * @param folderName
	 */
	public BenchmarkDatasetDTO_BoundingBox(String folderName) {
		super(folderName);
	}

	/* (non-Javadoc)
	 * @see model.db.EvaluationDtatasetDTO#evaluationDtatasetSubType()
	 */
	@Override
	protected String benchmarkDatasetSubType() {
		return "BoundingBox";
	}

}
