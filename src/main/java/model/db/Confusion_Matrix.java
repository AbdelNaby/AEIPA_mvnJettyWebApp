/**
 * 
 */
package model.db;

import java.util.ArrayList;

/**
 * @author acil
 *
 */
public class Confusion_Matrix {
	//ArrayList<Double> confusion_Matrix = new ArrayList<Double>();
	private ArrayList<Double>  TPR;
	private ArrayList<Double>  FPR;
	public Confusion_Matrix() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the tPR
	 */
	ArrayList<Double> getTPR() {
		return TPR;
	}
	/**
	 * @param tPR the tPR to set
	 */
	void setTPR(ArrayList<Double> tPR) {
		TPR = tPR;
	}
	/**
	 * @return the fPR
	 */
	ArrayList<Double> getFPR() {
		return FPR;
	}
	/**
	 * @param fPR the fPR to set
	 */
	void setFPR(ArrayList<Double> fPR) {
		FPR = fPR;
	}
	
}
