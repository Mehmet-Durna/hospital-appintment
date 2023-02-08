package be.thomasmore.hospitalappintment.controllers;

import be.thomasmore.hospitalappintment.model.Doctor;
import be.thomasmore.hospitalappintment.repositories.AppointmentRepository;
import be.thomasmore.hospitalappintment.service.DoctorService;
import lombok.AllArgsConstructor;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.*;


@Controller
@AllArgsConstructor
public class DoctorController {


    private DoctorService doctorService;
    private AppointmentRepository appointmentRepository;

    @GetMapping("/doctorlist")
    public String doctorlist(Model model) {
        Iterable<Doctor> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        return "doctorlist";
    }

    @GetMapping({"/doctordetails", "/doctordetails/{id}"})
    public String doctordetails(Model model, @PathVariable(required = false) Integer id,
                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                LocalDate today) {



        if (id == null) return "doctordetails";
        val doctor = doctorService.getDoctorById(id);
        val optionalPrev = doctorService.findPreviousDoctor(id);
        val optionalNext = doctorService.findNextDoctor(id);
        val allAppointments = appointmentRepository.findByDoctor(doctor);
        val todaysAppointments = appointmentRepository.findByDoctorAndDate(doctor,today.now());
        model.addAttribute("doctor", doctor);
        model.addAttribute("todayDate", today.now());
        model.addAttribute("allAppointments", allAppointments);
        model.addAttribute("todaysAppointments", todaysAppointments);
        model.addAttribute("availableSlots",
                doctorService.getAvailableAppointmentTimes(todaysAppointments).stream().toList());

        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", doctorService.findFirstDoctor().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", doctorService.findLastDoctor().get().getId());
        }

        return "doctordetails";
    }
}
