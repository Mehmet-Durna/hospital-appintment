package be.thomasmore.hospitalappintment.repositories;

import be.thomasmore.hospitalappintment.model.Hospital;
import org.aspectj.weaver.ast.And;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HospitalRepository  extends CrudRepository<Hospital,Integer> {
    Optional<Hospital> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Hospital> findFirstByIdGreaterThanOrderById(int id);
    Optional<Hospital> findFirstByOrderByIdDesc();
    Optional<Hospital> findFirstByOrderByIdAsc();


    @Query("SELECT h from Hospital h "+
            "WHERE (:min is null or h.capacity >= : min) " +
            "And (:max is null or h.capacity <= : max ) "+
            "AND (:distance IS NULL OR h.distanceFromPublicTransportInKm <= :distance) " +
            "AND (:freeParking IS NULL OR h.freeParkingAvailable = :freeParking) "  )
    List<Hospital> findByCapacityDistanceParking(
            @Param("min")Integer minimumCapacity,@Param("max") Integer maximumCapacity,  @Param("distance") Double distance,@Param("freeParking") Boolean freeParking);
}
