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
	
	private Color pcColor = Color.RED;
	private Color playerColor = Color.BLUE;
	private GameState gameState = null;
	private PlayingState playingState = null;
	private int dir1,dir2;
	private int unoccupied = 0;	// empty slot
	private int player = 1;
	private int pc = 2;
	public Snake game = new Snake();
	
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
	
	public void move(int i, int j) { // i is direction of movement, j represents either player or AI
		if (j == 1) {
			dir1 = i;
		}
		else {
			dir2 = i;
		}
	}
	
	public void updateMove(int player) {
		if (player == 1) {
			switch (dir1) {
			case 1: IsCollision(game.x-1, game.y);
					game.body[game.x-1][game.y] = player;
				break;
			case 2: IsCollision(game.x, game.y+1);
					game.body[game.x][game.y+1] = player;
				break;
			case 3: IsCollision(game.x+1, game.y);
					game.body[game.x+1][game.y] = player;
				break;
			case 4: IsCollision(game.x, game.y-1);
					game.body[game.x][game.y-1] = player;
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
		else if (game.body[x][y] != 0) {				// checks if the snake crashes into itself or enemy
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