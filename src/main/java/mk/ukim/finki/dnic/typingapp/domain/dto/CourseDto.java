package mk.ukim.finki.dnic.typingapp.domain.dto;

import lombok.Data;
import mk.ukim.finki.dnic.typingapp.domain.enums.Level;
import mk.ukim.finki.dnic.typingapp.domain.identity.User;
import mk.ukim.finki.dnic.typingapp.domain.models.Lesson;

import java.util.List;

@Data
public class CourseDto {

    private String courseName;

    private String description;

    private String imageUrl;

    private Float progress;

    private Level level;

    private List<Lesson> lessons;

    private List<User> users;

    public CourseDto(String courseName, String description, String imageUrl, Float progress, Level level, List<Lesson> lessons, List<User> users) {
        this.courseName = courseName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.progress = progress;
        this.level = level;
        this.lessons = lessons;
        this.users = users;
    }
}

