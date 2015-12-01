package Snakish;

public class SnakishMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Start Snakish Program
		SnakishModel model = new SnakishModel();
		SnakishView view = new SnakishView(model);
		SnakishController controller = new SnakishController(model, view);
	}
}