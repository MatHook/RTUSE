package OOPPractice.Prac1;

public class Ball {
    private float radius;

    public Ball(float radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public String toString() {
        return String.format("Radius of ball is %f.", radius);
    }
}
