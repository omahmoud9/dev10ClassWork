package learn.foraging.data;

import learn.foraging.models.Forage;
import learn.foraging.models.Forager;
import learn.foraging.models.Item;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ForageFileRepositoryTest {

    LocalDate date = LocalDate.of(2020, 6, 26);

    @Test
    void shouldFindByDate() {
        ForageFileRepository repo = new ForageFileRepository("./data/forage_data_test");
        List<Forage> forages = repo.findByDate(date);
        assertNotNull(forages);
        assertTrue(forages.size() > 1);
    }

    @Test
    void shouldCreateForage() throws DataException {
        Forage forage = new Forage();
        forage.setDate(date);
        forage.setKilograms(0.75);

        Item item = new Item();
        item.setId(12);
        forage.setItem(item);

        Forager forager = new Forager();
        forager.setId("AAAA-1111-2222-FFFF");
        forage.setForager(forager);

        ForageFileRepository repo = new ForageFileRepository("./data/forage_data_test");
        forage = repo.add(forage);

        assertNotNull(forage.getId());
        assertTrue(forage.getId().length() > 2);
    }

}