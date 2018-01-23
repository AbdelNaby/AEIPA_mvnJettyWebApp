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
public class BenchmarkDatasetDAO_GroundTruth extends 
GenericDAO<BenchmarkDatasetDTO_GroundTruth> {

	/**
	 * 
	 */
	public BenchmarkDatasetDAO_GroundTruth() {
		super();
	}

	/* (non-Javadoc)
	 * @see model.db.GenericDAO#tableName()
	 * Returns Table View Name GROUNDTRUTH_EVALDATASET
	 */
	@Override
	protected String tableName() {
		// Table View Name is GROUNDTRUTH_EVALDATASET
		return "GROUNDTRUTH_EVALDATASET";
	}

	/* (non-Javadoc)
	 * @see model.db.GenericDAO#valueList(model.db.GenericDTO)
	 * Filling in values from database row to the DTO object
	 */
	@Override
	protected ArrayList<String> valueList(BenchmarkDatasetDTO_GroundTruth dto) {
		// Filling in values from database row to the DTO object
		ArrayList<String> valueList = new ArrayList<String>();
		valueList.add(dto.getId());
		valueList.add(dto.getUserName());
		valueList.add(dto.getName());
		valueList.add(dto.getDescription());
		return valueList;
	}

	/* (non-Javadoc)
	 * @see model.db.GenericDAO#convertToDTO(java.sql.ResultSet)
	 */
	@Override
	protected ArrayList<BenchmarkDatasetDTO_GroundTruth> convertToDTO(ResultSet rs) {
		ArrayList<BenchmarkDatasetDTO_GroundTruth> gTEvalDatasetsList = new ArrayList<BenchmarkDatasetDTO_GroundTruth>() ;
		try {
			while (rs.next())
			{
				BenchmarkDatasetDTO_GroundTruth gTEvalDataset = new BenchmarkDatasetDTO_GroundTruth(rs.getString(attributeList.get(2)));
				
				gTEvalDataset.setId(rs.getString(attributeList.get(0)));
				gTEvalDataset.setUserName(rs.getString(attributeList.get(1)));
				gTEvalDataset.setDescription(rs.getString(attributeList.get(3)));
				gTEvalDatasetsList.add(gTEvalDataset);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return gTEvalDatasetsList;
	}

	/* (non-Javadoc)
	 * @see model.db.GenericDAO#setAttributeList()
	 * Setting the columns names from the database to the DTO object
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
