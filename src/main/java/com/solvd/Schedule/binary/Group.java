package com.solvd.Schedule.binary;

import java.util.Objects;

public class Group {

    private long id;
    private int limitAmount;
    private int shiftId;

    public Group(int shiftId, int limitAmount) {
        this.limitAmount = limitAmount;
        this.shiftId = shiftId;
    }

    public Group() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(int limitAmount) {
        this.limitAmount = limitAmount;
    }

    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return limitAmount == group.limitAmount && shiftId == group.shiftId && Objects.equals(id, group.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, limitAmount, shiftId);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", limitAmount=" + limitAmount +
                ", shiftId=" + shiftId +
                '}';
    }
}
