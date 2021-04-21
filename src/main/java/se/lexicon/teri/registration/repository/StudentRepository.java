package se.lexicon.teri.registration.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.teri.registration.entity.Student;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, String> {

    Optional<Student> findByEmail(String email);
    Optional<Student> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);
}
