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
    private boolean picked;
	
	/**
	 * 
	 * @param x: x coordinate of the head of the snake
	 * @param y: y coordinate of the head of the snake
	 * @param direction: an array of boolean representing the move-able directions
	 * @return
	 */
	public void determineMove(int xi, int yi) {
		freeMoves();
		if((yi-w < 0) || ((xi == x[0]) && (yi-w == y[0]))){
			direction[upAI] = false;
		}
		if ((yi+w > frameSizeY) || ((xi == x[0]) && (yi+w == y[0]))){
			direction[downAI] = false;
		}
		if ((xi-w < 0) || ((xi-w == x[0]) && (yi == y[0]))){
			direction[leftAI] = false;
		}
		if ((xi+w > frameSizeX) || ((xi+w == x[0]) && (yi == y[0]))){
			direction[rightAI] = false;
		}
		
		for (int i = 1; i<maxSize; i++){
			if(((xi == x[i]) && (yi-w == y[i])) || ((xi == a[i]) && (yi-w == a[i]))){
				direction[upAI] = false;
			}
			if(((xi == x[i]) && (yi+w == y[0])) || ((xi == x[i]) && (yi+w == y[0]))){
				direction[downAI] = false;
			}
			if(((xi-w == x[i]) && (yi == y[0])) || ((xi == x[i]) && (yi+w == y[0]))){
				direction[leftAI] = false;
			}
			if(((xi+w == x[i]) && (yi == y[i])) || ((xi == x[i]) && (yi+w == y[0]))){
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
}