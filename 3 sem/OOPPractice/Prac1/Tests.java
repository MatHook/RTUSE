package OOPPractice.Prac1;

public class Tests {
    public static void main(String[] args) {
        testBallInit();
        testBallToString();

        testBookInit();
        testBookToString();

        System.out.println("Work!");
    }

    private static void doAssert(boolean stat) {
        if(!stat) {
            throw new AssertionError("Assertion is wrong");
        }
    }

    private static void testBookInit() {
        Book book = new Book("Mciry", 40);

        doAssert(book.getLabel().equals("Mciry"));
        doAssert(book.getPages() == 40);
    }

    private static void testBookToString() {
        Book book = new Book("Mciry", 40);

        doAssert(book.toString().equals("Label of book is Mciry with 40 pages."));
    }

    private static void testBallInit() {
        Ball ball = new Ball(10);

        doAssert(ball.getRadius() == 10);
    }

    private static void testBallToString() {
        Ball ball = new Ball(10);

        doAssert(ball.toString().equals("Radius of ball is 10.000000."));
    }
}
