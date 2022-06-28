package com.solvd.Schedule.services.jdbcImplem;

import com.solvd.Schedule.binary.Classroom;
import com.solvd.Schedule.dao.IClassroomDAO;
import com.solvd.Schedule.dao.impl.ClassroomDAO;
import com.solvd.Schedule.services.ClassroomService;

import java.util.List;

public class ClassroomServiceImpl implements ClassroomService {

    @Override
    public Classroom getClassroom(long id) {
        IClassroomDAO classroomDAO = new ClassroomDAO();
        return classroomDAO.getEntity(id);
        }

    @Override
    public List<Classroom> getAllClassrooms() {
    IClassroomDAO classList = new ClassroomDAO();
    return classList.getAll();
    }
}
