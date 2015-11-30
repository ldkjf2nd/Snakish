package Snakish;

public class AI {
	int up = 0;
	int down = 1;
	int left = 2;
	int right = 3;
	int w = 10;
	int frameSizeX = 600;
	int frameSizeY = 600;
	public int deterMove(int x, int y, boolean[] direction) {
		boolean[] poss= freeMoves(direction);
		if(y-w < 0){
			direction[up] = false;
		}
		else if (y+w > frameSizeY){
			direction[down] = false;
		}
		else if (x-w < 0){
			direction[left] = false;
		}
		else if (x+w > frameSizeX) {
			direction[right] = false;
		}
		return 0;
		
	}
	public boolean[] freeMoves(boolean[] direction){
		boolean[] possible = direction;
		if (possible[up] = true) {
			possible[down] = false;
			possible[left] = true;
			possible[right] = true;
		}
		else if (direction[down] = true){
			possible[up] = false;
			possible[left] = true;
			possible[right] = true;
		}
		else if (possible[left] = true) {
			possible[right] = false;
			possible[up] = true;
			possible[down] = true;
		}
		else {
			possible[left] = false;
			possible[up] = true;
			possible[down] = true;
		}
		return possible;
	}
	public int generateMove(){
		return 0;
		
	}
	public int generateMove(int direction, boolean up, boolean down, boolean left, boolean right) {
		return 0;
		
	}
}
