package com.solvd.Schedule.services.jdbcImplem;

import com.solvd.Schedule.binary.Subject;
import com.solvd.Schedule.dao.ISubjectDAO;
import com.solvd.Schedule.dao.impl.SubjectDAO;
import com.solvd.Schedule.services.SubjectService;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {

    @Override
    public Subject getSubject(long id) {
        ISubjectDAO newSub = new SubjectDAO();

        return newSub.getEntity(id);
    }

    @Override
    public void delete(long id) {
        ISubjectDAO newSub = new SubjectDAO();
        newSub.delete(id);
    }

    @Override
    public void update(long id, Subject u) {
        ISubjectDAO newSub = new SubjectDAO();
        newSub.update(id, u);
    }

    @Override
    public void create(Subject u) {
        ISubjectDAO newSub = new SubjectDAO();
        newSub.saveEntity(u);
    }

    @Override
    public List<Subject> getAllSubjects() {
        ISubjectDAO newSub = new SubjectDAO();
        return newSub.getAll();
    }
}
