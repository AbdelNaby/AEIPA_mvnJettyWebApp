/**
 * 
 */
package model.db;

/**
 * @author acil
 *
 */
public abstract class IPADTO extends AlgorithmDTO {

	/**
	 * @param algoName
	 */
	public IPADTO(String algoName) {
		super(algoName);
	}

	/**
	 * 
	 */
	public IPADTO() 	{
		// Just for enabling creating objects without any mandatory parameters
	}

	/* (non-Javadoc)
	 * @see model.db.AlgorithmDTO#algoSubType()
	 */
	@Override
	protected String algoSubType() {
		return "IPA/" + iPASubType();
	}
	protected abstract String iPASubType();

}
