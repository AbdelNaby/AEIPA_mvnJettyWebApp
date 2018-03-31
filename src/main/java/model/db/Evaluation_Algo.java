/**
 * 
 */
package model.db;

import java.util.ArrayList;

/**
 * @author acil
 *
 */
public interface Evaluation_Algo {
	public ArrayList<Double> evaluate(String resultImgFullPath, String groundTruthImgFullPath);
}
