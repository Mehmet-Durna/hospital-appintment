package be.thomasmore.hospitalappintment.repositories;

import be.thomasmore.hospitalappintment.model.Department;
import be.thomasmore.hospitalappintment.model.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    Optional<Doctor> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Doctor> findFirstByIdGreaterThanOrderById(int id);
    Optional<Doctor> findFirstByOrderByIdDesc();
    Optional<Doctor> findFirstByOrderByIdAsc();
    Iterable<Doctor> findByDepartment(Department department);
}
