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
		body = new int [x][y];
				direction = 1;
	}
<<<<<<< HEAD
	public void move(int dir, int player) {
=======
	
	/**
	 * Captures the snake's movement.
	 * @param dir
	 */
	public void move(int dir) {
>>>>>>> master
		direction = dir;
		update(dir, player);
	}
<<<<<<< HEAD
	public void update(int dir, int player) {
=======
	
	/**
	 * Updates the position of the snake.
	 */
	public void update() {
		node temp = null;
>>>>>>> master
		if (direction == 1) {
			body[x+10][y] = player;
		}
		else if (direction == 2) {
			body[x][y+10] = player;
		}
<<<<<<< HEAD
		else if (direction ==3) {
			body[x-10][y] = player;
=======
		else if (direction == 3) {
>>>>>>> master
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
<<<<<<< HEAD
}
=======
	
	/**
	 * A self-implemented modified linked-list.
	 */
	private class node {
		private int x,y;
		private node tail;
		
		/**
		 * Constructor
		 * @param x
		 * @param y
		 * @param tail
		 */
		public void node(int x, int y, node tail) {
			this.x = x;
			this.y = y;
			this.tail = tail;
		}
		
		/**
		 * Returns the x-coordinate.
		 * @return int
		 */
		public int getX() {
			return this.x;
		}
		
		/**
		 * Returns the y-coordinate.
		 * @return int
		 */
		public int gety() {
			return this.y;
		}
		
		/**
		 * Returns the tail.
		 * @return node
		 */
		public node getTail() {
			return this.tail;
		}
	}
}
>>>>>>> master
