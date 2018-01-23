/**
 * 
 */
package model.db;

/**
 * @author acil
 *
 */
public class IPA_Edge_DetectionDTO extends IPA_Image_SegmentationDTO {

	/**
	 * @param name
	 */
	public IPA_Edge_DetectionDTO(String iPANname) {
		super(iPANname);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public IPA_Edge_DetectionDTO() {
		// Just for enabling creating objects without any mandatory parameters
	}

	/* (non-Javadoc)
	 * @see model.db.Image_Segmentation#image_SegmentationSubType()
	 */
	@Override
	protected String image_SegmentationSubType() {
		// TODO Auto-generated method stub
		return "Edge_Detection/";
	}

}
