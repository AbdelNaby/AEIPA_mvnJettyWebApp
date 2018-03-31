/**
 * 
 */
package model.db;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author  acilA POJO Class
 */
public abstract class OLD_DatasetDTO123 extends FolderDTO{

	private String evaluationDescription;
	//private ArrayList<String> datasetImageList;
	public String xYLabelSheetName;
	private String groundTruthDatasetName;
	private ArrayList<String> resultDatasetNameList = new ArrayList<String>();
	private final String strSeparator = " @nd# ";
	/**
	 * @return the groundTruthDatasetName
	 */
	public String getGroundTruthDatasetName() {
		return groundTruthDatasetName;
	}

	/**
	 * @param groundTruthDatasetName the groundTruthDatasetName to set
	 */
	public void setGroundTruthDatasetName(String groundTruthDatasetName) {
		this.groundTruthDatasetName = groundTruthDatasetName;
	}

	/**
	 * @return the xYLabelSheetName
	 */
	public String getxYLabelSheetName() {
		return xYLabelSheetName;
	}

	/**
	 * @param xYLabelSheetName the xYLabelSheetName to set
	 */
	public void setxYLabelSheetName(String xYLabelSheetName) {
		this.xYLabelSheetName = xYLabelSheetName;
	}
	public OLD_DatasetDTO123()
	{
		// Just for enabling creating objects without any mandatory parameters
	}
	public OLD_DatasetDTO123(String folderName) {
		super(folderName);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the evaluationDescription
	 */
	public String getEvaluationDescription() {
		return evaluationDescription;
	}

	/**
	 * @param evaluationDescription the evaluationDescription to set
	 */
	public void setEvaluationDescription(String evaluationDescription) {
		this.evaluationDescription = evaluationDescription;
	}
	
	/**
	 * To set the Type of the folder
	 */
	@Override
	public void setType() {
		// An Inputdataset under the Dataset type
		type = "Dataset/"+ datasetSubType();
	}
	protected abstract String datasetSubType();
	
	/**
	 * @param fullPath the fullPath to set
	 */
	@Override
	public void setFullPath() {
		this.fullPath = defaultPath + "Dataset/"+ name +"/" + type ;
		System.out.println("The fullPath in DatasetDTO is : " + fullPath);
	}
//	/**
//	 * @return the datasetImageList
//	 */
//	public ArrayList<String> getDatasetImageList() {
//		return datasetImageList;
//	}
//	/**
//	 * @param datasetImageList the datasetImageList to set
//	 */
//	public void setDatasetImageList(ArrayList<String> datasetImageList) {
//		this.datasetImageList = datasetImageList;
//	}
//

	/**
	 * @return the resultDatasetList
	 */
	public String getResultDatasetList() {
		String resultDataset = new String();
		String separator = "";
		for (int i=0; i<resultDatasetNameList.size(); i++ )
		{
			resultDataset += resultDatasetNameList.get(i) + separator;
			separator = strSeparator;
		}
		return resultDataset;
	}

	/**
	 * @param resultDatasetList the resultDatasetList to set
	 */
	public void setResultDatasetList(String resultDatasetList) {
		this.resultDatasetNameList = (ArrayList<String>) Arrays.asList(resultDatasetList.split(strSeparator));
	}
	
	public String addToResultDatasetList(IPADTO iPADTO)
	{
		this.resultDatasetNameList.add(iPADTO.getName() +"_"+ this.getName());
		return (createResultFolder(iPADTO.getName(), this.getName()));
	}
	
	public void addToResultDatasetList(String resultDatasetName)
	{
		this.resultDatasetNameList.add(resultDatasetName);
	}
	// As the IPA Name and the input dataset name are unique, the result folder name will be unique
	private String createResultFolder(String IPAName, String inputDatasetName) {
		String resultFolder = this.getFullPath()+IPAName+"_"+inputDatasetName+"/";
		File file = new File(resultFolder);
        if (!file.exists()) {
            if (file.mkdirs()) {
                System.out.println("Directory is created! " + file.getAbsolutePath());
				return resultFolder;
            } else {
                System.out.println("Failed to create directory! "  + file.getAbsolutePath());
				return null;
            }
        }
		return resultFolder;	
	}

	
}
