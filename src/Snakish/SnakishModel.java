package Snakish;

import java.awt.Color;
import java.awt.Graphics;
import Snakish.SnakishController;
import Snakish.SnakishView;

/**
 * This class manages the data, logic and rules of the game.
 * @author Tian Guo, Xin Tong Hu
 *
 */
public class SnakishModel {
	
	public enum GameState {
		TITLE_PAGE, NEW_GAME, DEMO, ABOUT, EXIT, IN_PROGRESS, END_GAME
	}
	
	public enum PlayingState {
		PLAYER_WIN, PC_WIN
	}
	
	private Color pcColor = Color.RED;
	private Color playerColor = Color.BLUE;
	
	private GameState gameState = null;
	private PlayingState playingState = null;
	
	int dir1;
	private int dir2;
	private int unoccupied = 0;	// empty slot
	private int player = 1;
	private int pc = 2;
	
	String name;							// Player's name
	boolean playerExists;
	private boolean demo;
	
	public int up = 1;
	public int right = 2;
	public int down = 3;
	public int left = 4;
	
	public int x1 = 50;
	public int y1 = 300;
	public int x2 = 550;
	public int y2 = 300;
	
	public int w = 60;
	
	public Snake snakes[]=new Snake[2];
	public Snake playerSnake;
	
	/**
	 * Constructor
	 */
	public SnakishModel() {
		
	}
	
	/**
	 * Checks whether the snake's move is legal, return false if illegal, else true.
	 * @param n
	 * @return boolean
	 */
	
	public boolean verifyLegalMove(int n) {
		if (n == up & dir1 == down) {
			return false;
		}
		else if (n == right & dir1 == left) {
			return false;
		}
		else if (n == down & dir1 == up) {
			return false;
		}
		else if (n == left & dir1 == right) {
			return false;
		}
		return true;
	}
	
	public void gameBegin(int dire1, int dire2) {
		setGameState(GameState.IN_PROGRESS);
		dir1 = dire1;
		dir2 = dire2;
	}
	
	public void move(int i, int j) { // i is direction of movement, j represents either player or AI
		if (j == player) {
			dir1 = i;
		}
		else {
			dir2 = i;
		}
	}
	
	public void updateMove(int dire1, int dire2) {
//		if (player == 1) {
//			switch (dir1) {
//			case 1: if (IsCollision(game.x-1, game.y)) {
//						game.body[game.x-1][game.y] = player;
//			}
//				break;
//			case 2: if (IsCollision(game.x, game.y+1)) {
//					game.body[game.x][game.y+1] = player;
//			}
//				break;
//			case 3: if (IsCollision(game.x+1, game.y)) {
//					game.body[game.x+1][game.y] = player;
//			}
//				break;
//			case 4: if (IsCollision(game.x, game.y-1)) {
//					game.body[game.x][game.y-1] = player;
//			}
//				break;
//			default: break;
//			}
//		}
		snakes[0].move(dire1);
		snakes[1].move(dire2);
		if(snakes[0].checkCrashed()){
			setPlayingState(PlayingState.PLAYER_WIN);
		}
		else if(snakes[1].checkCrashed()){
			setPlayingState(PlayingState.PC_WIN);
		}
	}
	
	/**
	 * Checks if there is a collision, return true if there is, else false.
	 * @return boolean
	 */
//	public boolean IsCollision(int x, int y) {
//		if (x < 0 | x > 60 | y < 0 | y > 60) {	// checks if the snake crashes into the wall
//			return true;
//		}
//		else if (game.body[x][y] != 0) {		// checks if the snake crashes into itself or enemy
//			return true;
//		}
//		return false;
//	}
	
	void start(){
		snakes[0] = new Snake(x1, y1, right, player);
		snakes[1] = new Snake(x2, y2, left, pc);
		snakes[0].setOther(snakes[1]);
		snakes[1].setOther(snakes[0]);
		demo = false;
	}
	

	public void player(SnakishController controller) {
		name = controller.tfName.getName();
		if (name.length() == 0) {
			name = "Unknown";
		}
		playerExists = true;
		start();
		playerSnake = snakes[0];
		playerSnake.setPc(false);
		playerSnake.enemy.setPc(true);
		playerSnake.name = name;
		playerSnake.enemy.name="PC";
		controller.clear();
//		requestFocus();
		setGameState(gameState.NEW_GAME);
	}
	
	public void paint(Graphics g) {
		for (int i = 0; i < 60; i++){
			for (int j = 0; j < 60; j++){
				if (snakes[0].body[i][j] != 0) {
					g.setColor(Color.RED);
					g.drawRect(i*w, j*w, w,w);
					g.fillRect(i*w, j*w, w,w);
				}
			}
		}
	}
	

	/**
	 * Returns the current game state
	 * @return GameState
	 */
	public GameState getGameState() {
		return gameState;
	}
	
	public void setGameState(GameState gs) {
		gameState = gs;
	}
	
	public PlayingState getPlayingState() {
		return playingState;
	}
	
	public void setPlayingState(PlayingState ps) {
		playingState = ps;
	}
}