import javax.swing.JFrame;


public class Main {
	public static void main(String[] args) {
		run(new FileChooser(), 400, 300);
	}

	public static void run(JFrame frame, int width, int height) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
}
