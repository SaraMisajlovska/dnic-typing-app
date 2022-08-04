package mk.ukim.finki.dnic.typingapp.repository;

import mk.ukim.finki.dnic.typingapp.domain.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    void deleteByLessonName(String name);
}
