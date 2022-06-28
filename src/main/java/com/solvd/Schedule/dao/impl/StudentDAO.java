package com.solvd.Schedule.dao.impl;

import com.solvd.Schedule.binary.Student;
import com.solvd.Schedule.dao.IGroupDAO;
import com.solvd.Schedule.dao.IStudentDAO;
import com.solvd.Schedule.util.exceptions.ExceptionDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends AbstractConnection implements IStudentDAO {

    private final String INSERT = "INSERT INTO students firstName, lastName, groupId VALUES (?,?, ?)";
    private final String UPDATE = "UPDATE students SET firstName =?, lastName= ?, groupId=? WHERE idStudents=?";
    private final String DELETE = "DELETE from students WHERE idStudents=?";
    private final String GET_ONE = "SELECT idStudents, firstName, lastName, groupId from students WHERE idStudents=?";
    private final String GET_ALL = "SELECT idStudents, firstName, lastName, groupId FROM students";
    private final String GET_ALL_ID = "SELECT idStudents, firstName, lastName, groupId FROM students WHERE groupId=?";

    private static final Logger LOG = LogManager.getLogger(StudentDAO.class);

    @Override
    public void saveEntity(Student entity) throws ExceptionDAO {
        PreparedStatement pt = null;
        Connection conn = getConnect();
        try {
            pt = conn.prepareStatement(INSERT);
            pt.setString(1, entity.getFirstName());
            pt.setString(2, entity.getLastName());
            pt.setLong(3, entity.getGroup().getId());
            pt.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Not saved ", e);
        } finally {
            returnConnect(conn);
            closeResources(pt);
        }
    }

    @Override
    public void update(long id, Student entity) throws ExceptionDAO {
        PreparedStatement ps = null;
        Connection conn = getConnect();
        try {
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setLong(3, entity.getGroup().getId());
            ps.setLong(4, id);
            if (ps.executeUpdate() == 0) {
                throw new ExceptionDAO("Maybe it don't update the Professor");
            }
        } catch (SQLException e) {
            LOG.error("Not updated", e);
            throw new ExceptionDAO("Error in SQL");
        } finally {
            returnConnect(conn);
            closeResources(ps);
        }
    }

    @Override
    public void delete(long id) throws ExceptionDAO {
        PreparedStatement ps = null;
        Connection conn = getConnect();
        try {
            ps = conn.prepareStatement(DELETE);
            ps.setLong(1, id);
            if (ps.executeUpdate() == 0) {
                throw new ExceptionDAO("check the method");
            }
        } catch (SQLException e) {
            LOG.error("Not delete", e);
            throw new ExceptionDAO("Error in SQL");
        } finally {
            returnConnect(conn);
            closeResources(ps);
        }
    }

    private Student convert(ResultSet rs) throws SQLException {
        Student newStud = new Student();
        newStud.setId(rs.getLong("idStudents"));
        newStud.setFirstName(rs.getString("firstName"));
        newStud.setLastName(rs.getString("lastName"));
        IGroupDAO group = new GroupDAO();
        newStud.setGroup(group.getEntity(rs.getLong("groupId")));
        return newStud;
    }

    @Override
    public Student getEntity(long id) throws ExceptionDAO {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        Student stud;
        try {
            ps = conn.prepareStatement(GET_ONE);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                stud = convert(rs);
            } else {
                throw new ExceptionDAO("Not work");
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the Student");
        } finally {
            returnConnect(conn);
            closeResources(ps, rs);
        }
        return stud;
    }

    @Override
    public List<Student> getAll() throws ExceptionDAO {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        List<Student> listStud = new ArrayList<>();
        try {
            ps = conn.prepareStatement(GET_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                listStud.add(convert(rs));
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the Students");
        } finally {
            returnConnect(conn);
            closeResources(ps, rs);
        }
        return listStud;
    }

    public List<Student> getAllbyGroupId(long id) throws ExceptionDAO {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        List<Student> listStud = new ArrayList<>();
        try {
            ps = conn.prepareStatement(GET_ALL_ID);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                listStud.add(convert(rs));
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the Students");
        } finally {
            returnConnect(conn);
            closeResources(ps, rs);
        }
        return listStud;
    }
    /*private Student convertForGroup(ResultSet rs) throws SQLException {
        Student newStud = new Student();
        newStud.setId(rs.getLong("idStudents"));
        newStud.setFirstName(rs.getString("firstName"));
        newStud.setLastName(rs.getString("lastName"));
        IGroupDAO group = new GroupDAO();
        newStud.setGroup(group.getEntity(rs.getLong("groupId")));
        return newStud;
    }*/
}
