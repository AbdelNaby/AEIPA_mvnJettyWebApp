/**
 * 
 */
package model.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author acil
 *
 */
public class OLD_InputDatasetDAO extends GenericDAO<InputDatasetDTO> {

	/**
	 * 
	 */
	public OLD_InputDatasetDAO() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.GenericDAO#tableName()
	 */
	@Override
	protected String tableName() {
		//// Table Name is INPUTDATASET
		return "INPUTDATASET1";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.GenericDAO#valueList(model.db.GenericDTO) Filling in values
	 * from database row to the DTO object
	 */
	@Override
	protected ArrayList<String> valueList(InputDatasetDTO dto) {
		// Filling in values from database row to the DTO object
		ArrayList<String> valueList = new ArrayList<String>();
		// valueList.add(dto.getId());
		valueList.add(dto.getUserName());
		valueList.add(dto.getName());
		valueList.add(dto.getDescription());
		valueList.add(dto.getFullPath());
		valueList.add(dto.getType());
		return valueList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.GenericDAO#convertToDTO(java.sql.ResultSet)
	 */
//	@Override
//	protected ArrayList<InputDatasetDTO> convertToDTO(ResultSet rs) {
//		ArrayList<InputDatasetDTO> inputDatasetsList = new ArrayList<InputDatasetDTO>();
//		try {
//			while (rs.next()) {
//				InputDatasetDTO inputDataset = new InputDatasetDTO();
//				// inputDataset.setId(rs.getString(attributeList.get(0)));
//				inputDataset.setUserName(rs.getString(attributeList.get(0)));
//				inputDataset.setName(rs.getString(attributeList.get(1)));
//				inputDataset.setDescription(rs.getString(attributeList.get(2)));
//				// Full path is generated automatically, there is no need to set it
//				// inputDataset.setFullPath(rs.getString(attributeList.get(3)));
//				// Type is set automatically when the object is created
//				// inputDataset.setType(rs.getString(attributeList.get(4)));
//				inputDatasetsList.add(inputDataset);
//			}
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//		return inputDatasetsList;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.GenericDAO#setAttributeList() Setting the columns names from
	 * the database to the DTO object
	 */
	@Override
	protected void setAttributeList() {
		// Setting the columns names from the database to the DTO object
		// attributeList.add("ID");
		attributeList.add("USERNAME");
		attributeList.add("NAME");
		// Type is auto generated
		attributeList.add("DESCRIPTION");
		attributeList.add("EVALUATIONDESCRIPTION");
		// full path is auto generated
	}

	@Override
	protected ArrayList<InputDatasetDTO> convertArrayListToArrayDTOs(ArrayList<String> arrayList) {
		ArrayList<InputDatasetDTO> inputDataList = new ArrayList<InputDatasetDTO>();
		int i = 0;
		while (arrayList.size() > i) {
			InputDatasetDTO inputDatasetDTO = new InputDatasetDTO();
			inputDatasetDTO.setUserName(arrayList.get(i++));
			inputDatasetDTO.setName(arrayList.get(i++));
			//Type is auto generated
			// Type is set automatically when the object is created
			inputDatasetDTO.setDescription(arrayList.get(i++));
			inputDatasetDTO.setEvaluationDescription(arrayList.get(i++));
			// Full path is generated automatically, there is no need to set it
			inputDataList.add(inputDatasetDTO);
		}
		return inputDataList;
	}
}
