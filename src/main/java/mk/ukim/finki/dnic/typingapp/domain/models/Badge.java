package mk.ukim.finki.dnic.typingapp.domain.models;

import lombok.Data;
import mk.ukim.finki.dnic.typingapp.domain.identity.User;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String badgeName;

    private String imageUrl;

    private String description;

    @ManyToMany
    private List<User> users;

    public Badge() {
    }

    public Badge(String badgeName, String imageUrl, String description, List<User> users) {
        this.badgeName = badgeName;
        this.imageUrl = imageUrl;
        this.description = description;
        this.users = users;
    }
}
