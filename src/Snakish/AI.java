package Snakish;

public class AI {
	int up = 0;
	int down = 1;
	int left = 2;
	int right = 3;
	public int deterMove(int x, int y, int direction){
		boolean[] rest = new boolean[4];
		if(x-10 < 0){
			if(y-10 < 0){
//				if(true)
				return generateMove();
			}
		}
		else if (y-10< 0){
			return generateMove();
		}
		return 0;
	}
	public int generateMove(){
		return 0;
		
	}
	public int generateMove(int direction, boolean up, boolean down, boolean left, boolean right) {
		return 0;
		
	}
}
