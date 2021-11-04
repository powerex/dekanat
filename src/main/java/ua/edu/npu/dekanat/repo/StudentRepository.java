package ua.edu.npu.dekanat.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.edu.npu.dekanat.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
