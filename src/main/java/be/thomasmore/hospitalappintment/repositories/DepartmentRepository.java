package be.thomasmore.hospitalappintment.repositories;

import be.thomasmore.hospitalappintment.model.Department;
import be.thomasmore.hospitalappintment.model.Hospital;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;

public interface DepartmentRepository  extends CrudRepository<Department,Integer> {
    Optional<Department> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Department> findFirstByIdGreaterThanOrderById(int id);
    Optional<Department> findFirstByOrderByIdDesc();
    Optional<Department> findFirstByOrderByIdAsc();
    Iterable<Department> findByHospital(Hospital hospital);


}
