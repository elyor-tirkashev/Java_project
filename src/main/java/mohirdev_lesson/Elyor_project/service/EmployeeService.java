package mohirdev_lesson.Elyor_project.service;


import mohirdev_lesson.Elyor_project.entity.Employee;
import mohirdev_lesson.Elyor_project.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findById(Long id){
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isEmpty()) {
            return optional.get();
        }
        return null;
    }

    public List<Employee> findAll(String name){
        List<Employee> employees = employeeRepository.findAll(name);
        return employees;
    }

    public List<Employee> findByQueryParam(String name){
        return employeeRepository.findAllByNameLikeNative(name);
    }


    public void delete(Long id) {
    }
}
