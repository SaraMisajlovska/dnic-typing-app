package mk.ukim.finki.dnic.typingapp.domain.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException {
    public PasswordsDoNotMatchException() {
        super("Passwords Do Not Match Exception");
    }
}
