package ua.edu.npu.dekanat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.edu.npu.dekanat.model.Student;
import ua.edu.npu.dekanat.repo.StudentRepository;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentConfig(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student ivan = new Student(
                    1L,
                    "Ivan",
                    "i.ivanov@student.npu.edu.ua",
                    LocalDate.of(2000, 12, 2),
                    20
            );

            Student maria = new Student(
                    2L,
                    "Maria",
                    "m.marainko@student.npu.edu.ua",
                    LocalDate.of(2001, 5, 12),
                    19
            );

            repository.saveAll(List.of(ivan, maria));
        };
    }

}
