import java.awt.Color;

public class Snake {
	private node head;
	private boolean isCrashed;
	private int direction;
	
	public Snake() {
		head = new node();
		head.x = 0;head.y=0;//initial position, will modify later
		direction = 1;
	}
	public void move(int dir) {
		direction = dir;
		update();
	}
	public void update() {
		node temp = null;
		if (direction == 1) {
			
		}
		else if (direction == 2) {
		}
		else if (direction ==3) {
		}
		else {
		}
		checkCrash();
	}
	public boolean checkCrash() {
		return true;//will check if position of head overlaps with other things.
	}
	private class node {
		private int x,y;
		private node tail;
		
		public void node(int x, int y, node tail) {
			this.x = x;
			this.y = y;
			this.tail = tail;
		}
		public int getX() {
			return this.x;
		}
		public int gety() {
			return this.y;
		}
		public node getTail() {
			return this.tail;
		}
	}
}
