package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.model.Student;

@Service
public class StudentService {

    public List<Student>getAllStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("1", "Abraham", "John", "20"));
        students.add(new Student("2", "Jane", "Doe", "22"));
        return students;
    }
}
