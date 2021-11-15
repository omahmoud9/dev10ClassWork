package learn.solarFarm.data;

import learn.solarFarm.models.Materials;
import learn.solarFarm.models.SolarPanel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolarPanelRepositoryDouble implements SolarPanelRepository{

    private ArrayList<SolarPanel> solarPanels = new ArrayList<>();

    public SolarPanelRepositoryDouble(){
        SolarPanel solarPanel = new SolarPanel();
        solarPanel.setSection(1);
        solarPanel.setRow(1);
        solarPanel.setColumn(1);
        solarPanel.setMaterial(Materials.COPPER_INDIUM_GALLUIM_SELENIDE);
        solarPanel.setPanelId(1);
        solarPanel.setTrackable(true);
        solarPanel.setYear(2000);
        solarPanels.add(solarPanel);
        solarPanels.add(new SolarPanel(7,7,7,7,Materials.COPPER_INDIUM_GALLUIM_SELENIDE,2000,true));
        solarPanels.add(new SolarPanel(8,1,7,7,Materials.COPPER_INDIUM_GALLUIM_SELENIDE,2000,true));
        solarPanels.add(new SolarPanel(9,1,8,7,Materials.COPPER_INDIUM_GALLUIM_SELENIDE,2000,true));
    }

    @Override
    public List<SolarPanel> findAll() throws DataAccessException {
        return new ArrayList<>(solarPanels);
    }

    @Override
    public SolarPanel findById(int panelId) throws DataAccessException {
        for( SolarPanel s: solarPanels){
            if(s.getPanelId() == panelId) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<SolarPanel> findBySection(int section) throws DataAccessException {
        ArrayList<SolarPanel> result = new ArrayList<>();
        for(SolarPanel s: solarPanels) {
            if(section == s.getSection()) {
                result.add(s);
            }
        }
        return result;
    }

    @Override
    public SolarPanel add(SolarPanel solarPanel) throws DataAccessException {
        solarPanels.add(solarPanel);
        return solarPanel;
    }

    @Override
    public boolean update(SolarPanel solarPanel) throws DataAccessException {
        return true;
    }

    @Override
    public boolean deleteById(int id) throws DataAccessException {
        return true;
    }

}
