package Snakish;

import java.util.Random;

public class AI {
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
    private boolean[] direction = new boolean[4];
	
	/**
	 * 
	 * @param x: x coordinate of the head of the snake
	 * @param y: y coordinate of the head of the snake
	 * @param direction: an array of boolean representing the move-able directions
	 * @return
	 */
	public int determineMove(int x, int y) {
		if(y-w < 0){
			direction[upAI] = false;
		}
		else if (y+w > frameSizeY){
			direction[downAI] = false;
		}
		else if (x-w < 0){
			direction[leftAI] = false;
		}
		else if (x+w > frameSizeX) {
			direction[rightAI] = false;
		}
		boolean[] possible = freeMoves();
		int move = generateMove(possible);
		return move;
	}
	
	public boolean[] freeMoves(){
		if (direction[upAI] = true) {
			direction[downAI] = false;
			direction[leftAI] = true;
			direction[rightAI] = true;
		}
		else if (direction[downAI] = true){
			direction[upAI] = false;
			direction[leftAI] = true;
			direction[rightAI] = true;
		}
		else if (direction[leftAI] = true) {
			direction[rightAI] = false;
			direction[upAI] = true;
			direction[downAI] = true;
		}
		else {
			direction[leftAI] = false;
			direction[upAI] = true;
			direction[downAI] = true;
		}
		return direction;
	}
	
	public int generateMove(boolean[] direction) {
		Random rn = new Random();
		int answer = rn.nextInt(4);
		if (direction[answer]) {
			if (checkCollision(answer)) {
				return answer;
			}
		}
		return 0;
	}
	
	private boolean checkCollision(int n) {
		if (n == 1) {				// left
			if ((a[0]-w) <= 0) {
				return true;
			}
			else {
				for (int z = 1; z < length; z++) {
		            if ((z > 4) && ((a[0]-w) == a[z]) || ((a[0]-w) == x[z])) {
		            	return true;
		            }
				}
			}
		}
		else if (n == 2) {			// right
			if ((a[0]+w) >= frameSizeX) {
				return true;
			}
			else {
				for (int z = 1; z < length; z++) {
		            if ((z > 4) && ((a[0]+w) == a[z]) || ((a[0]+w) == x[z])) {
		            	return true;
		            }
				}
			}
		}
		else if (n == 3) {			// up
			if ((b[0]+w) >= frameSizeY) {
				return true;
			}
			else {
				for (int z = 1; z < length; z++) {
		            if ((z > 4) && ((b[0]+w) == b[z]) || ((b[0]+w) == y[z])) {
		            	return true;
		            }
				}
			}
		}
		else if (n == 4) {			// down
			if ((b[0]-w) <= 0) {
				return true;
			}
			else {
				for (int z = 1; z < length; z++) {
		            if ((z > 4) && ((b[0]-w) == b[z]) || ((b[0]-w) == y[z])) {
		            	return true;
		            }
				}
			}
		}
		return false;
	}
}