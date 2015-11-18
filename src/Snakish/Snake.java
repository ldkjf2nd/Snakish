package Snakish;

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
import javax.swing.JPanel;
import javax.swing.Timer;


public class Snake extends JPanel implements ActionListener {

    private final int B_WIDTH = 600;
    private final int B_HEIGHT = 600;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 1800;
    private final int RAND_POS = 29;
    private final int DELAY = 140;

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];
    private final int a[] = new int[ALL_DOTS];
    private final int b[] = new int[ALL_DOTS];
    
    private int length;
    private int apple_x;
    private int apple_y;

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;
    private Image player;
    private Image AI;
    private Image head;

    public Snake() {

        addKeyListener(new TAdapter());
//        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
    }

    private void loadImages() {

        ImageIcon iid = new ImageIcon("src/player.png");
        player = iid.getImage();

        ImageIcon iia = new ImageIcon("src/pc.png");
        AI = iia.getImage();

        ImageIcon iih = new ImageIcon("src/head.png");
        head = iih.getImage();
    }

    private void initGame() {

        length = 1;

        for (int z = 0; z < length; z++) {
            x[z] = 50 - z * 10;
            y[z] = 400;
            a[z] = 350 - z *10;
            b[z] = 200;
        }

//        locateApple();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        
        if (inGame) {

//            g.drawImage(AI, apple_x, apple_y, this);

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

    private void gameOver(Graphics g) {
        
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
    }

    private void increment() {

           length++;
    }

    private void move() {

        for (int z = length; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
            a[z] = a[(z - 1)];
            b[z] = b[(z - 1)];
        }

        if (leftDirection) {
            x[0] += DOT_SIZE;
            a[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
            a[0] += DOT_SIZE;
        }

        if (upDirection) {
//            y[0] -= DOT_SIZE;
        	x[0] += DOT_SIZE;
            b[0] -= DOT_SIZE;
        }

        if (downDirection) {
//            y[0] += DOT_SIZE;
        	x[0] += DOT_SIZE;
            b[0] += DOT_SIZE;
        }
    }

    private void checkCollision() {

        for (int z = length; z > 0; z--) {

            if ((z > 4) && ((x[0] == x[z]) && (y[0] == y[z])) || ((a[0] == a[z]) && (b[0] == b[z]))) {
                inGame = false;
            }
            if (((x[0] == a[z]) && (y[0] == y[z])) || ((a[0] == a[z]) && (b[0] == b[z])) || ((x[z] == a[z]) && (y[z] == b[z]))){
        
            }
        }

        if ((y[0] >= B_HEIGHT) || (b[0] >= B_HEIGHT)) {
            inGame = false;
        }

        if ((y[0] < 0) || (b[0] < 0)) {
            inGame = false;
        }

        if ((x[0] >= B_WIDTH) || (a[0] >= B_WIDTH)) {
            inGame = false;
        }

        if ((x[0] < 0) || (a[0] < 0)) {
            inGame = false;
        }
        
        if(!inGame) {
            timer.stop();
        }
    }

//    private void locateApple() {
//
//        int r = (int) (Math.random() * RAND_POS);
//        apple_x = ((r * DOT_SIZE));
//
//        r = (int) (Math.random() * RAND_POS);
//        apple_y = ((r * DOT_SIZE));
//    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {

            increment();
            checkCollision();
            move();
        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
        }
    }
}
//import java.awt.Color;
//
//import javax.swing.Timer;
//
//import Snakish.SnakishModel.GameState;;
//
///**
// * 
// * @author Tian Guo, Xin Tong Hu
// *
// */
//public class Snake {
//	private int frameSizeX = 600;										// x size of the frame
//	private int frameSizeY = 600;										// y size of the frame
//	public int w = 10;													// width of the frame
//	
//	final int x[] = new int[frameSizeX/w];
//    final int y[] = new int[frameSizeY/w];
//
//    int length;
//    
//    public boolean up, down, left, right;
//    public boolean endGame;
//    
//    Timer timer;
//    
//	Color color;
//	int[][] body;
//	int unoccupied = 0;
//	int player;
//	String name;
//	boolean isCrashed;
//	private boolean pc;
//	Snake enemy;
////	// 4 directions
////	int up = 1;
////	int right = 2;
////	int down = 3;
////	int left = 4;
////	// direction of the snake
////	private int direction;
////	// initial position of the snake
////	int x, y;
////	// width of the board
////	private int w = 60;
//	
//	
//	/**
//	 * Constructor, initializes the snake.
//	 */
//	public Snake(int x, int y, int Direction, int Player) {
////		body = new int [w][w];
////		player = Player;
////		isCrashed = false;
////		this.x = x;
////		this.y = y;
////		direction = Direction;
//	}
//	
//    private void move() {
//        for (int z = length; z > 0; z--) {
//            x[z] = x[(z - 1)];
//            y[z] = y[(z - 1)];
//        }
//        if (left) {
//            x[0] -= w;
//        }
//        else if (right) {
//            x[0] += w;
//        }
//        else if (up) {
//            y[0] -= w;
//        }
//        else if (down) {
//            y[0] += w;
//        }
//    }
//    
//    private void checkCollision() {
//    	for (int z = length; z > 0; z--) {
//            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
//                endGame = true;
//            }
//        }
//    	if (y[0] >= frameSizeY) {
//    		endGame = true;
//        }
//    	else if (y[0] < 0) {
//    		endGame = true;
//        }
//    	else if (x[0] >= frameSizeX) {
//    		endGame = true;
//        }
//    	else if (x[0] < 0) {
//    		endGame = true;
//        }
//        if (endGame) {
//            timer.stop();
//        }
//    }
//    
//    private boolean getGameStatus() {
//    	return endGame;
//    }
//	
////	/**
////	 * Captures the snake's movement.
////	 * @param dir
////	 * @param player
////	 */
////	//public void move(int dir, int player) {
////	public void move(int dir) {
////		//update(dir, player);
////		if (verifyLegalMove(dir)){
////			update(dir);
////		}
////		else {
////			update(direction);
////		}
////	}
////	
////	/**
////	 * Checks whether the snake's move is legal, return false if illegal, else true.
////	 * @param n
////	 * @return boolean
////	 */
////	public boolean verifyLegalMove(int n) {
////		if (n == up & direction == down) {
////			return false;
////		}
////		else if (n == right & direction == left) {
////			return false;
////		}
////		else if (n == down & direction == up) {
////			return false;
////		}
////		else if (n == left & direction == right) {
////			return false;
////		}
////		return true;
////	}
////	
////	/**
////	 * Updates the position of the snake.
////	 * @param dir
////	 * @param player
////	 */
////	//public void update(int dir, int player) {
////	public void update(int dir) {
////		switch (direction) {
////			case 1: crashStatus(x, y-1);
////					body[x][y-1] = player;
////				break;
////			case 2: crashStatus(x, y+1);
////					body[x][y+1] = player;
////				break;
////			case 3: crashStatus(x+1, y);
////					body[x+1][y] = player;
////				break;
////			case 4: crashStatus(x, y-1);
////					body[x][y-1] = player;
////				break;
////			default: break;
////		}
////	}
////	
////	/**
////	 * Checks if the position of the head overlaps with other things.
////	 * @return boolean
////	 */
////	public void crashStatus(int x, int y) {
////		if (x < 0 | x > 60 | y < 0 | y > 60) {	// checks if the snake crashes into the wall
////			isCrashed = true;
////		}
////		else if (body[x][y] != 0 || enemy.body[x][y] != 0) {				// checks if the snake crashes into itself or enemy
////			isCrashed = true;
////		}
////	}
////	
////	/**
////	 * 
////	 * @return
////	 */
////	public boolean checkCrashed() {
////		return isCrashed;
////	}
////	
////	/**
////	 * 
////	 * @param bool
////	 */
////	public void setPc(boolean bool){
////		pc = bool;
////	}
////	
////	/**
////	 * 
////	 * @param enemy
////	 */
////	public void setOther(Snake enemy){
////		this.enemy = enemy;
////	}
//}