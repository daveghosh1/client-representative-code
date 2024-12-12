package com.springboot.controller;

import com.springboot.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.springboot.exception.InvalidFieldException;
import com.springboot.model.Student;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	@PostMapping
	public String saveStudentInformation(@RequestHeader("student-auth-key") String authorization,
			@RequestBody Student student) {
		if (StringUtils.isBlank(student.lastName())) {
			throw new InvalidFieldException("Last Name is a required field");
		}
		return String.format("Authorization %s is valid, and Data is saved", authorization);
	}

	/**
	 * Get api call for fetching list of students
	 *
	 * @return List of Students
	 */
	@GetMapping(value = "/students")
	public List<Student> getAllHistory() {
		List<Student> allStudentHistory = studentService.getAllStudentHistory();
		return allStudentHistory;
	}

	/**
	 * Get api call for fetching student data based on student name
	 *
	 * @return Student info
	 */
	@GetMapping(value = "/{studentName}")
	public Student getStudentByName(@PathVariable String studentName) {
		Student studentDetail = studentService.getStudentDetailsByName(studentName);
		return studentDetail;
	}
}