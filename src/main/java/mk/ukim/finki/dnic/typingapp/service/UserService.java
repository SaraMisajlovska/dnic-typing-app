package mk.ukim.finki.dnic.typingapp.service;

import mk.ukim.finki.dnic.typingapp.domain.enums.Role;
import mk.ukim.finki.dnic.typingapp.domain.identity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> findUsers();

    User register(String username, String password, String repeatPassword, String name, String surname, String address, Role role);
}