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
	private int player;
	private int x = 1;// starting position will be changed later;
	private int y = 1;
	
	/**
	 * Constructor
	 */
	public Snake() {
		body = new int [x][y];
				direction = 1;
	}

	public void move(int dir, int player) {
		
	}

	
	/**
	 * Captures the snake's movement.
	 * @param dir
	 */
	public void move(int dir) {

		direction = dir;
		update(dir, player);
	}

	public void update(int dir, int player) {
		
	}

	
	/**
	 * Updates the position of the snake.
	 */
	public void update() {

		if (direction == 1) {
			body[x+10][y] = player;
		}
		else if (direction == 2) {
			body[x][y+10] = player;
		}

		else if (direction ==3) {
			body[x-10][y] = player;
		}

		else if (direction == 3) {

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