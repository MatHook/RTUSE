package OOPLabs.Lab2;

public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println("Radius is: " + c1.getRadius() + " Area of this Circle: " + c1.getArea() + " Length of this circle: " + c1.getLengtCircle());

        Circle c2 = new Circle(1, 1, 1);
        System.out.println("Radius is: " + c2.getRadius() + " Area of this Circle: " + c2.getArea() + " Length of this circle: " + c2.getLengtCircle());
    }
}
