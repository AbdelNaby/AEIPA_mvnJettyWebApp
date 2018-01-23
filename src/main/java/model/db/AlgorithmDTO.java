/**
 * 
 */
package model.db;

/**
 * @author acil
 *
 */
public abstract class AlgorithmDTO extends FolderDTO {
	
	
	protected String mainFileName;
	protected String progLanguageName;
	protected String progLanguageNum;
	/**
	 * @param folderName
	 */
	public AlgorithmDTO(String algoName) {
		super(algoName);
	}

	public AlgorithmDTO() {
		// Just for enabling creating objects without any mandatory parameters
	}

	/* (non-Javadoc)
	 * @see model.db.FolderDTO#type()
	 */
//	@Override
//	protected String type() {
//		// Folder Type is IPA
//		return "IPA";
//	}
	/**
	 * @return the progLanguageName
	 */
	public String getProgLanguageName() {
		return progLanguageName;
	}

	/**
	 * @param progLanguageName the progLanguageName to set
	 */
	public void setProgLanguageName(String progLanguageName) {
		this.progLanguageName = progLanguageName;
	}

	/**
	 * @return the progLanguageNum
	 */
	public String getProgLanguageNum() {
		return progLanguageNum;
	}

	/**
	 * @param progLanguageNum the progLanguageNum to set
	 */
	public void setProgLanguageNum(String progLanguageNum) {
		this.progLanguageNum = progLanguageNum;
	}

	/**
	 * @return the mainFileName
	 */
	public String getMainFileName() {
		return mainFileName;
	}

	/**
	 * @param mainFileName the mainFileName to set
	 */
	public void setMainFileName(String mainFileName) {
		this.mainFileName = mainFileName;
	}

	@Override
	public void setType() {
		// Folder Type is Algorithm
		type = "Algorithm/"+ algoSubType();
	}
	protected abstract String algoSubType();
}
