import java.awt.Color;

public class Snake {
	private int[][] body;
	private boolean isCrashed;
	private int direction;
	private int player;
	private int x = 1;// starting position will be changed later;
	private int y = 1;
	
	public Snake() {
		direction = 1;
		body = new int [x][y];
		direction = 1;
	}
<<<<<<< HEAD

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

=======
	public void move(int dir, int player) {
		direction = dir;
		update(dir, player);
	}
	public void update(int dir, int player) {
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
		}

		else if (direction == 3) {

=======
		else if (direction ==3) {
			body[x-10][y] = player;
>>>>>>> master
		}
		
		else {
			body[x][y-10] = player;
		}

		checkCrash();
<<<<<<< HEAD
		}
		
	
	/**
	 * Checks if the position of the head overlaps with other things.
	 * @return boolean
	 */
	public boolean checkCrash() {
		return true;
	}

}
=======
	}
	public boolean checkCrash() {
		return true;//will check if position of head overlaps with other things.
	}
}
>>>>>>> master
