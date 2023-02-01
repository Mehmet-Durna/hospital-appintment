package be.thomasmore.hospitalappintment.repositories;

import be.thomasmore.hospitalappintment.model.Department;
import be.thomasmore.hospitalappintment.model.Doctor;
import be.thomasmore.hospitalappintment.model.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PatientRepository extends CrudRepository<Patient,Integer> {
    Optional<Patient> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Patient> findFirstByIdGreaterThanOrderById(int id);
    Optional<Patient> findFirstByOrderByIdDesc();
    Optional<Patient> findFirstByOrderByIdAsc();

}
