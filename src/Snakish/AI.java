package Snakish;

import java.util.Random;

public class AI {
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = true;
	int upAI = 0;
	int downAI = 1;
	int leftAI = 2;
	int rightAI = 3;
	int w = 10;
	int frameSizeX = 600;
	int frameSizeY = 600;
	private final int maxSize = 1800;
	private final int x[] = new int[maxSize];
	private final int y[] = new int[maxSize];
	private final int a[] = new int[maxSize];
	private final int b[] = new int[maxSize];
	private int length;
	private boolean[] ai = new boolean[4];
	private boolean picked;

	/**
	 * 
	 * @param x
	 *            : x coordinate of the head of the snake
	 * @param y
	 *            : y coordinate of the head of the snake
	 * @param direction
	 *            : an array of boolean representing the move-able directions
	 * @return
	 */
	public void determineMove(int xi, int yi) {
		freeMoves();
		if ((yi - w < 0) || ((xi == x[0]) && (yi - w == y[0]))) {
			ai[upAI] = false;
		}
		if ((yi + w > frameSizeY) || ((xi == x[0]) && (yi + w == y[0]))) {
			ai[downAI] = false;
		}
		if ((xi - w < 0) || ((xi - w == x[0]) && (yi == y[0]))) {
			ai[leftAI] = false;
		}
		if ((xi + w > frameSizeX) || ((xi + w == x[0]) && (yi == y[0]))) {
			ai[rightAI] = false;
		}

		for (int i = 1; i < maxSize; i++) {
			if (((xi == x[i]) && (yi - w == y[i]))
					|| ((xi == a[i]) && (yi - w == b[i]))) {
				ai[upAI] = false;
			}
			if (((xi == x[i]) && (yi + w == y[i]))
					|| ((xi == a[i]) && (yi + w == b[i]))) {
				ai[downAI] = false;
			}
			if (((xi - w == x[i]) && (yi == y[i]))
					|| ((xi - w == a[i]) && (yi == b[i]))) {
				ai[leftAI] = false;
			}
			if (((xi + w == x[i]) && (yi == y[i]))
					|| ((xi + w == a[i]) && (yi == b[i]))) {
				ai[rightAI] = false;
			}
		}
	}

	public void freeMoves() {
		if (ai[upAI] == true) {
			ai[downAI] = false;
			ai[leftAI] = true;
			ai[rightAI] = true;
		} else if (ai[downAI] == true) {
			ai[upAI] = false;
			ai[leftAI] = true;
			ai[rightAI] = true;
		} else if (ai[leftAI] == true) {
			ai[rightAI] = false;
			ai[upAI] = true;
			ai[downAI] = true;
		} else if (ai[rightAI] == false) {
			ai[leftAI] = false;
			ai[upAI] = true;
			ai[downAI] = true;
		}
	}

	public void generateMove() {
		int lastMove = 0;
		for (int i = 0; i < 4; i++) {
			if (ai[i] == true) {
				lastMove = i;
				break;
			}
		}
		determineMove(a[0], b[0]);
		if (ai[lastMove]) {
			Random rn = new Random();

			if (rn.nextBoolean()) {
				// ai[lastMove] = true;
				for (int i = 0; i < 4; i++) {
					if (i != lastMove) {
						ai[i] = false;
					}
				}
			} else {
				Moving();
			}
		} else {
			Moving();
		}
	}

	public void Moving() {
//		picked = false;
		boolean temp = true;
		Random rnd = new Random();
		int j;
		while(temp) {
			j = rnd.nextInt(ai.length);
			if (ai[j]) {
				for(int i = 0; i < 4; i++) {
					if (i!=j){
						ai[i] = false;
					}
				}
				temp = false;
			}
		}
		// picked = false;
	}

	private void move() {
		generateMove();
		for (int z = length; z > 0; z--) {
			x[z] = x[(z - 1)];
			y[z] = y[(z - 1)];
			a[z] = a[(z - 1)];
			b[z] = b[(z - 1)];
		}
		if (left) {
			x[0] -= w;
		} else if (right) {
			x[0] += w;
		} else if (up) {
			y[0] -= w;
		} else if (down) {
			y[0] += w;
		}
		if (ai[leftAI]) {
			a[0] -= w;
		} else if (ai[rightAI]) {
			a[0] += w;
		} else if (ai[upAI]) {
			b[0] -= w;
		} else if (ai[downAI]) {
			b[0] += w;
		}
	}

	public static void main(String[] args) {
		// Start Connect Four Program
		AI test = new AI();
		test.x[0] = 550;
		test.y[0] = 320;
		test.a[0] = 550;
		test.b[0] = 300;
		test.ai[1] = true;
		test.move();
		System.out.println(test.ai[0]);
		System.out.println(test.ai[1]);
		System.out.println(test.ai[2]);
		System.out.println(test.ai[3]);
		test.move();
		System.out.println(test.ai[0]);
		System.out.println(test.ai[1]);
		System.out.println(test.ai[2]);
		System.out.println(test.ai[3]);
		test.move();
		System.out.println(test.ai[0]);
		System.out.println(test.ai[1]);
		System.out.println(test.ai[2]);
		System.out.println(test.ai[3]);
		test.move();
		System.out.println(test.ai[0]);
		System.out.println(test.ai[1]);
		System.out.println(test.ai[2]);
		System.out.println(test.ai[3]);
	}
}