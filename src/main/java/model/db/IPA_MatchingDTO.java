/**
 * 
 */
package model.db;

/**
 * @author acil
 *
 */
public class IPA_MatchingDTO extends IPA_Object_RecognitionDTO {

	/**
	 * @param iPANname
	 */
	public IPA_MatchingDTO(String iPANname) {
		super(iPANname);
	}

	/**
	 * 
	 */
	public IPA_MatchingDTO() {
		// Just for enabling creating objects without any mandatory parameters
	}

	/* (non-Javadoc)
	 * @see model.db.Object_Recognition#Object_RecognitionSubType()
	 */
	@Override
	protected String iPA_Object_RecognitionSubType() {
		return "Matching/";
	}

}
