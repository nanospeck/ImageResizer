
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class DisplayImage extends JPanel {

	private static final String IMAGE = "/Users/akhilkarun/Desktop/download.jpeg";
	public static void main(String avg[]) throws IOException {
		DisplayImage abc = new DisplayImage();
	}
	

	    public DisplayImage()  throws IOException {
	    	BufferedImage img = ImageIO.read(new File(IMAGE)); 
	    	ImageIcon icon = new ImageIcon(img);
	    	ImageIcon icon1 = new ImageIcon(img);
	    	ImageIcon icon2 = new ImageIcon(img);
	         JLabel label1 = new JLabel(icon); 
	         JLabel label2 = new JLabel(icon1); 
	         JLabel label3 = new JLabel(icon2); 

	         add(label1);
	         add(label2);
	         add(label3);
	         JFrame frame = new JFrame();
	 		frame.setLayout(new FlowLayout());
	 		frame.setState(Frame.MAXIMIZED_BOTH);
	 		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
	 		frame.add(this);
	 		frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 		
	    }
//	public DisplayImage1() throws IOException {
//		BufferedImage img = ImageIO.read(new File(IMAGE));
//		ImageIcon icon = new ImageIcon(img);
//		JFrame frame = new JFrame();
//		frame.setLayout(new FlowLayout());
//		frame.setState(Frame.NORMAL);
//		JLabel lbl = new JLabel();
//		lbl.setIcon(icon);
//		frame.add(lbl);
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
}