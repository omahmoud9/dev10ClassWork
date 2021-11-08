package learn.solarFarm.models;

public class SolarPanel {
    private int panelId;
    private int section;
    private int row;
    private int column;
    private Materials material;
    private int year;
    private boolean trackable;

    public SolarPanel(){
    }

    public SolarPanel(int panelId, int section, int row, int column,Materials material,  int year, boolean trackable) {
        this.panelId = panelId;
        this.material = material;
        this.section = section;
        this.row = row;
        this.column = column;
        this.year = year;
        this.trackable = trackable;
    }


    public int getPanelId() {
        return panelId;
    }

    public void setPanelId(int panelId) {
        this.panelId = panelId;
    }

    public Materials getMaterial() {
        return material;
    }

    public void setMaterial(Materials material) {
        this.material = material;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isTrackable() {
        return trackable;
    }

    public void setTrackable(boolean trackable) {
        this.trackable = trackable;
    }
}