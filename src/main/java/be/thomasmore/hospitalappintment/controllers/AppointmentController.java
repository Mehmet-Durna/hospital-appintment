package be.thomasmore.hospitalappintment.controllers;


import be.thomasmore.hospitalappintment.model.Appointment;
import be.thomasmore.hospitalappintment.model.Department;


import be.thomasmore.hospitalappintment.repositories.AppointmentRepository;
import be.thomasmore.hospitalappintment.repositories.DepartmentRepository;

import be.thomasmore.hospitalappintment.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;


    @GetMapping({"/appointmentdetails", "/appointmentdetails/{id}"})
    public String appointmentdetails(Model model, @PathVariable(required = false) Integer id) {
        if (id==null) return "appointmentdetails";
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        Optional<Appointment> optionalPrev = appointmentRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Appointment> optionalNext = appointmentRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalAppointment.isPresent()) {
            Appointment a= optionalAppointment.get();
            model.addAttribute("appointment", a);
        }
        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", appointmentRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", appointmentRepository.findFirstByOrderByIdAsc().get().getId());
        }
        return "appointmentdetails";
    }


}
