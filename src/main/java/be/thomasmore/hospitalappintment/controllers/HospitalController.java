package be.thomasmore.hospitalappintment.controllers;


import be.thomasmore.hospitalappintment.model.Hospital;
import be.thomasmore.hospitalappintment.repositories.DepartmentRepository;
import be.thomasmore.hospitalappintment.repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class HospitalController {

    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private DepartmentRepository departmentRepository;


    @GetMapping("/hospitallist")
    public String hospitalList(Model model){
        Iterable<Hospital> hospitals = hospitalRepository.findAll();
        model.addAttribute("hospitals",hospitals);
        return "hospitallist";
    }


    @GetMapping({"/hospitaldetails", "/hospitaldetails/{id}"})
    public String hospitaldetails(Model model, @PathVariable(required = false) Integer id) {
        if (id==null) return "hospitaldetails";
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        Optional<Hospital> optionalPrev = hospitalRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Hospital> optionalNext = hospitalRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalHospital.isPresent()) {
            Hospital h = optionalHospital.get();
            model.addAttribute("hospital", h);
            model.addAttribute("departments", departmentRepository.findByHospital(h));
        }
        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", hospitalRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", hospitalRepository.findFirstByOrderByIdAsc().get().getId());
        }
        return "hospitaldetails";
    }

    @GetMapping("/hospitallist/filter")
    public String hospitalListWithFilter(Model model,
                                         @RequestParam(required = false) Integer minimumCapacity,
                                         @RequestParam(required = false) Integer maximumCapacity,
                                         @RequestParam(required = false) Double distance,
                                         @RequestParam(required = false) String freeParking) {
        List<Hospital> hospitals = hospitalRepository.findByCapacityDistanceParking(
                minimumCapacity, maximumCapacity, distance,
                ((freeParking==null || freeParking.equals("all")) ? null : (freeParking.equals("yes") ? true : false)));
        model.addAttribute("maxCapacity", maximumCapacity);
        model.addAttribute("minCapacity", minimumCapacity);
        model.addAttribute("distance", distance);
        model.addAttribute("freeParking", freeParking);
        model.addAttribute("hospitals", hospitals);
        model.addAttribute("nrHospitals", hospitals.size());
        model.addAttribute("showFilter", true);
        return "hospitallist";
    }
}
