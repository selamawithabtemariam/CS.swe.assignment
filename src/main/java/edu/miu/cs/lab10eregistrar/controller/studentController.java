package edu.miu.cs.lab10eregistrar.controller;

import edu.miu.cs.lab10eregistrar.Model.Student;
import edu.miu.cs.lab10eregistrar.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class studentController {

    @Autowired
    private StudentService studentService;

    //localhost:8080/student/list
    @GetMapping("/list")
    public String getStudents(Model model) {
        List<Student> students = studentService.getAll();
        model.addAttribute("students", students);
        return "student/list";
    }

    //localhost:8080/student/search?keyword=John
    @GetMapping("/search")
    public String searchStudent(@RequestParam("keyword") String keyword, Model model) {
        List<Student> students = studentService.search(keyword);
        model.addAttribute("students", students);
        return "student/list";
    }

    @PostMapping("/new")
    public String createStudent(@RequestBody Student student, Model model) {
        student = studentService.create(student);
        model.addAttribute("student", student);
        return "student/create";
    }

    @PutMapping("/edit/{studentId}")
    public String updateStudent(@PathVariable Long studentId, @RequestBody Student student, Model model) {
        Student existingStudent = studentService.get(studentId);

        if (existingStudent == null) {
            model.addAttribute("student", student);
            model.addAttribute("error", "Invalid request");
            return "student/edit"; //Throw exception
        }

        student = studentService.update(student);

        //Option-1
        model.addAttribute("student", student);
        model.addAttribute("success", "Student successfully updated");
        return "student/edit";

        //Option-2
        //return getStudents(model);
    }

    @DeleteMapping("/delete/{studentId}")
    public String delete(@PathVariable Long studentId, Model model) {
        Student existingStudent = studentService.get(studentId);

        if (existingStudent == null) {
            model.addAttribute("error", "Invalid request");
            return "student/list"; //Throw exception
        }

        studentService.delete(studentId);

        model.addAttribute("success", "Student successfully deleted");
        return getStudents(model);
    }

}
