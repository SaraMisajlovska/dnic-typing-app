package mk.ukim.finki.dnic.typingapp.domain.dto;

import lombok.Data;
import mk.ukim.finki.dnic.typingapp.domain.enums.Status;

@Data
public class LessonDto {

    private String lessonName;

    private String text;

    private Status status;

    private Long courseId;

    public LessonDto(String lessonName, String text, Status status, Long courseId) {
        this.lessonName = lessonName;
        this.text = text;
        this.status = status;
        this.courseId = courseId;
    }
}
