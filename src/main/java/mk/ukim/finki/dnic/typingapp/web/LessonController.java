package mk.ukim.finki.dnic.typingapp.web;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.dnic.typingapp.domain.dto.CourseDto;
import mk.ukim.finki.dnic.typingapp.domain.dto.LessonDto;
import mk.ukim.finki.dnic.typingapp.domain.models.Lesson;
import mk.ukim.finki.dnic.typingapp.service.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @GetMapping
    public List<Lesson> getCourses(){
        return this.lessonService.listLessons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lesson> findById(@PathVariable Long id) {
        return this.lessonService.findById(id)
                .map(course -> ResponseEntity.ok().body(course))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Lesson> save(@RequestBody LessonDto lessonDto) {
        return this.lessonService
                .save(lessonDto)
                .map(course -> ResponseEntity.ok().body(course))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Lesson> save(@PathVariable Long id, @RequestBody LessonDto lessonDto) {
        return this.lessonService.edit(id, lessonDto)
                .map(course -> ResponseEntity.ok().body(course))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.lessonService.delete(id);
        if (this.lessonService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

}
