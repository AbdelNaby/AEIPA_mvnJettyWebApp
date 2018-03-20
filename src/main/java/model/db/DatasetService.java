/**
 * 
 */
package model.db;

import java.util.ArrayList;

/**
 * @author acil
 *
 */
public class DatasetService extends FolderService<DatasetDTO> {

	/**
	 * 
	 */
	public DatasetService() {
		// Just for enabling creating objects without any mandatory parameters
	}

	/* (non-Javadoc)
	 * @see model.db.FolderService#validateDatabyType(model.db.FolderDTO)
	 */
	@Override
	protected boolean validateDatabyType(DatasetDTO dto) {
		// Nothing in particular to be checked here
		//All the validations are already have been checked in FolderService.validateData(T dto)
		return true;
	}

	/* (non-Javadoc)
	 * @see model.db.GenericService#dTOMapper(java.util.ArrayList)
	 */
	@Override
	public DatasetDTO dTOMapper(ArrayList<String> dTOvaluesList) {
		return null;
	} 
//	{
//		DatasetDTO dataset = null;
//		String datasetType = dTOvaluesList.get(5);
//		if (datasetType.equalsIgnoreCase("InputDataset")) {
//			dataset = new InputDatasetDTO();
//		}
//		else if(datasetType.equalsIgnoreCase("BoundingBox"))
//		{
//			dataset = new BenchmarkDatasetDTO_BoundingBox();
//		}else if(datasetType.equalsIgnoreCase("BoundingBoxLabeled"))
//		{
//			dataset = new BenchmarkDatasetDTO_BoundingBoxLabeled();
//		}else if(datasetType.equalsIgnoreCase("GroundTruth"))
//		{
//			dataset = new BenchmarkDatasetDTO_GroundTruth();
//		}
//		dataset.setId(dTOvaluesList.get(0));
//		dataset.setUserName(dTOvaluesList.get(1));
//		dataset.setName(dTOvaluesList.get(2));
//		dataset.setDescription(dTOvaluesList.get(3));
//		// Full path is generated automatically, there is no need to set it
//		// iPA.setFullPath(rs.getString(attributeList.get(---)));
//		// Type is set automatically when the object is created
//		// iPA.setType(rs.getString(attributeList.get(4)));
//		dataset.setEvaluationDescription(dTOvaluesList.get(5));
//		return dataset;
//	}

	/* (non-Javadoc)
	 * @see model.db.GenericService#dTOMapper(model.db.GenericDTO)
	 */
	@Override
	public ArrayList<String> dTOMapper(DatasetDTO dto) {
		ArrayList<String> tempDataset = new ArrayList<String>();
		tempDataset.add(dto.getUserName());
		tempDataset.add(dto.getName());
		tempDataset.add(dto.getType());
		tempDataset.add(dto.getDescription());
		tempDataset.add(dto.getFullPath());
		tempDataset.add(dto.getEvaluationDescription());
		return tempDataset;
	}


@Override
public boolean createNew(DatasetDTO dto) {
	DatasetDAO datasetDAO = new DatasetDAO();
	if (validateData(dto)) {
		// Adding the new IPA to the database
		if (!datasetDAO.add(dto)) {
			System.out.println("Dataset: " + dto.getName() + " has NOT been added succesfully. Problem in Database");
			return false;
		}
		System.out.println("New Dataset: " + dto.getName() + " has been added succesfully to the database with Type: " + dto.getType() );
		// Creating a directory in the physical disk
		createDirectory(dto.getFullPath());
		return true;
	}
	return false;
}

@Override
public boolean updateInfo(DatasetDTO oldDTO, DatasetDTO newDTO) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean delete(DatasetDTO dto) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public ArrayList<DatasetDTO> retrieveInfobyName(String name) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ArrayList<DatasetDTO> retrieveInfobyType(String type) {
	// TODO Auto-generated method stub
	return null;
}

	/* (non-Javadoc)
	 * @see model.db.GenericService#createNew(model.db.GenericDTO)
	 */
//	@Override
//	public boolean createNew(DatasetDTO dto)
	//		{
	//			InputDatasetDAO datasetDAO = null;
	//			String datasetType = dto.getType();
	//			if (datasetType.equalsIgnoreCase("InputDataset")) {
	//				InputDatasetDAO datasetDAO = new InputDatasetDAO();
	//			}
	//			else if(datasetType.equalsIgnoreCase("BoundingBox"))
	//			{
	//				BenchmarkDatasetDAO_BoundingBoxLabeled datasetDAO = 
	//						BenchmarkDatasetDAO_BoundingBoxLabeled();
	//			}else if(datasetType.equalsIgnoreCase("BoundingBoxLabeled"))
	//			{
	//				BenchmarkDatasetDAO_BoundingBox datasetDAO = 
	//						BenchmarkDatasetDAO_BoundingBox();
	//			}else
	//			{
	//				BenchmarkDatasetDAO_GroundTruth datasetDAO = 
	//						new BenchmarkDatasetDAO_GroundTruth();
	//			}
	//			IPADAO iPADAO = new IPADAO();
	//			// Checking the new IPA Name
	//			System.out.println("This is tha iPAMainFileName: " + dto.getMainFileName());
	//			if (validateData(dto)) {
	//				// Adding the new IPA to the database
	//				if (!iPADAO.add(dto)) {
	//					System.out.println("IPA: " + dto.getName() + " has NOT been added succesfully. Problem in Database");
	//					return false;
	//				}
	//				System.out.println("New IPA: " + dto.getName() + " has been added succesfully to the database.");
	//				// Creating a directory in the physical disk
	//				createDirectory(dto.getFullPath());
	//				return true;
	//			}
	//			return false;
	//		}
//	{
//		String datasetType = dto.getType();
//		if (datasetType.equalsIgnoreCase("InputDataset")) {
////			InputDatasetDAO datasetDAO = new InputDatasetDAO();
//		}
//		else if(datasetType.equalsIgnoreCase("BoundingBox"))
//		{
//			BenchmarkDatasetDAO_BoundingBoxLabeled datasetDAO = 
//					BenchmarkDatasetDAO_BoundingBoxLabeled();
//		}else if(datasetType.equalsIgnoreCase("BoundingBoxLabeled"))
//		{
//			BenchmarkDatasetDAO_BoundingBox datasetDAO = 
//					BenchmarkDatasetDAO_BoundingBox();
//		}else
//		{
//			BenchmarkDatasetDAO_GroundTruth datasetDAO = 
//					new BenchmarkDatasetDAO_GroundTruth();
//		}
//		
//		//Checking the new IPA Name
//		if (validateData(dto))
//		{
//			// Adding the new IPA to the database
//			if( !datasetDAO.add(dto))
//			{
//				System.out.println("IPA: " + dto.getName() 
//					+ " has NOT been added succesfully. Problem in Database");
//				return false;
//			}
//			System.out.println("New IPA: " + dto.getName() + " has been added "
//					+ "succesfully.");
//			return true;	
//		}
//		return false;
//	}

	/* (non-Javadoc)
	 * @see model.db.GenericService#updateInfo(model.db.GenericDTO, model.db.GenericDTO)
	 */
//	@Override
//	public boolean updateInfo(DatasetDTO oldDTO, DatasetDTO newDTO) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	/* (non-Javadoc)
//	 * @see model.db.GenericService#delete(model.db.GenericDTO)
//	 */
//	@Override
//	public boolean delete(DatasetDTO dto) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
