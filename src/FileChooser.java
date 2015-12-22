import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/*
 * @author akhilkarun
 *
 */

public class FileChooser extends JFrame {
	private JTextField filepath1 = new JTextField();
	private JTextField filepath2 = new JTextField();
	private JTextField filepath3 = new JTextField();
	private JTextField filepath4 = new JTextField();

	private JButton choose1 = new JButton("Choose");
	private JButton choose2 = new JButton("Choose");
	private JButton choose3 = new JButton("Choose");
	private JButton choose4 = new JButton("Choose");
	private JButton process = new JButton("Process");
	private JLabel image1  = new JLabel("Image 1");
	private JLabel image2  = new JLabel("Image 2");
	private JLabel image3  = new JLabel("Image 3");
	private JLabel image4  = new JLabel("Image 4");

	public FileChooser() {
		JPanel panel = new JPanel();
		choose1.addActionListener(new Choose1());
		choose2.addActionListener(new Choose2());
		choose3.addActionListener(new Choose3());
		choose4.addActionListener(new Choose4());
		
		//panel.add(choose1);
		process.addActionListener(new ProcessImage());
		panel.add(process);
		Container container = getContentPane();
		container.add(panel, BorderLayout.SOUTH);
		filepath1.setEditable(false);
		filepath2.setEditable(false);
		filepath3.setEditable(false);
		filepath4.setEditable(false);
		panel = new JPanel();
		//panel.setLayout(new GridLayout(8, 0));
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
	    c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.weightx=1.;
		c.gridwidth = 6;  
		c.gridy = 0;
		panel.add(image1);
		panel.add(filepath1,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.weightx=0;
		c.gridwidth = 1;  
		c.gridy = 1;
		panel.add(choose1,c);
		
	    c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.weightx=1.;
		c.gridwidth = 6;  
		c.gridy++;
		panel.add(image2,c);
		c.gridx = 1;
		panel.add(filepath2,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.weightx=0;
		c.gridwidth = 1;  
		c.gridy++;
		panel.add(choose2,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.weightx=1.;
		c.gridwidth = 6;  
		c.gridy++;
		panel.add(image3,c);
		c.gridx = 1;
		panel.add(filepath3,c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.weightx=0;
		c.gridwidth = 1;  
		c.gridy++;
		panel.add(choose3,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.weightx=1.;
		c.gridwidth = 6;  
		c.gridy++;
		panel.add(image4,c);
		c.gridx = 1;
		panel.add(filepath4,c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.weightx=0;
		c.gridwidth = 1;  
		c.gridy++;
		panel.add(choose4,c);
		container.add(panel, BorderLayout.NORTH);
	}

	class Choose1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser c = new JFileChooser();
			// Demonstrate "Open" dialog:
			int rVal = c.showOpenDialog(FileChooser.this);
			if (rVal == JFileChooser.APPROVE_OPTION) {
				filepath1.setText(c.getSelectedFile().getPath());
			}
			if (rVal == JFileChooser.CANCEL_OPTION) {
				filepath1.setText("");
			}
		}
	}
	class Choose2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser c = new JFileChooser();
			// Demonstrate "Open" dialog:
			int rVal = c.showOpenDialog(FileChooser.this);
			if (rVal == JFileChooser.APPROVE_OPTION) {
				filepath2.setText(c.getSelectedFile().getPath());
			}
			if (rVal == JFileChooser.CANCEL_OPTION) {
				filepath2.setText("");
			}
		}
	}
	class Choose3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser c = new JFileChooser();
			// Demonstrate "Open" dialog:
			int rVal = c.showOpenDialog(FileChooser.this);
			if (rVal == JFileChooser.APPROVE_OPTION) {
				filepath3.setText(c.getSelectedFile().getPath());
			}
			if (rVal == JFileChooser.CANCEL_OPTION) {
				filepath3.setText("");
			}
		}
	}
	class Choose4 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser c = new JFileChooser();
			// Demonstrate "Open" dialog:
			int rVal = c.showOpenDialog(FileChooser.this);
			if (rVal == JFileChooser.APPROVE_OPTION) {
				filepath4.setText(c.getSelectedFile().getPath());
			}
			if (rVal == JFileChooser.CANCEL_OPTION) {
				filepath4.setText("");
			}
		}
	}

	class ProcessImage implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			try {
				boolean filenamesvalid = isJPEG(filepath1.getText(),
						filepath2.getText(), filepath3.getText(),
						filepath4.getText());
				if (filenamesvalid) {
					DisplayImage abc = new DisplayImage(filepath1.getText(),filepath2.getText(),filepath3.getText(),filepath4.getText());
				} else {
					msgbox("Please choose all file with extention 'jpg' or 'jpeg' .");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public boolean isJPEG(String s1, String s2, String s3, String s4) {
		if (s1 != null && s2 != null && s3 != null && s4 != null) {
			if ((s1.toLowerCase().endsWith("jpeg") || s1.toLowerCase()
					.endsWith("jpg"))
					&& (s2.toLowerCase().endsWith("jpeg") || s2.toLowerCase()
							.endsWith("jpg"))
					&& (s3.toLowerCase().endsWith("jpeg") || s3.toLowerCase()
							.endsWith("jpg"))
					&& (s4.toLowerCase().endsWith("jpeg") || s4.toLowerCase()
							.endsWith("jpg")))
				return true;
		}
		return false;
	}
	
	private void msgbox(String s){
		   JOptionPane.showMessageDialog(null, s);
		}
	// uncomment for testing this class
//	public static void main(String[] args) {
//		run(new FileChooser(), 400, 300);
//	}
//
//	public static void run(JFrame frame, int width, int height) {
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(width, height);
//		frame.setVisible(true);
//	}
}
