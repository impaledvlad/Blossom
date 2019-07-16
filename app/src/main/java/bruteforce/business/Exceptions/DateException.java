package bruteforce.business.Exceptions;

public class DateException extends Exception {
    private final String message;

    public DateException(String m) {message = m;}

    public String toString() {return message;}
}
