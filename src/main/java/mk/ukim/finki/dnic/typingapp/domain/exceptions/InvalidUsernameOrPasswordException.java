package mk.ukim.finki.dnic.typingapp.domain.exceptions;

public class InvalidUsernameOrPasswordException extends RuntimeException {
    public InvalidUsernameOrPasswordException() {
        super("Invalid Username Or Password Exception");
    }
}
