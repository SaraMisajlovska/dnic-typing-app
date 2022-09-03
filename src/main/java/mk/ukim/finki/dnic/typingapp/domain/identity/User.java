package mk.ukim.finki.dnic.typingapp.domain.identity;

import lombok.Data;
import mk.ukim.finki.dnic.typingapp.domain.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "app_users")
public class User{

    @Id
    private String username;

    private String name;

    private String surname;

    private String email;

    private String city;

    private String country;

    private Role role;

    public User() {
    }

    public User(String username, String name, String surname, String email, String city, String country, Role role) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.city = city;
        this.country = country;
        this.role = role;
    }
}
