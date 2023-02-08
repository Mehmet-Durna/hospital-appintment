package be.thomasmore.hospitalappintment.controllers;


import be.thomasmore.hospitalappintment.model.Appointment;
import be.thomasmore.hospitalappintment.model.Department;


import be.thomasmore.hospitalappintment.repositories.AppointmentRepository;
import be.thomasmore.hospitalappintment.repositories.DepartmentRepository;

import be.thomasmore.hospitalappintment.repositories.DoctorRepository;
import be.thomasmore.hospitalappintment.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;



    @ModelAttribute("appointment")
    public Appointment findAppointment(@PathVariable(required = false) Integer id) {
        if (id!=null) {
            Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
            if (optionalAppointment.isPresent()) return optionalAppointment.get();
        }
        return new Appointment();
    }


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



    @GetMapping("/appointmentedit/{id}")
    public String appointmentEdit(Model model, @PathVariable int id) {

        return "admin/appointmentedit";
    }

    @PostMapping("/appointmentedit/{id}")
    public String appointmentEditPost(Model model, @PathVariable int id, @ModelAttribute("appointment") Appointment appointment) {
        appointmentRepository.save(appointment);
        return "redirect:/appointmentdetails/"+id;
    }

    @GetMapping("/appointmentnew/{patientId}/{doctorId}")
    public String appointmentNew(Model model,@PathVariable int patientId,@PathVariable int doctorId) {

        model.addAttribute("doctor", doctorRepository.findById(doctorId));
        model.addAttribute("patient", patientRepository.findById(patientId));
        return "admin/appointmentnew";
    }

    @PostMapping("/appointmentnew")
    public String appointmentNewPost(Model model, @ModelAttribute("appointment")  Appointment appointment) {
        appointmentRepository.save(appointment);
        return "redirect:/appointmentdetails/"+appointment.getId();
    }


}
