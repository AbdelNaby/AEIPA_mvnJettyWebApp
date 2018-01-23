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
public class BenchmarkDatasetDAO_BoundingBoxLabeled extends GenericDAO<BenchmarkDatasetDTO_BoundingBoxLabeled> {

	/**
	 * 
	 */
	public BenchmarkDatasetDAO_BoundingBoxLabeled() {
		super();
	}

	/* (non-Javadoc)
	 * @see model.db.GenericDAO#tableName()
	 * Returns Table View Name BOUNDINGBOX_LABELED_EVALDATASET
	 */
	@Override
	protected String tableName() {
		return "BOUNDINGBOX_LABELED_BENCHMARKDATASET";
	}

	/* (non-Javadoc)
	 * @see model.db.GenericDAO#valueList(model.db.GenericDTO)
	 * Filling in values from database row to the DTO object
	 */
	@Override
	protected ArrayList<String> valueList(BenchmarkDatasetDTO_BoundingBoxLabeled dto) {
		// Filling in values from database row to the DTO object
		ArrayList<String> valueList = new ArrayList<String>();
		valueList.add(dto.getId());
		valueList.add(dto.getUserName());
		valueList.add(dto.getName());
		valueList.add(dto.getDescription());
		valueList.add(dto.getxYLabelSheetName());
		return valueList;
	}

	/* (non-Javadoc)
	 * @see model.db.GenericDAO#convertToDTO(java.sql.ResultSet)
	 */
	@Override
	protected ArrayList<BenchmarkDatasetDTO_BoundingBoxLabeled> convertToDTO(ResultSet rs) {
		ArrayList<BenchmarkDatasetDTO_BoundingBoxLabeled> bBoxLabeledEvalDatasetsList = 
				new ArrayList<BenchmarkDatasetDTO_BoundingBoxLabeled>() ;
		try {
			while (rs.next())
			{
				BenchmarkDatasetDTO_BoundingBoxLabeled bBoxLabeledEvalDataset = 
						new BenchmarkDatasetDTO_BoundingBoxLabeled(rs.getString(attributeList.get(2)), rs.getString(attributeList.get(4)) );
			
				bBoxLabeledEvalDataset.setId(rs.getString(attributeList.get(0)));
				bBoxLabeledEvalDataset.setUserName(rs.getString(attributeList.get(1)));
				bBoxLabeledEvalDataset.setDescription(rs.getString(attributeList.get(3)));
				//bBoxLabeledEvalDataset.setxYLabelSheetName(rs.getString(attributeList.get(4)));
				bBoxLabeledEvalDatasetsList.add(bBoxLabeledEvalDataset);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return bBoxLabeledEvalDatasetsList;
	}

	/* (non-Javadoc)
	 * @see model.db.GenericDAO#setAttributeList()
	 */
	@Override
	protected void setAttributeList() {
		// Setting the columns names from the database to the DTO object
		attributeList.add("ID");
		attributeList.add("USER_NAME");
		attributeList.add("NAME");
		attributeList.add("DESCRIPTION");
		attributeList.add("XYLABEL_SHEETNAME");
	}

}
