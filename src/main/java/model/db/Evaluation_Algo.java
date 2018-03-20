/**
 * 
 */
package model.db;

import java.io.IOException;

/**
 * @author acil
 *
 */
public interface Evaluation_Algo {
	boolean evaluate(BenchmarkDatasetDTO benchmarkDatasetDTO,
			DatasetResultDTO resultDatasetDTO) throws IOException;
}
