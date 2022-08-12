package mk.ukim.finki.dnic.typingapp.service;

import mk.ukim.finki.dnic.typingapp.domain.identity.User;

public interface AuthenticationService {

    User login (String username, String password);
    User register (String name, String surname, String username, String password, String repeatPassword, String address);

}
