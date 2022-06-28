package com.solvd.Schedule.binary;

import com.solvd.Schedule.services.ShiftService;
import com.solvd.Schedule.services.jdbcImplem.ShiftServiceImpl;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class Subject {

    private long id;
    private String name;
    private Professor professor;

    public Subject(long id, String name, Professor professor) {
        this.id = id;
        this.name = name;
        this.professor = professor;
    }

    public Subject() {
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

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject)) return false;
        Subject subject = (Subject) o;
        return id == subject.id && name == subject.name && Objects.equals(professor, subject.professor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, professor);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name=" + name +
                ", professor=" + professor +
                '}';
    }

    public boolean checkSubject(Shifts shift, Days day, int time) {
        AtomicBoolean returnValue = new AtomicBoolean(true);
        ShiftService shiftServ = new ShiftServiceImpl();
        List<Shifts> shiftsList = shiftServ.getAllShiftsbyName(shift.getName());
        shiftsList.stream().forEach(shi -> {
            shi.getDays().stream().filter(d -> (d.getName() == day.getName())).toList()
                    .forEach(sameDay -> {
                        if (sameDay.getModules().get(time).getSubject() == this) {
                            returnValue.set(false);
                        }
                    });
        });
        return returnValue.get();
    }
}
