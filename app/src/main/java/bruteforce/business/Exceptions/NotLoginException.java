package bruteforce.business.Exceptions;

/**
 Class: ApplicationExceptions
 Author: Triet Nguyen
 Purpose: To handle log in exception
 */
public class NotLoginException extends AccessingExceptions {
    public NotLoginException() {
        super("have not login yet");
        setDetialInfo("have not login yet");
    }
}
