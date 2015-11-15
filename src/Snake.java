/**
 * 
 * @author Tian Guo, Xin Tong Hu
 *
 */
public class Snake {
	int[][] body;
	private boolean isCrashed;
	// direction of the snake
	private int direction;
	// initial position of the snake
	int x;
	int y;
	// width of the board
	private int w = 60;
	
	/**
	 * Constructor, initializes the snake.
	 */
	public Snake(int x, int y, int Direction, int Player) {
		body = new int [w][w];
		isCrashed = false;
		this.x = x;
		this.y = y;
		direction = Direction;
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
		switch (direction) {
			case 1: checkCrash(x-1, y);
					body[x-1][y] = player;
				break;
			case 2: checkCrash(x, y+1);
					body[x][y+1] = player;
				break;
			case 3: checkCrash(x+1, y);
					body[x+1][y] = player;
				break;
			case 4: checkCrash(x, y-1);
					body[x][y-1] = player;
				break;
			default: break;
		}
	}
	
	/**
	 * Checks if the position of the head overlaps with other things.
	 * @return boolean
	 */
	public boolean checkCrash(int x, int y) {
		if (x < 0 | x > 60 | y < 0 | y > 60) {	// checks if the snake crashes into the wall
			return true;
		}
		else if (body[x][y] != 0) {				// checks if the snake crashes into itself or enemy
			return true;
		}
		return false;
	}
}