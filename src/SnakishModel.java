import java.awt.Color;

public class SnakishModel {
	
	public enum GameState {
		NEW_GAME, END_GAME
	}
	
//	public enum PlayerState {
//		PLAYER_ONE_TURN, PLAYER_TWO_TURN
//	}
	
	public enum PlayingState {
		GAME_WIN
	}
	
	private Color pcColor = Color.red;
	private Color playerColor = Color.blue;
	private GameState gameState = null;
	private PlayingState playingState = null;
	
	/**
	 * Constructor
	 */
	public SnakishModel() {
		
	}
	
	/**
	 * Checks whether the snake's move is legal, return false if illegal, else true.
	 * @return boolean
	 */
	public boolean verifyLegalMove() {
		return false;
	}
	
	public void move() {
		
	}
	
	public void updateMove() {
		
	}
	
	/**
	 * Checks if there is a collision, return true if there is, else false.
	 * @return Boolean
	 */
	public boolean collision() {
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
