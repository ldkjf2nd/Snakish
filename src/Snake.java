import java.awt.Color;

/**
 * 
 * @author Tian Guo, Xin Tong Hu
 *
 */
public class Snake {
	private int[][] body;
	private boolean isCrashed;
	private int direction;
	private int x = 1;// starting position will be changed later;
	private int y = 1;
	
	/**
	 * Constructor
	 */
	public Snake() {
		direction = 1;
		body = new int [x][y];
		direction = 1;
	}
	
	/**
	 * Captures the snake's movement.
	 * @param dir
	 * @param player
	 */
	public void move(int dir, int player) {
		direction = dir;
		update(dir, player);
	}
	
	/**
	 * Updates the position of the snake.
	 * @param dir
	 * @param player
	 */
	public void update(int dir, int player) {
		if (direction == 1) {
			
			body[x+10][y] = player;
		}
		else if (direction == 2) {
			body[x][y+10] = player;
		}
		else if (direction ==3) {
			body[x-10][y] = player;
		}
		else {
			body[x][y-10] = player;
		}
		checkCrash();
	}
	
	/**
	 * Checks if the position of the head overlaps with other things.
	 * @return boolean
	 */
	public boolean checkCrash() {
		return true;
	}
}
