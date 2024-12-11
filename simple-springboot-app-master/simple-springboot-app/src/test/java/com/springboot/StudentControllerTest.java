package com.springboot;


import com.springboot.model.Student;
import com.springboot.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@WebAppConfiguration
public class StudentControllerTest {
    @Mock
    StudentService studentService;

    @Test
    public void getAllHistoryTest() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("1", "John Doe", "D", "30"));
        studentList.add(new Student("2", "Jane Smith", "A", "32"));
        when(studentService.getAllStudentHistory()).thenReturn(studentList);
    }

    @Test
    public void getStudentByNameTest() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("1", "John Doe", "D", "30"));
        studentList.add(new Student("2", "Jane Smith", "A", "32"));
        when(studentService.getStudentDetailsByName("John Doe")).thenReturn(studentList.get(0));
    }

}
