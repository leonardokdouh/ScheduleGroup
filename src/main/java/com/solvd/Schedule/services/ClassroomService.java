package com.solvd.Schedule.services;

import com.solvd.Schedule.binary.Classroom;

import java.util.List;

public interface ClassroomService {

    Classroom getClassroom (long id);

    List<Classroom> getAllClassrooms();
}
