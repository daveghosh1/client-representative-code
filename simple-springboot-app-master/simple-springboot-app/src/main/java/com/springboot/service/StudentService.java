package com.springboot.service;
import com.springboot.model.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public List<Student> getAllStudentHistory() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("1", "Linakar", "Sri", "30"));
        studentList.add(new Student("2", "Pawan", "A", "32"));
        for (Student student : studentList) {
            System.out.println(student);
        }
        return studentList;
    }

public Student getStudentDetailsByName(String studentName) {
    Student studentData = null;
    List<Student> studentList = new ArrayList<>();
    studentList.add(new Student("1", "Liankar", "sri", "30"));
    studentList.add(new Student("2", "Maruthi", "A", "32"));
    studentName = "Linakar";
    if(studentList.size() > 0) {
        for (Student student : studentList) {
            if (student.firstName().equals(studentName)) {
                studentData = student;
                System.out.println(student);
            }
        }
    }
    return studentData;
    }
}
