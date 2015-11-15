import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author Tian Guo, Xin Tong Hu
 *
 */
public class SnakishView extends JFrame {
	private JTextField tfName;				// Name of the Player
	private JButton btnSG;
	private JButton btnA;
	private JButton btnE;
	private int frameSizeX = 600;			// x size of the whole frame
	private int frameSizeY = 600;			// y size of the whole frame
	private int originX = 0;
	private int originY = 0;
	
	/**
	 * Constructor for ConnectFourView
	 * This should initialize the JFrame
	 */
	public SnakishView() {
		JPanel titlePage = new JPanel();
//		Container cp = getContentPane();
		
		tfName = new JTextField("Enter Name");
		tfName.setBounds(frameSizeX/2-60,originY+200,120,30);
		tfName.setEditable(true);
		titlePage.add(tfName);

		btnSG = new JButton("Start Game");
		btnSG.setBounds(tfName.getX(),tfName.getY()+40,120,30);
		titlePage.add(btnSG);
		btnA = new JButton("About");
		btnA.setBounds(tfName.getX(),tfName.getY()+40*2,120,30);
		titlePage.add(btnA);
		btnE = new JButton("Exit");
		btnE.setBounds(tfName.getX(),tfName.getY()+40*3,120,30);
		titlePage.add(btnE);
		
        //... finalize layout
        setContentPane(titlePage);
        setTitle("Snakish");							// Title
        // The window closing event should probably be passed to the 
        // Controller in a real program, but this is a short example.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Exit program if close-window button clicked
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