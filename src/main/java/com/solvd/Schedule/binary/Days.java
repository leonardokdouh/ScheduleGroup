package com.solvd.Schedule.binary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Days {

    private long id;
    private String name;
    private int hours;
    private int shiftsId;
    private Shifts shift;
    private List<Module> modules = new ArrayList<>(Arrays.asList(null, null, null, null));

    public Days(String name, int hours, int shiftsId) {
        this.name = name;
        this.hours = hours;
        this.shiftsId = shiftsId;
    }

    public Days(String name, Shifts shift) {
        this.name = name;
        this.shift = shift;
    }

    public Days() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getShiftsId() {
        return shiftsId;
    }

    public void setShiftsId(int shiftsId) {
        this.shiftsId = shiftsId;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public Shifts getShift() {
        return shift;
    }

    public void setShift(Shifts shift) {
        this.shift = shift;
    }

    public List<Subject> getSubjects() {
        List<Subject> returnList = new ArrayList<>();
        for (Module module : modules) {
            if (module != null) {
                returnList.add(module.getSubject());
            } else {
                returnList.add(null);
            }
        }
        return returnList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Days)) return false;
        Days days = (Days) o;
        return hours == days.hours && shiftsId == days.shiftsId && Objects.equals(id, days.id) && Objects.equals(name, days.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, hours, shiftsId);
    }

    @Override
    public String toString() {
        String startString = ("\n\t\t" + this.getName() + "\n\t\t\t");
        String time = "";
        String auxString = "";
        for (int i = 0; i < modules.size(); i++) {
            switch (shift.getName()) {
                case "Morning": {
                    switch (i) {
                        case 0:
                            time = "8:00-9:00 -> ";
                            break;
                        case 1:
                            time = "9:00-10:00 -> ";
                            break;
                        case 2:
                            time = "10:00-11:00 -> ";
                            break;
                        case 3:
                            time = "11:00-12:00 -> ";
                            break;
                    }
                    break;
                }
                case "Afternoon": {
                    switch (i) {
                        case 0:
                            time = "16:00-17:00 -> ";
                            break;
                        case 1:
                            time = "17:00-18:00 -> ";
                            break;
                        case 2:
                            time = "18:00-19:00 -> ";
                            break;
                        case 3:
                            time = "19:00-20:00 -> ";
                            break;
                    }
                }
                break;
            }
            if (modules.get(i) != null) {
                auxString = auxString + time + modules.get(i).getSubject().getName() + "\n\t\t\t\t"
                        + modules.get(i).getSubject().getProfessor() + "\n\t\t\t\t"
                        + "Classroom N°: " + modules.get(i).getClassroom().getClassroomNumber() + "\n\t\t\t";
            } else {
                auxString = auxString + time + "Empty" + "\n\t\t\t";
            }
        }
        return startString + auxString;
    }


}