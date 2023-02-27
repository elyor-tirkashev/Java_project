package mohirdev_lesson.Elyor_project.rest_controller;

import mohirdev_lesson.Elyor_project.model.Course;
import mohirdev_lesson.Elyor_project.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {


    @PostMapping("/students")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        return ResponseEntity.ok(student);
    }

    @PostMapping("/students/list")
    public ResponseEntity createAll(@RequestBody List<Student> students){
        return ResponseEntity.ok(students);
    }

    @PutMapping("/students")
    public ResponseEntity update(@RequestBody Student student){
        student.setLastName("Ergashev");
        return ResponseEntity.ok(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity updateSecond(@PathVariable Long id,
                                       @RequestBody Student student){
        student.setLastName("Ergashev");
        student.setId(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getone(@PathVariable Long id){
        Student student = new Student();
        student.setId(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/students")
    public ResponseEntity getAll(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String lastName,
                                 @RequestParam Integer age){
        List<Student> students = new ArrayList<>();
        Course course = new Course();
        course.setId(2L);
        course.setName("Spring_boot");
        students.add(new Student(id, name, lastName, age, course));
        students.add(new Student(3L, "name", "lastName", 7, course));
        return ResponseEntity.ok(students);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok(id+" Ma'lumot o'chirildi");
    }

    @PatchMapping("/students/{id}")
    public ResponseEntity patchUpdate(@PathVariable Long id,
                                      @RequestBody Student student){
        return ResponseEntity.ok(student);
    }

}
