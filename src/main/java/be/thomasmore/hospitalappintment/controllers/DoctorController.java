package be.thomasmore.hospitalappintment.controllers;



import be.thomasmore.hospitalappintment.model.Department;
import be.thomasmore.hospitalappintment.model.Doctor;
import be.thomasmore.hospitalappintment.repositories.AppointmentRepository;
import be.thomasmore.hospitalappintment.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("/doctorlist")
    public String doctorlist(Model model){
        Iterable<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("doctors",doctors);
        return "doctorlist";
    }

    @GetMapping({"/doctordetails", "/doctordetails/{id}"})
    public String doctordetails(Model model, @PathVariable(required = false) Integer id) {
        if (id==null) return "doctordetails";
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        Optional<Doctor> optionalPrev = doctorRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Doctor> optionalNext = doctorRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalDoctor.isPresent()) {
            Doctor d = optionalDoctor.get();
            model.addAttribute("doctor",d);
            model.addAttribute("appointments",appointmentRepository.findByDoctor(d));
        }

        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", doctorRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", doctorRepository.findFirstByOrderByIdAsc().get().getId());
        }
        return "doctordetails";
    }


}
