package OOPLabs.Lab1;

import java.awt.*;
import java.util.Scanner;

public class lab2 {
    public static void main(String[] args) {
        Circle cc = new Circle();
        System.out.println(cc);
        System.out.println(cc.getRadius());
        System.out.println(cc.getArea());
        System.out.println(cc.getLengtCircle());
    }
}
class Circle {
    Scanner sc = new Scanner(System.in);
    private int R;
    private Point point;

    public Circle() {
        point = new Point(0, 0);
        System.out.print("Enter Radius of circle: ");
        R = sc.nextInt();
    }

    public Circle(int r, int x, int y) {
        point = new Point(x, y);
        R = r;
    }

    public int getRadius() {
        return R;
    }

    public double getArea() {
        System.out.print("\nArea of circle: ");
        return Math.PI*R*R;
    }

    public double getLengtCircle() {
        System.out.print("\nLength of circle: ");
        return 2 * Math.PI * R;
    }
}
