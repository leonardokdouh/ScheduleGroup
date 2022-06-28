package com.solvd.Schedule.services;

import com.solvd.Schedule.binary.Professor;

import java.util.List;

public interface ProfessorService {

    Professor getProfessor(long id);

    void delete(long id);

    void update(long id, Professor u);

    void create(Professor u);

    List<Professor> getProfessors();
}
