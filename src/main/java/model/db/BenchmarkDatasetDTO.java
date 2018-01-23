/**
 * 
 */
package model.db;

/**
 * @author acil
 *
 */
public abstract class BenchmarkDatasetDTO extends DatasetDTO {

	public BenchmarkDatasetDTO()
	{
		// Just for enabling creating objects without any mandatory parameters
	}
	public BenchmarkDatasetDTO(String folderName) {
		super(folderName);
	}

	@Override
	protected String datasetSubType() {
		return "BenchmarkDtataset/" + benchmarkDatasetSubType();
	}
	protected abstract String benchmarkDatasetSubType() ;
}
