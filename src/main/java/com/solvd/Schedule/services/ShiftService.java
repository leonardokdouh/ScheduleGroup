package com.solvd.Schedule.services;

import com.solvd.Schedule.binary.Shifts;

import java.util.List;

public interface ShiftService {

    Shifts getShift (long id);

    List<Shifts> getAllShiftsbyName(String name);

    List<Shifts> getShifts();
}
