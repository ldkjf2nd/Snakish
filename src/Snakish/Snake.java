package Snakish;

/**
 * 
 * @author Tian Guo, Xin Tong Hu
 *
 */
public class Snake {
	int[][] body;
	int unoccupied = 0;
	int player;
	String name;
	boolean isCrashed;
	private boolean pc;
	Snake enemy;
	// 4 directions
	int up = 1;
	int right = 2;
	int down = 3;
	int left = 4;
	// direction of the snake
	private int direction;
	// initial position of the snake
	int x, y;
	// width of the board
	private int w = 60;
	
	
	/**
	 * Constructor, initializes the snake.
	 */
	public Snake(int x, int y, int Direction, int Player) {
		body = new int [w][w];
		player = Player;
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
		//update(dir, player);
		if (verifyLegalMove(dir)){
			update(dir);
		}
		else {
			update(direction);
		}
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
			case 1: crashStatus(x, y-1);
					body[x][y-1] = player;
				break;
			case 2: crashStatus(x, y+1);
					body[x][y+1] = player;
				break;
			case 3: crashStatus(x+1, y);
					body[x+1][y] = player;
				break;
			case 4: crashStatus(x, y-1);
					body[x][y-1] = player;
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
		else if (body[x][y] != 0 || enemy.body[x][y] != 0) {				// checks if the snake crashes into itself or enemy
			isCrashed = true;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean checkCrashed() {
		return isCrashed;
	}
	
	/**
	 * 
	 * @param bool
	 */
	public void setPc(boolean bool){
		pc = bool;
	}
	
	/**
	 * 
	 * @param enemy
	 */
	public void setOther(Snake enemy){
		this.enemy = enemy;
	}
}