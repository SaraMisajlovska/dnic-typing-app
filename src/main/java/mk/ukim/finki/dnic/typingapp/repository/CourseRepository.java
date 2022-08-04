package mk.ukim.finki.dnic.typingapp.repository;

import mk.ukim.finki.dnic.typingapp.domain.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    void deleteByCourseName(String name);
}
