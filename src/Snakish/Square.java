package Snakish;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Square extends JPanel {

    int x;
    int y;
    Color c;
    private static ArrayList<Rectangle> squares = new ArrayList<Rectangle>();
    

//	public Square(int a, int b, Color co){
//    	x = a;
//    	y = b;
//    	c = co;
//    }

	   public void addSquare(int x, int y, Color co) {
		  this.x = x;
		  this.y = y;
		  c = co;
	      Rectangle rect = new Rectangle(x, y, 10, 10);
	      squares.add(rect);
	   }

	   @Override
	   public Dimension getPreferredSize() {
		return null;
		}

	   @Override
	   protected void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      Graphics2D g2 = (Graphics2D) g;
	      for (Rectangle rect : squares) {
	    	 g2.setColor(c);
	    	 g2.fillRect(x, y, 10, 10);
//	         g2.draw(rect);
	      }
	   }

    public static void main(String[] args){
        JFrame f = new JFrame("urgh");
        Square s = new Square();
//        for (int i = 0; i < 15; i++) {
//            s.addSquare(i * 10, i * 10, Color.blue);
//        }
//
        f.add(s);
        s.addSquare(1, 300, Color.GREEN);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setSize(600, 600);

    }
}