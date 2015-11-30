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
    private final int xp[] = new int[maxSize];
    private final int yp[] = new int[maxSize];
    private final int a[] = new int[maxSize];
    private final int b[] = new int[maxSize];
    private int length;
    private boolean[] direction = new boolean[4];
    private boolean picked;
	
	/**
	 * 
	 * @param x: x coordinate of the head of the snake
	 * @param y: y coordinate of the head of the snake
	 * @param direction: an array of boolean representing the move-able directions
	 * @return
	 */
	public void determineMove(int x, int y) {
		freeMoves();
		if((y-w < 0) || ((x == xp[0]) && (y-w == yp[0]))){
			direction[upAI] = false;
		}
		if ((y+w > frameSizeY) || ((x == xp[0]) && (y+w == yp[0]))){
			direction[downAI] = false;
		}
		if ((x-w < 0) || ((x-w == xp[0]) && (y == yp[0]))){
			direction[leftAI] = false;
		}
		if ((x+w > frameSizeX) || ((x+w == xp[0]) && (y == yp[0]))){
			direction[rightAI] = false;
		}
		
		for (int i = 1; i<maxSize; i++){
			if(((x == xp[i]) && (y-w == yp[i])) || ((x == a[i]) && (y-w == a[i]))){
				direction[upAI] = false;
			}
			if(((x == xp[i]) && (y+w == yp[0])) || ((x == xp[i]) && (y+w == yp[0]))){
				direction[downAI] = false;
			}
			if(((x-w == xp[i]) && (y == yp[0])) || ((x == xp[i]) && (y+w == yp[0]))){
				direction[leftAI] = false;
			}
			if(((x+w == xp[i]) && (y == yp[i])) || ((x == xp[i]) && (y+w == yp[0]))){
				direction[rightAI] = false;
			}
		}
	}
	
	public void freeMoves(){
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
	}
	
	public void generateMove() {
		int lastMove = 0;
		for(int i = 0; i< 4; i++) {
			if(direction[i] == true) {
				lastMove = i;
				break;
			}
		}
		determineMove(a[0],b[0]);
		if(direction[lastMove]) {
			Random rn = new Random();
			
			if (rn.nextBoolean()) {
				direction[lastMove] = true;
				for (int i = 0; i < 4; i++) {
					if(i != lastMove){
						direction[i] = false;
					}
				}
			}
			else {
				Moving();
			}
		}
		else {
			Moving();
		}
	}
	
	public void Moving() {
		for(int i = 0; i < 4; i++) {
			if (!picked) {
				if(direction[i] == true){
					picked = true;
				}
			}
			else {
				direction[i] = false;
			}
		}
	}
	
	private boolean checkCollision(int n) {
		if (n == 1) {				// left
			if ((a[0]-w) <= 0) {
				return true;
			}
			else {
				for (int z = 1; z < length; z++) {
		            if ((z > 4) && ((a[0]-w) == a[z]) || ((a[0]-w) == xp[z])) {
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
		            if ((z > 4) && ((a[0]+w) == a[z]) || ((a[0]+w) == xp[z])) {
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
		            if ((z > 4) && ((b[0]+w) == b[z]) || ((b[0]+w) == yp[z])) {
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
		            if ((z > 4) && ((b[0]-w) == b[z]) || ((b[0]-w) == yp[z])) {
		            	return true;
		            }
				}
			}
		}
		return false;
	}
}