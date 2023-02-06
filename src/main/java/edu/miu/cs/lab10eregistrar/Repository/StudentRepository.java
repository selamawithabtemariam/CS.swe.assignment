package edu.miu.cs.lab10eregistrar.Repository;

import edu.miu.cs.lab10eregistrar.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentByFirstNameOrLastNameOrMiddleNameOrStudentNumber(String keyword1, String keyword2, String keyword3, String keyword4);
}
