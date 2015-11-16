package Snakish;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.*;

import Snakish.SnakishModel.GameState;

/**
 * 
 * @author Tian Guo, Xin Tong Hu
 *
 */
public class SnakishController {
	private SnakishModel model = null;
	private SnakishView view = null;
	
	private int frameSizeX = 600;			// x size of the frame
	private int frameSizeY = 600;			// y size of the frame
	
//	//Inputs
	JTextField tfName = new JTextField("Enter Name");					// textfield for the player to enter name
	private JButton btnSG = new JButton("Start Game");
	private JButton btnA = new JButton("About");
	private JButton btnE = new JButton("Exit");
	private JPanel menuPanel = new JPanel();
	private JFrame frame;
	private JTextPane about = new JTextPane();
//	private JPanel boardPanel = null; 
//	
//	//Outputs to the view
//	private JPanel textPanel = null;
//	private JPanel topPanel = null;
	
	/**
	 * Constructor for SnakishController.
	 * @param model: the model it uses
	 * @param view: the view it uses
	 */
	public SnakishController(SnakishModel model, SnakishView view) {
		this.model = model;
		this.view = view;
		model.setGameState(GameState.TITLE_PAGE);
		initialize();
	}
	
	/**
	 * initializes main menu
	 */
	public void initialize(){
		frame = view.getJFrame();
		initializeMenu();
	}
	
	/**
	 * creates buttons for main menu
	 */
	private void initializeMenu() {
		//Setting button function
		btnSG.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				model.setGameState(GameState.NEW_GAME);
				startGame();
			}
		});
		
		btnA.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				model.setGameState(GameState.ABOUT);
				about();
			}
		});
		
		btnE.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (model.getGameState() == GameState.ABOUT) {
					model.setGameState(GameState.TITLE_PAGE);
					clear();
					menuPanel = new JPanel();
					initializeMenu();
				}
				else if (model.getGameState() == GameState.TITLE_PAGE) {
//					System.out.println("exited peacefully");
					System.exit(0);
				}
			}
		});
		
		tfName.setBounds(frameSizeX/2-60,200,120,30);				// location of the textfield
		tfName.setEditable(true);									// should be editable for player to enter name
		menuPanel.add(tfName);
		btnSG.setBounds(tfName.getX(),tfName.getY()+40,120,30);		// location of the button
		menuPanel.add(btnSG);
		btnA.setBounds(tfName.getX(),tfName.getY()+40*2,120,30);	// location of the button
		menuPanel.add(btnA);
		btnE.setBounds(tfName.getX(),tfName.getY()+40*3,120,30);	// location of the button
		menuPanel.add(btnE);
		
		menuPanel.setLayout(null);
		frame.add(menuPanel);
		frame.setVisible(true);
		menuPanel.setVisible(true);
	}
	
	private void startGame() {
		view.remakeJFrame();		
		model.setGameState(GameState.IN_PROGRESS);
		model.start();
	}
	
	private void about() {
		clear();
		StyledDocument doc = about.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		about.setText("The objective of the game is to make the opponent crash. \n \n"
				+ "Use top, down, left, right arrows to control the snake. \n \n"
				+ "Design and Programmed by: \nTian Guo and Xin Tong Hu");
		about.setBounds(100,tfName.getY(), 400, 200);
		btnE.setBounds(tfName.getX(),tfName.getY()+40*3,120,30);
		about.setVisible(true);
		menuPanel.add(btnE);
		menuPanel.add(about);
	}
	
	void clear() {
		menuPanel.remove(tfName);
		menuPanel.remove(btnSG);
		menuPanel.remove(btnA);
		menuPanel.remove(btnE);
		menuPanel.remove(about);
	}
	
//	private void repaint(){
//		tfName.repaint();
//		btnSG.repaint();
//		about.repaint();
//		btnA.repaint();
//		btnE.repaint();
//		tfName.requestFocus();
//		btnSG.requestFocus();
//		about.requestFocus();
//		btnA.requestFocus();
//		btnE.requestFocus();
//	}
	
	public static void main(String[] args) {
		SnakishModel model = new SnakishModel();
		SnakishView view = new SnakishView(model);
		SnakishController controller = new SnakishController(model, view);
	}
}