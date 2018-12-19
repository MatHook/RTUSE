package OOPPractice.Prac8;

public class IllegalAddressException extends RuntimeException {
    private static final long serialVersionUID = 10012301230L;

    public IllegalAddressException() {
        super();
    }

    public IllegalAddressException(String message) {
        super(message);
    }

    public IllegalAddressException(String message, Throwable throwable) {
        super(message, throwable);
    }
}