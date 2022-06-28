package com.solvd.Schedule.services.jdbcImplem;

import com.solvd.Schedule.binary.Days;
import com.solvd.Schedule.dao.IDaysDAO;
import com.solvd.Schedule.dao.impl.DaysDAO;
import com.solvd.Schedule.dao.impl.ShiftsDAO;
import com.solvd.Schedule.services.DaysService;

import java.util.List;

public class DaysServiceImpl implements DaysService {

    @Override
    public Days getDays(long id) {
        IDaysDAO day = new DaysDAO();
        ShiftsDAO shiftDao = new ShiftsDAO();
        Days retDay = day.getEntity(id);
        retDay.setShift(shiftDao.getEntity(retDay.getShiftsId()));
        return retDay;
    }

    @Override
    public void update(long id, Days u) {
        IDaysDAO days = new DaysDAO();
        days.update(id, u);
    }

    @Override
    public List<Days> getAllDays() {
        IDaysDAO listDays = new DaysDAO();
        return listDays.getAll();
    }

    @Override
    public List<Days> getAllbyShiftId(long id) {
        DaysDAO listDays = new DaysDAO();
        ShiftsDAO shiftDao = new ShiftsDAO();
        List<Days> retDays = listDays.getAllbyShiftId(id);
        retDays.forEach(day -> {
            day.setShift(shiftDao.getEntity(id));
        });
        return retDays;
    }
}
