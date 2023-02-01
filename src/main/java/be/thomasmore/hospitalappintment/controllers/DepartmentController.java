package be.thomasmore.hospitalappintment.controllers;


import be.thomasmore.hospitalappintment.model.Department;



import be.thomasmore.hospitalappintment.repositories.DepartmentRepository;

import be.thomasmore.hospitalappintment.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/departmentlist")
    public String departmentlist(Model model){
        Iterable<Department> departments = departmentRepository.findAll();
        model.addAttribute("departments",departments);
        return "departmentlist";
    }


    @GetMapping({"/departmentdetails", "/departmentdetails/{id}"})
    public String departmentdetails(Model model, @PathVariable(required = false) Integer id) {
        if (id==null) return "departmentdetails";
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        Optional<Department> optionalPrev = departmentRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Department> optionalNext = departmentRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalDepartment.isPresent()) {
            Department d = optionalDepartment.get();
            model.addAttribute("department", d);
            model.addAttribute("doctors", doctorRepository.findByDepartment(d));
        }
        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", departmentRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", departmentRepository.findFirstByOrderByIdAsc().get().getId());
        }
        return "departmentdetails";
    }


}
