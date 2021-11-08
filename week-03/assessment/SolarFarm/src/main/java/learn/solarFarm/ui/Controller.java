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
//    public void tryRun() {
//        try {
//            run();
//        } catch (DataAccessException ex) {
//            ;
//        }
//    }

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

    public void findBySection() {

    }

    public void updatePanel() {

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


