package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.exception.InvalidFieldException;
import com.springboot.model.Student;
import com.springboot.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;

	@PostMapping
    public String saveStudentInformation(@RequestHeader("student-auth-key") String authorization,
                                         @RequestBody Student student) {
        if (student.lastName() == null || student.lastName().isBlank()) {
            throw new InvalidFieldException("Last Name is a required field");
        }
        return String.format("Authorization %s is valid, and Data is saved", authorization);
    }

	@GetMapping
	  public List<Student> fetchAllStudentInformation() {
        return studentService.getAllStudents();
    }
}
