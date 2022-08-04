package mk.ukim.finki.dnic.typingapp.service;


import mk.ukim.finki.dnic.typingapp.domain.dto.LessonDto;
import mk.ukim.finki.dnic.typingapp.domain.models.Lesson;

import java.util.List;
import java.util.Optional;

public interface LessonService {

    Optional<Lesson> save(LessonDto lessonDto);

    Optional<Lesson> edit(Long lessonId, LessonDto lessonDto);

    void delete(Long lessonId);

    List<Lesson> listLessons();

    Optional<Lesson> findById(Long id);
}
