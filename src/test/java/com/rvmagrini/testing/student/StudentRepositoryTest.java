package com.rvmagrini.testing.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @AfterEach
    void tearDown() {
        studentRepository.deleteAll();
    }

    @Test
    void checkWhenStudentEmailExists() {
        // given
        String email = "jones@gmail.com";
        Student student = new Student("Jones", email, Gender.MALE);
        studentRepository.save(student);

        // when
        boolean expected = studentRepository.selectExistsEmail(email);

        // then
        assertThat(expected).isTrue();
    }

    @Test
    void checkWhenStudentEmailDoesNotExist() {
        // given
        String email = "jones@gmail.com";

        // when
        boolean expected = studentRepository.selectExistsEmail(email);

        // then
        assertThat(expected).isFalse();
    }
}