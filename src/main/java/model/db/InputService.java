/**
 * 
 */
package model.db;

import java.util.ArrayList;

/**
 * @author acil
 *
 */
public class InputService extends FolderService<InputDTO> {

	/**
	 * 
	 */
	public InputService() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see model.db.FolderService#retrieveInfobyName(java.lang.String)
	 */
	@Override
	public InputDTO retrieveInfobyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see model.db.FolderService#retrieveInfobyType(java.lang.String)
	 */
	@Override
	public ArrayList<InputDTO> retrieveInfobyType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see model.db.FolderService#validateDatabyType(model.db.FolderDTO)
	 */
	@Override
	protected boolean validateDatabyType(InputDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see model.db.GenericService#dTOMapper(java.util.ArrayList)
	 */
	@Override
	public InputDTO dTOMapper(ArrayList<String> dTOvaluesList) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see model.db.GenericService#dTOMapper(model.db.GenericDTO)
	 */
	@Override
	public ArrayList<String> dTOMapper(InputDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see model.db.GenericService#createNew(model.db.GenericDTO)
	 */
	@Override
	public boolean createNew(InputDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see model.db.GenericService#updateInfo(model.db.GenericDTO, model.db.GenericDTO)
	 */
	@Override
	public boolean updateInfo(InputDTO oldDTO, InputDTO newDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see model.db.GenericService#delete(model.db.GenericDTO)
	 */
	@Override
	public boolean delete(InputDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

}
