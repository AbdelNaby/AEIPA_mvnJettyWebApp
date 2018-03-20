/**
 * 
 */
package model.db;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;

/**
 * @author acil
 *
 */
public class Evaluation_Algo_ImgDiffPercent implements Evaluation_Algo {

	/**
	 * 
	 */
	public Evaluation_Algo_ImgDiffPercent() {
		// TODO Auto-generated constructor stub
	}


	public boolean evaluate(BenchmarkDatasetDTO benchmarkDatasetDTO, 
			DatasetResultDTO resultDatasetDTO) throws IOException {
		//benchmarkDatasetDTO.
		ArrayList<String> resultDatasetImageList = 
				resultDatasetDTO.getDatasetImageList();
		ArrayList<String> benchmarkDatasetImageList = 
				benchmarkDatasetDTO.getDatasetImageList();
		ArrayList<Double> evalutionResultList = new ArrayList<Double>();
		for(int i=0; i<resultDatasetImageList.size(); i++)
		{
			String resultImgFullPath = resultDatasetDTO.getFullPath() + resultDatasetImageList.get(i);
			String benchmarkImgFullPath = benchmarkDatasetDTO.getFullPath() + benchmarkDatasetImageList.get(i);
			BufferedImage img1 = ImageIO.read(new File(resultImgFullPath));
		    BufferedImage img2 = ImageIO.read(new File(benchmarkImgFullPath));
			evalutionResultList.add(getDifferencePercent(img1, img2));
			//getDifferencePercent(resultDatasetImageList[i],benchmarkDatasetImageList[i]);
		}
		
		return false;
	}
	  private static double getDifferencePercent(BufferedImage img1, 
			  BufferedImage img2) {
	        int width = img1.getWidth();
	        int height = img1.getHeight();
	        int width2 = img2.getWidth();
	        int height2 = img2.getHeight();
	        if (width != width2 || height != height2) {
	            throw new IllegalArgumentException(String.format("Images must have the same dimensions: (%d,%d) vs. (%d,%d)", width, height, width2, height2));
	        }
	 
	        long diff = 0;
	        for (int y = 0; y < height; y++) {
	            for (int x = 0; x < width; x++) {
	                diff += pixelDiff(img1.getRGB(x, y), img2.getRGB(x, y));
	            }
	        }
	        long maxDiff = 3L * 255 * width * height;
	 
	        return 100.0 * diff / maxDiff;
	    }
	 
	    private static int pixelDiff(int rgb1, int rgb2) {
	        int r1 = (rgb1 >> 16) & 0xff;
	        int g1 = (rgb1 >>  8) & 0xff;
	        int b1 =  rgb1        & 0xff;
	        int r2 = (rgb2 >> 16) & 0xff;
	        int g2 = (rgb2 >>  8) & 0xff;
	        int b2 =  rgb2        & 0xff;
	        return Math.abs(r1 - r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2);
	    }


}
