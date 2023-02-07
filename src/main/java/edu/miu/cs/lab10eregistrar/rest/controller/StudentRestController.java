package edu.miu.cs.lab10eregistrar.rest.controller;

import edu.miu.cs.lab10eregistrar.Model.Student;
import edu.miu.cs.lab10eregistrar.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RequestMapping("eregistrar/api/student")
@RestController
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/list", produces = "application/json")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping(value = "/get/{studentId}", produces = "application/json")
    public Student getStudentById(@PathVariable Long studentId) {
        return studentService.get(studentId);
    }

    @PostMapping(value = "/new", produces = "application/json")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) throws URISyntaxException {
        Student student1 = studentService.create(student);
        return ResponseEntity.created(new URI("/api/student/" + student1.getId())).body(student1);
    }

    @PutMapping(value = "/edit/{studentId}", produces = "application/json")
    public Student updateStudent(@PathVariable Long studentId, @RequestBody Student student) {
        return studentService.update(student);
    }

    @DeleteMapping(value = "/delete/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.delete(studentId);
    }
}
