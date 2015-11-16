package Snakish;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 
 * @author Tian Guo, Xin Tong Hu
 *
 */
public class SnakishView extends JFrame {
	private SnakishModel model;
	private JFrame frame;
	String name;							// Player's name
	private int frameSizeX = 600;			// x size of the frame
	private int frameSizeY = 600;			// y size of the frame
	
	/**
	 * Constructor for ConnectFourView, initializes the frame
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
		//Default Close Action
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Sets Window Properties
		frame.setSize(frameSizeX,frameSizeY);
	}

	public JFrame getJFrame() {
		return frame;
	}
	
	/**
	 * Method to overwrite the previous JFrame
	 * @param frame
	 */
	public void setJFrame(JFrame f){
		frame = f;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(frameSizeX,frameSizeY);	
		frame.setVisible(true);
	}

	public void remakeJFrame() {
		frame.setVisible(false);
		frame.dispose();
		setJFrame(new JFrame("Snakish"));
	}
}