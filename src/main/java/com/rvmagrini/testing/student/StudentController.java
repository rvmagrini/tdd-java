package com.rvmagrini.testing.student;

import com.rvmagrini.testing.student.exception.BadRequestException;
import com.rvmagrini.testing.student.exception.StudentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("testing")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public void addStudent(@Valid @RequestBody Student student) throws BadRequestException {
        studentService.addStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) throws StudentNotFoundException {
        studentService.deleteStudent(studentId);
    }

}
