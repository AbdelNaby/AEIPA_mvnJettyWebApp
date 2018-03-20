/**
 * 
 */
package model.db;

import java.util.ArrayList;

/**
 * @author acil
 *
 */
public class OLD_BenchmarkDatasetService_GroundTruth {//extends DatasetService {

//	/**
//	 * 
//	 */
//	public OLD_BenchmarkDatasetService_GroundTruth() {
//		// TODO Auto-generated constructor stub
//	}
//	
//
//	/* (non-Javadoc)
//	 * @see model.db.GenericService#dTOMapper(java.util.ArrayList)
//	 */
//	@Override
//	public DatasetDTO dTOMapper(ArrayList<String> dTOvaluesList) {
//		DatasetDTO dataset = new BenchmarkDatasetDTO_GroundTruth();
//		//dataset.setId(dTOvaluesList.get(0));
//		dataset.setUserName(dTOvaluesList.get(0));
//		dataset.setName(dTOvaluesList.get(1));
//		dataset.setDescription(dTOvaluesList.get(2));
//		// Full path is generated automatically, there is no need to set it
//		// dataset.setFullPath(rs.getString(attributeList.get(---)));
//		// Type is set automatically when the object is created
//		// dataset.setType(rs.getString(attributeList.get(3)));
//		dataset.setEvaluationDescription(dTOvaluesList.get(4));
//		return dataset;
//	}
//
//
//	/* (non-Javadoc)
//	 * @see model.db.GenericService#createNew(model.db.GenericDTO)
//	 */
//	@Override
//	public boolean createNew(DatasetDTO dto) {
//		OLD_BenchmarkDatasetDAO_GroundTruth datasetDAO = 
//					new OLD_BenchmarkDatasetDAO_GroundTruth();
//		//Checking the new Dataset Name
//		if (validateData(dto))
//		{
//			// Adding the new IPA to the database
//			if( !datasetDAO.add((BenchmarkDatasetDTO_GroundTruth) dto))
//			{
//				System.out.println("Dataset (BenchmarkDataset_GroundTruth): " + dto.getName() 
//					+ " has NOT been added succesfully. Problem in Database");
//				return false;
//			}
//			System.out.println("New Dataset (BenchmarkDataset_GroundTruth): " + dto.getName() + " has been added "
//					+ "succesfully.");
//			return true;	
//		}
//		return false;
//	}
//
//
//	@Override
//	public DatasetDTO retrieveInfo(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public boolean updateInfo(DatasetDTO oldDTO, DatasetDTO newDTO) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//
//	@Override
//	public boolean delete(DatasetDTO dto) {
//		// TODO Auto-generated method stub
//		return false;
//	}
}
