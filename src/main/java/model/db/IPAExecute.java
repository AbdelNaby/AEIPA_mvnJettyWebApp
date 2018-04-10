/**
 * 
 */
package model.db;

import java.util.ArrayList;

/**
 * @author acil
 *
 */
public abstract class IPAExecute {
	public abstract ArrayList<ResultDTO> executeIPA(IPADTO iPADTO, DatasetContainerDTO datasetContainerDTO, String userName);
}
