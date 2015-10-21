import java.awt.Color;

/**
 * 
 * @author Tian Guo, Xin Tong Hu
 *
 */
public class Snake {
	private node head;
	private boolean isCrashed;
	private int direction;
	
	/**
	 * Constructor
	 */
	public Snake() {
		head = new node();
		head.x = 0;head.y=0;//initial position, will modify later
		direction = 1;
	}
	
	/**
	 * Captures the snake's movement.
	 * @param dir
	 */
	public void move(int dir) {
		direction = dir;
		update();
	}
	
	/**
	 * Updates the position of the snake.
	 */
	public void update() {
		node temp = null;
		if (direction == 1) {
			
		}
		else if (direction == 2) {
		}
		else if (direction == 3) {
		}
		else {
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