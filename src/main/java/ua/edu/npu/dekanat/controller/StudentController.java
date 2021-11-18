package ua.edu.npu.dekanat.controller;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.edu.npu.dekanat.model.Student;
import ua.edu.npu.dekanat.services.StudentService;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Controller
@RequestMapping(path="api/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
//        this.studentService = new StudentService();
        this.studentService = studentService;
    }

    @GetMapping
    public ModelAndView getStudents() {
        ModelAndView mav = new ModelAndView("student-list");
        mav.addObject("something", "Student list");
        mav.addObject("students", studentService.getStudents());
        return mav;
    }

    @GetMapping(path = "/addNew")
    public ModelAndView showAddForm() {
        ModelAndView mav = new ModelAndView("add-student-form");
        Student student = new Student();
        mav.addObject("new_student", student);
        return mav;
    }

    @PostMapping
    public String addNewStudent(@ModelAttribute Student student) {
        studentService.addNewStudent(student);
        return "redirect:/api/student";
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }
}
