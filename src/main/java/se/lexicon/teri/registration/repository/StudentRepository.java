package se.lexicon.teri.registration.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.teri.registration.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, String> {

    Optional<Student> findByEmailIgnoreCase(String email);

    List<Student> findByFirstNameIgnoreCase(String firstName);

    List<Student> findByLastNameIgnoreCase(String lastName);

    List<Student> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);
}
