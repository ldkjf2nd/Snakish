import java.awt.Color;

public class Snake {
	private int[][] body;
	private boolean isCrashed;
	private int direction;
	private int x = 1;// starting position will be changed later;
	private int y = 1;
	
	public Snake() {
		body = new int [x][y];
				direction = 1;
	}
	public void move(int dir, int player) {
		direction = dir;
		update(dir, player);
	}
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
	public boolean checkCrash() {
		return true;//will check if position of head overlaps with other things.
	}
}
