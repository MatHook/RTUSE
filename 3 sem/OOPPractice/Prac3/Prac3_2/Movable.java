package OOPPractice.Prac3.Prac3_2;

public interface Movable {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}

class MovablePoint implements Movable {
    protected int x;
    protected int y;
    protected int xSpeed;
    protected int ySpeed;

    MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() {
        y += ySpeed;
    }

    @Override
    public void moveDown() {
        y -= ySpeed;
    }

    @Override
    public void moveLeft() {
        x -= xSpeed;
    }

    @Override
    public void moveRight() {
        x += xSpeed;
    }

    public String toString() {
        return "Movable Point";
    }
}

class MovableCircle implements Movable {
    private  int radius;
    private MovablePoint center;

    MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        this.radius = radius;
        center = new MovablePoint(x, y, xSpeed, ySpeed);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void moveUp() {
        center.y += center.ySpeed;
    }

    @Override
    public void moveDown() {
        center.y -= center.ySpeed;
    }

    @Override
    public void moveLeft() {
        center.x -= center.xSpeed;
    }

    @Override
    public void moveRight() {
        center.x += center.xSpeed;
    }

    public String toString() {
        return "Movable Circle";
    }
}

class Tests {
    public static void main(String[] args) {
        testMovablesInit();
        testMovablesMove();

        System.out.println("Work");
    }

    private static void doAssert(boolean condition) {
        if (!condition) {
            throw new AssertionError("Assertion is wrong!");
        }
    }

    private static void testMovablesInit() {
        MovableCircle movableCircle = new MovableCircle(0, 0, 0, 0, 3);

        doAssert(movableCircle.getRadius() == 3);

        MovablePoint movablePoint = new MovablePoint(0, 0, 0, 0);
    }

    private static void testMovablesMove() {
        MovableCircle movableCircle = new MovableCircle(0, 0, 0, 0, 3);
        MovablePoint movablePoint = new MovablePoint(0, 0, 0, 0);

        movableCircle.moveUp();
        movableCircle.moveDown();
        movableCircle.moveLeft();
        movableCircle.moveRight();

        movablePoint.moveUp();
        movablePoint.moveDown();
        movablePoint.moveLeft();
        movablePoint.moveRight();
    }
}