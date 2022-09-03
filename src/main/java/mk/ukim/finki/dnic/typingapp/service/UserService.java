package mk.ukim.finki.dnic.typingapp.service;

import mk.ukim.finki.dnic.typingapp.domain.dto.UserDto;
import mk.ukim.finki.dnic.typingapp.domain.enums.Role;
import mk.ukim.finki.dnic.typingapp.domain.identity.User;



import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findUsers();

    User register(String username, String name, String surname, String email, String city, String country, Role role);
    Optional<User> edit (UserDto userDto);
}