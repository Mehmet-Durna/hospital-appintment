package be.thomasmore.hospitalappintment.controllers;

import be.thomasmore.hospitalappintment.model.Appointment;
import be.thomasmore.hospitalappintment.model.User;
import be.thomasmore.hospitalappintment.repositories.AppointmentRepository;
import be.thomasmore.hospitalappintment.repositories.DoctorRepository;
import be.thomasmore.hospitalappintment.repositories.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;


    @ModelAttribute("appointment")
    public Appointment findAppointment(@PathVariable(required = false) Integer id) {
        logger.info("findAppointment "+id);
        if (id!=null) {
            Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
            if (optionalAppointment.isPresent()) return optionalAppointment.get();
        }
        return new Appointment();
    }

    @GetMapping("/appointmentedit/{id}")
    public String appointmentEdit(Model model, @PathVariable int id) {
        logger.info("appointmentedit : "+id);
        model.addAttribute("doctors", doctorRepository.findAll());
        model.addAttribute("patients", patientRepository.findAll());
        return "admin/appointmentedit";
    }

    @PostMapping("/appointmentedit/{id}")
    public String appointmentEditPost(Model model, @PathVariable int id, @ModelAttribute("appointment") Appointment appointment) {
        logger.info("appointmentEditPost " + id + " -- new name=" + appointment.getPatient().getPatientName());
        appointmentRepository.save(appointment);
        return "redirect:/appointmentdetails/"+id;
    }

    @GetMapping("/appointmentnew")
    public String appointmentNew(Model model) {
        logger.info("appointmentnew");
        model.addAttribute("doctors", doctorRepository.findAll());
        model.addAttribute("patients", patientRepository.findAll());
        return "admin/appointmentnew";
    }

    @PostMapping("/appointmentnew")
    public String appointmentNewPost(Model model, @ModelAttribute("appointment")  Appointment appointment) {
        logger.info("partyNewPost -- new name=" + appointment.getPatient().getPatientName() + ", date=" + appointment.getDate());
        appointmentRepository.save(appointment);
        return "redirect:/appointmentdetails/"+appointment.getId();
    }

    @GetMapping("/adminrights")
    public String adminRightsDecider(Model model, User user){
        model.addAttribute("user",user);
        return "admin/adminrights";
    }
}
