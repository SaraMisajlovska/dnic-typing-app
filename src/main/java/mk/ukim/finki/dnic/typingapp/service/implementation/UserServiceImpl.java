package mk.ukim.finki.dnic.typingapp.service.implementation;


import mk.ukim.finki.dnic.typingapp.domain.enums.Role;
import mk.ukim.finki.dnic.typingapp.domain.exceptions.*;
import mk.ukim.finki.dnic.typingapp.domain.identity.User;
import mk.ukim.finki.dnic.typingapp.repository.UserRepository;
import mk.ukim.finki.dnic.typingapp.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname, String address, Role role) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if (this.userRepository.findByUsername(username).isPresent())
            throw new UsernameExistsException(username);
        //String username, String password, String repeatPassword, String name, String surname, String address, Role role
        User user = new User(username, name, surname, address, passwordEncoder.encode(password), role);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException(s));
    }

}
