import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SnakishController {
	private SnakishModel model = null;
	private SnakishView view = null;
	
	//Inputs
	private JButton startGameButton = new JButton("Start Game");
	private JButton aboutButton = new JButton("About");
	private JButton exitButton = new JButton("Exit");
	private JPanel menuPanel = null;
	private JPanel boardPanel = null; 
	
	//Outputs to the view
	private JPanel textPanel = null;
	private JPanel topPanel = null;
	
	/**
	 * Constructor for SnakishController
	 * @param model: the model it uses
	 * @param view: the view it uses
	 */
	public SnakishController(SnakishModel model, SnakishView view) {
		this.model = model;
		this.view = view;
	}
	
	private void startGame() {
		
	}
}
