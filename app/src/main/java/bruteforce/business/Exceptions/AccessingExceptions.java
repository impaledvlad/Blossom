package bruteforce.business.Exceptions;

import bruteforce.application.Exceptions.ApplicationExceptions;

/**
 Class: AccessingExceptions
 Author: Triet Nguyen
 Purpose: To set up business exceptions
 */
public class AccessingExceptions extends ApplicationExceptions {
    public AccessingExceptions() {
        super();
    }

    public AccessingExceptions(final String context) {
        super(context);
    }

    public AccessingExceptions(final Exception cause) {
        super(cause);
    }

    public AccessingExceptions(final String context, Exception cause) {
        super(context, cause);
    }

}
