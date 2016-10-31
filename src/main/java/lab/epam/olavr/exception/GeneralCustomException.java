package lab.epam.olavr.exception;


public class GeneralCustomException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private static final String GENERAL_CUSTOM_EXCEPTION = "GeneralCustomException: ";

    // Classic constructor with a message of error.
    public GeneralCustomException(String message) {
        super(message);
       //performLogging(message);
    }

    public GeneralCustomException(String message, Throwable e) {
        super(message, e);
       // performLogging(message + e.getMessage());
    }


}
