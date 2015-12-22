
//http://www.mkyong.com/java/how-to-resize-an-image-in-java/

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/*
 * @author akhilkarun
 *
 */
public class ImageResize {

	
	public static BufferedImage resizeImage(BufferedImage originalImage, int height,int width){
		BufferedImage resizedImage = new BufferedImage(width, height, 5);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();
		return resizedImage;
	}
	
	public static BufferedImage resizeImageWithHint(BufferedImage originalImage, int height,int width){

		BufferedImage resizedImage = new BufferedImage(width, height, 5);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();
		g.setComposite(AlphaComposite.Src);

		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		return resizedImage;
	}
	
//	 uncomment for testing this class
//	public static void main(String[] args) {
//
//		try {
//
//			BufferedImage originalImage = ImageIO
//					.read(new File("/Users/akhilkarun/Desktop/download.jpeg"));
//			int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
//			System.out.println(type);
//			BufferedImage resizeImageJpg = resizeImage(originalImage, type);
//			ImageIO.write(resizeImageJpg, "jpg",
//					new File("/Users/akhilkarun/Desktop/download1.jpeg"));
//
//			BufferedImage resizeImagePng = resizeImage(originalImage, type);
//			ImageIO.write(resizeImagePng, "jpg",
//					new File("/Users/akhilkarun/Desktop/download2.jpeg"));
//
//			BufferedImage resizeImageHintJpg = resizeImageWithHint(originalImage, type);
//			ImageIO.write(resizeImageHintJpg, "jpg",
//					new File("/Users/akhilkarun/Desktop/download3.jpeg"));
//
//			BufferedImage resizeImageHintPng = resizeImageWithHint(originalImage, type);
//			ImageIO.write(resizeImageHintPng, "jpg",
//					new File("/Users/akhilkarun/Desktop/download4.jpeg"));
//
//		} catch (IOException e) {
//			System.err.println(e.getMessage());
//		}
//
//	}

}
