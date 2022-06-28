package com.solvd.Schedule.services;

import com.solvd.Schedule.binary.Days;

import java.util.List;

public interface DaysService {

    Days getDays (long id);

    void update(long id, Days u);

    List<Days> getAllDays();

    List<Days> getAllbyShiftId(long id);
}
