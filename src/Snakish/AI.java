package Snakish;

public class AI {
	int up = 0;
	int down = 1;
	int left = 2;
	int right = 3;
	public int deterMove(int x, int y, boolean[] direction){
		boolean[] poss= freeMoves(direction);
		if(y-10 < 0){
			direction[up] = false;
		}
		else if (y+10> 600){
			direction[down] = false;
		}
		else if (x-10< 0){
			direction[left] = false;
		}
		else if (x+10>600) {
			direction[right] = false;
		}
		
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
		return possible;
	}
	public int generateMove(){
		return 0;
		
	}
	public int generateMove(int direction, boolean up, boolean down, boolean left, boolean right) {
		return 0;
		
	}
}
