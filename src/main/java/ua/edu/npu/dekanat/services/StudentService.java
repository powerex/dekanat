package ua.edu.npu.dekanat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.edu.npu.dekanat.model.Student;
import ua.edu.npu.dekanat.repo.StudentRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> foundedStudentByEmail = studentRepository
                .findStudentByEmail(student.getEmail());
        if (foundedStudentByEmail.isPresent()) {
            throw new IllegalStateException("Email exists");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalStateException("No such student with id = " + id);
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentId + " not in database"
                ));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(), email)) {
            Optional<Student> foundedStudentByEmail = studentRepository
                    .findStudentByEmail(email);
            if (foundedStudentByEmail.isPresent()) {
                throw new IllegalStateException("Email already taken");
            }
            student.setEmail(email);
        }
    }
}
