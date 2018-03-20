/**
 * 
 */
package model.db;

import java.util.ArrayList;

/**
 * @author acil
 *
 */
public class DatasetDAO extends GenericDAO<DatasetDTO> {

	/**
	 * 
	 */
	public DatasetDAO() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.GenericDAO#tableName()
	 */
	@Override
	protected String tableName() {
		// TODO Auto-generated method stub
		return "DATASET2";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.GenericDAO#valueList(model.db.GenericDTO) Filling in values in
	 * database row from the DTO object
	 */
	@Override
	protected ArrayList<String> valueList(DatasetDTO dto) {
		// Filling in values to database row from the DTO object
		ArrayList<String> valueList = new ArrayList<String>();
		// valueList.add(dto.getId());
		valueList.add(dto.getUserName());
		valueList.add(dto.getName());
		valueList.add(dto.getType());
		valueList.add(dto.getDescription());
		valueList.add(dto.getEvaluationDescription());
		valueList.add(dto.getFullPath());
		valueList.add(dto.getBenchmarkDatasetNAME());
		valueList.add(dto.getxYLabelSheetName());
		return valueList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.GenericDAO#convertArrayListToArrayDTOs(java.util.ArrayList)
	 * 
	 * Filling in values from database row to the DTO object
	 * 
	 */
	@Override
	protected ArrayList<DatasetDTO> convertArrayListToArrayDTOs(ArrayList<String> arrayList) {
		ArrayList<DatasetDTO> datasetDTOList = new ArrayList<DatasetDTO>();
		int i = 0;
		while (arrayList.size() > i) {
			DatasetDTO datasetDTO = null;
			if (arrayList.get(2).equals("GroundTruth")) {
				datasetDTO = new BenchmarkDatasetDTO_GroundTruth();
			} else {
				if (arrayList.get(2).equals("BoundingBox")) {
					datasetDTO = new BenchmarkDatasetDTO_BoundingBox();
				} else {
					if (arrayList.get(2).equals("BoundingBoxLabeled")) {
						datasetDTO = new BenchmarkDatasetDTO_BoundingBoxLabeled();
					} else {
						datasetDTO = new InputDatasetDTO();
						if (arrayList.get(2).equals("DatasetResult")) {
							datasetDTO = new DatasetResultDTO();
						} else {
							datasetDTO = new InputDatasetDTO(arrayList.get(1), arrayList.get(6));
						}
					}
				}
			}
			System.out.println("printing the arraylist in DatasetDAO.convertAray " + arrayList + i);
			datasetDTO.setUserName(arrayList.get(i++));
			datasetDTO.setName(arrayList.get(i++));
			// Type is auto generated
			// Type is set automatically when the object is created
			i++;
			datasetDTO.setType();
			
			datasetDTO.setDescription(arrayList.get(i++));
			datasetDTO.setEvaluationDescription(arrayList.get(i++));
			
			// Full path is generated automatically, there is no need to set it
			i++;
			datasetDTO.setFullPath();
			// BenchmarkDatasetNAME is already filled in the InputDatasetDTO(arrayList.get(1), arrayList.get(6))
			// No need for it here anymore
			i++;
			datasetDTO.setxYLabelSheetName(arrayList.get(i++));
			datasetDTOList.add(datasetDTO);
		}
		return datasetDTOList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.GenericDAO#setAttributeList()
	 * Setting the columns names from
	 * the database to the DTO object
	 */
	@Override
	protected void setAttributeList() {
		// Setting the columns names from the database to the attributeList inside the DTO
		// attributeList.add("ID");
		attributeList.add("USERNAME");
		attributeList.add("NAME");
		attributeList.add("TYPE");
		attributeList.add("DESCRIPTION");
		attributeList.add("EVALUATIONDESCRIPTION");
		attributeList.add("FullPath");
		attributeList.add("BenchmarkDatasetNAME");
		attributeList.add("XYLABEL_SHEETNAME");
	}
}
