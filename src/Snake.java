import java.awt.Color;

public class Snake {
	private node head;
	private boolean isCrashed;
	private int direction;
	
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
