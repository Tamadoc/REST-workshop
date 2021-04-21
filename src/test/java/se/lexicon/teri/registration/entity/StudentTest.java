package se.lexicon.teri.registration.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentTest {

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student();
        student.setFirstName("Teri");
        student.setLastName("Sandstedt");
        student.setAge(46);
        student.setGender("Female");
        student.setEmail("teri@test.se");
        student.setPhoneNumber("123456789");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test_createdStudentIdUnsaved() {
        assertNull(student.getId());
    }

    @Test
    void test_createdStudentName() {
        assertEquals("Teri", student.getFirstName());
    }

    @Test
    void test_createdStudentStatus() {
        assertTrue(student.isStatus());
    }
}