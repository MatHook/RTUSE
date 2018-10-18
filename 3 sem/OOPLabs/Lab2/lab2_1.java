package OOPLabs.Lab2;

import java.awt.*;
import java.util.Scanner;

public class lab2_1 {
    public static void main(String[] args) {
        Circle cc = new Circle();
        System.out.println(cc);
        System.out.println(cc.getRadius());
        System.out.println(cc.getArea());
        System.out.println(cc.getLengtCircle());
    }
}
class Circle {
    private int R;
    private Point point;

    Circle() {
        point = new Point(0, 0);
        System.out.print("Enter Radius of circle: ");
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
    }

    Circle(int r, int x, int y) {
        point = new Point(x, y);
        R = r;
    }

    int getRadius() {
        return R;
    }

    double getArea() {
        return Math.PI*R*R;
    }

    double getLengtCircle() {
        return 2 * Math.PI * R;
    }
}