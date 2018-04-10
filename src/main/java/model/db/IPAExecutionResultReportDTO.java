/**
 * 
 */
package model.db;

import java.util.ArrayList;

/**
 * @author acil
 *
 */
public class IPAExecutionResultReportDTO extends GenericDTO{


	private String  datasetName;
	private ArrayList<SeqDatasetResult> seqDatasetResultList = new ArrayList<SeqDatasetResult>();
	private String seqDatasetResultSize;
	public IPAExecutionResultReportDTO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the datasetName
	 */
	public String getDatasetName() {
		return datasetName;
	}
	/**
	 * @param datasetName the datasetName to set
	 */
	public void setDatasetName(String datasetName) {
		this.datasetName = datasetName;
	}
	/**
	 * @return the seqDatasetResultList
	 */
	public ArrayList<SeqDatasetResult> getSeqDatasetResultList() {
		return seqDatasetResultList;
	}
	/**
	 * @param seqDatasetResultList the seqDatasetResultList to set
	 */
	public void setSeqDatasetResultList(ArrayList<SeqDatasetResult> seqDatasetResultList) {
		this.seqDatasetResultList = seqDatasetResultList;
	}
	/**
	 * @return the seqDatasetResultSize
	 */
	public String getSeqDatasetResultSize() {
		return String.valueOf(seqDatasetResultList.size());
	}
	/**
	 * @param seqDatasetResultSize the seqDatasetResultSize to set
	 */
	public void setSeqDatasetResultSize(String seqDatasetResultSize) {
		this.seqDatasetResultSize = seqDatasetResultSize;
	}


}
