package Snakish;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

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

	private int frameSizeX = 600; // x size of the frame
	private int frameSizeY = 600; // y size of the frame
	private String msg;

	String name; // Player's name

	JTextField tfName = new JTextField("Name"); // textfield for the
												// player to enter name
	private JButton btnSG = new JButton("Start Game"); // start game button
	private JButton btnA = new JButton("About"); // about button
	private JButton btnE = new JButton("Exit"); // exit button
	private JPanel menuPanel = new JPanel(); // JPanel for menu
	private JFrame frame; // The frame of the name
	private JTextPane Text = new JTextPane(); // JTextPane to display text
	private Snake s;

	/**
	 * Constructor for SnakishController.
	 * 
	 * @param model
	 *            : the model it uses
	 * @param view
	 *            : the view it uses
	 */
	public SnakishController(SnakishModel model, SnakishView view) {
		this.model = model;
		this.view = view;
		initialize();
	}

	/**
	 * initializes main menu
	 */
	public void initialize() {
		frame = view.frame;
		initializeMenu();
	}

	/**
	 * creates buttons and textfield for main menu
	 */
	private void initializeMenu() {
		model.setGameState(GameState.TITLE_PAGE);
		btnSG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setGameState(GameState.NEW_GAME);
				view.remakeJFrame();
				startGame();
			}
		});

		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setGameState(GameState.ABOUT);
				clear();
				about();
			}
		});

		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (model.getGameState() == GameState.ABOUT) {
					clear();
					frame.remove(menuPanel);
					menuPanel = new JPanel();
					initializeMenu();
				} else if (model.getGameState() == GameState.TITLE_PAGE) {
					System.exit(0);
				}
			}
		});
		tfName.setBounds(frameSizeX / 2 - 60, 200, 120, 30); // location of the
																// textfield
		tfName.setEditable(true); // should be editable for player to enter name
		menuPanel.add(tfName);
		btnSG.setBounds(tfName.getX(), tfName.getY() + 40, 120, 30); // location
																		// of
																		// the
																		// button
		menuPanel.add(btnSG);
		btnA.setBounds(tfName.getX(), tfName.getY() + 40 * 2, 120, 30); // location
																		// of
																		// the
																		// button
		menuPanel.add(btnA);
		btnE.setBounds(tfName.getX(), tfName.getY() + 40 * 3, 120, 30); // location
																		// of
																		// the
																		// button
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
//		setDoubleBuffered(true);
		model.setGameState(GameState.IN_PROGRESS);
		name = tfName.getText();
		if (name.equals("Name")) {
			name = "Player";
		}
		clear();
		frame.remove(menuPanel);
//		menuPanel.setVisible(false);
		frame.setVisible(false);
		frame.dispose();
//		view.remakeJFrame();
//		view.getJFrame();
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
		btnE.setBounds(tfName.getX(), tfName.getY() + 40 * 3, 120, 30);
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

	/**
	 * 
	 */
	void clearAll() {
		frame.setVisible(false);
		frame.remove(s);
		frame = new JFrame();
		initialize();
	}

	/**
	 * 
	 */
	void clearGame() {
		frame.setVisible(false);
		frame.remove(s);
		frame.dispose();
		startGame();
	}

	// public void run(){
	// long time,temp,max = 40;
	// while(true) {
	// time = System.currentTimeMillis();
	// update();
	// // point();
	// temp = System.currentTimeMillis() - time;
	// time = max - temp;
	// try{
	// if (time > 0) Thread.sleep(time);
	// }catch(Exception e){}
	// }
	// }

	// public void update() {
	// if (model.getGameState() == GameState.TITLE_PAGE) {
	// model.counter++;
	// if(model.counter==500){
	// model.counter=0;
	// model.setGameState(GameState.DEMO);
	// demo();
	// }
	// }
	// }

	// private void demo(){
	// model.start();
	// model.demo=true;
	// model.snakes[0].setPc(true);
	// model.snakes[1].setPc(true);
	// clear();
	// }

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
		Text.setEditable(false);
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
		private boolean right = true;
		private boolean up = false;
		private boolean down = false;
		private int leftAI = 2;
		private int rightAI = 3;
		private int upAI = 0;
		private int downAI = 1;
		private boolean ai[] = new boolean[4];
		private boolean picked;

		private Timer timer;
		private Image player;
		private Image AI;
		private Image head;

		/**
		 * 
		 */
		public Snake() {
			setFocusable(true);
			setPreferredSize(new Dimension(frameSizeX, frameSizeY));
			loadImages();
			initGame();
		}

		/**
		 * 
		 */
		private void loadImages() {
			ImageIcon iip = new ImageIcon("src/player.png");
			player = iip.getImage();

			ImageIcon iia = new ImageIcon("src/pc.png");
			AI = iia.getImage();

			ImageIcon iih = new ImageIcon("src/head.png");
			head = iih.getImage();
		}

		/**
		 * 
		 */
		private void initGame() {
			x[0] = model.x1;
			y[0] = model.y1;
			a[0] = model.x2;
			b[0] = model.y2;

			ai[2] = true;

			timer = new Timer(DELAY, this);
			addKeyListener(new TAdapter());
			model.setGameState(GameState.IN_PROGRESS);
			model.setPlayingState(null);
			if (left == true || right == true || up == true || down == true) {
				timer.start();
			}
		}

		/**
		 * 
		 */
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			doDrawing(g);
		}

		/**
		 * 
		 * @param g
		 */
		private void doDrawing(Graphics g) {
			if (model.getGameState() == GameState.IN_PROGRESS) {
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
			} else {
				gameOver(g);
			}
		}

		/**
		 * 
		 * @param g
		 * @param text
		 * @param x
		 * @param y
		 */
		private void drawString(Graphics g, String text, int x, int y) {
			for (String line : text.split("\n"))
				g.drawString(line, x, y += g.getFontMetrics().getHeight());
		}

		/**
		 * 
		 * @param g
		 */
		private void gameOver(Graphics g) {
			model.setGameState(GameState.END_GAME);
			if (model.getPlayingState() == PlayingState.PLAYER_WIN) {
				msg = name
						+ " wins!\nPress ESC to exit\nPress ENTER to restart";
			} else if (model.getPlayingState() == PlayingState.PC_WIN) {
				msg = "PC wins!\nPress ESC to exit\nPress ENTER to restart";
			} else if (model.getPlayingState() == PlayingState.TIE) {
				msg = "Tie!\n Press ESC to exit\nPress ENTER to restart";
			}
			// g.dispose();
			// endGame();
			drawString(g, msg, tfName.getX(), tfName.getY());
		}

		/**
		 * 
		 * @param x
		 *            : x coordinate of the head of the snake
		 * @param y
		 *            : y coordinate of the head of the snake
		 * @param direction
		 *            : an array of boolean representing the move-able
		 *            directions
		 * @return
		 */
		public void determineMove(int xi, int yi) {
			freeMoves();
			if ((yi - w < 0) || ((xi == x[0]) && (yi - w == y[0]))) {
				ai[upAI] = false;
			}
			if ((yi + w > frameSizeY - 30) || ((xi == x[0]) && (yi + w == y[0]))) {
				ai[downAI] = false;
			}
			if ((xi - w <= 0) || ((xi - w == x[0]) && (yi == y[0]))) {
				ai[leftAI] = false;
			}
			if ((xi + w > frameSizeX - 30) || ((xi + w == x[0]) && (yi == y[0]))) {
				ai[rightAI] = false;
			}

			for (int i = 1; i < maxSize; i++) {
				if (((xi == x[i]) && (yi - w == y[i]))
						|| ((xi == a[i]) && (yi - w == b[i]))) {
					ai[upAI] = false;
				}
				if (((xi == x[i]) && (yi + w == y[i]))
						|| ((xi == a[i]) && (yi + w == b[i]))) {
					ai[downAI] = false;
				}
				if (((xi - w == x[i]) && (yi == y[i]))
						|| ((xi - w == a[i]) && (yi == b[i]))) {
					ai[leftAI] = false;
				}
				if (((xi + w == x[i]) && (yi == y[i]))
						|| ((xi + w == a[i]) && (yi == b[i]))) {
					ai[rightAI] = false;
				}
			}
		}

		/**
		 * 
		 */
		public void freeMoves() {
			if (ai[upAI] == true) {
				ai[downAI] = false;
				ai[leftAI] = true;
				ai[rightAI] = true;
			} else if (ai[downAI] == true) {
				ai[upAI] = false;
				ai[leftAI] = true;
				ai[rightAI] = true;
			} else if (ai[leftAI] == true) {
				ai[rightAI] = false;
				ai[upAI] = true;
				ai[downAI] = true;
			} else {
				ai[leftAI] = false;
				ai[upAI] = true;
				ai[downAI] = true;
			}
		}

		/**
		 * 
		 */
		public void generateMove() {
			int lastMove = 0;
			for (int i = 0; i < 4; i++) {
				if (ai[i] == true) {
					lastMove = i;
					break;
				}
			}
			determineMove(a[0], b[0]);
			if (!ai[lastMove]) {
				aiMakeMove();
			}
			else {
				for(int i = 0; i < 4; i++) {
					if (i!=lastMove){
						ai[i] = false;
					}
				}
			}
		}

		/**
		 * 
		 */
		public void aiMakeMove() {
//			picked = false;
			boolean temp = true;
			Random rnd = new Random();
			int j;
			while(temp) {
				j = rnd.nextInt(ai.length);
				if (ai[j]) {
					for(int i = 0; i < 4; i++) {
						if (i!=j){
							ai[i] = false;
						}
					}
				}
				temp = false;
			}
			// picked = false;
		}

		/**
		 * 
		 */
		private void move() {
			generateMove();
			for (int z = length; z > 0; z--) {
				x[z] = x[(z - 1)];
				y[z] = y[(z - 1)];
				a[z] = a[(z - 1)];
				b[z] = b[(z - 1)];
			}
			if (left) {
				x[0] -= w;
			} else if (right) {
				x[0] += w;
			} else if (up) {
				y[0] -= w;
			} else if (down) {
				y[0] += w;
			}
			if (ai[leftAI]) {
				a[0] -= w;
			} else if (ai[rightAI]) {
				a[0] += w;
			} else if (ai[upAI]) {
				b[0] -= w;
			} else if (ai[downAI]) {
				b[0] += w;
			}
		}

		/**
		 * 
		 */
		private void checkCollision() {
			for (int z = 1; z < length; z++) {
				if (((z > 4) && (x[0] == x[z]) && (y[0] == y[z]))
						|| ((x[0] == a[z]) && (y[0] == b[z]))) {
					model.setGameState(GameState.END_GAME);
					model.setPlayingState(PlayingState.PC_WIN);
				} else if (((z > 4) && (a[0] == a[z]) && (b[0] == b[z]))
						|| ((a[0] == x[z]) && (b[0] == y[z]))) {
					model.setGameState(GameState.END_GAME);
					model.setPlayingState(PlayingState.PLAYER_WIN);
				} else if (((x[0] == a[0]) && (y[0] == b[0]))
						|| ((a[0] == x[0]) && (b[0] == y[0]))) {
					model.setGameState(GameState.END_GAME);
					model.setPlayingState(PlayingState.TIE);
				}
			}
			if ((x[0] > frameSizeX - w) || (y[0] > frameSizeY - 30)
					|| (x[0] < -w) || (y[0] < -w)) {
				model.setGameState(GameState.END_GAME);
				model.setPlayingState(PlayingState.PC_WIN);
			} else if ((a[0] > frameSizeX - w) || (b[0] > frameSizeY - 30)
					|| (a[0] < -w) || (b[0] < -w)) {
				model.setGameState(GameState.END_GAME);
				model.setPlayingState(PlayingState.PLAYER_WIN);
			}
			if (model.getGameState() == GameState.END_GAME) {
				timer.stop();
			}
		}

		/**
	     * 
	     */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (model.getPlayingState() == null) {
				length++;
				checkCollision();
				move();
			}
			repaint();
			setDoubleBuffered(true);
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
				} else if ((key == KeyEvent.VK_RIGHT) && (!left)) {
					right = true;
					up = false;
					down = false;
				} else if ((key == KeyEvent.VK_UP) && (!down)) {
					up = true;
					right = false;
					left = false;
				} else if ((key == KeyEvent.VK_DOWN) && (!up)) {
					down = true;
					right = false;
					left = false;
				}
				if (key == KeyEvent.VK_ESCAPE) {
					// && runGame) {
					// runGame = false;
					if (model.getGameState() == GameState.IN_PROGRESS) {
						clearAll();
					} else {
						System.exit(0);
					}
				}
				if ((key == KeyEvent.VK_ENTER)
						&& (model.getGameState() == GameState.END_GAME)) {
					// && runGame) {
					// runGame = false;
					clearGame();
				}
			}
		}
	}
}