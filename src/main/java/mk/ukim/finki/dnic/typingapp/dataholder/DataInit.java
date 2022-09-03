package mk.ukim.finki.dnic.typingapp.dataholder;

import lombok.AllArgsConstructor;
import mk.ukim.finki.dnic.typingapp.domain.dto.CourseDto;
import mk.ukim.finki.dnic.typingapp.domain.dto.LessonDto;
import mk.ukim.finki.dnic.typingapp.domain.enums.Level;
import mk.ukim.finki.dnic.typingapp.domain.enums.Role;
import mk.ukim.finki.dnic.typingapp.domain.enums.Status;
import mk.ukim.finki.dnic.typingapp.service.CourseService;
import mk.ukim.finki.dnic.typingapp.service.LessonService;
import mk.ukim.finki.dnic.typingapp.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInit {

    private final CourseService courseService;
    private final LessonService lessonService;
    private final UserService userService;

    @PostConstruct
    public void initData() {

//        this.badgeService.save(
//                new BadgeDto("WelcomeBadge",
//                        "https://www.iconpacks.net/icons/1/free-badge-icon-1361-thumb.png",
//                        "This is your first badge. Welcome to the course!",
//                        new ArrayList<>()));
        this.userService.register("sara.m",
                "Sara",
                "Misajlovska",
                "saram@user.com",
                "Skopje",
                "Macedonia",
                Role.USER);
        this.courseService.save(
                new CourseDto("Beginner Course",
                        "This is a course suitable for beginners.",
                        "https://static.typingclub.com/m/corp2/lessonplan-icons/typing-fr.png",
                        Float.parseFloat("0.0"),
                        Level.LEVEL_1,
                        new ArrayList<>(),
                        List.of(this.userService.findUsers().stream().findFirst().get()))
        );
        this.courseService.save(
                new CourseDto("Intermediate Course",
                        "This is a course suitable for individuals who know their basics.",
                        "https://static.typingclub.com/m/corp2/lessonplan-icons/typing-fr.png",
                        Float.parseFloat("0.0"),
                        Level.LEVEL_2,
                        new ArrayList<>(),
                        List.of(this.userService.findUsers().stream().findFirst().get()))
        );
        this.courseService.save(
                new CourseDto("Advanced Course",
                        "This is a course suitable for skilled individuals",
                        "https://static.typingclub.com/m/corp2/lessonplan-icons/typing-fr.png",
                        Float.parseFloat("0.0"),
                        Level.LEVEL_3,
                        new ArrayList<>(),
                        List.of(this.userService.findUsers().stream().findFirst().get()))
        );

        this.lessonService.save(
                new LessonDto("Lesson 1: Learn the keys f and j.",
                        "ffff jjjj ff jj fff jjj fj fj jjf ffj ff jjj ffj jjf jfjf fffj jjjf ffjj ff jj ffff",
                        Status.NOT_STARTED,
                        courseService.listCourses().stream().findFirst().get().getId())
        );

        this.lessonService.save(
                new LessonDto("Lesson 100: Learn tricky words.",
                        "their there their there their their their their there there there there their there",
                        Status.NOT_STARTED,
                        courseService.listCourses().stream().filter(course -> course.getCourseName().equals("Intermediate Course")).findFirst().get().getId())
        );

        this.lessonService.save(
                new LessonDto("Lesson 200: Increase your typing speed",
                        "their there their there their their their their there there there there their there",
                        Status.NOT_STARTED,
                        courseService.listCourses().stream().filter(course -> course.getCourseName().equals("Advanced Course")).findFirst().get().getId())
        );

        this.courseService.edit(courseService.listCourses().stream().findFirst().get().getId(),
                new CourseDto("Beginner Course",
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
