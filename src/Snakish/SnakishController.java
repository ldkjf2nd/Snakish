package Snakish;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.*;

import Snakish.SnakishModel.GameState;
import Snakish.SnakishModel.PlayingState;

/**
 * 
 * @author Tian Guo, Xin Tong Hu
 *
 */
public class SnakishController extends JPanel {
	private SnakishModel model = null;
	private SnakishView view = null;
	
	private int frameSizeX = 600;										// x size of the frame
	private int frameSizeY = 600;										// y size of the frame
	
//	public int up = 1;													// 4 directions of where the snake can move
//	public int right = 2;
//	public int down = 3;
//	public int left = 4;

	static boolean esc, enter;
	String name;														// Player's name
//    private Image player;
//    private Image pc;
//    private Image head;
	
	JTextField tfName = new JTextField("Enter Name");					// textfield for the player to enter name
	private JButton btnSG = new JButton("Start Game");					// start game button
	private JButton btnA = new JButton("About");						// about button
	private JButton btnE = new JButton("Exit");							// exit button
	private JPanel menuPanel = new JPanel();							// JPanel for menu
	private JFrame frame;												// The frame of the name
	private JTextPane Text = new JTextPane();							// JTextPane to display text
	
//	Graphics2D buffer,bground,gr;
//	Image ibuffer,head,grass,ibground;

	/**
	 * Constructor for SnakishController.
	 * @param model: the model it uses
	 * @param view: the view it uses
	 */
	public SnakishController(SnakishModel model, SnakishView view) {
		this.model = model;
		this.view = view;
		this.model.setGameState(GameState.TITLE_PAGE);
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
	 * creates buttons and textfield for main menu
	 */
	private void initializeMenu() {
		//Setting button function
		btnSG.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clear();
				startGame();
			}
		});
		
		btnA.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				model.setGameState(GameState.ABOUT);
//				System.out.println("about peacefully");
				clear();
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
	
	/**
	 * 
	 */
	private void startGame() {
		clear();
		frame.add(new Snake());
		frame.setVisible(true);
//		initGame();
		
//		model.playerExists = true;
//		model.playerSnake = model.snakes[0];
//		model.playerSnake.setPc(false);
//		model.playerSnake.enemy.setPc(true);
	}
	
//    private void initGame() {
//        model.playerSnake.length = 1;
//        model.pcSnake.length = 1;
//
//        for (int z = 0; z < model.playerSnake.length; z++) {
//            model.playerSnake.x[z] = 50 - z * 10;
//            model.playerSnake.y[z] = 50;
//        }
//        
//        for (int z = 0; z < model.pcSnake.length; z++) {
//            model.pcSnake.x[z] = 50 - z * 10;
//            model.pcSnake.y[z] = 50;
//        }
//        
//        model.playerSnake.timer = new Timer(model.DELAY, this);
//        model.playerSnake.timer.start();
//        
//        model.pcSnake.timer = new Timer(model.DELAY, this);
//        model.pcSnake.timer.start();
//    }
    
//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        doDrawing(g, s);
//    }
    
//    private void doDrawing(Graphics g, Snake s) {
//    	if (model.getGameState() == GameState.IN_PROGRESS) {
//    		for (int z = 0; z < s.length; z++) {
//    			if (z == 0) {
//    				g.drawImage(head, s.x[z], s.y[z], this);
//                }
//                else {
//                    g.drawImage(player, s.x[z], s.y[z], this);
//                }
//            }
//            Toolkit.getDefaultToolkit().sync();
//        }
//        else {
//        	model.setGameState(GameState.END_GAME);
//        	endGame();
//        }        
//    }
	
//	private void loadImages() {
//        ImageIcon iip = new ImageIcon("player.png");
//        player = iip.getImage();
//
//        ImageIcon iipc = new ImageIcon("pc.png");
//        pc = iipc.getImage();
//
//        ImageIcon iih = new ImageIcon("head.png");
//        head = iih.getImage();
//    }
	
	/**
	 * 
	 */
	private void about() {
		displayText("The objective of the game is to make the opponent crash. \n \n"
				+ "Use top, down, left, right arrows to control the snake. \n \n"
				+ "Design and Programmed by: \nTian Guo and Xin Tong Hu");
		btnE.setBounds(tfName.getX(), tfName.getY()+40*3, 120, 30);
		menuPanel.add(btnE);
		menuPanel.add(Text);
	}
	
	/**
	 * 
	 */
	void clear() {
		menuPanel.remove(tfName);
		menuPanel.remove(btnSG);
		menuPanel.remove(btnA);
		menuPanel.remove(btnE);
		menuPanel.remove(Text);
	}

//	public void run(){
//		long time,temp,max = 40;
//		while(true) {
//			time = System.currentTimeMillis();
//			update();
////			point();
//			temp = System.currentTimeMillis() - time;
//			time = max - temp;
//			try{
//				if (time > 0) Thread.sleep(time);
//			}catch(Exception e){}
//		}
//	}

//	public void draw() {
//		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
//        GraphicsDevice device = env.getDefaultScreenDevice();
//        ibuffer=createImage(600,600);
//		buffer=(Graphics2D)ibuffer.getGraphics();
//		ibground=createImage(getWidth(),getHeight());
//		bground=(Graphics2D)ibground.getGraphics();
//		gr=(Graphics2D)getGraphics();
//		model.snakes[0].paint(buffer);
//		model.snakes[1].paint(buffer);
//	}
//	
//	private Image obtImage(String img){
//		Toolkit tk=Toolkit.getDefaultToolkit();
//		return tk.getImage(getClass().getResource(img));
//	}
	
//	public void draw() {
//		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
//        GraphicsDevice device = env.getDefaultScreenDevice();
//        ibuffer=createImage(600,600);
//		buffer=(Graphics2D)ibuffer.getGraphics();
//		ibground=createImage(getWidth(),getHeight());
//		bground=(Graphics2D)ibground.getGraphics();
//		gr=(Graphics2D)getGraphics();
//		model.snakes[0].paint(buffer);
//		model.snakes[1].paint(buffer);
//	}
//	
//	private Image obtImage(String img){
//		Toolkit tk=Toolkit.getDefaultToolkit();
//		return tk.getImage(getClass().getResource(img));
//	}
	
//	public void run(){
//		long time,temp,max = 40;
//		while(true) {
//			time = System.currentTimeMillis();
//			update();
////			point();
//			temp = System.currentTimeMillis() - time;
//			time = max - temp;
//			try{
//				if (time > 0) Thread.sleep(time);
//			}catch(Exception e){}
//		}
//	}

	
//	public void update() {
//		if (model.getGameState() == GameState.TITLE_PAGE) {
//			model.counter++;
//			if(model.counter==500){
//				model.counter=0;
//				model.setGameState(GameState.DEMO);
//				demo();
//			}
//		}
//		else if (model.getGameState() == GameState.IN_PROGRESS) {
//			if (!model.snakes[0].isCrashed && !model.snakes[1].isCrashed) {
////				model.verifyLegalMove(model.dir1);
//			}
//			else {
//				model.setGameState(GameState.END_GAME);
//				endGame();
//			}
//		}
//	}
	
//	private void demo(){
//		model.start();
//		model.demo=true;
//		model.snakes[0].setPc(true);
//		model.snakes[1].setPc(true);
//		clear();
//	}
	
	/**
	 * 
	 * @param text
	 */
	private void displayText(String text) {
		StyledDocument doc = Text.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		Text.setText(text);
		Text.setBounds(100, tfName.getY(), 400, 200);
		Text.setVisible(true);
	}
	
	/**
	 * 
	 */
	private void endGame() {
		displayEndGame();
		if (view.esc) {
			checkEsc();
		}
		else if (view.enter) {
			if (model.getGameState() == GameState.END_GAME) {
				clear();
				startGame();
			}
		}
	}
	
	/**
	 * 
	 */
	private void displayEndGame() {
		if (model.getPlayingState() == PlayingState.PLAYER_WIN){
			//display text on panel
			displayText(model.name + " wins! \n \n"
					+ "Press ESC to exit \n \n"
					+ "Press ENTER to restart");
		}
		else if (model.getPlayingState() == PlayingState.PC_WIN){
			displayText("PC wins! \n \n"
					+ "Press ESC to exit \n \n"
					+ "Press ENTER to restart");
		}
	}
	
	/**
	 * 
	 */
	private void checkEsc() {
		if (model.getGameState() == GameState.NEW_GAME || model.getGameState() == GameState.IN_PROGRESS) {
			model.setGameState(GameState.TITLE_PAGE);
			clear();
			menuPanel = new JPanel();
			initializeMenu();
		}
		else if (model.getGameState() == GameState.END_GAME) {
			System.exit(0);
		}
	}
//
//	public void keyPressed(KeyEvent e){
//		int key=e.getKeyCode();
//		if (key == KeyEvent.VK_LEFT && !model.right) {
//			model.left = true;
//			model.up = false;
//			model.down = false;
//		}
//		else if (key == KeyEvent.VK_RIGHT && !model.left) {
//			model.right = true;
//			model.up = false;
//			model.down = false;
//		}
//		else if (key == KeyEvent.VK_UP && !model.down) {
//			model.up = true;
//			model.left = false;
//			model.right = false;
//		}
//		else if (key == KeyEvent.VK_DOWN && !model.up) {
//			model.down = true;
//			model.left = false;
//			model.right = false;
//		}
//		else if(key == KeyEvent.VK_ESCAPE) {
//			esc = true;
//		}
//		else if(key == KeyEvent.VK_ENTER) {
//			enter = true;
//		}
//	}
	
//	public class game extends JPanel {
//	    public game() {
//	        add(new Snake());
////	        setResizable(false);
////	        pack();
////	        setTitle("Snake");
////	        setLocationRelativeTo(null);
////	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    }
//	}
}