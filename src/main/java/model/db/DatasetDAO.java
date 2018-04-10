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
		return "DATASET3";
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
		valueList.add(dto.getKeyWords());
		valueList.add(dto.getFullPath());
		valueList.add(dto.getResultType().toString());
		valueList.add(dto.getxYLabelSheetName());
		valueList.add(dto.getDatasetName());
		valueList.add(dto.getConfusionMatrixStr());
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
			if (arrayList.get(2).equals("RESULT")) {
				datasetDTO = new ResultDTO();
			} else {
				if (arrayList.get(2).equals("GROUNDTRUTH")) {
					datasetDTO = new GroundTruthDTO(arrayList.get(i+1),arrayList.get(i+9), arrayList.get(i+0));
				} else {
					datasetDTO = new InputDTO(arrayList.get(i+1),arrayList.get(i+9), arrayList.get(i+0));
				}
			}
			System.out.println("printing the arraylist in DatasetDAO.convertArray " + arrayList + i);
			datasetDTO.setUserName(arrayList.get(i+0));
			datasetDTO.setName(arrayList.get(i+1));
			// Type is auto generated
			// Type is set automatically when the object is created
			
			datasetDTO.setType();
			
			datasetDTO.setDescription(arrayList.get(i+3));
			datasetDTO.setEvaluationDescription(arrayList.get(i+4));
			datasetDTO.setKeyWords(arrayList.get(i+5));
			datasetDTO.setResultType(arrayList.get(i+6));
			// We have to set the full path in the end of filling all data so the datasetName will be retrieved
			datasetDTO.setxYLabelSheetName(arrayList.get(i+8));
			datasetDTO.setDatasetName(arrayList.get(i+9));
			// Full path is generated automatically, there is no need to set it
			datasetDTO.setFullPath();
			datasetDTO.setConfusionMatrixStr(arrayList.get(i+10));
			datasetDTOList.add(datasetDTO);
			i+=11;
		}
		return datasetDTOList;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.GenericDAO#setAttributeList() Setting the columns names from
	 * the database to the DTO object
	 */
	@Override
	protected void setAttributeList() {
		// Setting the columns names from the database to the attributeList inside the
		// DTO
		// attributeList.add("ID");
		attributeList.add("USERNAME");
		attributeList.add("NAME");
		attributeList.add("TYPE");
		attributeList.add("DESCRIPTION");
		attributeList.add("EVALUATIONDESCRIPTION");
		attributeList.add("KEYWORDS");
		attributeList.add("FullPath");
		attributeList.add("RESULT_TYPE");
		attributeList.add("XYLABEL_SHEETNAME");
		attributeList.add("DATASETNAME");
		attributeList.add("CONFUSION_MATRIX_PERRESULTFOLDER");
	}
}
