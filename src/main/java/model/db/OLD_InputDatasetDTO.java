/**
 * 
 */
package model.db;


/**
 * @author acil
 *
 */
public class OLD_InputDatasetDTO extends OLD_DatasetDTO123 {
	// Every input dataset has a groundTruth dataset	
//	public GroundTruthDatasetDTO groundTruthDataset ;
	//public ArrayList<ResultDatasetDTO> resultDatasetDTO = new ArrayList<ResultDatasetDTO>();
	public OLD_InputDatasetDTO(String folderName, String groundTruthDatasetName) {
	//public InputDatasetDTO(String folderName){
		super(folderName);
		this.setGroundTruthDatasetName(groundTruthDatasetName);
//		DatasetDAO datasetDAO = new DatasetDAO();
//		ArrayList<DatasetDTO> datasetDTO = datasetDAO.display("NAME", "=", groundTruthDatasetName);
//		System.out.println("======++===+++++> Inside the Input dataset groundTruth is: "+ datasetDTO.get(0).getName());
//		System.out.println("======++===+++++> Inside the Input dataset groundTruth is: "+ datasetDTO.get(0).getFullPath());
//		this.groundTruthDataset = (GroundTruthDatasetDTO) datasetDTO.get(0);
		//this.groundTruthDataset = groundTruthDataset ;
//		 Example:
//		GroundTruthDatasetDTO_GroundTruth gt = (GroundTruthDatasetDTO_GroundTruth)groundTruthDataset;
	}

	public OLD_InputDatasetDTO()
	{
		// Just for enabling creating objects without any mandatory parameters
	}

	@Override
	protected String datasetSubType() {
		return "InputDataset";
	}
	
}
