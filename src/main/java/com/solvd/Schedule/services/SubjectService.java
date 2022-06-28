package com.solvd.Schedule.services;

import com.solvd.Schedule.binary.Subject;

import java.util.List;

public interface SubjectService {

    Subject getSubject (long id);

    void delete(long id);

    void update(long id, Subject u);

    void create(Subject u);

    List<Subject> getAllSubjects();
}
