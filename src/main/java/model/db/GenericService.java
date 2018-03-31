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
//	/**
//	 * @param dto
//	 */
//	public GenericService(T dto) {
//	}
	public GenericService() 	{
		// Just for enabling creating objects without any mandatory parameters
	}
	public abstract T dTOMapper(ArrayList<String> dTOvaluesList);

	public abstract ArrayList<String> dTOMapper(T dto);

	public abstract boolean createNew(T dto);
	public abstract boolean updateInfo(T oldDTO, T newDTO);
	public abstract boolean delete(T dto);
	public abstract boolean validateData(T dto);

}
