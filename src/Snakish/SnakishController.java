package Snakish;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Snakish.SnakishModel.GameState;


/**
 * 
 * @author Tian Guo, Xin Tong Hu
 *
 */
public class SnakishController {
	private SnakishModel model = null;
	private SnakishView view = null;
	
//	//Inputs
//	private JButton startGameButton = new JButton("Start Game");
//	private JButton aboutButton = new JButton("About");
//	private JButton exitButton = new JButton("Exit");
	private JPanel menuPanel = null;
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
		view.addMouseListener(null);
	}
	
	/**
	 * initializes main menu
	 */
	public void initalize(){
		view.getJFrame().setVisible(true);
		initalizeButtons();
	}
	
	/**
	 * creates buttons for main menu
	 */
	private void initalizeButtons(){
		//Setting button function
		view.btnSG.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				model.setGameState(GameState.NEW_GAME);
				startGame();
			}
		});
		
		view.btnA.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				model.setGameState(GameState.ABOUT);
//				startGame();
			}
		});
		
		view.btnE.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				model.setGameState(GameState.END_GAME);
//				startGame();
			}
		});
		
		// Visualize title page
		menuPanel = new JPanel();
		menuPanel.add(view.tfName);
		menuPanel.add(view.btnSG);
		menuPanel.add(view.btnA);
		menuPanel.add(view.btnE);

		view.getJFrame().add(menuPanel,BorderLayout.CENTER);
	}
	
	private void startGame() {
		if(model.getGameState()==GameState.NEW_GAME){
			view.remakeJFrame();		
			model.setGameState(GameState.IN_PROGRESS);
		}
	}
}