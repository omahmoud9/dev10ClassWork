package learn.solarFarm.data;

import learn.solarFarm.models.SolarPanel;

import java.util.List;

public interface SolarPanelRepository {

    List<SolarPanel> findAll() throws DataAccessException;

    SolarPanel findById(int panelId) throws DataAccessException;

    List<SolarPanel> findBySection(int section) throws DataAccessException;

    SolarPanel add(SolarPanel solarPanel) throws DataAccessException;

    boolean update(SolarPanel solarPanel) throws DataAccessException;

    boolean deleteById(int id) throws DataAccessException;
}