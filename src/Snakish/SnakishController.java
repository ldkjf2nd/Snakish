package Snakish;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.util.Random;

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
	private boolean runGame;
	
//	public int up = 1;													// 4 directions of where the snake can move
//	public int right = 2;
//	public int down = 3;
//	public int left = 4;

//	static boolean esc, enter;
	String name;														// Player's name
//	private Image player;
//	private Image pc;
//	private Image head;
	
	JTextField tfName = new JTextField("Enter Name");					// textfield for the player to enter name
	private JButton btnSG = new JButton("Start Game");					// start game button
	private JButton btnA = new JButton("About");						// about button
	private JButton btnE = new JButton("Exit");							// exit button
	private JPanel menuPanel = new JPanel();							// JPanel for menu
	private JFrame frame;												// The frame of the name
	private JTextPane Text = new JTextPane();							// JTextPane to display text
	private Snake s;
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
		initialize();
	}
	
	/**
	 * initializes main menu
	 */
	public void initialize(){

		model.setGameState(GameState.TITLE_PAGE);
		System.out.println("start");
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(frameSizeX,frameSizeY);
		initializeMenu();
	}
	
	/**
	 * creates buttons and textfield for main menu
	 */
	private void initializeMenu() {
		//Setting button function
		System.out.println("menu");
		btnSG.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				model.setGameState(GameState.NEW_GAME);
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
		model.setGameState(GameState.IN_PROGRESS);
		runGame = true;
		clear();
		frame.setVisible(false);
		frame.dispose();
		s = new Snake();
		frame.add(s);
		frame.setVisible(true);
	}
	
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
	
	void clearAll() {
		frame.setVisible(false);
		frame.remove(s);
		frame = new JFrame();
		initialize();
	}
	
	void clearGame() {
		frame.setVisible(false);
		frame.remove(s);
		frame.dispose();
		startGame();
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
	void endGame() {
		model.setPlayingState(PlayingState.PLAYER_WIN);
		model.setGameState(GameState.END_GAME);
		frame.dispose();
		frame = view.getJFrame();
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
	 void displayEndGame() {
		System.out.println("urgh");
//		if (model.getPlayingState() == PlayingState.PLAYER_WIN){
			//display text on panel
			displayText(model.name + " wins! \n \n"
					+ "Press ESC to exit \n \n"
					+ "Press ENTER to restart");
			frame.add(Text);
//			frame.setVisible(true);
			System.out.println("urghhhh");
//		}
//		else if (model.getPlayingState() == PlayingState.PC_WIN){
//			displayText("PC wins! \n \n"
//					+ "Press ESC to exit \n \n"
//					+ "Press ENTER to restart");
//			frame.add(Text);
//		}
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

	public class Snake extends JPanel implements ActionListener {
	    private final int frameSizeX = 600;
	    private final int frameSizeY = 600;
	    private final int w = 10;
	    private final int maxSize = 1800;
	    private final int DELAY = 140;

	    private final int x[] = new int[maxSize];
	    private final int y[] = new int[maxSize];
	    private final int a[] = new int[maxSize];
	    private final int b[] = new int[maxSize];
	    
	    private int length;

	    private boolean left = false;
	    private boolean right = false;
	    private boolean up = false;
	    private boolean down = true;
	    private boolean leftAI = true;
	    private boolean rightAI = false;
	    private boolean upAI = false;
	    private boolean downAI = false;
	    private boolean ai[] = new boolean[4];
	    private boolean inGame = true;

	    private Timer timer;
	    private Image player;
	    private Image AI;
	    private Image head;

	    public Snake() {
//	        addKeyListener(new TAdapter());
	        setFocusable(true);
	        setPreferredSize(new Dimension(frameSizeX, frameSizeY));
	        loadImages();
	        initGame();
	    }

	    private void loadImages() {
	        ImageIcon iip = new ImageIcon("src/player.png");
	        player = iip.getImage();

	        ImageIcon iia = new ImageIcon("src/pc.png");
	        AI = iia.getImage();

	        ImageIcon iih = new ImageIcon("src/head.png");
	        head = iih.getImage();
	    }

	    private void initGame() {
//	    	addKeyListener(new TAdapter());
	        x[0] = model.x1;
	        y[0] = model.y1;
	        a[0] = model.x2;
	        b[0] = model.y2;
	        
	        timer = new Timer(DELAY, this);
	    	addKeyListener(new TAdapter());
	    	model.setGameState(GameState.IN_PROGRESS);
	        if (left == true || right == true || up == true || down == true) {
	        	timer.start();
	        }
	    }

	    @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);

	        doDrawing(g);
	    }
	    
	    private void doDrawing(Graphics g) {
	        if (inGame) {
	            for (int z = 0; z < length; z++) {
	                if (z == 0) {
	                    g.drawImage(head, x[z], y[z], this);
	                } else {
	                    g.drawImage(player, x[z], y[z], this);
	                }
	            }
	            for (int z = 0; z < length; z++) {
	                if (z == 0) {
	                    g.drawImage(head, a[z], b[z], this);
	                } else {
	                    g.drawImage(AI, a[z], b[z], this);
	                }
	            }
	            Toolkit.getDefaultToolkit().sync();
	        }
	        else {
	            gameOver(g);;
	        }        
	    }

	    private void gameOver(Graphics g) {
	        String msg = "press ESC to exit, press Enter to restart";
	        Font small = new Font("Helvetica", Font.BOLD, 14);
	        FontMetrics metr = getFontMetrics(small);

	        g.setColor(Color.black);
	        g.setFont(small);
	        g.drawString(msg, (frameSizeX - metr.stringWidth(msg)) / 2, frameSizeY / 2);
	    }

	    private void move() {
	        for (int z = length; z > 0; z--) {
	            x[z] = x[(z - 1)];
	            y[z] = y[(z - 1)];
	            a[z] = a[(z - 1)];
	            b[z] = b[(z - 1)];
	        }
	        if (left) {
	            x[0] -= w;
	        }
	        else if (right) {
	            x[0] += w;
	        }
	        else if (up) {
	            y[0] -= w;
	        }
	        else if (down) {
	            y[0] += w;
	        }
	        if (leftAI) {
	            a[0] -= w;
	        }
	        else if (rightAI) {
	        	a[0] += w;
	        }
	        else if (upAI) {
	            b[0] -= w;
	        }
	        else if (downAI) {
	            b[0] += w;
	        }
	    }
	    
//	    private void AiMove(int Ai) {
//	    	 if (ai[0]) {
//		            a[0] -= w;
//		            ai[0] = false;
//		            
//		        }
//
//		        if (ai[1]) {
//		            a[0] += w;
//		            ai[1] = false;
//		        }
//
//		        if (ai[2]) {
//		            b[0] -= w;
//		            ai[2] = false;
//		        }
//
//		        if (ai[3]) {
//		            b[0] += w;
//		            ai[3] = false;
//		        }
//	    }
	    
//	    /**
//	     * 
//	     */
//	    private void aiMove() {
//            Random rn = new Random();
//            int answer = rn.nextInt(4) + 1;		// 1 represents left, 2 represents right, 3 represents up, 4 represents down
//            if (verifyLegalMove(answer)) {
//	            if (answer == 1) {
//	            	leftAI = true;
//	            	rightAI = false;
//	            	upAI = false;
//	            	downAI = false;
//	            }
//	            else if (answer == 2) {
//	            	rightAI = true;
//	            	leftAI = false;
//	            	upAI = false;
//	            	downAI = false;
//	            }
//	            else if (answer == 3) {
//	            	upAI = true;
//	            	rightAI = false;
//	            	leftAI = false;
//	            	downAI = false;
//	            }
//	            else if (answer == 4) {
//	            	downAI = true;
//	            	upAI = false;
//	            	rightAI = false;
//	            	leftAI = false;
//	            }
//            }
//            else {
//            	aiMove();
//            }
//	    }
//		
//		/**
//		 * Checks whether the AIsnake's move is legal, return false if illegal, else true.
//		 * @return boolean
//		 */
//		public boolean verifyLegalMove(int n) {
//			if (n == 1 && rightAI) {
//				return false;
//			}
//			else if (n == 2 && leftAI) {
//				return false;
//			}
//			else if (n == 3 && downAI) {
//				return false;
//			}
//			else if (n == 4 && upAI) {
//				return false;
//			}
//			if (checkCollision(n)) {
//				return false;
//			}
//			else {
//				return true;
//			}
//		}
//		
//		private boolean checkCollision(int n) {
//			if (n == 1) {				// left
//				if ((a[0]-w) <= 0) {
//					return true;
//				}
//				else {
//					for (int z = 1; z < length; z++) {
//			            if ((z > 4) && ((a[0]-w) == a[z]) || ((a[0]-w) == x[z])) {
//			            	return true;
//			            }
//					}
//				}
//			}
//			else if (n == 2) {			// right
//				if ((a[0]+w) >= frameSizeX) {
//					return true;
//				}
//				else {
//					for (int z = 1; z < length; z++) {
//			            if ((z > 4) && ((a[0]+w) == a[z]) || ((a[0]+w) == x[z])) {
//			            	return true;
//			            }
//					}
//				}
//			}
//			else if (n == 3) {			// up
//				if ((b[0]+w) >= frameSizeY) {
//					return true;
//				}
//				else {
//					for (int z = 1; z < length; z++) {
//			            if ((z > 4) && ((b[0]+w) == b[z]) || ((b[0]+w) == y[z])) {
//			            	return true;
//			            }
//					}
//				}
//			}
//			else if (n == 4) {			// down
//				if ((b[0]-w) <= 0) {
//					return true;
//				}
//				else {
//					for (int z = 1; z < length; z++) {
//			            if ((z > 4) && ((b[0]-w) == b[z]) || ((b[0]-w) == y[z])) {
//			            	return true;
//			            }
//					}
//				}
//			}
//			return false;
//		}
		
		/**
		 * 
		 */
	    private void checkCollision() {
	        for (int z = 1; z < length; z++) {
	            if ((z > 4) && ((x[0] == x[z]) && (y[0] == y[z])) || ((a[0] == a[z]) && (b[0] == b[z]))) {
	            	model.setGameState(GameState.END_GAME);
	                inGame = false;
	            }
	            else if (((x[0] == a[z]) && (y[0] == b[z])) || ((a[0] == x[z]) && (b[0] == y[z])) || ((x[0] == a[0]) && (y[0] == b[0])) || ((a[0] == x[0]) && (b[0] == y[0]))){
	            	model.setGameState(GameState.END_GAME);
	            	inGame = false;
	            }
	        }
	        if ((y[0] >= frameSizeY) || (b[0] >= frameSizeY)) {
	        	model.setGameState(GameState.END_GAME);
	            inGame = false;
	        }
	        else if ((y[0] < 0) || (b[0] < 0)) {
	        	model.setGameState(GameState.END_GAME);
	            inGame = false;
	        }
	        else if ((x[0] >= frameSizeX) || (a[0] >= frameSizeX)) {
	        	model.setGameState(GameState.END_GAME);
	            inGame = false;
	        }
	        else if ((x[0] < 0) || (a[0] < 0)) {
	        	model.setGameState(GameState.END_GAME);
	            inGame = false;
	        }
	        if(!inGame) {
	            timer.stop();
	        }
	    }

	    /**
	     * 
	     */
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (inGame) {
	            length++;
	            checkCollision();
	            aiMove();
	            move();
	        }
	        repaint();
	    }

	    /**
	     * 
	     * @author Tian Guo, Xin Tong Hu
	     *
	     */
	    private class TAdapter extends KeyAdapter {
	        @Override
	        public void keyPressed(KeyEvent e) {
	            int key = e.getKeyCode();
	            if ((key == KeyEvent.VK_LEFT) && (!right)) {
	                left = true;
	                up = false;
	                down = false;
	            }
	            else if ((key == KeyEvent.VK_RIGHT) && (!left)) {
	                right = true;
	                up = false;
	                down = false;
	            }
	            else if ((key == KeyEvent.VK_UP) && (!down)) {
	                up = true;
	                right = false;
	                left = false;
	            }
	            else if ((key == KeyEvent.VK_DOWN) && (!up)) {
	                down = true;
	                right = false;
	                left = false;
	            }
	            if (key == KeyEvent.VK_ESCAPE && runGame) {
	            	runGame = false;
	            	if(inGame){
		            	System.out.println("exit");
		            	clearAll();
	            	}
	            	else {
	            		System.exit(0);
	            	}
	            }
	            if ((key == KeyEvent.VK_ENTER) && (!inGame) && runGame) {
	            	runGame = false;
	            	clearGame();
	            }
	        }
	    }
	}
}