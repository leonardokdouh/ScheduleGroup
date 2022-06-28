package com.solvd.Schedule.dao.impl;

import com.solvd.Schedule.binary.Classroom;
import com.solvd.Schedule.dao.IClassroomDAO;
import com.solvd.Schedule.util.exceptions.ExceptionDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassroomDAO extends AbstractConnection implements IClassroomDAO {

    private final String GET_ONE = "SELECT idClassrooms, classroomsNumber, size, available from classrooms WHERE idClassrooms=?";
    private final String GET_ALL = "SELECT idClassrooms, classroomsNumber, size, available FROM classrooms";

    private static final Logger LOG = LogManager.getLogger(ClassroomDAO.class);

    @Override
    public void saveEntity(Classroom entity) throws ExceptionDAO {
        throw new UnsupportedOperationException("No implementation yet");

    }

    @Override
    public void update(long id, Classroom entity) throws ExceptionDAO {
        throw new UnsupportedOperationException("No implementation yet");

    }

    @Override
    public void delete(long id) throws ExceptionDAO {
        throw new UnsupportedOperationException("No implementation yet");

    }

    private Classroom convert(ResultSet rs) throws SQLException {
        int classNumber = rs.getInt("classroomsNumber");
        int size = rs.getInt("size");
        boolean available = rs.getBoolean("available");
        Classroom classroom = new Classroom(classNumber, size, available);
        classroom.setId(rs.getLong("idClassrooms"));
        return classroom;
    }


    @Override
    public List<Classroom> getAll() throws ExceptionDAO {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        List<Classroom> classroomList = new ArrayList<>();
        try {
            ps = conn.prepareStatement(GET_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                classroomList.add(convert(rs));
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the List of Classroom", e);
        } finally {
            returnConnect(conn);
            try {
                ps.close();
                rs.close();
            } catch (SQLException e) {
                LOG.error("Error in SQL", e);
            }
        }
        return classroomList;
    }

    @Override
    public Classroom getEntity(long id) throws ExceptionDAO {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        Classroom classroom = null;

        try {
            ps = conn.prepareStatement(GET_ONE);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                classroom = convert(rs);
            } else {
                throw new ExceptionDAO("The id is not in the database");
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Error in SQL");
        } finally {
            returnConnect(conn);
            try {
                ps.close();
                rs.close();
            } catch (SQLException e) {
                LOG.error("Error in SQL", e);
            }
            return classroom;
        }
    }
}
