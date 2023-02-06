package edu.miu.cs.lab10eregistrar.Service;

import edu.miu.cs.lab10eregistrar.Model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAll();

    List<Student> search(String keyword);

    Student create(Student student);

    Student update(Student student);

    void delete(Long id);

    Student get(Long id);
}
