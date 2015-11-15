package Snakish;
import java.awt.Color;

/**
 * This class manages the data, logic and rules of the game.
 * @author Tian Guo, Xin Tong Hu
 *
 */
public class SnakishModel {
	
	public enum GameState {
		NEW_GAME, ABOUT, EXIT, IN_PROGRESS, END_GAME
	}
	
	public enum PlayingState {
		GAME_WIN
	}
	
	private Color pcColor = Color.RED;
	private Color playerColor = Color.BLUE;
	private GameState gameState = null;
	private PlayingState playingState = null;
	private int dir1,dir2;
	private int unoccupied = 0;	// empty slot
	private int player = 1;
	private int pc = 2;
	public int up = 1;
	public int right = 2;
	public int down = 3;
	public int left = 4;
	
	public int x1 = 50;
	public int y1 = 300;
	public int x2 = 550;
	public int y2 = 300;
	public Snake game = new Snake(x1, y1, dir1, player);
	
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
	
	public void move(int i, int j) { // i is direction of movement, j represents either player or AI
		if (j == player) {
			dir1 = i;
		}
		else {
			dir2 = i;
		}
	}
	
	public void updateMove(int player) {
		if (player == 1) {
			switch (dir1) {
			case 1: if (IsCollision(game.x-1, game.y)) {
						game.body[game.x-1][game.y] = player;
			}
				break;
			case 2: if (IsCollision(game.x, game.y+1)) {
					game.body[game.x][game.y+1] = player;
			}
				break;
			case 3: if (IsCollision(game.x+1, game.y)) {
					game.body[game.x+1][game.y] = player;
			}
				break;
			case 4: if (IsCollision(game.x, game.y-1)) {
					game.body[game.x][game.y-1] = player;
			}
				break;
			default: break;
			}
		}
	}
	
	/**
	 * Checks if there is a collision, return true if there is, else false.
	 * @return boolean
	 */
	public boolean IsCollision(int x, int y) {
		if (x < 0 | x > 60 | y < 0 | y > 60) {	// checks if the snake crashes into the wall
			return true;
		}
		else if (game.body[x][y] != 0) {		// checks if the snake crashes into itself or enemy
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the current game state
	 * @return GameState
	 */
	public GameState getGameState() {
		return gameState;
	}
}