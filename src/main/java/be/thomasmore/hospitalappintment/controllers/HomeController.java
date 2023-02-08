package be.thomasmore.hospitalappintment.controllers;

import be.thomasmore.hospitalappintment.model.Department;
import be.thomasmore.hospitalappintment.model.Hospital;
import be.thomasmore.hospitalappintment.model.Patient;
import be.thomasmore.hospitalappintment.model.User;
import be.thomasmore.hospitalappintment.repositories.DepartmentRepository;
import be.thomasmore.hospitalappintment.repositories.HospitalRepository;
import be.thomasmore.hospitalappintment.repositories.PatientRepository;
import be.thomasmore.hospitalappintment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.security.Principal;



@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PatientRepository patientRepository;


    @GetMapping({"/", "/home"})
    public String home(Model model, Principal principal) {



        return "home";
    }





}