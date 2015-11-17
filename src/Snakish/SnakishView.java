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
	private int frameSizeX = 600;			// x size of the frame
	private int frameSizeY = 600;			// y size of the frame
	Container cp = getContentPane();
	static boolean esc, enter;
	
	/**
	 * Constructor for SnakishView, initializes the frame
	 * @param model
	 */
	public SnakishView(SnakishModel model) {
		this.model = model;
//		cp.setLayout(new GridLayout(60,60,0,0));
		initFrame();
	}
	
	/**
	 * This should initialize the JFrame
	 */
	private void initFrame() {
		frame = new JFrame("Snakish");
		addKeyListener(new TAdapter());
		//Default Close Action
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Sets Window Properties
//		frame.setPreferredSize(new Dimension(frameSizeX,frameSizeY));
		frame.setSize(frameSizeX,frameSizeY);
	}
	
	/**
	 * Method to return JFrame of the view
	 * @return JFrame: JFrame of the view
	 */
	public JFrame getJFrame() {
		return frame;
	}
	
	/**
	 * Method to overwrite the previous JFrame
	 * @param f
	 */
	public void setJFrame(JFrame f){
		frame = f;
		addKeyListener(new TAdapter());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(frameSizeX,frameSizeY);	
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

private class TAdapter extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	
		@Override
		public void keyPressed(KeyEvent e){
			int key=e.getKeyCode();
			if (key == KeyEvent.VK_LEFT && !model.right) {
				model.left = true;
				model.up = false;
				model.down = false;
			}
			else if (key == KeyEvent.VK_RIGHT && !model.left) {
				model.right = true;
				model.up = false;
				model.down = false;
			}
			else if (key == KeyEvent.VK_UP && !model.down) {
				model.up = true;
				model.left = false;
				model.right = false;
			}
			else if (key == KeyEvent.VK_DOWN && !model.up) {
				model.down = true;
				model.left = false;
				model.right = false;
			}
			else if(key == KeyEvent.VK_ESCAPE) {
				esc = true;
			}
			else if(key == KeyEvent.VK_ENTER) {
				enter = true;
			}
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}