package mk.ukim.finki.dnic.typingapp.service.implementation;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.dnic.typingapp.domain.enums.Role;
import mk.ukim.finki.dnic.typingapp.domain.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.dnic.typingapp.domain.exceptions.UsernameExistsException;
import mk.ukim.finki.dnic.typingapp.domain.identity.User;
import mk.ukim.finki.dnic.typingapp.repository.UserRepository;
import mk.ukim.finki.dnic.typingapp.service.AuthenticationService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl  implements AuthenticationService {
    private final UserRepository userRepository;

    @Override
    public User login(String username, String password) {

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public User register(String name, String surname, String username, String password, String repeatPassword, String address) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (!password.equals(repeatPassword)) {
            throw new PasswordsDoNotMatchException();
        }


        User u = new User(username, name, surname, address, password, Role.USER);
        if (userRepository.findByUsername(username).isPresent()
                || !userRepository.findByUsername(username).isEmpty()){
            throw new UsernameExistsException(username);
        }
        return userRepository.save(u);
    }
}
