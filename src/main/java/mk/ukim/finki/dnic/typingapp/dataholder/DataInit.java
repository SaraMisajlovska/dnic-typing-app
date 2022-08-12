package mk.ukim.finki.dnic.typingapp.dataholder;

import lombok.AllArgsConstructor;
import mk.ukim.finki.dnic.typingapp.domain.dto.BadgeDto;
import mk.ukim.finki.dnic.typingapp.domain.dto.CourseDto;
import mk.ukim.finki.dnic.typingapp.domain.dto.LessonDto;
import mk.ukim.finki.dnic.typingapp.domain.enums.Level;
import mk.ukim.finki.dnic.typingapp.domain.enums.Role;
import mk.ukim.finki.dnic.typingapp.domain.enums.Status;
import mk.ukim.finki.dnic.typingapp.service.BadgeService;
import mk.ukim.finki.dnic.typingapp.service.CourseService;
import mk.ukim.finki.dnic.typingapp.service.LessonService;
import mk.ukim.finki.dnic.typingapp.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInit {

    private final CourseService courseService;
    private final LessonService lessonService;
    private final BadgeService badgeService;
    private final UserService userService;

    @PostConstruct
    public void initData() {

        this.badgeService.save(
                new BadgeDto("WelcomeBadge",
                        "https://www.iconpacks.net/icons/1/free-badge-icon-1361-thumb.png",
                        "This is your first badge. Welcome to the course!",
                        new ArrayList<>()));
        this.userService.register("saram",
                "sm",
                "sm",
                "sara",
                "misajlovska",
                "vs bato",
                Role.USER);
        this.courseService.save(
                new CourseDto("BeginnerCourse",
                        "This is a course suitable for beginners.",
                        "https://static.typingclub.com/m/corp2/lessonplan-icons/typing-fr.png",
                        Float.parseFloat("0.0"),
                        Level.LEVEL_1,
                        new ArrayList<>(),
                        List.of(this.userService.findUsers().stream().findFirst().get()))
        );

        this.lessonService.save(
                new LessonDto("Lesson 1: Learn the keys f and j.",
                        "ffff jjjj ff jj fff jjj fj fj jjf ffj ff jjj ffj jjf jfjf fffj jjjf ffjj ff jj ffff",
                        Status.NOT_STARTED,
                        courseService.listCourses().stream().findFirst().get().getId())
        );

        this.courseService.edit(courseService.listCourses().stream().findFirst().get().getId(),
                new CourseDto("BeginnerCourse",
                        "This is a course suitable for beginners.",
                        "https://static.typingclub.com/m/corp2/lessonplan-icons/typing-fr.png",
                        Float.parseFloat("0.0"),
                        Level.LEVEL_1,
                        List.of(this.lessonService.listLessons().stream().findFirst().get()),
                        List.of(this.userService.findUsers().stream().findFirst().get())
                )
        );

    }
}
