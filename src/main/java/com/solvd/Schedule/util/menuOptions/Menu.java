package com.solvd.Schedule.util.menuOptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Menu {

    private static final Logger LOG = LogManager.getLogger(Menu.class);

    public static void menuOptions() {

        MenuOptions[] options = MenuOptions.values();
        LOG.info("Please select an option:" + "\n");
        for (MenuOptions o : options) {
            LOG.info((o.ordinal() + 1) + ") " + o.getMenuOptions());
        }
    }
}
