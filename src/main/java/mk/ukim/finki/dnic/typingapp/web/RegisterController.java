package mk.ukim.finki.dnic.typingapp.web;

import mk.ukim.finki.dnic.typingapp.domain.enums.Role;
import mk.ukim.finki.dnic.typingapp.domain.exceptions.InvalidArgumentException;
import mk.ukim.finki.dnic.typingapp.domain.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.dnic.typingapp.service.AuthenticationService;
import mk.ukim.finki.dnic.typingapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final AuthenticationService authenticationService;
    private final UserService userService;

    public RegisterController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasErrors", error);
            model.addAttribute("error", error);

        }

        model.addAttribute("bodyContent", "register");
        return "master-template";
    }

    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatPassword,
                           @RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String address,
                           @RequestParam Role role) {
        try {
            userService.register(username, password, repeatPassword, name, surname, address, role);
            return "redirect:/login";
        } catch (PasswordsDoNotMatchException | InvalidArgumentException e) {
            return "redirect:/register?error=" + e.getMessage();
        }

    }
}