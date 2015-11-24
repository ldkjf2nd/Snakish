package Snakish;

public class AI {
	int up = 0;
	int down = 1;
	int left = 2;
	int right = 3;
	public int deterMove(int x, int y, boolean[] direction){
		if(y-10 < 0){
			direction[up] = false;
		}
		else if (y+10< 0){
			direction[down] = false;
		}
		else if (x-10< 0){
			direction[down] = false;
		}
		else if (x-10
	}
	public boolean[] freeMoves(boolean[] direction){
		boolean[] pos = direction;
		if (pos[up] = true) {
			pos[down] = false;
			pos[left] = true;
			pos[right] = true;
		}
		else if (direction[down] = true){
			pos[up] = false;
			pos[left] = true;
			pos[right] = true;
		}
		else if (pos[left] = true) {
			pos[right] = false;
			pos[up] = true;
			pos[down] = true;
		}
		return pos;
	}
	public int generateMove(){
		return 0;
		
	}
	public int generateMove(int direction, boolean up, boolean down, boolean left, boolean right) {
		return 0;
		
	}
}
