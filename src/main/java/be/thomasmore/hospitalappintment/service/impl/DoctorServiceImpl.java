package be.thomasmore.hospitalappintment.service.impl;

import be.thomasmore.hospitalappintment.model.Appointment;
import be.thomasmore.hospitalappintment.model.Doctor;
import be.thomasmore.hospitalappintment.repositories.DoctorRepository;
import be.thomasmore.hospitalappintment.service.DoctorService;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Integer id) {
        return doctorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found!"));
    }

    @Override
    public Optional<Doctor> findPreviousDoctor(Integer id) {
        return doctorRepository.findFirstByIdLessThanOrderByIdDesc(id);
    }

    @Override
    public Optional<Doctor> findNextDoctor(Integer id) {
        return doctorRepository.findFirstByIdGreaterThanOrderById(id);
    }

    @Override
    public Optional<Doctor> findFirstDoctor() {
        return doctorRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public Optional<Doctor> findLastDoctor() {
        return doctorRepository.findFirstByOrderByIdAsc();
    }

    @Override
    public ArrayList<LocalTime> getAvailableAppointmentTimes(List<Appointment> appointments) {
        val allSlots = new ArrayList<LocalTime>();
        var startOfDay = LocalTime.parse("08:00");
        for (int i = 0; i < 18; i++) {
            allSlots.add(startOfDay);
            startOfDay = startOfDay.plusMinutes(30);
        }
        appointments.forEach(appointment -> {
            val appointmentTime = appointment.getTime();
            if (allSlots.contains(appointmentTime)) {
                allSlots.remove(appointmentTime);
            }
        });

        return allSlots;
    }
}
