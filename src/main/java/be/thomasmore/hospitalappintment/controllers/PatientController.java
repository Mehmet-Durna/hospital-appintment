package be.thomasmore.hospitalappintment.controllers;



import be.thomasmore.hospitalappintment.model.Department;
import be.thomasmore.hospitalappintment.model.Doctor;
import be.thomasmore.hospitalappintment.model.Patient;
import be.thomasmore.hospitalappintment.repositories.AppointmentRepository;
import be.thomasmore.hospitalappintment.repositories.DoctorRepository;
import be.thomasmore.hospitalappintment.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;


    @GetMapping("/patientlist")
    public String doctorlist(Model model){
        Iterable<Patient> patients = patientRepository.findAll();
        model.addAttribute("patients",patients);
        return "patientlist";
    }

    @GetMapping({"/patientdetails", "/patientdetails/{id}"})
    public String patientdetails(Model model, @PathVariable(required = false) Integer id) {
        if (id==null) return "patientdetails";
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        Optional<Patient> optionalPrev = patientRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Patient> optionalNext = patientRepository.findFirstByIdGreaterThanOrderById(id);

        if (optionalPatient.isPresent()) {
           Patient p = optionalPatient.get();
            model.addAttribute("patient",p);
            model.addAttribute("appointments",appointmentRepository.findByPatient(p));
        }

        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", patientRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", patientRepository.findFirstByOrderByIdAsc().get().getId());
        }
        return "patientdetails";
    }


}
