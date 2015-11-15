import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author Tian Guo, Xin Tong Hu
 *
 */
public class SnakishView extends JFrame {
	private JTextField tfName;				// Name of the Player
	private int frameSizeX = 600;			// x size of the whole frame
	private int frameSizeY = 600;			// y size of the whole frame
	private int originX = 0;
	private int originY = 0;
	
	/**
	 * Constructor for ConnectFourView
	 * This should initialize the JFrame
	 */
	public SnakishView() {
		Container cp = getContentPane();
		
		tfName = new JTextField("Enter Name");
		tfName.setBounds(frameSizeX/2-60,originY+245,120,30);
		tfName.setEditable(true);
		cp.add(tfName);

		JButton btnSG = new JButton("Start Game");
		btnSG.setBounds(tfName.getX(),tfName.getY()+40,120,30);
		cp.add(btnSG);
		JButton btnA = new JButton("About");
		btnA.setBounds(tfName.getX(),btnSG.getY()+40,120,30);
		cp.add(btnA);
		JButton btnE = new JButton("Exit");
		btnE.setBounds(tfName.getX(),btnA.getY()+40,120,30);
		cp.add(btnE);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Exit program if close-window button clicked
	    setTitle("Snakish");							// Title
	    setSize(frameSizeX, frameSizeY);				// Sets initial size
	    setVisible(true);								// JFrame is visible
	}
	
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