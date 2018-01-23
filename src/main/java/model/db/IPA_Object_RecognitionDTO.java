/**
 * 
 */
package model.db;

/**
 * @author acil
 *
 */
public abstract class IPA_Object_RecognitionDTO extends IPADTO {

	/**
	 * @param iPANname
	 */
	public IPA_Object_RecognitionDTO(String iPANname) {
		super(iPANname);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public IPA_Object_RecognitionDTO() {
		// Just for enabling creating objects without any mandatory parameters
	}

	/* (non-Javadoc)
	 * @see model.db.IPADTO#iPASubType()
	 */
	@Override
	protected String iPASubType() {
		// TODO Auto-generated method stub
		return "Object_Recognition/";
	}
	protected abstract String iPA_Object_RecognitionSubType();
}
