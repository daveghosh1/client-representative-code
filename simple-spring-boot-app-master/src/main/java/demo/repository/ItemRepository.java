package demo.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import demo.domain.Item;

/**
 * Repository interface for managing Item entities.
 */
public interface ItemRepository extends CrudRepository<Item, Long> {

    /**
     * Find items by their name.
     *
     * @param name the name of the item
     * @return the list of items with the given name
     */
    List<Item> findItemByName(String name);
}