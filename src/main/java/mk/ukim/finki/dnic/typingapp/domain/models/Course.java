package mk.ukim.finki.dnic.typingapp.domain.models;

import lombok.Data;
import mk.ukim.finki.dnic.typingapp.domain.enums.Level;
import mk.ukim.finki.dnic.typingapp.domain.identity.User;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    private String description;

    private String imageUrl;

    private Float progress;

    @Enumerated(EnumType.STRING)
    private Level level;

    @OneToMany(mappedBy = "course")
    private List<Lesson> lessons;

    @ManyToMany
    private List<User> users;

    public Course() {
    }

    public Course(String courseName, String description, String imageUrl, Float progress, Level level, List<Lesson> lessons, List<User> users) {
        this.courseName = courseName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.progress = progress;
        this.level = level;
        this.lessons = lessons;
        this.users = users;
    }
}
