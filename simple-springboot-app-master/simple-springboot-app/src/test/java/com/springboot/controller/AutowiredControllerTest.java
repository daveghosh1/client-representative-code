package com.springboot.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.springboot.service.Animal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.*;

@WebMvcTest(AutowiredController.class)
public class AutowiredControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Qualifier("dog")
    private Animal animal;

    @InjectMocks
    private AutowiredController autowiredController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(autowiredController).build();
    }

    @Test
    public void testFetchDogCharacteristics() throws Exception {
        when(animal.characteristics()).thenReturn("Barks");

        mockMvc.perform(get("/autowire"))
                .andExpect(status().isOk())
                .andExpect(content().string("Barks"));
    }
}