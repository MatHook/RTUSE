package OOPPractice.Prac3.Prac3_1;

abstract class Shape {
    protected String color;
    protected boolean filled;

    Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    Shape() {
        this("Black", true);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public boolean isFilled() {
        return filled;
    }

    public String  toString() {
        return "Shape";
    }

    abstract double getArea();

    abstract double getPerimeter();
}

class Circle extends Shape {
    protected double radius;

    Circle(){
        super();

        radius = 0;
    }

    Circle(double radius, String color, boolean filled) {
        super(color, filled);

        this.radius = radius;
    }

    double getRadius() {
        return radius;
    }

    void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI*radius*radius;
    }

    @Override
    double getPerimeter() {
        return 2*Math.PI*radius;
    }

    public String toString() {
        return "Circle";
    }
}

class Rectangle extends Shape {
    protected double width;
    protected   double lenght;

    Rectangle(){
        this(0, 0);
    }

    Rectangle(double width, double length) {
        super();

        this.width = width;
        this.lenght = length;
    }

    Rectangle(double width, double lenght, String color, boolean filled) {
        super(color, filled);

        this.width = width;
        this.lenght = lenght;
    }

    double getWidth() {
        return width;
    }

    void setWidth(double width) {
        this.width = width;
    }

    double getLenght() {
        return lenght;
    }

    void setLenght(double lenght) {
        this.lenght = lenght;
    }

    @Override
    double getArea() {
        return width * lenght;
    }

    @Override
    double getPerimeter() {
        return 2 * width + 2 * lenght;
    }

    public String toString() {
        return "Rectangle";
    }
}

class Square extends Rectangle {
    Square() {
        super(0, 0);
    }

    Square(double side) {
        super(side, side);
    }

    Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    double getSide() {
        return width;
    }

    void setSide(double side) {
        this.width = side;
        this.lenght = side;
    }

    @Override
    void setLenght(double lenght) {
        super.setLenght(lenght);
        super.setWidth(width);
    }

    @Override
    void setWidth(double width) {
        super.setWidth(width);
        super.setLenght(lenght);
    }

    public String toString() {
        return "Square";
    }
}

class Tests {
    public static void main(String[] args) {
        testInits();
        testCircle();
        testCasts();

        System.out.println("Work");
    }

    private static void doAssert(boolean condition) {
        if (!condition) {
            throw new AssertionError("Assertion is wrong!");
        }
    }

    private static void testInits() {
        Circle c = new Circle(1, "yellow", true);
        Rectangle r = new Rectangle(2, 3);
        Square s = new Square(1);
    }

    private static void testCircle() {
        Circle c = new Circle(1, "yellow", true);

        doAssert(c.getArea() == Math.PI);
        doAssert(c.getColor().equals("yellow"));
        doAssert(c.isFilled() == true);
        doAssert(c.toString().equals("Circle"));
    }

    private static void testCasts() {
        doAssert(((Shape) new Circle(1, "yellow", true)).getArea() == Math.PI);
        doAssert(((Shape) new Square(1)).getArea() == 1);
    }
}