package be.thomasmore.hospitalappintment.repositories;

import be.thomasmore.hospitalappintment.model.Appointment;
import be.thomasmore.hospitalappintment.model.Department;
import be.thomasmore.hospitalappintment.model.Doctor;
import be.thomasmore.hospitalappintment.model.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AppointmentRepository extends CrudRepository<Appointment,Integer> {

    Optional<Appointment> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Appointment> findFirstByIdGreaterThanOrderById(int id);
    Optional<Appointment> findFirstByOrderByIdDesc();
    Optional<Appointment> findFirstByOrderByIdAsc();
    Iterable<Appointment> findByDoctor(Doctor d);
    Iterable<Appointment> findByPatient(Patient p);
}
