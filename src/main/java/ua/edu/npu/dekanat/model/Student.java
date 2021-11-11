package ua.edu.npu.dekanat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Data
@NoArgsConstructor
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
               allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate birthDay;
    @Transient
    private Integer age;

    public Student(Long id, String name, String email, LocalDate birthDay) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDay = birthDay;
    }

    public Student(String name, String email, LocalDate birthDay) {
        this.name = name;
        this.email = email;
        this.birthDay = birthDay;
    }

    public Integer getAge() {
        return Period.between(birthDay, LocalDate.now()).getYears();
    }
}

