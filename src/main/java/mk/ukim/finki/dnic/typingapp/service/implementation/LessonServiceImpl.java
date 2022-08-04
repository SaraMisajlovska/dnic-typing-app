package mk.ukim.finki.dnic.typingapp.service.implementation;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.dnic.typingapp.domain.dto.LessonDto;
import mk.ukim.finki.dnic.typingapp.domain.models.Course;
import mk.ukim.finki.dnic.typingapp.domain.models.Lesson;
import mk.ukim.finki.dnic.typingapp.repository.CourseRepository;
import mk.ukim.finki.dnic.typingapp.repository.LessonRepository;
import mk.ukim.finki.dnic.typingapp.service.LessonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;


    @Override
    public Optional<Lesson> save(LessonDto lessonDto) {
        Course course = courseRepository
                .findById(lessonDto.getCourseId())
                .orElseThrow(() -> new IllegalArgumentException("Course doesn't exist"));

        lessonRepository.deleteByLessonName(lessonDto.getLessonName());
        Lesson lesson = new Lesson(lessonDto.getLessonName(), lessonDto.getText(), lessonDto.getStatus(), course);
        lessonRepository.save(lesson);

        return Optional.of(lesson);
    }

    @Override
    public Optional<Lesson> edit(Long lessonId, LessonDto lessonDto) {
        Lesson lesson = lessonRepository
                .findById(lessonId)
                .orElseThrow(() -> new IllegalArgumentException("Lesson doesn't exist"));

        Course course = courseRepository
                .findById(lessonDto.getCourseId())
                .orElseThrow(() -> new IllegalArgumentException("Course doesn't exist"));

        lesson.setLessonName(lessonDto.getLessonName());
        lesson.setText(lessonDto.getText());
        lesson.setStatus(lessonDto.getStatus());
        lesson.setStatus(lessonDto.getStatus());
        lesson.setCourse(course);

        lessonRepository.save(lesson);

        return Optional.of(lesson);
    }

    @Override
    public void delete(Long lessonId) {
        lessonRepository.deleteById(lessonId);
    }

    @Override
    public List<Lesson> listLessons() {
        return lessonRepository.findAll();
    }

    @Override
    public Optional<Lesson> findById(Long id) {
        return lessonRepository.findById(id);
    }
}
