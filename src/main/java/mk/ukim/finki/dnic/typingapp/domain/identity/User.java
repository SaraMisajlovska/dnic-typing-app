package mk.ukim.finki.dnic.typingapp.domain.identity;

import lombok.Data;
import mk.ukim.finki.dnic.typingapp.domain.enums.Role;
import mk.ukim.finki.dnic.typingapp.domain.models.Badge;
import mk.ukim.finki.dnic.typingapp.domain.models.Course;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@Table(name = "app_users")
public class User implements UserDetails {

    @Id
    private String username;

    private String name;

    private String surname;

    private String address;

    private String profilePhoto;

    private String password;

    private Role role;

    //Authentication
    private boolean isAccountNonExpired = true;

    private boolean isAccountNonLocked = true;

    private boolean isCredentialsNonExpired = true;

    private boolean isEnabled = true;

    public User() {
    }

    public User(String username, String name, String surname, String address, String password, Role role) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.password = password;
        this.role = role;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
