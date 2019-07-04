package bruteforce.application.Exceptions;

/**
 Class: ApplicationExceptions
 Author: Triet Nguyen
 Purpose: To set up application exceptions
 */
public class ApplicationExceptions extends RuntimeException {
    private String detailInfo = "\"go to:\\n\" +\n" +
            "                    \"Presentation/MessageExceptionHandlers/MessageExceptionHandlers.java to make Exception handler for your specific Exception%s\"";

    public ApplicationExceptions() {
        super();
    }

    public ApplicationExceptions(final Exception cause) {
        super(cause);
    }

    public ApplicationExceptions(final String context) {
        super(context);
        detailInfo = context;
    }

    public ApplicationExceptions(final String context, Exception cause) {
        super(context, cause);
        detailInfo = context;
    }

    protected void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }

    public String getDetailInfo() {
        return this.detailInfo;
    }
}
