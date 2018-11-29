package OOPPractice.Prac8;

public class OrderAlreadyAddedException extends Exception {
    private static final long serialVersionUID = 10012301230L;

    public OrderAlreadyAddedException() {
        super();
    }

    public OrderAlreadyAddedException(String message) {
        super(message);
    }

    public OrderAlreadyAddedException(String message, Throwable throwable) {
        super(message, throwable);
    }
}