/**
 * 
 */
package model.db;

/**
 * @author acil
 *
 */
public class InputDatasetDTO extends DatasetDTO {
	// Every input dataset has a benchmark dataset	
	public BenchmarkDatasetDTO benchmarkDataset ;
	
	InputDatasetDTO(String folderName, BenchmarkDatasetDTO benchmarkDataset) {
		super(folderName);
		this.benchmarkDataset = benchmarkDataset ;
		// Example:
		//BenchmarkDatasetDTO_GroundTruth gt = (BenchmarkDatasetDTO_GroundTruth)benchmarkDataset;
		
	}

	public InputDatasetDTO()
	{
		// Just for enabling creating objects without any mandatory parameters
	}

	@Override
	protected String datasetSubType() {
		return "InputDataset";
	}
}
