/**
 * 
 */
package model.db;

/**
 * @author acil
 *
 */
public abstract class IPAExecute {
	public abstract boolean executeIPA(IPADTO iPADTO, DatasetContainerDTO datasetContainerDTO, String userName);
}