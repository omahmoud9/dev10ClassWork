package learn.solarFarm.ui;

public enum MenuOptions {
    EXIT("Exit"),
    FIND_PANELS_BY_SECTION("Find Panels by  Section"),
    ADD_PANEL("Add a Panel"),
    UPDATE_PANEL("Update a Panel"),
    REMOVE_PANEL("Remove a Panel");


private final String text;

    MenuOptions(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
