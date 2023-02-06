package edu.miu.cs.lab10eregistrar.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "student10")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String studentNumber;

    @NotBlank
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = true)
    private String middleName;

    @NotBlank
    @Column(nullable = false)
    private String lastName;

    @Column(nullable = true)
    private double cgpa;

    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate enrolmentDate;

    @Column(nullable = false)
    private boolean isInternational;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cgpa=" + cgpa +
                ", enrolmentDate=" + enrolmentDate +
                ", isInternational=" + isInternational +
                '}';
    }
}


