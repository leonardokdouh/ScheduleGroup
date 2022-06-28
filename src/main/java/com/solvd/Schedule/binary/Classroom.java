package com.solvd.Schedule.binary;

import com.solvd.Schedule.services.ClassroomService;
import com.solvd.Schedule.services.ShiftService;
import com.solvd.Schedule.services.jdbcImplem.ClassroomServiceImpl;
import com.solvd.Schedule.services.jdbcImplem.ShiftServiceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Classroom {

    private long id;
    private int classroomNumber;
    private int size;
    private boolean available;

    public Classroom(int classroomNumber, int size, boolean available) {
        this.classroomNumber = classroomNumber;
        this.size = size;
        this.available = available;
    }

    public Classroom() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getClassroomNumber() {
        return classroomNumber;
    }

    public void setClassroomNumber(int classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Classroom)) return false;
        Classroom classroom = (Classroom) o;
        return classroomNumber == classroom.classroomNumber && size == classroom.size && available == classroom.available && Objects.equals(id, classroom.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, classroomNumber, size, available);
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", classroomNumber=" + classroomNumber +
                ", size=" + size +
                ", available=" + available +
                '}';
    }

    public Classroom checkClassrooms(Shifts shift, Days day, int time) {
        ClassroomService classroomServ = new ClassroomServiceImpl();
        List<Classroom> availableClassrooms = classroomServ.getAllClassrooms();
        ShiftService shiftServ = new ShiftServiceImpl();
        List<Shifts> shiftsList = shiftServ.getAllShiftsbyName(shift.getName());
        shiftsList.stream().forEach(shi -> {
            shi.getDays().stream().filter(d -> (d.getName() == day.getName())).toList()
                    .forEach(sameDay -> {
                        availableClassrooms.remove(sameDay.getModules().get(time).getClassroom());
                    });
        });
        Random rand = new Random();
        return availableClassrooms.get(rand.nextInt(availableClassrooms.size()));
    }
}
