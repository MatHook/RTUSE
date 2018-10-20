package OOPLabs.Lab5;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class lab5_1 {
    public static void main(String[] args) throws InterruptedException {
        Random rnd = new Random();
        MyFrame frame = new MyFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        for (int i = 0; i < 20; i++) {
            draw(frame, rnd.nextInt(800), rnd.nextInt(800));
        }
    }
    private static void draw(MyFrame frame, int x, int y) {
        frame.draw(x, y);
    }
}

class MyFrame extends JFrame {
   MyFrame(){
       this.setBounds(0, 0, 1000, 1000);
    }
    public void paint(Graphics g) {
       g.fillOval(10, 10, 100, 100);
    }
    void draw(int x, int y) {
       Graphics g = getGraphics();

       g.drawOval(x, y, 100, 100);
       repaint();
    }
}