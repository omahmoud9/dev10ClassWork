package learn.solarFarm;

import learn.solarFarm.data.DataAccessException;
import learn.solarFarm.data.SolarPanelFileRepository;
import learn.solarFarm.domain.SolarPanelService;
import learn.solarFarm.ui.Controller;
import learn.solarFarm.ui.View;

public class App {

    public static void main(String[] args) throws DataAccessException {

        SolarPanelFileRepository repository= new SolarPanelFileRepository("./data/solarPanels.csv");
        SolarPanelService service = new SolarPanelService(repository);

        View view = new View();

        Controller controller = new Controller(view, service);
        controller.run();
    }
}
