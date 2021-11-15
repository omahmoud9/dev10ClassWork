package learn.solarFarm.domain;

import learn.solarFarm.data.DataAccessException;
import learn.solarFarm.data.SolarPanelRepositoryDouble;
import learn.solarFarm.models.Materials;
import learn.solarFarm.models.SolarPanel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolarPanelServiceTest {

    SolarPanelService service = new SolarPanelService(new SolarPanelRepositoryDouble());

    @Test
    void shouldAddSolarPanel() throws DataAccessException {
        SolarPanelResult result = service.add(new SolarPanel(1, 1, 12, 12, Materials.MONORYSTALLINE_SILICON, 2000, true));
        assertTrue(result.isSuccessful());
    }

    @Test
    void shouldNotAddRowOver250() throws DataAccessException {
        SolarPanel solarPanel = new SolarPanel();
        solarPanel.setRow(251);
        SolarPanelResult result = service.add(solarPanel);
        assertFalse(result.isSuccessful());
    }

    @Test
    void shouldNotAddColOver250() throws DataAccessException {
        SolarPanel solarPanel = new SolarPanel();
        solarPanel.setColumn(251);
        SolarPanelResult result = service.add(solarPanel);
        assertFalse(result.isSuccessful());
    }

    @Test
    void shouldNotAddNullSolarPanel() throws DataAccessException {
        SolarPanelResult result = service.add(null);
        assertFalse(result.isSuccessful());
    }

    @Test
    void shouldNotAddSolarPanelWithSameSpot() throws DataAccessException {
        SolarPanelResult result = service.add(new SolarPanel(0, 7, 7, 7, Materials.MONORYSTALLINE_SILICON, 200, true));
        SolarPanelResult result1 = service.add(new SolarPanel(0, 1, 1, 1, Materials.MONORYSTALLINE_SILICON, 200, true));
        assertFalse(result.isSuccessful());
        assertFalse(result1.isSuccessful());
    }

    @Test
    void shouldUpdate() throws DataAccessException {
        SolarPanelResult result = service.update(new SolarPanel(1, 12, 12, 12, Materials.MULTICRYSTALLINE_SILICON, 1955, false));
        assertTrue(result.isSuccessful());
    }


    @Test
    void shouldDeletePanel() throws DataAccessException {
        SolarPanelResult result = service.deleteById(1);
        assertTrue(result.isSuccessful());
    }

    @Test
    void shouldNotDelete() throws DataAccessException {
        SolarPanelResult result = service.deleteById(10);
        assertFalse(result.isSuccessful());
    }


    @Test
    void shouldFindBySection() throws DataAccessException {
        List<SolarPanel> section1 = service.findBySection(1);
        assertNotNull(section1);
        assertEquals(3, section1.size());
    }
}