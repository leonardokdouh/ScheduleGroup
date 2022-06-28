package com.solvd.Schedule.util.menuOptions;

public enum MenuOptions {

    OPTION_1("Create schedule from scratch."),
    OPTION_2("Add subject to an existing schedule."),
    OPTION_3("Do you want to see all our Professors?");

    private String menuOptions;

    MenuOptions(String menuOptions) {
        this.menuOptions = menuOptions;
    }

    public String getMenuOptions() {
        return menuOptions;
    }
}
