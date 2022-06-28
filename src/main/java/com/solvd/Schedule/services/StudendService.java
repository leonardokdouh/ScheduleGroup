package com.solvd.Schedule.services;

import com.solvd.Schedule.binary.Student;

import java.util.List;

public interface StudendService {

    Student getStudent (long id);

    void delete(long id);

    void update(long id, Student u);

    void create(Student u);

    List<Student>getAllStudentsbyId(long id);

    List<Student>getAllStudent();
}
