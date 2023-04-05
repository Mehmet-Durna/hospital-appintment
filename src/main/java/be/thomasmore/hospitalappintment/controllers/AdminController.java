package be.thomasmore.hospitalappintment.controllers;

import be.thomasmore.hospitalappintment.model.*;
import be.thomasmore.hospitalappintment.repositories.*;
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
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private DepartmentRepository departmentRepository;


    @ModelAttribute("hospital")
    public Hospital findHospital(@PathVariable(required = false) Integer id) {
        logger.info("findhospital "+id);
        if (id!=null) {
            Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
            if (optionalHospital.isPresent()) return optionalHospital.get();
        }
        return new Hospital();
    }

    @ModelAttribute("department")
    public Department findDepartment(@PathVariable(required = false) Integer id) {
        logger.info("findDepartment "+id);
        if (id!=null) {
            Optional<Department> optionalDepartment = departmentRepository.findById(id);
            if (optionalDepartment.isPresent()) return optionalDepartment.get();
        }
        return new Department();
    }


    @ModelAttribute("doctor")
    public Doctor findDoctor(@PathVariable(required = false) Integer id) {

        if (id!=null) {
            Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
            if (optionalDoctor.isPresent()) return optionalDoctor.get();
        }
        return new Doctor();
    }


    @GetMapping("/doctornew")
    public String doctorNew(Model model) {
        logger.info("doctornew");

        model.addAttribute("departments", departmentRepository.findAll());
        return "admin/doctornew";
    }

    @PostMapping("/doctornew")
    public String doctorNewPost(Model model, @ModelAttribute("doctor")  Doctor doctor) {

        doctorRepository.save(doctor);
        return "redirect:/hospitallist";
    }






    @GetMapping("/departmentnew")
    public String departmentNew(Model model) {
        logger.info("departmentnew");
        model.addAttribute("hospitals", hospitalRepository.findAll());
        model.addAttribute("patients", patientRepository.findAll());
        return "admin/departmentnew";
    }

    @PostMapping("/departmentnew")
    public String departmentNewPost(Model model, @ModelAttribute("department")  Department department) {

        departmentRepository.save(department);
        return "redirect:/hospitallist";
    }







    @GetMapping("/hospitalnew")
    public String hospitalNew(Model model) {
        logger.info("hospitalnew");
        model.addAttribute("doctors", doctorRepository.findAll());
        model.addAttribute("patients", patientRepository.findAll());
        return "admin/hospitalnew";
    }

    @PostMapping("/hospitalnew")
    public String hospitalNewPost(Model model, @ModelAttribute("hospital")  Hospital hospital) {

        hospitalRepository.save(hospital);
        return "redirect:/hospitallist";
    }

    @GetMapping("/adminrights")
    public String adminRightsDecider(Model model, User user){
        model.addAttribute("user",user);
        return "admin/adminrights";
    }

//    @ModelAttribute("appointment")
//    public Appointment findAppointment(@PathVariable(required = false) Integer id) {
//        logger.info("findAppointment "+id);
//        if (id!=null) {
//            Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
//            if (optionalAppointment.isPresent()) return optionalAppointment.get();
//        }
//        return new Appointment();
//    }

//    @GetMapping("/appointmentedit/{id}")
//    public String appointmentEdit(Model model, @PathVariable int id) {
//        logger.info("appointmentedit : "+id);
//        model.addAttribute("doctors", doctorRepository.findAll());
//        model.addAttribute("patients", patientRepository.findAll());
//        return "admin/appointmentedit";
//    }
//
//    @PostMapping("/appointmentedit/{id}")
//    public String appointmentEditPost(Model model, @PathVariable int id, @ModelAttribute("appointment") Appointment appointment) {
//        logger.info("appointmentEditPost " + id + " -- new name=" + appointment.getPatient().getPatientName());
//        appointmentRepository.save(appointment);
//        return "redirect:/appointmentdetails/"+id;
//    }
//

}
