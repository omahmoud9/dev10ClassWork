package learn.solarFarm.domain;

import learn.solarFarm.models.SolarPanel;

import java.util.ArrayList;
import java.util.List;

public class SolarPanelResult {
    private ArrayList<String> messages = new ArrayList<>();
    private SolarPanel solarPanel;

    public boolean isSuccessful() {
        return messages.size() == 0;
    }

    public SolarPanel getSolarPanel() {
        return solarPanel;
    }

    public void setSolarPanel(SolarPanel solarPanel) {
        this.solarPanel = solarPanel;
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }

    public void addErrorMessage(String message){
        this.messages.add(message);
    }
}