package OOPLabs.Lab6;

import javax.swing.*;
import java.awt.*;

public class lab6_2 {
    public static void main(String[] args) {
        new Frame6_2();
    }
}

class Frame6_2 extends JFrame {
    Frame6_2() {
        JFrame frame6_2 = new JFrame("lab6_2");
        JLabel north = new JLabel("North");
        north.setLocation(300, 0);
        JLabel south = new JLabel("South");
        south.setLocation(300, 600);
        JLabel east = new JLabel("East");
        east.setLocation(600, 300);
        JLabel west = new JLabel("West");
        west.setLocation(0, 300);

        frame6_2.setLayout(new FlowLayout());
        frame6_2.setSize(600, 600);
        frame6_2.setVisible(true);
        frame6_2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}