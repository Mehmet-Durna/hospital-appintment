package be.thomasmore.hospitalappintment.repositories;

import be.thomasmore.hospitalappintment.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String name);
}
