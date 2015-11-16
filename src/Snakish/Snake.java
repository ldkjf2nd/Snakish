package Snakish;
/**
 * 
 * @author Tian Guo, Xin Tong Hu
 *
 */
public class Snake {
	int[][] body;
	int unoccupied = 0;
	int ID;
	private boolean isCrashed;
	// 4 directions
	int up = 1;
	int right = 2;
	int down = 3;
	int left = 4;
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
		ID = Player;
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
	//public void move(int dir, int player) {
	public void move(int dir) {
		direction = dir;
		//update(dir, player);
		update(direction);
	}
	
	/**
	 * Checks whether the snake's move is legal, return false if illegal, else true.
	 * @param n
	 * @return boolean
	 */
	public boolean verifyLegalMove(int n) {
		if (n == up & direction == down) {
			return false;
		}
		else if (n == right & direction == left) {
			return false;
		}
		else if (n == down & direction == up) {
			return false;
		}
		else if (n == left & direction == right) {
			return false;
		}
		return true;
	}
	
	/**
	 * Updates the position of the snake.
	 * @param dir
	 * @param player
	 */
	//public void update(int dir, int player) {
	public void update(int dir) {
		switch (direction) {
			case 1: if(verifyLegalMove(dir)) {
						crashStatus(x, y-1);
						body[x][y-1] = ID;
						}
				break;
			case 2: crashStatus(x, y+1);
					body[x][y+1] = ID;
				break;
			case 3: crashStatus(x+1, y);
					body[x+1][y] = ID;
				break;
			case 4: crashStatus(x, y-1);
					body[x][y-1] = ID;
				break;
			default: break;
		}
	}
	
	/**
	 * Checks if the position of the head overlaps with other things.
	 * @return boolean
	 */
	public void crashStatus(int x, int y) {
		if (x < 0 | x > 60 | y < 0 | y > 60) {	// checks if the snake crashes into the wall
			isCrashed = true;
		}
		else if (body[x][y] != 0) {				// checks if the snake crashes into itself or enemy
			isCrashed = true;
		}
	}
	
	public boolean checkCrashed() {
		return isCrashed;
	}
}