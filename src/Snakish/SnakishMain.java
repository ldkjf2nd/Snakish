package Snakish;
import javax.swing.SwingUtilities;

public class SnakishMain {

	public static void main(String[] args) {
		// Run the GUI construction in the Event-Dispatching thread for thread-safety
		SwingUtilities.invokeLater(new Runnable() {
		@Override
		public void run() {
			new SnakishView(); // Let the constructor do the job
		}
		});
	}
}
