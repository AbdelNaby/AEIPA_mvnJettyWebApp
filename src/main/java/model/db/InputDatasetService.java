/**
 * 
 */
package model.db;

import java.util.ArrayList;
/**
 * @author acil
 *
 */
public class InputDatasetService extends FolderService {

	/**
	 * 
	 */
	InputDatasetDAO inputDataset = new InputDatasetDAO();
	public InputDatasetService() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see model.db.FolderService#dTOMapper(java.util.ArrayList)
	 */
	@Override
	protected void dTOMapper(ArrayList<String> dTOvaluesList) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean add() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

}
