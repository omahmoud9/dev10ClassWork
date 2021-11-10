package learn.solarFarm.ui;

import learn.solarFarm.models.Materials;
import learn.solarFarm.models.SolarPanel;

import java.util.List;
import java.util.Scanner;

public class View {


    private final static String TABLE_FORMAT = "%s %-20s %-20s  %-20s  %-5s   %5s";
    private final Scanner console = new Scanner((System.in));

    public void displayHeader(String text) {
        displayText("");
        displayText(text);
        displayText("=".repeat(text.length()));
        displayText("");
    }

    public MenuOptions displayMainMenu() {
        displayHeader("Main Menu");
        MenuOptions[] options = MenuOptions.values();
        for (int i = 0; i < options.length; i++) {
            displayText(String.format("%s. %s", i, options[i].getText()));
        }
        return null;
    }

    public void displaySolarPanels(List<SolarPanel> solarPanels) {
        String tableHeader = String.format(TABLE_FORMAT, "Section ", "Row", "Col", "Materials", "Year Installed", "Tracks The Sun");
        displayText(tableHeader);
        displayText("-".repeat(tableHeader.length()));
        if (solarPanels == null || solarPanels.size() == 0) {
            displayText("No Solar Panels found");
        } else {
            for (int i = 0; i < solarPanels.size(); i++) {
                displayText(panelRow(i,solarPanels.get(i)));
            }
        }
        displayText("-".repeat(tableHeader.length()));
    }

    private String panelRow(int index, SolarPanel solarPanel) {
        return String.format(TABLE_FORMAT,
                solarPanel.getSection(),
                solarPanel.getRow(),
                solarPanel.getColumn(),
                solarPanel.getMaterial(),
                solarPanel.getYear(),
                String.format("%s" ,solarPanel.isTrackable())
        );
    }



    public int getSolarPanelSection(){
        return readInt("Section: ");
    }

    public int getSolarPanelRow() {
        return readInt("Row: ");
    }

    public int getSolarPanelCol(){
        return readInt("Col: ");
    }


    public void displayErrors(List<String> errors) {
        for(String error: errors) {
            displayError(error);
        }
    }

    public void displayError(String text) {
        System.out.println(text);
    }

    public int getMainMenuSelection() {
        return readInt("select [0-4]:", 0 , 4);
    }

    private String readString(String prompt) {
        System.out.print(prompt);
        return console.nextLine();
    }

    private int readInt(String prompt) {

        int result = 0;
        boolean isValid = false;

        do {
            String value = readString(prompt);
            try {
                result = Integer.parseInt(value);
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.println("Value must be a number");
            }
        } while(!isValid);
        return result;
    }

    private int readInt(String prompt, int min, int max) {
        int result = 0;
        do{
            result=readInt(prompt);
            if(result < min || result > max) {
                System.out.printf("Value must be between %s and %s. %n", min, max);
            }
        } while (result < min || result > max);
        return result;
    }

    public Materials getMaterials() {
        System.out.println("Material Type:");
        System.out.println("1: MULTICRYSTALLINE_SILICON");
        System.out.println("2: MONORYSTALLINE_SILICON");
        System.out.println("3: AMORPHOUS_SILICON");
        System.out.println("4: CADMIUM_TELLURIDE");
        System.out.println("5: COPPER_INDIUM_GALLUIM_SELENIDE");
        int choice = readInt("[1-5]");
        if(choice == 1) {
            return Materials.MONORYSTALLINE_SILICON;
        } else if (choice == 2) {
            return Materials.MONORYSTALLINE_SILICON;
        } else if (choice == 3) {
            return Materials.AMORPHOUS_SILICON;
        } else if (choice == 4) {
            return Materials.CADMIUM_TELLURIDE;
        } else if (choice == 5) {
            return Materials.COPPER_INDIUM_GALLUIM_SELENIDE;
        }
        return Materials.MULTICRYSTALLINE_SILICON;
    }

    public boolean getTrackable() {
        String choice = readString("Tracks sun[y/n]: ");
        if(choice.equals("y")){
            return true;
        } else {
            return false;
        }
    }

    public SolarPanel makePanel(){
        SolarPanel result = new SolarPanel();
        System.out.println();
        System.out.println("New Solar Panel");
        result.setSection(readInt("Section:"));
        result.setRow(readInt("Row:",1 ,250));
        result.setColumn(readInt("Column:", 1, 250));
        result.setMaterial(getMaterials());
        result.setYear(readInt("Year installed:",1950,2021));
        result.setTrackable(getTrackable());
        return result;
    }



    public SolarPanel updatePanel(SolarPanel solarPanel) {

        int section = readInt("Section: ");
        if (section != 0) {
            solarPanel.setSection(section);
        }

        int row = readInt("Row: ");
        if (row > 0 && row < 251) {
            solarPanel.setRow(row);
        }

        int col = readInt("Column: ");
        if (col > 0 && col < 251) {
            solarPanel.setRow(col);
        }
        return solarPanel;
    }



    public void displayText(String text) {
        System.out.println(text);
    }
}