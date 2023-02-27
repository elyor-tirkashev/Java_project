package mohirdev_lesson.Elyor_project.repository;


import mohirdev_lesson.Elyor_project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query(value = "Select * from employee d where d.name = :name", nativeQuery = true)
    List<Employee> findAll(@Param("name") String name);

    @Query(value = "Select * from employee d where d.name like %:name% ORDER by id desc", nativeQuery = true)
    List<Employee> findAllByNameLikeNative(@Param("name") String name);


}



