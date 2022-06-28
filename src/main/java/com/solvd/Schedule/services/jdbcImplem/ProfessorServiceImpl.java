package com.solvd.Schedule.services.jdbcImplem;

import com.solvd.Schedule.binary.Professor;
import com.solvd.Schedule.dao.IProfessorDAO;
import com.solvd.Schedule.dao.impl.ProfessorDAO;
import com.solvd.Schedule.services.ProfessorService;

import java.util.List;

public class ProfessorServiceImpl implements ProfessorService {

    @Override
    public Professor getProfessor(long id) {
        IProfessorDAO prof = new ProfessorDAO();
        return prof.getEntity(id);
    }

    @Override
    public void delete(long id) {
        IProfessorDAO prof = new ProfessorDAO();
        prof.delete(id);
    }

    @Override
    public void update(long id, Professor u) {
        IProfessorDAO prof = new ProfessorDAO();
        prof.update(id, u);
    }

    @Override
    public void create(Professor u) {
        IProfessorDAO prof = new ProfessorDAO();
        prof.saveEntity(u);
    }

    @Override
    public List<Professor> getProfessors() {
        IProfessorDAO prof = new ProfessorDAO();
        return prof.getAll();
    }
}
