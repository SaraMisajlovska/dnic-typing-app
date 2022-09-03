package mk.ukim.finki.dnic.typingapp.service.implementation;


import lombok.AllArgsConstructor;
import mk.ukim.finki.dnic.typingapp.domain.dto.UserDto;
import mk.ukim.finki.dnic.typingapp.domain.enums.Role;
import mk.ukim.finki.dnic.typingapp.domain.exceptions.*;
import mk.ukim.finki.dnic.typingapp.domain.identity.User;
import mk.ukim.finki.dnic.typingapp.repository.UserRepository;
import mk.ukim.finki.dnic.typingapp.service.UserService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @Override
    public User register(String username, String name, String surname, String email, String city, String country, Role role) {
        if (this.userRepository.findByUsername(username).isPresent())
            throw new UsernameExistsException(username);
        //String username, String password, String repeatPassword, String name, String surname, String address, Role role
        User user = new User(username, name, surname, email, city, country, role);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> edit(UserDto userDto) {
        User user = userRepository.findByUsername(userDto.getUsername()).orElseThrow(() -> new UserNotFoundException(userDto.getUsername()));
        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setCity(userDto.getCity());
        user.setCountry(userDto.getCountry());
        user.setEmail(userDto.getEmail());
        this.userRepository.save(user);
        return Optional.of(user);
    }

}
