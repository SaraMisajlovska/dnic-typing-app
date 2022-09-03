package mk.ukim.finki.dnic.typingapp.domain.dto;

import lombok.Data;
import mk.ukim.finki.dnic.typingapp.domain.enums.Role;

@Data
public class UserDto {

    private String username;

    private String name;

    private String surname;

    private String email;

    private String city;

    private String country;

    private Role role;
}
