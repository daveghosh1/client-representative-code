package demo.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Item;
import demo.repository.ItemRepository;

/**
 * REST controller for managing items.
 */
@RequestMapping("/api/item")
@RestController
public class ItemService {

    private static final Logger logger = LogManager.getLogger(ItemService.class);

    @Autowired
    ItemRepository itemRepository;

    /**
     * GET /api/item : Get all items.
     *
     * @return the list of items
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Item> getItem() {
        try {
            return List.copyOf(StreamSupport.stream(itemRepository.findAll().spliterator(), false).collect(Collectors.toList()));
        } catch (Exception e) {
            logger.error("Error fetching items", e);
            return List.of();
        }
    }

    /**
     * GET /api/item/{name} : Get items by name.
     *
     * @param name the name of the item
     * @return the list of items with the given name
     */
    @RequestMapping(method = RequestMethod.GET, value = "{name}")
    public List<Item> getItem(@PathVariable String name) {
        try {
            return itemRepository.findItemByName(name);
        } catch (Exception e) {
            logger.error("Error fetching items by name", e);
            return List.of();
        }
    }

    /**
     * POST /api/item : Add a new item.
     *
     * @param item the item to add
     */
    @RequestMapping(method = RequestMethod.POST)
    public void addItem(Item item) {
        try {
            itemRepository.save(item);
        } catch (Exception e) {
            logger.error("Error adding item", e);
        }
    }
}