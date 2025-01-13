package com.springboot;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.springboot.model.Student;
import com.springboot.service.StudentService;
@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StudentService studentService;
    private List<Student> studentList;
    @BeforeEach
    public void setUp() {
        studentList = Arrays.asList(
                new Student("1", "Abraham", "John", "20"),
                new Student("2", "Jane", "Doe", "22")
        );
    }
    @Test
    public void testFetchAllStudentInformation() throws Exception {
        when(studentService.getAllStudents()).thenReturn(studentList);
        mockMvc.perform(get("/student")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":\"1\",\"firstName\":\"Abraham\",\"lastName\":\"John\",\"age\":\"20\"}," +
                        "{\"id\":\"2\",\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"age\":\"22\"}]"));
    }
    @Test
    public void testSaveStudentInformation() throws Exception {
        String studentJson = "{\"id\":\"3\",\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":\"25\"}";
        mockMvc.perform(post("/student")
                .header("student-auth-key", "valid-auth-key")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Authorization valid-auth-key is valid, and Data is saved"));
    }
}