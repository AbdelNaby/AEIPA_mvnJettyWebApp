/**
 * 
 */
package model.db;

/**
 * @author acil
 *
 */
public abstract class IPA_Image_SegmentationDTO extends IPADTO {

	/**
	 * @param name
	 */
	public IPA_Image_SegmentationDTO(String iPANname) {
		super(iPANname);
	}

	/**
	 * 
	 */
	public IPA_Image_SegmentationDTO() {
		// Just for enabling creating objects without any mandatory parameters
	}

	/* (non-Javadoc)
	 * @see model.db.IPADTO#iPASubType()
	 */
	@Override
	protected String iPASubType() {
		return "Image_Segmentation/" + image_SegmentationSubType();
	}
	protected abstract String image_SegmentationSubType();
}
