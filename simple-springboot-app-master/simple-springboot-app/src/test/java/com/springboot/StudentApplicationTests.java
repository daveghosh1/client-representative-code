package com.springboot;
import com.springboot.model.Student;
import com.springboot.service.StudentService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentApplicationTests {
	@Mock
	StudentService studentService;

	@Test
	public void testStudentList() {
		List<Student> result = studentService.getAllStudentHistory();
		result.add(new Student("1", "John Doe", "D", "30"));
		result.add(new Student("2", "Jane Smith", "A", "32"));
		when(studentService.getAllStudentHistory()).thenReturn(result);
		Assertions.assertEquals(2, result.size());
		Assertions.assertEquals("John Doe", result.get(0).firstName());
		Assertions.assertEquals("Jane Smith", result.get(1).firstName());
	}
	@Test
	public void testStudentByName() {
		Student student = new Student("2", "Jane Smith", "A", "32");
		studentService.getStudentDetailsByName("Jane Smith");
		when(studentService.getStudentDetailsByName("Jane Smith")).thenReturn(student);
		assertEquals("2", student.id());
		assertEquals ("Jane Smith", student.firstName());
		assertEquals ("A", student.lastName());
		assertEquals ("32", student.age());
	}
}
