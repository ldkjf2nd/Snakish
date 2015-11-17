package Snakish;

import java.awt.EventQueue;
import javax.swing.JFrame;


public class testMain extends JFrame {

    public testMain() {

        add(new Board());
        
        setResizable(false);
        pack();
        
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
                JFrame ex = new testMain();
                ex.setVisible(true);                
            }
        });
    }
}