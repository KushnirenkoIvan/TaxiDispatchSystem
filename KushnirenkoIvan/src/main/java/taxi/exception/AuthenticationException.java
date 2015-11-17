package taxi.exception;

public class AuthenticationException extends Throwable {

    public AuthenticationException() {
        super("ERROR: Cannot authenticate.");
    }

}
