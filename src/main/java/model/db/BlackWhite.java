package model.db;

/**
public class Main 
{
    public static void main( String[] args )
    {
	System.out.println( "***** Hello" ) ;
	System.out.println( "***************************************Hello" ) ;
	System.out.println( "*************Hello From inside the App Main.java code ==>"  + args[0] ) ;
	System.out.println( "*************Hello" ) ;
	System.out.println( "*************Hello" ) ;
	}

}

 * 
 */

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author acil
 *
 */

public class BlackWhite {
	public static void main(String[] args) {
		try {
			System.out.println("***** Hello");
			System.out.println("***************************************Hello");
			System.out.println("*************Hello From inside the App Main.java code ==>" + args[0]);
			System.out.println("*************Hello");
			System.out.println("*************Hello");

			// BufferedImage image = null;
			// File dir = new File
			// ("/home/acil/eclipse-workspace/AEIPA_mvnJettyWebApp/app/ColoredPhotoes");
			// File[] dirList = dir.listFiles();
			// for (int i = 1; i < dirList.length; i++) {
			// try{
			// image = ImageIO.read(dirList[i].getAbsoluteFile());
			// int d = 2;
			// int iw = image.getWidth();
			// int ih = image.getHeight();
			// }catch (ArrayIndexOutOfBoundsException e) {
			// System.out.println("out of bounds");
			// }
			// }

			int width = 963; // width of the image
			int height = 640; // height of the image
			BufferedImage image = null;
			File f = null;

			// read image
			try {
				f = new File("\\home\\acil\\eclipse-workspace\\AEIPA_mvnJettyWebApp\\app\\ColoredPhotoes\\cow.jpg"); // image
																														// file
																														// path
				image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
				image = ImageIO.read(f);
				System.out.println("Reading complete.");
			} catch (IOException e) {
				System.out.println("Error: " + e);
			}

			// BufferedImage image = ImageIO.read(new File("cow.jpg"));
			System.out.println("***** Hello1");
			System.out.println(image.getWidth());
			System.out.println(image.getHeight());
			BufferedImage binarized = new BufferedImage(image.getWidth(), image.getHeight(),
					BufferedImage.TYPE_BYTE_BINARY);
			System.out.println("***** Hello2");
			int red;
			int newPixel;
			int threshold = 230;
			for (int i = 0; i < image.getWidth(); i++) {
				for (int j = 0; j < image.getHeight(); j++) {
					// Get pixels
					red = new Color(image.getRGB(i, j)).getRed();
					int alpha = new Color(image.getRGB(i, j)).getAlpha();

					if (red > threshold) {
						newPixel = 0;
					} else {
						newPixel = 255;
					}
					newPixel = colorToRGB(alpha, newPixel, newPixel, newPixel);
					binarized.setRGB(i, j, newPixel);
				}
			}
			System.out.println("***** Hello4");
			ImageIO.write(binarized, "jpg", new File("test.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int colorToRGB(int alpha, int red, int green, int blue) {
		int newPixel = 0;
		newPixel += alpha;
		newPixel = newPixel << 8;
		newPixel += red;
		newPixel = newPixel << 8;
		newPixel += green;
		newPixel = newPixel << 8;
		newPixel += blue;
		return newPixel;
	}
}