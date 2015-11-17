package Snakish;

import java.awt.*;

import javax.swing.*;

public class Square extends JPanel {

    int x;
    int y;
    Color c;

	public Square(int a, int b, Color co){
    	x = a;
    	y = b;
    	c = co;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        fillSquare(g);
    }

    public void fillSquare(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(c);
        g2.fillRect(x, y, 10, 10);
    }

//    public static void main(String[] args){
//        JFrame f = new JFrame();
//        Square graphics = new Square(50,50,Color.blue);
//        f.add(graphics);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setVisible(true);
//        f.setSize(600, 600);
//
//    }
}