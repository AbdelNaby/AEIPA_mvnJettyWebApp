/**
 * 
 */
package model.db;

import java.text.DecimalFormat;

/**
 * @author acil
 *
 */
public class Confusion_Matrix {
	//ArrayList<Double> confusion_Matrix = new ArrayList<Double>();
	protected double  tPR = 0.00;
	protected double  tNR = 0.00;
	protected double  fNR = 0.00;
	protected double  fPR = 0.00;
	private static DecimalFormat df2 = new DecimalFormat(".##");
	public Confusion_Matrix() {
		// TODO Auto-generated constructor stub
	}
//	public String getConfusion_Matrix()
//	{
//		String str = df2.format(tPR) + " " + df2.format(tNR) + " " + 
//				df2.format(fNR) + " " + df2.format(fPR);
//		return str;
//	}
	public String toString()
	{
		String str = gettPR() + " @nd# " + gettNR() + " @nd# " + 
				getfNR() + " @nd# " + getfPR();
		return str;
	}
	/**
	 * @return the tPR
	 */
	public String gettPR() {
		return df2.format(tPR);
	}
	/**
	 * @param tPR the tPR to set
	 */
	public void settPR(double tPR) {
		this.tPR = tPR;
	}
	/**
	 * @return the tNR
	 */
	public String gettNR() {
		return df2.format(tNR);
	}
	/**
	 * @param tNR the tNR to set
	 */
	public void settNR(double tNR) {
		this.tNR = tNR;
	}
	/**
	 * @return the fNR
	 */
	public String getfNR() {
		return df2.format(fNR);
	}
	/**
	 * @param fNR the fNR to set
	 */
	public void setfNR(double fNR) {
		this.fNR = fNR;
	}
	/**
	 * @return the fPR
	 */
	public String getfPR() {
		return df2.format(fPR);
	}
	/**
	 * @param fPR the fPR to set
	 */
	public void setfPR(double fPR) {
		this.fPR = fPR;
	}

}
