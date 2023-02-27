package mohirdev_lesson.Elyor_project.service;

import mohirdev_lesson.Elyor_project.entity.Department;
import mohirdev_lesson.Elyor_project.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;


    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department save(Department department){
        return departmentRepository.save(department);
    }

    public Department findById(Long id){
        Department department = departmentRepository.findById(id).get();
        return department;
    }

    public List<Department> findAll(String name){
        List<Department> departments = departmentRepository.findAll(name);
        return departments;
    }

    public List<Department> findByQueryParam(String name){
        return departmentRepository.findAllByNameLikeNative(name);
    }
    public void delete(Long id){
        departmentRepository.deleteById(id);
    }
}
