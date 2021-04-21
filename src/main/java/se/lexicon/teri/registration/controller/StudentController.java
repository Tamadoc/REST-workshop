package se.lexicon.teri.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.teri.registration.entity.Student;
import se.lexicon.teri.registration.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    private StudentRepository repository;

    @Autowired
    public void setStudentRepository(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> studentList = (List<Student>) repository.findAll();

        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") String id) {
        Optional<Student> student = repository.findById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        repository.deleteById(id);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        Student result = repository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/")
    public ResponseEntity<Student> update(@RequestBody Student student) {
        return ResponseEntity.ok(repository.save(student));
    }
}
