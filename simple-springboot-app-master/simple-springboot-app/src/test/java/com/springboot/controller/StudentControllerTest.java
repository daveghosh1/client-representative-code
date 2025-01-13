package com.springboot.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.springboot.exception.InvalidFieldException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.*;

/**
 * Test class for StudentController.
 */
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private StudentController studentController;


    /**
     * Sets up the test environment.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(studentController)
                .setControllerAdvice(new ExceptionHandlerController())
                .build();
    }

    /**
     * Tests saving valid student information.
     *
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void testSaveStudentInformation_Valid() throws Exception {
        String studentJson = "{\"id\":\"1\",\"firstName\":\"John\",\"lastName\":\"Doe\",\"age\":\"20\"}";
        mockMvc.perform(post("/student")
                        .header("student-auth-key", "valid-key")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Authorization valid-key is valid, and Data is saved"));
    }


    /**
     * Tests saving invalid student information.
     *
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void testSaveStudentInformation_Invalid() throws Exception {
        String studentJson = "{\"id\":\"1\",\"firstName\":\"John\",\"lastName\":\"\",\"age\":\"20\"}";
        mockMvc.perform(post("/student")
                        .header("student-auth-key", "valid-key")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson))
                .andExpect(status().isOk())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof InvalidFieldException))
                .andExpect(result -> assertEquals("Last Name is a required field", result.getResolvedException().getMessage()));
    }
}