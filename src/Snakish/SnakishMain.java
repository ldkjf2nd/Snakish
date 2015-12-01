package Snakish;

public class SnakishMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Start Connect Four Program
		SnakishModel model = new SnakishModel();
		SnakishView view = new SnakishView(model);
		SnakishController controller = new SnakishController(model, view);
	}
}