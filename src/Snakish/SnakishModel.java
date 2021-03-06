package Snakish;

/**
 * This class manages the data, logic and rules of the game.
 * 
 * @author Tian Guo, Xin Tong Hu
 *
 */
public class SnakishModel {

	public enum GameState {
		TITLE_PAGE, NEW_GAME, ABOUT, EXIT, IN_PROGRESS, END_GAME
	}

	public enum PlayingState {
		PLAYER_WIN, PC_WIN, TIE
	}

	private GameState gameState = null;
	private PlayingState playingState = null;

	public boolean up, down, left, right;

	public int x1 = 50;
	public int y1 = 300;
	public int x2 = 550;
	public int y2 = 300;

	final int DELAY = 140;

	/**
	 * Constructor
	 */
	public SnakishModel() {
	}

	// /**
	// *
	// */
	// private void loadImages() {
	// ImageIcon iip = new ImageIcon("src/player.png");
	// player = iip.getImage();
	//
	// ImageIcon iipc = new ImageIcon("src/pc.png");
	// pc = iipc.getImage();
	//
	// ImageIcon iih = new ImageIcon("src/head.png");
	// head = iih.getImage();
	// }

	// public void gameBegin(int dire1, int dire2) {
	// setGameState(GameState.IN_PROGRESS);
	// dir1 = dire1;
	// dir2 = dire2;
	// }

	// public void move(int i, int j) { // i is direction of movement, j
	// represents either player or AI
	// if (j == player) {
	// dir1 = i;
	// }
	// else {
	// dir2 = i;
	// }
	// }

	// public void updateMove(int dire1, int dire2) {
	// // if (player == 1) {
	// // switch (dir1) {
	// // case 1: if (IsCollision(game.x-1, game.y)) {
	// // game.body[game.x-1][game.y] = player;
	// // }
	// // break;
	// // case 2: if (IsCollision(game.x, game.y+1)) {
	// // game.body[game.x][game.y+1] = player;
	// // }
	// // break;
	// // case 3: if (IsCollision(game.x+1, game.y)) {
	// // game.body[game.x+1][game.y] = player;
	// // }
	// // break;
	// // case 4: if (IsCollision(game.x, game.y-1)) {
	// // game.body[game.x][game.y-1] = player;
	// // }
	// // break;
	// // default: break;
	// // }
	// // }
	// snakes[0].move(dire1);
	// snakes[1].move(dire2);
	// if(snakes[0].checkCrashed()){
	// setPlayingState(PlayingState.PLAYER_WIN);
	// }
	// else if(snakes[1].checkCrashed()){
	// setPlayingState(PlayingState.PC_WIN);
	// }
	// }

	// /**
	// * Checks if there is a collision, return true if there is, else false.
	// * @return boolean
	// */
	// public boolean IsCollision(int x, int y) {
	// if (x < 0 | x > 60 | y < 0 | y > 60) { // checks if the snake crashes
	// into the wall
	// return true;
	// }
	// else if (game.body[x][y] != 0) { // checks if the snake crashes into
	// itself or enemy
	// return true;
	// }
	// return false;
	// }

	// public void paint(Graphics2D g){
	// for(int i=0;i<snakes[i].body.length;i++) {
	// for(int j=0;j<snakes[i].body[i].length;j++) {
	// if(snakes[i].body[i][j] == player) {
	// g.setColor(i*w==snakes[i].x&&j*w==snakes[i].y?Color.GREEN:snakes[i].color);
	// g.fillRect(i*w,j*w,w,w);
	// }
	// }
	// }
	// }

	// void start(){
	// snakes[0] = new Snake(x1, y1, right, player);
	// snakes[1] = new Snake(x2, y2, left, pc);
	// snakes[0].setOther(snakes[1]);
	// snakes[1].setOther(snakes[0]);
	// demo = false;
	// board[5][30] = new Square(50, 300, playerColor);
	// board[55][30] = new Square(550, 300, pcColor);
	// }
	//
	// public void paint() {
	// for (int i = 0; i < 60; i++) {
	// for (int j = 0; i < 60; j++) {
	// if(snakes[0].body[i][j] != 0){
	// board[i][j] = new Square(i*10,j*10,playerColor);
	// }
	// else if(snakes[1].body[i][j] !=0){
	// board[i][j] = new Square(i*10,j*10,pcColor);
	// }
	// }
	// }
	// }

	/**
	 * Returns the current game state
	 * 
	 * @return GameState
	 */
	public GameState getGameState() {
		return gameState;
	}

	/**
	 * 
	 * @param gs
	 */
	public void setGameState(GameState gs) {
		gameState = gs;
	}

	/**
	 * 
	 * @return
	 */
	public PlayingState getPlayingState() {
		return playingState;
	}

	/**
	 * 
	 * @param ps
	 */
	public void setPlayingState(PlayingState ps) {
		playingState = ps;
	}
}