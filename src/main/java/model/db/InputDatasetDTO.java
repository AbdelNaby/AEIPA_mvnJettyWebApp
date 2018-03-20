/**
 * 
 */
package model.db;

import java.util.ArrayList;

/**
 * @author acil
 *
 */
public class InputDatasetDTO extends DatasetDTO {
	// Every input dataset has a benchmark dataset	
	public BenchmarkDatasetDTO benchmarkDataset ;
	
	public InputDatasetDTO(String folderName, String benchmarkDatasetName) {
	//public InputDatasetDTO(String folderName){
		super(folderName);
		this.benchmarkDatasetName = benchmarkDatasetName;
		DatasetDAO datasetDAO = new DatasetDAO();
		ArrayList<DatasetDTO> datasetDTO = datasetDAO.display("NAME", "=", benchmarkDatasetName);
		System.out.println("======++===+++++> Inside the Input dataset benchmark is: "+ datasetDTO.get(0).getName());
		System.out.println("======++===+++++> Inside the Input dataset benchmark is: "+ datasetDTO.get(0).getFullPath());
		benchmarkDataset = (BenchmarkDatasetDTO) datasetDTO.get(0);
	//	this.benchmarkDataset = benchmarkDataset ;
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
