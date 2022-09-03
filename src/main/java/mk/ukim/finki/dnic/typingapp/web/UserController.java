package mk.ukim.finki.dnic.typingapp.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.dnic.typingapp.domain.dto.UserDto;
import mk.ukim.finki.dnic.typingapp.domain.identity.User;
import mk.ukim.finki.dnic.typingapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("https://typing-app-191517.herokuapp.com")
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public User getUser() {
        return userService.findUsers().stream().findFirst().get();
    }

    @PutMapping("/edit")
    public ResponseEntity<User> editUser(@RequestBody UserDto userDto) {
        return this.userService.edit(userDto)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
