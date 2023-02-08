package be.thomasmore.hospitalappintment.repositories;

import be.thomasmore.hospitalappintment.model.Appointment;
import be.thomasmore.hospitalappintment.model.Doctor;
import be.thomasmore.hospitalappintment.model.Patient;
import org.springframework.data.repository.CrudRepository;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends CrudRepository<Appointment,Integer> {

    Optional<Appointment> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Appointment> findFirstByIdGreaterThanOrderById(int id);
    Optional<Appointment> findFirstByOrderByIdDesc();
    Optional<Appointment> findFirstByOrderByIdAsc();
    List<Appointment> findByDoctor(Doctor d);
    List<Appointment> findByPatient(Patient p);
    List<Appointment> findByDoctorAndDate(Doctor d,LocalDate date);
}
