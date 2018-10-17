package OOPLabs.Lab5;

import javax.swing.*;
import java.awt.*;

public class lab5_1 extends JFrame{
    public static void main(String[] args) {
        new lab5_1();
    }
    JPanel[] pnl = new JPanel[20];
    private lab5_1(){
        setLayout(new FlowLayout());
        setSize(200, 200);
        setVisible(true);
    }
}

abstract class Shape {
    private String color;
    private int R;

    int getR() {
        return R;
    }
    String getColor() {
        return color;
    }
    Shape(String color, int R) {
        this.color = color;
        this.R = R;
    }
}