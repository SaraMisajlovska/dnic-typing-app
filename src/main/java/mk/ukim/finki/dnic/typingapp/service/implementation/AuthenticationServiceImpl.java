package mk.ukim.finki.dnic.typingapp.service.implementation;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.dnic.typingapp.domain.enums.Role;
import mk.ukim.finki.dnic.typingapp.domain.exceptions.UsernameExistsException;
import mk.ukim.finki.dnic.typingapp.domain.identity.User;
import mk.ukim.finki.dnic.typingapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl {
    private final UserRepository userRepository;

    public User register(String username, String name, String surname, String email, String city, String country, Role role) {
        User u = new User(username, name, surname, email, city, country, Role.USER);
        if (userRepository.findByUsername(username).isPresent()
                || !userRepository.findByUsername(username).isEmpty()) {
            throw new UsernameExistsException(username);
        }
        return userRepository.save(u);
    }
}
