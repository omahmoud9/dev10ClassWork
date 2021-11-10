package learn.solarFarm.domain;

import learn.solarFarm.data.DataAccessException;
import learn.solarFarm.data.SolarPanelRepository;
import learn.solarFarm.models.SolarPanel;

import java.util.List;

public class SolarPanelService {

    private final SolarPanelRepository repository;

    public SolarPanelService(SolarPanelRepository repository) {
        this.repository = repository;
    }

    public List<SolarPanel> findBySection(int section) throws DataAccessException{
        return repository.findBySection(section);
    }




    private SolarPanelResult validateInputs(SolarPanel solarPanel){
        SolarPanelResult result = new SolarPanelResult();
        if(solarPanel == null){
            result.addErrorMessage("Solar Panel cant be null.");
            return result;
        }
        if(solarPanel.getRow() > 250 || solarPanel.getRow() < 1){
            result.addErrorMessage("Row Must be Between 1 and 250");
            return  result;
        }
        if(solarPanel.getColumn() > 250 || solarPanel.getColumn() < 1){
            result.addErrorMessage("Column Must be Between 1 and 250");
            return  result;
        } if(solarPanel.getYear() > 2021)
            result.addErrorMessage("Year must be before 2022");
        return result;
    }

    private SolarPanelResult validateDomain(SolarPanel solarPanel) throws DataAccessException {
        SolarPanelResult result = new SolarPanelResult();
        List<SolarPanel> allSolarPanels = repository.findAll();
        for(int i = 0; i < allSolarPanels.size(); i++)
            if(solarPanel.getSection() == allSolarPanels.get(i).getSection())
                if (solarPanel.getRow() == allSolarPanels.get(i).getRow())
                    if(solarPanel.getColumn() == allSolarPanels.get(i).getColumn()) {
                        result.addErrorMessage("Spot is already being used");
                    }

        return result;
    }
    public SolarPanelResult add(SolarPanel solarPanel) throws DataAccessException {
        SolarPanelResult result = validateInputs(solarPanel);
        if(!result.isSuccessful()) {
            return result;
        }
        result = validateDomain(solarPanel);
        if(!result.isSuccessful()) {
            return result;
        }

        SolarPanel s = repository.add(solarPanel);
        result.setSolarPanel(s);

        return result;
    }

    public SolarPanelResult update(SolarPanel solarPanel) throws DataAccessException {
        SolarPanelResult result = validateInputs(solarPanel);
        if (!result.isSuccessful()) {
            return result;
        }

        if (solarPanel.getSection() < 1) {
            result.addErrorMessage("id should be set for update");

            if (result.isSuccessful() && !repository.update(solarPanel)) {
                result.addErrorMessage("Could not find solarPanel id");
            }
        }
        repository.update(solarPanel);

        return result;
    }


    public SolarPanelResult deleteById(int panelId) throws DataAccessException {
        SolarPanelResult result = new SolarPanelResult();
        SolarPanel solarPanel = repository.findById(panelId);
        if (solarPanel == null) {
            result.addErrorMessage("Could not find Solar Panel");
            return result;
        }

        boolean success = repository.deleteById(panelId);
        if(!success) {
            result.addErrorMessage("Could not find Solar Panel");
            return result;
        }
        return result;
    }
}
