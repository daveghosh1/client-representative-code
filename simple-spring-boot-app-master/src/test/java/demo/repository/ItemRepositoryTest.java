package demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import demo.domain.Item;

@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Test
    @Transactional
    public void saveItem() throws Exception {
        // Create a new item
        Item item = new Item(0, "Test item", LocalDate.now());
        // Save the item to the repository
        Item saved = repository.save(item);

        // Retrieve the item by its ID
        Item found = repository.findById(saved.getId()).orElse(null);
        // Assert that the name of the found item matches the expected name
        assertEquals("Test item", found.getName());
    }
}