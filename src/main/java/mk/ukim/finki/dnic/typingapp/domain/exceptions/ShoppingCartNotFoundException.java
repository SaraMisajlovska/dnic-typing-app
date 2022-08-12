package mk.ukim.finki.dnic.typingapp.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ShoppingCartNotFoundException extends RuntimeException {
    public ShoppingCartNotFoundException(Long id) {
        super(String.format("Shopping Cart with ID %d was not found", id));
    }
}
