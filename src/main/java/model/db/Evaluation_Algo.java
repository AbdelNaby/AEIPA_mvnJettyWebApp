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
	public Confusion_Matrix evaluate(String resultImgFullPath, String groundTruthImgFullPath);
}
