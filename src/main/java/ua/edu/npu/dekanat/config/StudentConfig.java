package ua.edu.npu.dekanat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.edu.npu.dekanat.model.Student;
import ua.edu.npu.dekanat.repo.StudentRepository;

import java.time.LocalDate;
import java.time.Month;
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
                    LocalDate.of(2001, 5, 27)
            );

            Student maria = new Student(
                    2L,
                    "Maria",
                    "m.marainko@student.npu.edu.ua",
                    LocalDate.of(2001, 5, 12)
            );

            Student olga = new Student(
                    3L,
                    "Olga",
                    "o.koroleva@student.npu.edu.ua",
                    LocalDate.of(2003, Month.JUNE, 10)
            );

            Student oleg = new Student(
                    4L,
                    "Oleg",
                    "o.olegko@student.npu.edu.ua",
                    LocalDate.of(2001, Month.DECEMBER, 31)
            );

            Student ivan2 = new Student(
                    5L,
                    "Ivan",
                    "i.ivanovski@student.npu.edu.ua",
                    LocalDate.of(2001, 5, 27)
            );

            Student maria2 = new Student(
                    6L,
                    "Maria",
                    "m.marainkova@student.npu.edu.ua",
                    LocalDate.of(2001, 5, 12)
            );

            Student olga2 = new Student(
                    7L,
                    "Olga",
                    "o.korolevska@student.npu.edu.ua",
                    LocalDate.of(2003, Month.JUNE, 10)
            );

            Student oleg2 = new Student(
                    8L,
                    "Oleg",
                    "o.olegkov@student.npu.edu.ua",
                    LocalDate.of(2001, Month.DECEMBER, 31)
            );

            Student ivan3 = new Student(
                    9L,
                    "Ivan",
                    "i.ivanovkin@student.npu.edu.ua",
                    LocalDate.of(2001, 5, 27)
            );

            Student maria3 = new Student(
                    10L,
                    "Maria",
                    "m.marainenko@student.npu.edu.ua",
                    LocalDate.of(2001, 5, 12)
            );

            Student olga3 = new Student(
                    11L,
                    "Olga",
                    "o.korolenko@student.npu.edu.ua",
                    LocalDate.of(2003, Month.JULY, 10)
            );

            Student oleg3 = new Student(
                    12L,
                    "Oleg",
                    "o.heelovski@student.npu.edu.ua",
                    LocalDate.of(2001, Month.DECEMBER, 31)
            );

            repository.saveAll(List.of(
                    ivan, maria, olga, oleg,
                    ivan2, maria2, olga2, oleg2,
                    ivan3, maria3, olga3, oleg3));
        };
    }

}
