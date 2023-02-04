package be.thomasmore.hospitalappintment.service;

import be.thomasmore.hospitalappintment.model.Appointment;
import be.thomasmore.hospitalappintment.model.Doctor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface DoctorService {

    List<Doctor> findAll();

    Doctor getDoctorById(Integer id);

    Optional<Doctor> findPreviousDoctor(Integer id);

    Optional<Doctor> findNextDoctor(Integer id);

    Optional<Doctor> findFirstDoctor();

    Optional<Doctor> findLastDoctor();

    ArrayList<LocalTime> getAvailableAppointmentTimes(List<Appointment> appointments);
}
