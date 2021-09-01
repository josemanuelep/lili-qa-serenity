package co.com.webtest.certification.lili.exceptions;

public class SearchIntentException extends AssertionError {

    public static final String ALERT_MESSAGE_INTENT_NOT_FOUND = "The searched intent dont appear";

    public SearchIntentException(String message, Throwable cause) {
        super(message, cause);
    }
}
