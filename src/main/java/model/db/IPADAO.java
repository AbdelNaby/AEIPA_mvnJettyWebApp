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
public class IPADAO extends GenericDAO<IPADTO> {

	/**
	 * 
	 */
	public IPADAO() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.GenericDAO#tableName()
	 */
	@Override
	protected String tableName() {
		return "IPA";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.GenericDAO#valueList(model.db.GenericDTO) Filling in values
	 * from database row to the DTO object
	 */
	@Override
	protected ArrayList<String> valueList(IPADTO dto) {
		// Filling in values from database row to the DTO object
		ArrayList<String> valueList = new ArrayList<String>();
		valueList.add(dto.getId());
		valueList.add(dto.getUserName());
		valueList.add(dto.getName());
		valueList.add(dto.getDescription());
		valueList.add(dto.getFullPath());
		valueList.add(dto.getType());
		valueList.add(dto.getMainFileName());
		valueList.add(dto.getProgLanguageName());
		valueList.add(dto.getProgLanguageNum());
		return valueList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.GenericDAO#convertToDTO(java.sql.ResultSet)
	 */
	@Override
	protected ArrayList<IPADTO> convertToDTO(ResultSet rs) {
		ArrayList<IPADTO> iPAdataList = new ArrayList<IPADTO>();
		try {
			while (rs.next()) {
				IPADTO iPA = null;
				if (rs.getString(attributeList.get(5)).equalsIgnoreCase("Matching")) {
					iPA = new IPA_MatchingDTO();
				}
				else if(rs.getString(attributeList.get(5)).equalsIgnoreCase("Edge_Detection"))
				{
					iPA = new IPA_Edge_DetectionDTO();
				}
				iPA.setId(rs.getString(attributeList.get(0)));
				iPA.setUserName(rs.getString(attributeList.get(1)));
				iPA.setName(rs.getString(attributeList.get(2)));
				iPA.setDescription(rs.getString(attributeList.get(3)));
				// Full path is generated automatically, there is no need to set it
				// iPA.setFullPath(rs.getString(attributeList.get(4)));
				// Type is set automatically when the object is created
				// iPA.setType(rs.getString(attributeList.get(5)));
				iPAdataList.add(iPA);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return iPAdataList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.GenericDAO#setAttributeList()
	 */
	@Override
	protected void setAttributeList() {
		// Setting the columns names from the database to the DTO object
		attributeList.add("ID");
		attributeList.add("USER_NAME");
		attributeList.add("NAME");
		attributeList.add("DESCRIPTION");
	}
}
