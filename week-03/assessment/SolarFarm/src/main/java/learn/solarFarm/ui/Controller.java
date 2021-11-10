package learn.solarFarm.ui;

import learn.solarFarm.data.DataAccessException;
import learn.solarFarm.domain.SolarPanelResult;
import learn.solarFarm.domain.SolarPanelService;
import learn.solarFarm.models.SolarPanel;

import java.util.List;

public class Controller {

    private final SolarPanelService service;
    private final View view;

    public Controller(View view, SolarPanelService service) {
        this.view = view;
        this.service = service;
    }


    public void run() throws DataAccessException {
        view.displayHeader("Welcome to SolarPanel tracker");

        int selection = -1;
        do {
            view.displayMainMenu();
            selection = view.getMainMenuSelection();
            switch (selection) {
                case 0:
                    System.out.println("GoodBye!");
                case 1:
                    findBySection();
                    break;
                case 2:
                    addPanel();
                    break;
                case 3:
                    updatePanel();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("invalid Selection");
            }

        } while (selection != 0);
    }

    private void findBySection() throws DataAccessException {
            int section = view.getSolarPanelSection();
            List<SolarPanel> solarPanels = service.findBySection(section);
            view.displaySolarPanels(solarPanels);
        }

    private void updatePanel() throws DataAccessException {

        view.displayText("What Panel would you like to update?");
        int section = view.getSolarPanelSection();
        int row = view.getSolarPanelRow();
        int col = view.getSolarPanelCol();
        List<SolarPanel> solarPanels = service.findBySection(section);
        for(int index = 0; index < solarPanels.size(); index++) {
            if(solarPanels.get(index).getRow() == row &&
            solarPanels.get(index).getColumn() == col){
                view.displayText("Updated location: ");
                view.updatePanel(solarPanels.get(index));
                SolarPanelResult result = service.update(solarPanels.get(index));
            }

        }


    }

    private void deletePanel() throws DataAccessException {
        view.displayText("What Panel would you like to delete?");
        int section = view.getSolarPanelSection();
        int row = view.getSolarPanelRow();
        int col = view.getSolarPanelCol();
        List<SolarPanel> solarPanels = service.findBySection(section);
        for(int index =0; index < solarPanels.size(); index++) {
            if(solarPanels.get(index).getRow() == row &&
                    solarPanels.get(index).getColumn() == col){
                view.displayText("Updated location: ");
                view.updatePanel(solarPanels.get(index));
            }
        }

    }

    private void addPanel() throws DataAccessException {
        SolarPanel solarPanel = view.makePanel();
        SolarPanelResult result = service.add(solarPanel);
        if(result.isSuccessful()) {
            System.out.println("Panel Added!");
            System.out.println();
        } else {
            view.displayErrors(result.getMessages());
        }
    }




}