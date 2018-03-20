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
public class OLD_BenchmarkDatasetDAO_BoundingBox 
extends GenericDAO<BenchmarkDatasetDTO_BoundingBox> {

	/**
	 * 
	 */
	public OLD_BenchmarkDatasetDAO_BoundingBox() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.GenericDAO#tableName() Returns Table View Name
	 * GROUNDTRUTH_EVALDATASET
	 */
	@Override
	protected String tableName() {
		return "BENCHMARKDATASET_BOUNDINGBOX1";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.GenericDAO#valueList(model.db.GenericDTO) 
	 * Filling in values
	 * from database row to the DTO object
	 */
	@Override
	protected ArrayList<String> valueList(BenchmarkDatasetDTO_BoundingBox dto) {
		// Filling in values from database row to the DTO object
		ArrayList<String> valueList = new ArrayList<String>();
		valueList.add(dto.getUserName());
		valueList.add(dto.getName());
		valueList.add(dto.getDescription());
		return valueList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.GenericDAO#convertToDTO(java.sql.ResultSet)
	 */
//	@Override
//	protected ArrayList<BenchmarkDatasetDTO_BoundingBox> convertToDTO(ResultSet rs) {
//		ArrayList<BenchmarkDatasetDTO_BoundingBox> bBoxBenchDatasetsList = new ArrayList<BenchmarkDatasetDTO_BoundingBox>();
//		try {
//			while (rs.next()) {
//				BenchmarkDatasetDTO_BoundingBox bBoxBenchmarkDataset = new BenchmarkDatasetDTO_BoundingBox(
//						rs.getString(attributeList.get(1)));
//
//				bBoxBenchmarkDataset.setUserName(rs.getString(attributeList.get(0)));
//				bBoxBenchmarkDataset.setDescription(rs.getString(attributeList.get(2)));
//				bBoxBenchDatasetsList.add(bBoxBenchmarkDataset);
//			}
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//		return bBoxBenchDatasetsList;
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
		attributeList.add("USERNAME");
		attributeList.add("NAME");
		attributeList.add("DESCRIPTION");
	}

	@Override
	protected ArrayList<BenchmarkDatasetDTO_BoundingBox> convertArrayListToArrayDTOs(ArrayList<String> arrayList) {
		// TODO Auto-generated method stub
		return null;
	}

}
