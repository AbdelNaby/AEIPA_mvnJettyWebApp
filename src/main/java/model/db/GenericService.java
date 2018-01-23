/**
 * 
 */
package model.db;

import java.util.ArrayList;
/**
 * @author acil
 *
 */
public abstract class GenericService<T extends GenericDTO> {
	/**
	 * @param dto
	 */
	public GenericService(T dto) {
	}
	public GenericService() 	{
		// Just for enabling creating objects without any mandatory parameters
	}
	public abstract T dTOMapper(ArrayList<String> dTOvaluesList);

	public abstract ArrayList<String> dTOMapper(T dto);

	public abstract boolean createNew();
	public abstract boolean updateInfo(T dto);
	public abstract boolean delete();
	public abstract boolean validateData();
}
