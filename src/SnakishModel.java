import java.awt.Color;

/**
 * This class manages the data, logic and rules of the game.
 * @author Tian Guo, Xin Tong Hu
 *
 */
public class SnakishModel {
	
	public enum GameState {
		NEW_GAME, END_GAME
	}
	
	public enum PlayingState {
		GAME_WIN
	}
	
	private Color pcColor = Color.red;
	private Color playerColor = Color.blue;
	private GameState gameState = null;
	private PlayingState playingState = null;
	private int dir1,dir2;
	
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
		if (n == 1 & dir1 == 3) {
			return false;
		}
		else if (n == 2 & dir1 == 4) {
			return false;
		}
		else if (n == 3 & dir1 == 1) {
			return false;
		}
		else if (n == 4 & dir1 == 2) {
			return false;
		}
		return true;
	}
	
	public void move() {
		
	}
	
	public void updateMove() {
		
	}
	
	/**
	 * Checks if there is a collision, return true if there is, else false.
	 * @return boolean
	 */
	public boolean collision() {
		return false;
	}
	
	/**
	 * Returns the current game state.
	 * @return GameState
	 */
	public GameState getGameState() {
		return gameState;
	}
}
