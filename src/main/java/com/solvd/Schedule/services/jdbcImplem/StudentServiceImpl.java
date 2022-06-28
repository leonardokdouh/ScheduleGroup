package com.solvd.Schedule.services.jdbcImplem;

import com.solvd.Schedule.binary.Student;
import com.solvd.Schedule.dao.IStudentDAO;
import com.solvd.Schedule.dao.impl.StudentDAO;
import com.solvd.Schedule.services.StudendService;

import java.util.List;

public class StudentServiceImpl implements StudendService {

    @Override
    public Student getStudent(long id) {
        IStudentDAO stud = new StudentDAO();
        return stud.getEntity(id);
    }

    @Override
    public void delete(long id) {
        IStudentDAO stud = new StudentDAO();
        stud.delete(id);

    }

    @Override
    public void update(long id, Student u) {
        IStudentDAO stud = new StudentDAO();
        stud.update(id, u);
    }

    @Override
    public void create(Student u) {
        IStudentDAO stud = new StudentDAO();
        stud.saveEntity(u);
    }

    @Override
    public List<Student> getAllStudentsbyId(long id) {
        IStudentDAO stud = new StudentDAO();
        List<Student> thisList = ((StudentDAO) stud).getAllbyGroupId(id);
        return thisList;
    }

    @Override
    public List<Student> getAllStudent() {
        IStudentDAO stud = new StudentDAO();
        return stud.getAll();
    }
}
