import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;
import java.awt.event.*;

/**
 * 
 * @author Tian Guo, Xin Tong Hu
 *
 */
public class SnakishView extends Frame implements MouseListener {

	private int frameSizeX = 600;			//x size of the whole frame
	private int frameSizeY = 600;			//y size of the whole frame
	
	/**
	 * Constructor for ConnectFourView
	 * This should initialize the JFrame
	 */
	public SnakishView() {
		super("Snakish");
		setSize(frameSizeX,frameSizeY);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
		
		addMouseListener(this);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SnakishView();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}