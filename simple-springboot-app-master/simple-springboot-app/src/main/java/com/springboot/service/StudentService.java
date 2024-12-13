package com.springboot.service;

import com.springboot.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getAllStudentHistory() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("1", "John Doe", "D", "30"));
        studentList.add(new Student("2", "Jane Smith", "A", "32"));
        for (Student student : studentList) {
            System.out.println(student);
        }
        return studentList;
    }

    public Student getStudentDetailsByName(String studentName) {
        Student studentData = null;
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("1", "John Doe", "D", "30"));
        studentList.add(new Student("2", "Jane Smith", "A", "32"));
        studentName = "John Doe";
        for (Student student : studentList) {
            if (student.firstName().equals(studentName)) {
                studentData = student;
                System.out.println(student);
            }
        }
        return studentData;
    }
}