/**
 * 
 */
package model.db;

/**
 * @author acil
 *
 */
public class BenchmarkDatasetDTO_GroundTruth extends BenchmarkDatasetDTO {

	public BenchmarkDatasetDTO_GroundTruth()
	{
		// Just for enabling creating objects without any mandatory parameters
		
	}
	/**
	 * @param folderName
	 */
	public BenchmarkDatasetDTO_GroundTruth(String folderName) {
		super(folderName);
	}

	/* (non-Javadoc)
	 * @see model.db.EvaluationDtatasetDTO#evaluationDtatasetSubType()
	 */
	@Override
	protected String benchmarkDatasetSubType() {
		return "GroundTruth/";
	}

}
