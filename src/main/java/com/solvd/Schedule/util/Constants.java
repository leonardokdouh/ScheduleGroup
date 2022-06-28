package com.solvd.Schedule.util;

public enum Constants {

    MAX_CONNECTIONS("db.max_connections"),
    URL("db.url"),
    USERNAME("db.username"),
    PASSWORD("db.pass"),
    PATHJSON("src/main/resources/Professors.json"),
    PATHPROPERTIES("src/main/resources/db.properties");

    private String constantValues;

    Constants(String constants) {
        this.constantValues = constants;
    }

    public String getConstantValues() {
        return constantValues;
    }
}
