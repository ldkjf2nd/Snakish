package Snakish;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Snakish.SnakishModel.GameState;
import Snakish.SnakishModel.PlayingState;

/**
 * 
 * @author Tian Guo, Xin Tong Hu
 *
 */
public class SnakishView extends JFrame {
	private SnakishModel model;
	static JTextField tfName;				// Name of the Player
	static JButton btnSG;					// Start game button
	static JButton btnA;					// About button
	static JButton btnE;					// Exit button
	String name;							// Player's name
	private int frameSizeX = 600;			// x size of the frame
	private int frameSizeY = 600;			// y size of the frame
	private int originX = 0;
	private int originY = 0;
	
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
		JPanel titlePage = new JPanel();
//		Container cp = getContentPane();
		
		// TextField for player's name
		tfName = new JTextField("Enter Name");					// textfield for the player to enter name
		tfName.setBounds(frameSizeX/2-60,originY+200,120,30);	// location of the textfield
		tfName.setEditable(true);								// should be editable for player to enter name
		titlePage.add(tfName);
		// Button for Start Game, About and Exit
		btnSG = new JButton("Start Game");						// button for Start Game
		btnSG.setBounds(tfName.getX(),tfName.getY()+40,120,30);	// location of the button
		titlePage.add(btnSG);
		btnA = new JButton("About");							// button for about
		btnA.setBounds(tfName.getX(),tfName.getY()+40*2,120,30);// location of the button
		titlePage.add(btnA);
		btnE = new JButton("Exit");								// button for exit
		btnE.setBounds(tfName.getX(),tfName.getY()+40*3,120,30);// location of the button
		titlePage.add(btnE);
		
        //... finalize layout
        setContentPane(titlePage);
		setLayout(null);
        setTitle("Snakish");									// Title
        // The window closing event should probably be passed to the 
        // Controller in a real program, but this is a short example.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			// Exit program if close-window button clicked
	    setSize(frameSizeX, frameSizeY);						// Sets initial size
	    setVisible(true);										// JFrame is visible
	}
	
	public void actionPerformed(ActionEvent evt) {
		Object src = evt.getSource();
		if (src == btnSG) {
			model.player(this);
		}
		else if (src == btnA) {
			clear();
			add(btnE);
			model.setGameState(GameState.ABOUT);
		}
		else if (src == btnE) {
			if (model.getGameState() == GameState.TITLE_PAGE) {
				System.exit(0);
			}
			else if (model.getGameState() == GameState.ABOUT) {
				remove(btnE);
				initFrame();
				model.setGameState(GameState.TITLE_PAGE);
			}
		}
	}
	
	void clear() {
		remove(tfName);
		remove(btnSG);
		remove(btnA);
		remove(btnE);
	}

	public Window getJFrame() {
		// TODO Auto-generated method stub
		return null;
	}

	public void remakeJFrame() {
		// TODO Auto-generated method stub
		
	}
}