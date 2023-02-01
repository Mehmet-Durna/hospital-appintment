package be.thomasmore.hospitalappintment.repositories;

import be.thomasmore.hospitalappintment.model.Hospital;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HospitalRepository  extends CrudRepository<Hospital,Integer> {
    Optional<Hospital> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Hospital> findFirstByIdGreaterThanOrderById(int id);
    Optional<Hospital> findFirstByOrderByIdDesc();
    Optional<Hospital> findFirstByOrderByIdAsc();
}
