package com.solvd.Schedule.binary;

import java.util.Objects;

public class Module {

    private long id;
    private Subject subject;
    private Classroom classroom;
    private Shifts shifts;

    public Module(Subject subject, Classroom classroom, Shifts shifts) {
        this.subject = subject;
        this.classroom = classroom;
        this.shifts = shifts;
    }

    public Module() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Shifts getShift() {
        return shifts;
    }

    public void setShift(Shifts shifts) {
        this.shifts = shifts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Module)) return false;
        Module module = (Module) o;
        return Objects.equals(id, module.id) && Objects.equals(subject, module.subject) && Objects.equals(classroom, module.classroom) && Objects.equals(shifts, module.shifts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, classroom, shifts);
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", subject=" + subject +
                ", classroom=" + classroom +
                ", shift=" + shifts +
                '}';
    }
}
