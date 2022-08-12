package mk.ukim.finki.dnic.typingapp.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class ProductAlreadyInShoppingCartException extends RuntimeException {
    public ProductAlreadyInShoppingCartException(Long id,String username) {
        super(String.format("Product with ID %d already exists in shopping cart for user %s", id,username));
    }
}