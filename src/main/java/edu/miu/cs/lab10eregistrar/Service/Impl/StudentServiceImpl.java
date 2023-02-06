package edu.miu.cs.lab10eregistrar.Service.Impl;

import edu.miu.cs.lab10eregistrar.Model.Student;
import edu.miu.cs.lab10eregistrar.Repository.StudentRepository;
import edu.miu.cs.lab10eregistrar.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> search(String keyword) {
        return studentRepository.findStudentByFirstNameOrLastNameOrMiddleNameOrStudentNumber(keyword, keyword, keyword, keyword);
    }

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {
        Student existing = studentRepository.findById(student.getId()).orElse(null);
        if (existing == null)
            return null; //Throw exception
        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        Student existing = studentRepository.findById(id).orElse(null);
        if (existing == null)
            return; //Throw exception
        studentRepository.delete(existing);
    }

    @Override
    public Student get(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
}
