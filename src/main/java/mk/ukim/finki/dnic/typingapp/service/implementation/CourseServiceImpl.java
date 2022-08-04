package mk.ukim.finki.dnic.typingapp.service.implementation;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.dnic.typingapp.domain.dto.CourseDto;
import mk.ukim.finki.dnic.typingapp.domain.models.Course;
import mk.ukim.finki.dnic.typingapp.repository.CourseRepository;
import mk.ukim.finki.dnic.typingapp.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Optional<Course> save(CourseDto courseDto) {
        courseRepository.deleteByCourseName(courseDto.getCourseName());

        Course course = new Course(courseDto.getCourseName(),
                courseDto.getDescription(),
                courseDto.getImageUrl(),
                courseDto.getProgress(),
                courseDto.getLevel(),
                courseDto.getLessons(),
                courseDto.getUsers());
        courseRepository.save(course);

        return Optional.of(course);
    }

    @Override
    public Optional<Course> edit(Long courseId, CourseDto courseDto) {
        Course course = courseRepository
                .findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course doesn't exist"));

        course.setCourseName(courseDto.getCourseName());
        course.setDescription(courseDto.getDescription());
        course.setImageUrl(courseDto.getImageUrl());
        course.setProgress(courseDto.getProgress());
        course.setLevel(courseDto.getLevel());
        course.setLessons(courseDto.getLessons());
        course.setUsers(courseDto.getUsers());

        courseRepository.save(course);

        return Optional.of(course);

    }

    @Override
    public void delete(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public List<Course> listCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return this.courseRepository.findById(id);
    }
}
