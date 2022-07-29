package mk.ukim.finki.dnic.typingapp.domain.models;

import lombok.Data;
import mk.ukim.finki.dnic.typingapp.domain.enums.Status;

import javax.persistence.*;

@Data
@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lessonName;

    private String text;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Course course;

    public Lesson() {}

    public Lesson(String lessonName, String text, Status status, Course course) {
        this.lessonName = lessonName;
        this.text = text;
        this.status = status;
        this.course = course;
    }
}
