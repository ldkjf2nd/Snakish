package Snakish;

import javax.swing.*;

/**
 * 
 * @author Tian Guo, Xin Tong Hu
 *
 */
public class SnakishView extends JFrame {
	private SnakishModel model;
	JFrame frame;
	private int frameSizeX = 600; // x size of the frame
	private int frameSizeY = 600; // y size of the frame

	/**
	 * Constructor for SnakishView, initializes the frame
	 * 
	 * @param model
	 */
	public SnakishView(SnakishModel model) {
		this.model = model;
		initFrame();
	}

	/**
	 * This should initialize the JFrame
	 */
	private void initFrame() {
		frame = new JFrame("Snakish");
		// Default Close Action
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Sets Window Properties
		frame.setSize(frameSizeX, frameSizeY);
	}

	/**
	 * Method to return JFrame of the view
	 * 
	 * @return JFrame: JFrame of the view
	 */
	public JFrame getJFrame() {
		return frame;
	}

	/**
	 * Method to overwrite the previous JFrame
	 * 
	 * @param f
	 */
	public void setJFrame(JFrame f) {
		frame = f;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(frameSizeX, frameSizeY);
		frame.setVisible(true);
	}

	/**
	 * Method to remake JFrame
	 */
	public void remakeJFrame() {
		frame.setVisible(false);
		frame.dispose();
		setJFrame(new JFrame("Snakish"));
	}
}