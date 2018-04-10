/**
 * 
 */
package model.db;


/**
 * @author acil
 *
 */
public abstract class DatasetDTO extends FolderDTO {

	//dataseName is the Dataset Folder Name
	//foldername is the the specific type name
	private String datasetName;
	private ResultType resultType = ResultType.BOUNDING_BOX;
	private String xYLabelSheetName;
	private String keyWords;
	private String evaluationDescription;
	private Confusion_Matrix confusion_Matrix = new Confusion_Matrix();
	//private String ConfusionMatrixStr;

	protected DatasetDTO() {
		super();
		
	}
	protected DatasetDTO(String folderName, String dataseName, String userName) {
		this.setDatasetName(dataseName);
		this.setName(folderName);
		System.out.println("The dataseName is : "+ dataseName);
		this.setUserName(userName);
		init();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param folderName
	 */
	public DatasetDTO(String folderName) {
		super(folderName);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.db.DataDTO#datasetSubType()
	 */
	@Override
	public void setType() {
		// An Inputdataset under the Dataset type
		type = "Dataset/" + datasetName +"/" + datasetSubType();
		
	}

	/**
	 * @param fullPath the fullPath to set
	 */
	@Override
	public void setFullPath() {
		this.fullPath = defaultPath + type +"/" + name +"/";
		System.out.println("The fullPath is : " + fullPath);
	}
	protected abstract String datasetSubType();

//	/**
//	 * @return the DatabaseName
//	 */
//	public String getDatabaseName() {
//		// Return the DatabaseName
//	    System.out.println("Folder name is: " + name);    
//	    String[] paths = name.split("_");
//	    System.out.println("Folder name splitted is: " + paths[paths.length-1]); 
//		return paths[0];
//	}
	/**
	 * @return the datasetName
	 */
	public String getDatasetName() {
		return datasetName;
	}

	/**
	 * @param datasetName
	 *            the datasetName to set
	 */
	public void setDatasetName(String datasetName) {
		this.datasetName = datasetName;
	}

	/**
	 * @return the resultType
	 */
	public String getResultType() {
		String str = new String();
		switch (resultType) {
		case BOUNDING_BOX:
			System.out.println("BOUNDING_BOX");
			str = "BOUNDING_BOX";
			break;
			
		default:
			System.out.println("LABELLED_BOUNDING_BOX");
			str = "LABELLED_BOUNDING_BOX";
			break;
		}
		return str;
	}

	/**
	 * @param string
	 *            the resultType to set
	 */
	public void setResultType(String resultTypestr) {
		switch (resultTypestr) {
		case "BOUNDING_BOX":
			System.out.println("BOUNDING_BOX");
			resultType = ResultType.BOUNDING_BOX;
			break;
		default:
			System.out.println("LABELLED_BOUNDING_BOX");
			resultType = ResultType.LABELLED_BOUNDING_BOX;
			break;
		}
	}

	/**
	 * @return the xYLabelSheetName
	 */
	public String getxYLabelSheetName() {
		return xYLabelSheetName;
	}

	/**
	 * @param xYLabelSheetName
	 *            the xYLabelSheetName to set
	 */
	public void setxYLabelSheetName(String xYLabelSheetName) {
		this.xYLabelSheetName = xYLabelSheetName;
	}

	/**
	 * @return the keyWords
	 */
	public String getKeyWords() {
		return keyWords;
	}

	/**
	 * @param keyWords
	 *            the keyWords to set
	 */
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	/**
	 * @return the evaluationDescription
	 */
	public String getEvaluationDescription() {
		return evaluationDescription;
	}

	/**
	 * @param evaluationDescription
	 *            the evaluationDescription to set
	 */
	public void setEvaluationDescription(String evaluationDescription) {
		this.evaluationDescription = evaluationDescription;
	}
//	/**
//	 * @return the confusion_Matrix_perResultFolder
//	 */
//	public String getConfusion_Matrix_perResultFolder() {
//
//		return getConfusion_Matrix().toString();
//	}
//	/**
//	 * @param confusion_Matrix_perResultFolder the confusion_Matrix_perResultFolder to set
//	 */
//	public void setConfusion_Matrix_perResultFolder(String confusion_Matrix_perResultFolder) {
//		if(confusion_Matrix_perResultFolder != null) {
//		String[] selectedIPANameList = confusion_Matrix_perResultFolder.split(" @nd# ");
//		getConfusion_Matrix().settPR(Double.parseDouble(selectedIPANameList[0]));
//		getConfusion_Matrix().settNR(Double.parseDouble(selectedIPANameList[1]));
//		getConfusion_Matrix().setfNR(Double.parseDouble(selectedIPANameList[2]));
//		getConfusion_Matrix().setfPR(Double.parseDouble(selectedIPANameList[3]));
//		}else
//		{
//			setConfusion_Matrix(null);
//		}
//	}
	/**
	 * @return the confusion_Matrix
	 */
	public Confusion_Matrix getConfusion_Matrix() {
		return confusion_Matrix;
	}
	/**
	 * @param confusion_Matrix the confusion_Matrix to set
	 */
	public void setConfusion_Matrix(Confusion_Matrix confusion_Matrix) {
		this.confusion_Matrix = confusion_Matrix;
	}
	/**
	 * @return the confusionMatrixStr
	 */
	public String getConfusionMatrixStr() {
		return confusion_Matrix.toString();
	}
	/**
	 * @param confusionMatrixStr the confusionMatrixStr to set
	 */
	public void setConfusionMatrixStr(String confusionMatrixStr) {
		if(confusionMatrixStr != null) {
			String[] selectedIPANameList = confusionMatrixStr.split(" @nd# ");
			confusion_Matrix.settPR(Double.parseDouble(selectedIPANameList[0]));
			confusion_Matrix.settNR(Double.parseDouble(selectedIPANameList[1]));
			confusion_Matrix.setfNR(Double.parseDouble(selectedIPANameList[2]));
			confusion_Matrix.setfPR(Double.parseDouble(selectedIPANameList[3]));
			}else
			{
				confusion_Matrix = null;
			}
	}
}
