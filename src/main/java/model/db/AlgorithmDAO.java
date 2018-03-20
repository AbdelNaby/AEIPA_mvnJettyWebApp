/**
 * 
 */
package model.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author acil
 * IPADAO is already implemented in the Class IPADAO
 * AlgorithmDAO is used for general Algorithms
 */
public class AlgorithmDAO extends GenericDAO<AlgorithmDTO> {

	/**
	 * 
	 */
	public AlgorithmDAO() {
		super();
	}

	/* (non-Javadoc)
	 * @see model.db.GenericDAO#tableName()
	 * Table View Name is IPA
	 */
	@Override
	protected String tableName() {
		// Table View Name is IPA
		return "IPA";
	}

	/* (non-Javadoc)
	 * @see model.db.GenericDAO#valueList(model.db.GenericDTO)
	 * Filling in values from database row to the DTO object
	 */
	@Override
	protected ArrayList<String> valueList(AlgorithmDTO dto) {
		// Filling in values from database row to the DTO object
		ArrayList<String> valueList = new ArrayList<String>();
		//valueList.add(dto.getId());
		valueList.add(dto.getUserName());
		valueList.add(dto.getName());
		valueList.add(dto.getMainFileName());
//		ArrayList<String> fileNameList = dto.getFileNameList();
//		String allFileName = null;
//		for (int i = 0; i < fileNameList.size(); i++) {
//			allFileName += fileNameList.get(i);
//			if(i <= fileNameList.size())
//			{
//				allFileName += " , ";
//			}	
//		}
		//valueList.add(dto.getFileNameList());
		//No need for the Full path value since it is automatically constructed in the AlgorithmDTO object
		//valueList.add(dto.getFullPath());
		valueList.add(dto.getDescription());
		valueList.add(dto.getProgLanguageName());
		valueList.add(dto.getProgLanguageNum());
		return valueList;
	}

	/* (non-Javadoc)
	 * @see model.db.GenericDAO#convertToDTO(java.sql.ResultSet)
	 */
//	@Override
//	protected ArrayList<AlgorithmDTO> convertToDTO(ResultSet rs) {
//		ArrayList<AlgorithmDTO> algosList = new ArrayList<AlgorithmDTO>() ;
//		try {
//			while (rs.next())
//			{
//				AlgorithmDTO algo;
//				if (rs.getString(attributeList.get(3)).equalsIgnoreCase(""))
//				{
//					algo = new IPA_MatchingDTO();
//				}
//				else
//				{
//					algo = new IPA_Edge_DetectionDTO();
//				}
//				//algo.setId(rs.getString(attributeList.get(0)));
//				algo.setUserName(rs.getString(attributeList.get(0)));
//				algo.setName(rs.getString(attributeList.get(1)));
//				algo.setType();
//				algo.setMainFileName(rs.getString(attributeList.get(3)));
//				// No need to set the full path
//				algo.setDescription(rs.getString(attributeList.get(4)));
//				algo.setProgLanguageName(rs.getString(attributeList.get(5)));
//				algo.setProgLanguageNum(rs.getString(attributeList.get(6)));
//				
//				algosList.add(algo);
//			}
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//		return algosList;
//	}

	/* (non-Javadoc)
	 * @see model.db.GenericDAO#setAttributeList()
	 */
	@Override
	protected void setAttributeList() {
		// Setting the columns names from the database to the DTO object
		attributeList.add("USER_NAME");
		attributeList.add("NAME");
		attributeList.add("MAIN_FILE_NAME");
		//attributeList.add("FILE_NAME_LIST");
		//No need for the Full path value since it is automatically 
		//constructed in the AlgorithmDTO object
		//attributeList.add("FULL_PATH");
		attributeList.add("DESCRIPTION");
		attributeList.add("PROGRAMINGLANG_NAME");
		attributeList.add("PROGRAMINGLANG_NUM");
	}

	@Override
	protected ArrayList<AlgorithmDTO> convertArrayListToArrayDTOs(ArrayList<String> arrayList) {
		// TODO Auto-generated method stub
		return null;
	}

}
