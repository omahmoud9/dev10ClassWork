package learn.foraging.data;

import learn.foraging.models.Category;
import learn.foraging.models.Item;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ItemFileRepositoryTest {

    ItemFileRepository repository = new ItemFileRepository("./data/items-test.txt");

    @Test
    void shouldFindAll() {
        assertTrue(repository.findAll().size() > 0);
    }

    @Test
    void shouldFindPapaw() {
        Item papaw = repository.findById(6);
        assertNotNull(papaw);
        assertEquals("Papaw", papaw.getName());
        assertEquals(Category.EDIBLE, papaw.getCategory());
        assertEquals(new BigDecimal("9.99"), papaw.getDollarPerKilogram());
    }

    @Test
    void shouldCreateNewFile() throws DataException {
        String path = "./data/items-new.txt";
        File file = new File(path);
        file.delete();

        ItemFileRepository repository = new ItemFileRepository(path);
        Item item = new Item();
        item.setName("Catalpa");
        item.setCategory(Category.INEDIBLE);
        item.setDollarPerKilogram(BigDecimal.ZERO);
        item = repository.add(item);

        assertEquals(1, item.getId());
        assertEquals(1, repository.findAll().size());
    }


}