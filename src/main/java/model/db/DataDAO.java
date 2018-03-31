/**
 * 
 */
package model.db;

import java.util.ArrayList;

/**
 * @author acil
 *
 */
public abstract class DataDAO extends GenericDAO<InputDTO> {

	/**
	 * 
	 */
	public DataDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected abstract String tableName();

	@Override
	protected abstract ArrayList<String> valueList(InputDTO dto);

	@Override
	protected abstract ArrayList<InputDTO> convertArrayListToArrayDTOs(ArrayList<String> arrayList);

	@Override
	protected abstract void setAttributeList() ;



}
