package demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        // Test to ensure the Spring application context loads successfully
    }

    @Test
    void testBeanPresence() {
        // Test to ensure a specific bean is present in the application context
        assertNotNull(applicationContext.getBean(DemoApplication.class), "DemoApplication bean should be present");
    }
}