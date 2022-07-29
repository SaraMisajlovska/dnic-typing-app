package mk.ukim.finki.dnic.typingapp.domain.identity;

import lombok.Data;
import mk.ukim.finki.dnic.typingapp.domain.models.Badge;
import mk.ukim.finki.dnic.typingapp.domain.models.Course;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "app_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String address;

    private String profilePhoto;

    private String email;

    private String password;

    public User() {
    }

    public User(String name, String surname, String address, String profilePhoto, String email, String password, List<Badge> earnedBadges, List<Course> enrolledCourses) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.profilePhoto = profilePhoto;
        this.email = email;
        this.password = password;
    }
}
