package se.lexicon.teri.registration.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.teri.registration.entity.Student;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryIntegrationTest {

    @Autowired
    private StudentRepository repository;
    private Student student;
    private String studentId;

    @BeforeEach
    void setUp() {
        student = new Student();
        student.setFirstName("Teri");
        student.setLastName("Sandstedt");
        student.setAge(46);
        student.setGender("Female");
        student.setEmail("teri@test.se");
        student.setPhoneNumber("123456789");

        repository.save(student);
        studentId = student.getId();
    }

    @AfterEach
    void tearDown() throws Exception {
        repository.deleteAll();
    }

    @Test
    void test_findByID() {
        Optional<Student> foundStudent = repository.findById(studentId);
        assertEquals(student, foundStudent.get());
    }

    @Test
    void test_findAll() {
        List<Student> students = (List<Student>) repository.findAll();
        int expectedSize = 1;
        assertEquals(expectedSize, students.size());
    }

    @Test
    void test_delete() {
        repository.delete(student);

        List<Student> students = (List<Student>) repository.findAll();
        int expectedSize = 0;
        assertEquals(expectedSize, students.size());
    }

    @Test
    void test_findByEmailIgnoreCase() {
        Optional<Student> foundStudent = repository.findByEmailIgnoreCase("teri@test.se");
        assertEquals(student, foundStudent.get());
    }

    @Test
    void findByFirstNameIgnoreCase() {
        List<Student> students = repository.findByFirstNameIgnoreCase("teri");
        int expectedSize = 1;
        assertEquals(expectedSize, students.size());
    }

    @Test
    void findByLastNameIgnoreCase() {
        List<Student> students = repository.findByLastNameIgnoreCase("sandstedt");
        int expectedSize = 1;
        assertEquals(expectedSize, students.size());
    }

    @Test
    void test_findByFirstNameIgnoreCaseAndLastNameIgnoreCase() {
        List<Student> students = repository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase("teri", "sandstedt");
        int expectedSize = 1;
        assertEquals(expectedSize, students.size());
    }
}