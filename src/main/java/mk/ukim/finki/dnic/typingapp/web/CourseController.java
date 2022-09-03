package mk.ukim.finki.dnic.typingapp.web;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.dnic.typingapp.domain.dto.CourseDto;
import mk.ukim.finki.dnic.typingapp.domain.identity.User;
import mk.ukim.finki.dnic.typingapp.domain.models.Course;
import mk.ukim.finki.dnic.typingapp.service.CourseService;
import mk.ukim.finki.dnic.typingapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;


    @GetMapping
    public List<Course> getCourses(){
        return this.courseService.listCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id) {
        return this.courseService.findById(id)
                .map(course -> ResponseEntity.ok().body(course))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Course> save(@RequestBody CourseDto courseDto) {
        return this.courseService
                .save(courseDto)
                .map(course -> ResponseEntity.ok().body(course))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Course> save(@PathVariable Long id, @RequestBody CourseDto courseDto) {
        return this.courseService.edit(id, courseDto)
                .map(course -> ResponseEntity.ok().body(course))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.courseService.delete(id);
        if (this.courseService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

}
