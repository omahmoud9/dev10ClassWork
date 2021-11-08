package learn.solarFarm.data;


import learn.solarFarm.domain.SolarPanelResult;
import learn.solarFarm.models.Materials;
import learn.solarFarm.models.SolarPanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolarPanelFileRepositoryTest {

    private static final String SEED_PATH = ("./data/solarPanels-seed.csv");
    private static final String TEST_PATH = ("./data/solarPanels-test.csv");

    private final SolarPanelFileRepository repository = new SolarPanelFileRepository(TEST_PATH);

    @BeforeEach
    void setup() throws IOException {
        Files.copy(Paths.get(SEED_PATH), Paths.get(TEST_PATH), StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void shouldFindSixOrbiters() throws DataAccessException {
        List<SolarPanel> actual = repository.findAll();
        assertNotNull(actual);
        assertEquals(6, actual.size());
    }

    @Test
    void shouldFindExistingSolarPanel() throws DataAccessException {
        SolarPanel solarPanel1 = repository.findById(1);
        SolarPanel solarPanel2 = repository.findById(2);
        SolarPanel solarPanel6 = repository.findById(6);
        assertNotNull(solarPanel1);
        assertEquals(1, solarPanel1.getPanelId());
        assertEquals(2, solarPanel2.getPanelId());
        assertEquals(6, solarPanel6.getPanelId());
    }

    @Test
    void shouldNOTFindNonExistingOrbiter() throws DataAccessException {
        SolarPanel no = repository.findById(100);
        SolarPanel no1 = repository.findById( 1000);
        assertNull(no);
        assertNull(no1);
    }

    @Test
    void shouldFindBySection() throws DataAccessException {
        List<SolarPanel> section1 = repository.findBySection(1);
        assertNotNull(section1);
        assertEquals(3,section1.size());

        List<SolarPanel> section2 = repository.findBySection(2);
        assertNotNull(section2);
        assertEquals(1,section2.size());

        List<SolarPanel> section3 = repository.findBySection(3);
        assertNotNull(section3);
        assertEquals(1,section3.size());

        List<SolarPanel> section4 = repository.findBySection(4);
        assertNotNull(section4);
        assertEquals(1,section4.size());
    }

    @Test
    void shouldAddSolarPanel() throws DataAccessException {
        SolarPanel solarPanel = new SolarPanel();
        solarPanel.setSection(1);
        solarPanel.setRow(2);
        solarPanel.setColumn(3);
        solarPanel.setYear(2000);
        solarPanel.setMaterial(Materials.COPPER_INDIUM_GALLUIM_SELENIDE);
        solarPanel.setTrackable(true);

        SolarPanel actual = repository.add(solarPanel);

        assertNotNull(actual);
        assertEquals(7,actual.getPanelId());
    }

    @Test
    void shouldUpdateExistingPanel() throws DataAccessException {
        SolarPanel solarPanel = new SolarPanel();
        solarPanel.setPanelId(3);
        solarPanel.setMaterial(Materials.MONORYSTALLINE_SILICON);
        solarPanel.setTrackable(false);
        solarPanel.setYear(200);
        solarPanel.setRow(2);
        solarPanel.setColumn(17);
        solarPanel.setSection(4);



        boolean success = repository.update(solarPanel);
        assertTrue(success);

        SolarPanel actual = repository.findById(3);
        assertNotNull(actual);
        assertEquals(4, actual.getSection());
        assertEquals(200, actual.getYear());
        assertEquals(2, actual.getRow());


    }

    @Test
    void shouldNOTUpdateNONExistingPanel() throws DataAccessException {
        SolarPanel solarPanel = new SolarPanel();
        solarPanel.setPanelId(190);

        boolean actual = repository.update(solarPanel);
        assertFalse(actual);
    }

    @Test
    void shouldDeleteExisting() throws DataAccessException{
        boolean actual = repository.deleteById(6);
        assertTrue(actual);

        SolarPanel s = repository.findById(6);
        assertNull(s);
    }

    @Test
    void shouldNOTDeleteMissingPanel() throws DataAccessException {
        boolean actual = repository.deleteById(15);
        assertFalse(actual);

    }
}