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

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.FolderService#validateDatabyType(model.db.FolderDTO)
	 */
	@Override
	protected boolean validateDatabyType(DatasetDTO dto) {
		if(dto.getDatasetName().isEmpty())
		{
			System.out.println("DatasetName is mandatory. Please enter a value.");
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.GenericService#dTOMapper(java.util.ArrayList)
	 */
	@Override
	public DatasetDTO dTOMapper(ArrayList<String> dTOvaluesList) {
		return null;
	}
	// {
	// DatasetDTO dataset = null;
	// String datasetType = dTOvaluesList.get(5);
	// if (datasetType.equalsIgnoreCase("InputDataset")) {
	// dataset = new InputDatasetDTO();
	// }
	// else if(datasetType.equalsIgnoreCase("BoundingBox"))
	// {
	// dataset = new DatasetContainerDTODTO_BoundingBox();
	// }else if(datasetType.equalsIgnoreCase("BoundingBoxLabeled"))
	// {
	// dataset = new DatasetContainerDTODTO_BoundingBoxLabeled();
	// }else if(datasetType.equalsIgnoreCase("GroundTruth"))
	// {
	// dataset = new DatasetContainerDTODTO_GroundTruth();
	// }
	// dataset.setId(dTOvaluesList.get(0));
	// dataset.setUserName(dTOvaluesList.get(1));
	// dataset.setName(dTOvaluesList.get(2));
	// dataset.setDescription(dTOvaluesList.get(3));
	// // Full path is generated automatically, there is no need to set it
	// // iPA.setFullPath(rs.getString(attributeList.get(---)));
	// // Type is set automatically when the object is created
	// // iPA.setType(rs.getString(attributeList.get(4)));
	// dataset.setEvaluationDescription(dTOvaluesList.get(5));
	// return dataset;
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.GenericService#dTOMapper(model.db.GenericDTO)
	 */
	@Override
	public ArrayList<String> dTOMapper(DatasetDTO dto) {
		return null;
	}
	// ArrayList<String> tempDataset = new ArrayList<String>();
	// tempDataset.add(dto.getUserName());
	// tempDataset.add(dto.getName());
	// tempDataset.add(dto.getType());
	// tempDataset.add(dto.getDescription());
	// tempDataset.add(dto.getEvaluationDescription());
	// tempDataset.add(dto.getKeyWords());
	// tempDataset.add(dto.getResultType());
	// tempDataset.add(dto.getFullPath());
	//
	// return tempDataset;
	// }

	@Override
	public boolean createNew(DatasetDTO dto) {
		DatasetDAO datasetDAO = new DatasetDAO();
		if (validateData(dto)) {
			// Adding the new IPA to the database
			if (!datasetDAO.add(dto)) {
				System.out
						.println("Dataset: " + dto.getName() + " has NOT been added succesfully. Problem in Database");
				return false;
			}
			System.out.println("New Dataset: " + dto.getName()
					+ " has been added succesfully to the database with Type: " + dto.getType());
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
	public DatasetDTO retrieveInfobyName(String name) {
		DatasetDAO datasetDAO = new DatasetDAO();
		// Checking the new IPA Name
		System.out.println("This is from retrieveInfo for DatasetName: " + name);

		// ArrayList<DatasetDTO> dataset = datasetDAO.display("NAME", "LIKE", "%" + name
		// + "%");

		ArrayList<DatasetDTO> dataset = datasetDAO.display("NAME", "=", name);
		if (dataset == null) {
			// Failed to retrieve the information of the IPA
			System.out.println("Dataset Name: " + name + " has NOT been found in the database succesfully..");
			return null;
		}
		System.out.println("Dataset Name: " + name + " has  been found in the database succesfully..");
		return dataset.get(0);
	}
	public DatasetContainerDTO retrieveDataset_InputDTOName(String inputDatasetName) {
		DatasetDTO datasetDTO = retrieveInfobyName_InputDTO(inputDatasetName);
		return retrievebyDatasetName(datasetDTO.getDatasetName());
	}
	public DatasetDTO retrieveInfobyName_InputDTO(String name) {
		DatasetDAO datasetDAO = new DatasetDAO();
		// Checking the new IPA Name
		System.out.println("This is from retrieveInfo for DatasetName: " + name);
		ArrayList<String> chkAttributeList = new ArrayList<String>();
		chkAttributeList.add("NAME");
		chkAttributeList.add("TYPE");
		ArrayList<String> chkConditionOpList = new ArrayList<String>();
		chkConditionOpList.add("=");
		chkConditionOpList.add("=");
		ArrayList<String> chkConnectorOpList = new ArrayList<String>();
		chkConnectorOpList.add("AND");
		ArrayList<String> chkValueList = new ArrayList<String>();
		chkValueList.add(name);
		chkValueList.add("INPUT");		
		ArrayList<DatasetDTO> dataset = datasetDAO.displayManyConditions(chkAttributeList, chkConditionOpList, chkConnectorOpList, chkValueList);
				
		if (dataset == null) {
			// Failed to retrieve the information of the IPA
			System.out.println("Dataset Name: " + name + " has NOT been found in the database succesfully..");
			return null;
		}
		System.out.println("Dataset Name: " + name + " has  been found in the database succesfully..");
		return dataset.get(0);
	}
	@Override
	public ArrayList<DatasetDTO> retrieveInfobyType(String type) {
		DatasetDAO datasetDAO = new DatasetDAO();
		// Checking the new IPA Name
		System.out.println("This is from retrieveInfobyType: " + type);

		ArrayList<DatasetDTO> datasetList = datasetDAO.display("TYPE", "=", type);
		if (datasetList == null) {
			// Failed to retrieve the information of the IPA
			System.out.println("Dataset type: " + type + " has NOT been found in the database succesfully..");
			return null;
		}
		System.out.println("Dataset type: " + type + " has  been found in the database succesfully..");
		return datasetList;
	}
	

	public ArrayList<DatasetDTO> retrieveInfobyResultType(String resultType) {
		DatasetDAO datasetDAO = new DatasetDAO();
		// Checking the new IPA Name
		System.out.println("This is from retrieveInfobyType: " + resultType);

		ArrayList<DatasetDTO> resultDatasetList = datasetDAO.display("RESULT_TYPE", "=", resultType);
		if (resultDatasetList == null) {
			// Failed to retrieve the information of the IPA
			System.out.println("Dataset type: " + resultType + " has NOT been found in the database succesfully..");
			return null;
		}
		System.out.println("Dataset type: " + resultType + " has  been found in the database succesfully..");
		ArrayList<DatasetDTO> inputDatasetList = new ArrayList<DatasetDTO>();
		for(int i=0; i< resultDatasetList.size(); i++)
		{
			ArrayList<String> chkAttributeList = new ArrayList<String>();
			chkAttributeList.add("DATASETNAME");
			chkAttributeList.add("TYPE");
			ArrayList<String> chkConditionOpList = new ArrayList<String>();
			chkConditionOpList.add("=");
			chkConditionOpList.add("=");
			ArrayList<String> chkConnectorOpList = new ArrayList<String>();
			chkConnectorOpList.add("AND");
			ArrayList<String> chkValueList = new ArrayList<String>();
			chkValueList.add(resultDatasetList.get(i).getName());
			chkValueList.add("INPUT");
			inputDatasetList = datasetDAO.displayManyConditions(chkAttributeList, chkConditionOpList, chkConnectorOpList, chkValueList);
		}
		return inputDatasetList;
	}

	
	
	///////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////
	
	
	public DatasetContainerDTO retrievebyDatasetName(String datasetName) {	
		
	DatasetDAO datasetDAO = new DatasetDAO();
	ArrayList<DatasetDTO> inputDatasetList = new ArrayList<DatasetDTO>();
	ArrayList<DatasetDTO> resultDatasetList = new ArrayList<DatasetDTO>();
	ArrayList<DatasetDTO> groundTruthDatasetList = new ArrayList<DatasetDTO>();
	DatasetContainerDTO tempDatasetContainerDTO = new DatasetContainerDTO();
	ArrayList<String> chkAttributeList = new ArrayList<String>();
	chkAttributeList.add("DATASETNAME");
	chkAttributeList.add("TYPE");
	ArrayList<String> chkConditionOpList = new ArrayList<String>();
	chkConditionOpList.add("=");;
	chkConditionOpList.add("=");
	ArrayList<String> chkConnectorOpList = new ArrayList<String>();
	chkConnectorOpList.add("AND");
	ArrayList<String> chkValueList = new ArrayList<String>();
	chkValueList.add(datasetName);
	chkValueList.add("INPUT");
	inputDatasetList = datasetDAO.displayManyConditions(chkAttributeList, chkConditionOpList, chkConnectorOpList, chkValueList);
	System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$ >"+ inputDatasetList.get(0).getName());
	chkValueList.set(1, "GROUNDTRUTH");
	groundTruthDatasetList = datasetDAO.displayManyConditions(chkAttributeList, chkConditionOpList, chkConnectorOpList, chkValueList);
	System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$ >"+ groundTruthDatasetList.get(0).getName());
	chkValueList.set(1, "RESULT");
	resultDatasetList = datasetDAO.displayManyConditions(chkAttributeList, chkConditionOpList, chkConnectorOpList, chkValueList);
	if(resultDatasetList != null) {
		
		ArrayList<ResultDTO> tempResultDTOList = new ArrayList<ResultDTO>();
		for(int h=0; h<resultDatasetList.size(); h++)
		{
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$ >");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$ >");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$ >");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$ >");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$ >");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$ >");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$ >" + resultDatasetList.get(h).getName());
			tempResultDTOList.add((ResultDTO) resultDatasetList.get(h));
		}
		tempDatasetContainerDTO.setResultSequenceDatasettDTOList(tempResultDTOList);
	}		
	if(inputDatasetList != null) {
		ArrayList<InputDTO> tempInputDTOList = new ArrayList<InputDTO>();
		for(int h=0; h<inputDatasetList.size(); h++)
		{
			tempInputDTOList.add((InputDTO) inputDatasetList.get(h));
			System.out.println("inputDatasetList : "+ inputDatasetList.get(h).getName());
			System.out.println("tempInputDTOList : "+ tempInputDTOList.get(h).getDatasetName());
		}
		tempDatasetContainerDTO.setInputSequenceDatasetDTOList(tempInputDTOList);
	}
	if(groundTruthDatasetList != null) {
		ArrayList<GroundTruthDTO> tempGroundTruthDTOList = new ArrayList<GroundTruthDTO>();
		for(int h=0; h<groundTruthDatasetList.size(); h++)
		{
			tempGroundTruthDTOList.add((GroundTruthDTO) groundTruthDatasetList.get(h));
		}
		tempDatasetContainerDTO.setGroundTruthSequenceDatasetDTOList(tempGroundTruthDTOList);
	}
	
	return tempDatasetContainerDTO;
}	
	/////////////////////////////////////////////////
	
	
	
	
	public ArrayList<DatasetContainerDTO> retrieveDatasetbyResultType(String resultType) {
		//ArrayList<DatasetContainerDTO> datasetContainerDTO = new ArrayList<DatasetContainerDTO>();
		DatasetDAO datasetDAO = new DatasetDAO();
		// Checking the new IPA Name
		System.out.println("This is from retrieveInfobyType: " + resultType);

		ArrayList<DatasetDTO> allResultDatasetList = datasetDAO.display("RESULT_TYPE", "=", resultType);
		if (allResultDatasetList == null) {
			// Failed to retrieve the information of the IPA
			System.out.println("Dataset type: " + resultType + " has NOT been found in the database succesfully..");
			return null;
		}
		ArrayList<String> datasetNameList = new ArrayList<String>();
		for(int i=0; i<allResultDatasetList.size();i++)
		{
			String strTemp = allResultDatasetList.get(i).getDatasetName();
			boolean flag = true;
			
			for(int j =0; j<datasetNameList.size(); j++)
			{
				if(datasetNameList.get(j).equalsIgnoreCase(strTemp))
				{
					flag = false;
				}
			}
			if(flag) {
				datasetNameList.add(strTemp);
			}
		}			
		//datasetContainerDTO.re
		//datasetContainerDTO.get(0).resultDatasetDTOList.addAll((ArrayList<ResultDTO>)resultDatasetList);
		System.out.println("Dataset type: " + resultType + " has  been found in the database succesfully..");

		ArrayList<DatasetContainerDTO> datasetContainerDTOList= new ArrayList<DatasetContainerDTO>();

	
		for(int i=0; i< datasetNameList.size(); i++)
		{
			DatasetContainerDTO tempDatasetContainerDTO = new DatasetContainerDTO();
			tempDatasetContainerDTO = retrievebyDatasetName(datasetNameList.get(i));
			datasetContainerDTOList.add(tempDatasetContainerDTO);			
		}
		return datasetContainerDTOList;	
	}
//	public ArrayList<DatasetDTO> retrieveInfobyBenchmarkName(String benchmarkName) {
//		DatasetDAO datasetDAO = new DatasetDAO();
//		// Checking the new IPA Name
//		System.out.println("This is from retrieveInfobyBenchmarkName: " + benchmarkName);
//
//		ArrayList<DatasetDTO> datasetList = datasetDAO.display("DatasetContainerDTONAME", "=", benchmarkName);
//		if (datasetList == null) {
//			// Failed to retrieve the information of the IPA
//			System.out.println(
//					"DatasetContainerDTONAME: " + benchmarkName + " has NOT been found in the database succesfully..");
//			return null;
//		}
//		System.out.println("DatasetContainerDTONAME " + benchmarkName + " has  been found in the database succesfully..");
//		return datasetList;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.GenericService#createNew(model.db.GenericDTO)
	 */
	// @Override
	// public boolean createNew(DatasetDTO dto)
	// {
	// InputDatasetDAO datasetDAO = null;
	// String datasetType = dto.getType();
	// if (datasetType.equalsIgnoreCase("InputDataset")) {
	// InputDatasetDAO datasetDAO = new InputDatasetDAO();
	// }
	// else if(datasetType.equalsIgnoreCase("BoundingBox"))
	// {
	// DatasetContainerDTODAO_BoundingBoxLabeled datasetDAO =
	// DatasetContainerDTODAO_BoundingBoxLabeled();
	// }else if(datasetType.equalsIgnoreCase("BoundingBoxLabeled"))
	// {
	// DatasetContainerDTODAO_BoundingBox datasetDAO =
	// DatasetContainerDTODAO_BoundingBox();
	// }else
	// {
	// DatasetContainerDTODAO_GroundTruth datasetDAO =
	// new DatasetContainerDTODAO_GroundTruth();
	// }
	// IPADAO iPADAO = new IPADAO();
	// // Checking the new IPA Name
	// System.out.println("This is tha iPAMainFileName: " + dto.getMainFileName());
	// if (validateData(dto)) {
	// // Adding the new IPA to the database
	// if (!iPADAO.add(dto)) {
	// System.out.println("IPA: " + dto.getName() + " has NOT been added
	// succesfully. Problem in Database");
	// return false;
	// }
	// System.out.println("New IPA: " + dto.getName() + " has been added succesfully
	// to the database.");
	// // Creating a directory in the physical disk
	// createDirectory(dto.getFullPath());
	// return true;
	// }
	// return false;
	// }
	// {
	// String datasetType = dto.getType();
	// if (datasetType.equalsIgnoreCase("InputDataset")) {
	//// InputDatasetDAO datasetDAO = new InputDatasetDAO();
	// }
	// else if(datasetType.equalsIgnoreCase("BoundingBox"))
	// {
	// DatasetContainerDTODAO_BoundingBoxLabeled datasetDAO =
	// DatasetContainerDTODAO_BoundingBoxLabeled();
	// }else if(datasetType.equalsIgnoreCase("BoundingBoxLabeled"))
	// {
	// DatasetContainerDTODAO_BoundingBox datasetDAO =
	// DatasetContainerDTODAO_BoundingBox();
	// }else
	// {
	// DatasetContainerDTODAO_GroundTruth datasetDAO =
	// new DatasetContainerDTODAO_GroundTruth();
	// }
	//
	// //Checking the new IPA Name
	// if (validateData(dto))
	// {
	// // Adding the new IPA to the database
	// if( !datasetDAO.add(dto))
	// {
	// System.out.println("IPA: " + dto.getName()
	// + " has NOT been added succesfully. Problem in Database");
	// return false;
	// }
	// System.out.println("New IPA: " + dto.getName() + " has been added "
	// + "succesfully.");
	// return true;
	// }
	// return false;
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.GenericService#updateInfo(model.db.GenericDTO,
	 * model.db.GenericDTO)
	 */
	// @Override
	// public boolean updateInfo(DatasetDTO oldDTO, DatasetDTO newDTO) {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// /* (non-Javadoc)
	// * @see model.db.GenericService#delete(model.db.GenericDTO)
	// */
	// @Override
	// public boolean delete(DatasetDTO dto) {
	// // TODO Auto-generated method stub
	// return false;
	// }

}
