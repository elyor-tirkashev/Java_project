package mohirdev_lesson.Elyor_project.rest_controller;

import mohirdev_lesson.Elyor_project.entity.Department;
import mohirdev_lesson.Elyor_project.service.DepartmentService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments")
    public ResponseEntity<Department> create(@RequestBody Department department){
        Department result = departmentService.save(department);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/departments")
    public ResponseEntity<Department> update(@RequestBody Department department){
        if (department.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        Department result = departmentService.save(department);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> get(@PathVariable Long id){
        Department result = departmentService.findById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/departments")
    public ResponseEntity getAll(@RequestParam String name){
        List<Department> departments = departmentService.findAll(name);
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/departments/search")
    public ResponseEntity getAllByQueryParam(@RequestParam String name){
        List<Department> result = departmentService.findByQueryParam(name);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        departmentService.delete(id);
        return ResponseEntity.ok("Qator o'chdi");
    }
}
