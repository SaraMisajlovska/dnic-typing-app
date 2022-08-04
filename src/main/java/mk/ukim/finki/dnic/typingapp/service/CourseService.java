package mk.ukim.finki.dnic.typingapp.service;

import mk.ukim.finki.dnic.typingapp.domain.dto.CourseDto;
import mk.ukim.finki.dnic.typingapp.domain.models.Course;


import java.util.List;
import java.util.Optional;

public interface CourseService {

    Optional<Course> save(CourseDto courseDto);

    Optional<Course> edit(Long courseId, CourseDto courseDto);

    void delete(Long courseId);

    List<Course> listCourses();

    Optional<Course> findById(Long id);
}
