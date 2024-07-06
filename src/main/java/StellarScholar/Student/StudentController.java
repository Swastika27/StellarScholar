package StellarScholar.Student;

import StellarScholar.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/stellar_scholar")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public List<StudentModel> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentModel> getStudentById (@PathVariable(value = "id") Long studentId) throws ResourceNotFoundException {
        return studentService.getStudentById(studentId);
    }

    @PostMapping("/student")
    public StudentModel createStudent(@Valid @RequestBody StudentModel student) {
        return studentService.createStudent(student);
    }
}
