package be.thomasmore.hospitalappintment.controllers;


import be.thomasmore.hospitalappintment.model.Appointment;
import be.thomasmore.hospitalappintment.model.Department;


import be.thomasmore.hospitalappintment.model.User;
import be.thomasmore.hospitalappintment.repositories.AppointmentRepository;
import be.thomasmore.hospitalappintment.repositories.DepartmentRepository;

import be.thomasmore.hospitalappintment.repositories.DoctorRepository;
import be.thomasmore.hospitalappintment.repositories.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(AppointmentController.class);

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
        logger.info("appointmentedit : "+id);
        model.addAttribute("doctors", doctorRepository.findAll());
        model.addAttribute("patients", patientRepository.findAll());
        return "appointmentedit";
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
        return "appointmentnew";
    }

    @PostMapping("/appointmentnew")
    public String appointmentNewPost(Model model, @ModelAttribute("appointment")  Appointment appointment) {
        logger.info("partyNewPost -- new name=" + appointment.getPatient().getPatientName() + ", date=" + appointment.getDate());
        appointmentRepository.save(appointment);
        return "redirect:/appointmentdetails/"+appointment.getId();
    }






}
