/**
 * 
 */
package model.db;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author acil
 *	To be moved to DatasetServices
 */
public class DatasetContainerDTO extends GenericDTO{


	private ArrayList<InputDTO> inputSequenceDatasetDTOList;
	private ArrayList<GroundTruthDTO> groundTruthSequenceDatasetDTOList;
	private ArrayList<ResultDTO> resultSequenceDatasettDTOList = new ArrayList<ResultDTO>();
//	//private String groundTruthDatasetName;
//	private ArrayList<String> resultDatasetNameList = new ArrayList<String>();
////	private final String strSeparator = " @nd# ";
	
	public DatasetContainerDTO()
	{}

	/**
	 * @return the inputSequenceDatasetDTOList
	 */
	public ArrayList<InputDTO> getInputSequenceDatasetDTOList() {
		return inputSequenceDatasetDTOList;
	}

	/**
	 * @param inputSequenceDatasetDTOList the inputSequenceDatasetDTOList to set
	 */
	public void setInputSequenceDatasetDTOList(ArrayList<InputDTO> inputSequenceDatasetDTOList) {
		this.inputSequenceDatasetDTOList = inputSequenceDatasetDTOList;
	}

	/**
	 * @return the groundTruthSequenceDatasetDTOList
	 */
	public ArrayList<GroundTruthDTO> getGroundTruthSequenceDatasetDTOList() {
		return groundTruthSequenceDatasetDTOList;
	}

	/**
	 * @param groundTruthSequenceDatasetDTOList the groundTruthSequenceDatasetDTOList to set
	 */
	public void setGroundTruthSequenceDatasetDTOList(ArrayList<GroundTruthDTO> groundTruthSequenceDatasetDTOList) {
		this.groundTruthSequenceDatasetDTOList = groundTruthSequenceDatasetDTOList;
	}

	/**
	 * @return the resultSequenceDatasettDTOList
	 */
	public ArrayList<ResultDTO> getResultSequenceDatasettDTOList() {
		return resultSequenceDatasettDTOList;
	}

	/**
	 * @param resultSequenceDatasettDTOList the resultSequenceDatasettDTOList to set
	 */
	public void setResultSequenceDatasettDTOList(ArrayList<ResultDTO> resultSequenceDatasettDTOList) {
		this.resultSequenceDatasettDTOList = resultSequenceDatasettDTOList;
	}



	/**
	 * @param resultDTO to be added to resultDTOList
	 */
	public void addToResultDTOList(ResultDTO resultDTO) {
		this.resultSequenceDatasettDTOList.add(resultDTO);
	}

//	/**
//	 * @return the resultDatasetNameList
//	 */
//	public ArrayList<String> getResultDatasetNameList() {
//		return resultDatasetNameList;
//	}
//	/**
//	 * @return the resultDatasetNameList
//	 */
//	public String getResultDatasetNameasString() {
//		String resultDataset = new String();
//		String separator = "";
//		for (int i=0; i<resultDatasetNameList.size(); i++ )
//		{
//			resultDataset += resultDatasetNameList.get(i) + separator;
//			separator = strSeparator;
//		}
//		return resultDataset;
//	}
//	/**
//	 * @param resultDatasetNameList the resultDatasetNameList to set
//	 */
//	public void setResultDatasetNameList(ArrayList<String> resultDatasetNameList) {
//		this.resultDatasetNameList = resultDatasetNameList;
//	}
//	/**
//	 * @param resultDatasetList the resultDatasetList to set
//	 */
//	public void setResultDatasetList(String resultDatasetList) {
//		this.resultDatasetNameList = (ArrayList<String>) Arrays.asList(resultDatasetList.split(strSeparator));
//	}





//	/**
//	 * @param groundTruthDatasetName the groundTruthDatasetName to set
//	 */
//	private void setGroundTruthDatasetName(String groundTruthDatasetName) {
//		this.groundTruthDatasetName = groundTruthDatasetName;
//	}

}
