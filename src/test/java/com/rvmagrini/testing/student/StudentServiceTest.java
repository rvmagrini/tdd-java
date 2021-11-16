package com.rvmagrini.testing.student;

import com.rvmagrini.testing.student.exception.BadRequestException;
import com.rvmagrini.testing.student.exception.StudentNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentService(studentRepository);
    }

    @Test
    void canGetAllStudents() {
        // when
        studentService.getAllStudents();

        //then
        verify(studentRepository).findAll();
    }

    @Test
    void canAddStudent() throws BadRequestException {
        // given
        Student student = new Student("Jones", "jones@gmail.com", Gender.MALE);

        // when
        studentService.addStudent(student);

        // then
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);

        verify(studentRepository).save(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();

        assertThat(capturedStudent).isEqualTo(student);
    }

    @Test
    void willThrowWhenEmailIsTaken() {
        // given
        Student student = new Student("Jones", "jones@gmail.com", Gender.MALE);

        given(studentRepository.selectExistsEmail(student.getEmail())).willReturn(true);

        // when
        // then
        assertThatThrownBy(() -> studentService.addStudent(student))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Email " + student.getEmail() + " already taken");

        verify(studentRepository, never()).save(any());

    }

    @Test
    void canDeleteStudent() throws StudentNotFoundException {
        // given
        Long studentId = 10L;

        given(studentRepository.existsById(studentId)).willReturn(true);

        // when
        studentService.deleteStudent(studentId);

        // then
        verify(studentRepository).deleteById(studentId);
    }

    @Test
    void willThrowWhenStudentNotFound() {
        // given
        Long studentId = 10L;

        given(studentRepository.existsById(studentId)).willReturn(false);

        // when
        // then
        assertThatThrownBy(() -> studentService.deleteStudent(studentId))
                .isInstanceOf(StudentNotFoundException.class)
                .hasMessageContaining("Student with id " + studentId + " does not exist");

        verify(studentRepository, never()).deleteById(any());

    }
}