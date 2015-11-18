//package Snakish;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.FontMetrics;
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//
//import javax.swing.ImageIcon;
//import javax.swing.JPanel;
//import javax.swing.Timer;
//
//import Snakish.SnakishModel.GameState;
//import Snakish.SnakishModel.PlayingState;
//
//public class Snake extends JPanel implements ActionListener {
//	private SnakishModel model;
//    private final int frameSizeX = 600;
//    private final int frameSizeY = 600;
//    private final int w = 10;
//    private final int maxSize = 1800;
//    private final int DELAY = 40;
//
//    private final int x[] = new int[maxSize];
//    private final int y[] = new int[maxSize];
//    private final int a[] = new int[maxSize];
//    private final int b[] = new int[maxSize];
//    
//    private int length;
//
//    private boolean left = false;
//    private boolean right = false;
//    private boolean up = false;
//    private boolean down = true;
//    private boolean inGame = true;
//
//    private Timer timer;
//    private Image player;
//    private Image AI;
//    private Image head;
//
//    public Snake(SnakishModel model) {
////        addKeyListener(new TAdapter());
//        setFocusable(true);
//        this.model = model;
//        setPreferredSize(new Dimension(frameSizeX, frameSizeY));
//        loadImages();
//        initGame();
//    }
//
//    private void loadImages() {
//        ImageIcon iip = new ImageIcon("src/player.png");
//        player = iip.getImage();
//
//        ImageIcon iia = new ImageIcon("src/pc.png");
//        AI = iia.getImage();
//
//        ImageIcon iih = new ImageIcon("src/head.png");
//        head = iih.getImage();
//    }
//
//    private void initGame() {
////    	addKeyListener(new TAdapter());
//        x[0] = model.x1;
//        y[0] = model.y1;
//        a[0] = model.x2;
//        b[0] = model.y2;
//        
//        timer = new Timer(DELAY, this);
//    	addKeyListener(new TAdapter());
//        if (left == true || right == true || up == true || down == true) {
//        	timer.start();
//        }
//    }
//
//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        doDrawing(g);
//    }
//    
//    private void doDrawing(Graphics g) {
//        if (inGame) {
//            for (int z = 0; z < length; z++) {
//                if (z == 0) {
//                    g.drawImage(head, x[z], y[z], this);
//                } else {
//                    g.drawImage(player, x[z], y[z], this);
//                }
//            }
//            for (int z = 0; z < length; z++) {
//                if (z == 0) {
//                    g.drawImage(head, a[z], b[z], this);
//                } else {
//                    g.drawImage(AI, a[z], b[z], this);
//                }
//            }
//            Toolkit.getDefaultToolkit().sync();
//        }
//        else {
//            gameOver(g);
//        }        
//    }
//
//    private void gameOver(Graphics g) {
//        String msg = "Game Over";
//        Font small = new Font("Helvetica", Font.BOLD, 14);
//        FontMetrics metr = getFontMetrics(small);
//
//        g.setColor(Color.white);
//        g.setFont(small);
//        g.drawString(msg, (frameSizeX - metr.stringWidth(msg)) / 2, frameSizeY / 2);
//    }
//
//    private void move() {
//
//        for (int z = length; z > 0; z--) {
//            x[z] = x[(z - 1)];
//            y[z] = y[(z - 1)];
//            a[z] = a[(z - 1)];
//            b[z] = b[(z - 1)];
//        }
//
//        if (left) {
//            x[0] += w;
//            a[0] -= w;
//        }
//
//        if (right) {
//            x[0] += w;
//            a[0] += w;
//        }
//
//        if (up) {
////            y[0] -= w;
//        	x[0] += w;
//            b[0] -= w;
//        }
//
//        if (down) {
////            y[0] += w;
//        	x[0] += w;
//            b[0] += w;
//        }
//    }
//
//    private void checkCollision() {
//
//        for (int z = 1; z < length; z++) {
//            if ((z > 4) && ((x[0] == x[z]) && (y[0] == y[z])) || ((a[0] == a[z]) && (b[0] == b[z]))) {
//                inGame = false;
//            }
//            else if (((x[0] == a[z]) && (y[0] == b[z])) || ((a[0] == x[z]) && (b[0] == y[z])) || ((x[0] == a[0]) && (y[0] == b[0])) || ((a[0] == x[0]) && (b[0] == y[0]))){
//            	inGame = false;
//            }
//        }
//        if ((y[0] >= frameSizeY) || (b[0] >= frameSizeY)) {
//            inGame = false;
//        }
//        else if ((y[0] < 0) || (b[0] < 0)) {
//            inGame = false;
//        }
//        else if ((x[0] >= frameSizeX) || (a[0] >= frameSizeX)) {
//            inGame = false;
//        }
//        else if ((x[0] < 0) || (a[0] < 0)) {
//            inGame = false;
//        }
//        if(!inGame) {
//            timer.stop();
//        }
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//        if (inGame) {
//
//            length++;
//            checkCollision();
//            move();
//        }
//
//        repaint();
//    }
//
//    private class TAdapter extends KeyAdapter {
//
//        @Override
//        public void keyPressed(KeyEvent e) {
//
//            int key = e.getKeyCode();
//
//            if ((key == KeyEvent.VK_LEFT) && (!right)) {
//                left = true;
//                up = false;
//                down = false;
//            }
//
//            if ((key == KeyEvent.VK_RIGHT) && (!left)) {
//                right = true;
//                up = false;
//                down = false;
//            }
//
//            if ((key == KeyEvent.VK_UP) && (!down)) {
//                up = true;
//                right = false;
//                left = false;
//            }
//
//            if ((key == KeyEvent.VK_DOWN) && (!up)) {
//                down = true;
//                right = false;
//                left = false;
//            }
//        }
//    }
//}
////import java.awt.Color;
////
////import javax.swing.Timer;
////
////import Snakish.SnakishModel.GameState;;
////
/////**
//// * 
//// * @author Tian Guo, Xin Tong Hu
//// *
//// */
////public class Snake {
////	private int frameSizeX = 600;										// x size of the frame
////	private int frameSizeY = 600;										// y size of the frame
////	public int w = 10;													// width of the frame
////	
////	final int x[] = new int[frameSizeX/w];
////    final int y[] = new int[frameSizeY/w];
////
////    int length;
////    
////    public boolean up, down, left, right;
////    public boolean endGame;
////    
////    Timer timer;
////    
////	Color color;
////	int[][] body;
////	int unoccupied = 0;
////	int player;
////	String name;
////	boolean isCrashed;
////	private boolean pc;
////	Snake enemy;
//////	// 4 directions
//////	int up = 1;
//////	int right = 2;
//////	int down = 3;
//////	int left = 4;
//////	// direction of the snake
//////	private int direction;
//////	// initial position of the snake
//////	int x, y;
//////	// width of the board
//////	private int w = 60;
////	
////	
////	/**
////	 * Constructor, initializes the snake.
////	 */
////	public Snake(int x, int y, int Direction, int Player) {
//////		body = new int [w][w];
//////		player = Player;
//////		isCrashed = false;
//////		this.x = x;
//////		this.y = y;
//////		direction = Direction;
////	}
////	
////    private void move() {
////        for (int z = length; z > 0; z--) {
////            x[z] = x[(z - 1)];
////            y[z] = y[(z - 1)];
////        }
////        if (left) {
////            x[0] -= w;
////        }
////        else if (right) {
////            x[0] += w;
////        }
////        else if (up) {
////            y[0] -= w;
////        }
////        else if (down) {
////            y[0] += w;
////        }
////    }
////    
////    private void checkCollision() {
////    	for (int z = length; z > 0; z--) {
////            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
////                endGame = true;
////            }
////        }
////    	if (y[0] >= frameSizeY) {
////    		endGame = true;
////        }
////    	else if (y[0] < 0) {
////    		endGame = true;
////        }
////    	else if (x[0] >= frameSizeX) {
////    		endGame = true;
////        }
////    	else if (x[0] < 0) {
////    		endGame = true;
////        }
////        if (endGame) {
////            timer.stop();
////        }
////    }
////    
////    private boolean getGameStatus() {
////    	return endGame;
////    }
////	
//////	/**
//////	 * Captures the snake's movement.
//////	 * @param dir
//////	 * @param player
//////	 */
//////	//public void move(int dir, int player) {
//////	public void move(int dir) {
//////		//update(dir, player);
//////		if (verifyLegalMove(dir)){
//////			update(dir);
//////		}
//////		else {
//////			update(direction);
//////		}
//////	}
//////	
//////	/**
//////	 * Checks whether the snake's move is legal, return false if illegal, else true.
//////	 * @param n
//////	 * @return boolean
//////	 */
//////	public boolean verifyLegalMove(int n) {
//////		if (n == up & direction == down) {
//////			return false;
//////		}
//////		else if (n == right & direction == left) {
//////			return false;
//////		}
//////		else if (n == down & direction == up) {
//////			return false;
//////		}
//////		else if (n == left & direction == right) {
//////			return false;
//////		}
//////		return true;
//////	}
//////	
//////	/**
//////	 * Updates the position of the snake.
//////	 * @param dir
//////	 * @param player
//////	 */
//////	//public void update(int dir, int player) {
//////	public void update(int dir) {
//////		switch (direction) {
//////			case 1: crashStatus(x, y-1);
//////					body[x][y-1] = player;
//////				break;
//////			case 2: crashStatus(x, y+1);
//////					body[x][y+1] = player;
//////				break;
//////			case 3: crashStatus(x+1, y);
//////					body[x+1][y] = player;
//////				break;
//////			case 4: crashStatus(x, y-1);
//////					body[x][y-1] = player;
//////				break;
//////			default: break;
//////		}
//////	}
//////	
//////	/**
//////	 * Checks if the position of the head overlaps with other things.
//////	 * @return boolean
//////	 */
//////	public void crashStatus(int x, int y) {
//////		if (x < 0 | x > 60 | y < 0 | y > 60) {	// checks if the snake crashes into the wall
//////			isCrashed = true;
//////		}
//////		else if (body[x][y] != 0 || enemy.body[x][y] != 0) {				// checks if the snake crashes into itself or enemy
//////			isCrashed = true;
//////		}
//////	}
//////	
//////	/**
//////	 * 
//////	 * @return
//////	 */
//////	public boolean checkCrashed() {
//////		return isCrashed;
//////	}
//////	
//////	/**
//////	 * 
//////	 * @param bool
//////	 */
//////	public void setPc(boolean bool){
//////		pc = bool;
//////	}
//////	
//////	/**
//////	 * 
//////	 * @param enemy
//////	 */
//////	public void setOther(Snake enemy){
//////		this.enemy = enemy;
//////	}
////}