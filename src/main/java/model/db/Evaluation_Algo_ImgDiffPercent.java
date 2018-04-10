/**
 * 
 */
package model.db;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;

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

	@Override
	public Confusion_Matrix evaluate(String resultImgFullPath, String groundTruthImgFullPath) {
		// BinaryResults/test.jpg
		// ColoredPhotoes/img1.png
		// BenchmarkImages/test.jpg
		// true positive rate
		BufferedImage resultImg = null;
		BufferedImage groundTruthImg = null;
		try {
			resultImg = ImageIO.read(new File(resultImgFullPath));

			groundTruthImg = ImageIO.read(new File(groundTruthImgFullPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		double p = getDifferencePercent(resultImg, groundTruthImg);
//
//		// Reporting section
//		DecimalFormat df = new DecimalFormat("00.00"); // Changing format here.
//		ArrayList<Double> confusion_Matrix = new ArrayList<Double>();
//		double TPR = p;
//		double FPR = 100 - p;
//		System.out.println("TPR: " + TPR + " %");
//		System.out.println("FPR: " + FPR + " %");
//
//		System.out.println("Diff percent: " + df.format(p) + " %");
//
//		System.out.println("Diff percent exactly: " + p + " %");
//		confusion_Matrix.add(TPR);
//		confusion_Matrix.add(FPR);
		System.out.println("confusion_Matrix                 is");
		System.out.println("confusion_Matrix                 is");
		System.out.println("confusion_Matrix                 is");
		System.out.println("confusion_Matrix                 is");
		System.out.println("confusion_Matrix                 is");
		System.out.println("confusion_Matrix                 is");
		
		Confusion_Matrix confusion_Matrix = getDifferencePercent(resultImg, groundTruthImg);
		System.out.println("fNR " + confusion_Matrix.getfNR());
		System.out.println("fPR " + confusion_Matrix.getfPR());
		System.out.println("tNR " + confusion_Matrix.gettNR());
		System.out.println("tPR " + confusion_Matrix.gettPR());
		return confusion_Matrix;
	}

	// public boolean evaluate(ArrayList<ResultDTO> resultDTO) throws IOException {
	// //benchmarkDatasetDTO.
	//// ArrayList<String> resultDatasetImageList =
	//// resultDatasetDTO.getFilesNameList();
	//// ArrayList<String> benchmarkDatasetImageList =
	//// benchmarkDatasetDTO.getFilesNameList();
	//// ArrayList<Double> evalutionResultList = new ArrayList<Double>();
	//// for(int i=0; i<resultDatasetImageList.size(); i++)
	//// {
	//// String resultImgFullPath = resultDatasetDTO.getFullPath() +
	// resultDatasetImageList.get(i);
	//// String benchmarkImgFullPath = benchmarkDatasetDTO.getFullPath() +
	// benchmarkDatasetImageList.get(i);
	//// BufferedImage img1 = ImageIO.read(new File(resultImgFullPath));
	//// BufferedImage img2 = ImageIO.read(new File(benchmarkImgFullPath));
	//// evalutionResultList.add(getDifferencePercent(img1, img2));
	//// //getDifferencePercent(resultDatasetImageList[i],benchmarkDatasetImageList[i]);
	//// }
	//
	// return false;
	// }
	private static Confusion_Matrix getDifferencePercent(BufferedImage resultImg, BufferedImage groundTruthImg) {
		int width = resultImg.getWidth();
		int height = resultImg.getHeight();
		int width2 = groundTruthImg.getWidth();
		int height2 = groundTruthImg.getHeight();
		if (width != width2 || height != height2) {
			throw new IllegalArgumentException(String.format(
					"Images must have the same dimensions: (%d,%d) vs. (%d,%d)", width, height, width2, height2));
		}

		double diff = 0;
		double  tPR = 0.00;
		double  tNR = 0.00;
		double  fNR = 0.00;
		double  fPR = 0.00;
		for (int y = 0; y < height; y++) {
			
			for (int x = 0; x < width; x++) {
				double tempDiff = pixelDiff(resultImg.getRGB(x, y), groundTruthImg.getRGB(x, y));
				
				if (tempDiff < 100 ) {
					// No difference
					// Yes-Yes
					// TP
					// Light Color
					tPR += tempDiff;
				
				} else if (tempDiff < 400) {
					// No-No
					// TN
					// Dark Color
					tNR += tempDiff;
				} else if (tempDiff < 700) {
					// Yes-No
					// FN
					fNR += tempDiff;
				} else {
					// No-Yes
					// FP
					fPR += tempDiff;
				}
				//System.out.println("tempDiff is  "+tempDiff);

				//diff += pixelDiff(resultImg.getRGB(x, y), groundTruthImg.getRGB(x, y));
			}
		}
		
		long maxDiff = 3L * 255 * width * height;
		Confusion_Matrix confusion_MatrixTemp = new Confusion_Matrix();
		confusion_MatrixTemp.settPR(100.0 * tPR / maxDiff);
		confusion_MatrixTemp.settNR(100.0 * tNR / maxDiff);
		confusion_MatrixTemp.setfNR(100.0 * fNR / maxDiff);
		confusion_MatrixTemp.setfPR(100.0 * fPR / maxDiff);
		return confusion_MatrixTemp;
	}

	private static int pixelDiff(int rgb1, int rgb2) {
		int r1 = (rgb1 >> 16) & 0xff;
		int g1 = (rgb1 >> 8) & 0xff;
		int b1 = rgb1 & 0xff;
		int r2 = (rgb2 >> 16) & 0xff;
		int g2 = (rgb2 >> 8) & 0xff;
		int b2 = rgb2 & 0xff;
		return Math.abs(r1 - r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2);
	}

}
