package com.solvd.Schedule.dao.impl;

import com.solvd.Schedule.binary.Professor;
import com.solvd.Schedule.dao.IProfessorDAO;
import com.solvd.Schedule.util.exceptions.ExceptionDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO extends AbstractConnection implements IProfessorDAO {

    private final String INSERT = "INSERT INTO professors (firstName, lastName) VALUES (?,?)";
    private final String UPDATE = "UPDATE professors SET firstName =?, lastName= ? WHERE idProfessors=?";
    private final String DELETE = "DELETE from professors WHERE idProfessors=?";
    private final String GET_ONE = "SELECT idProfessors, firstName, lastName from professors WHERE idProfessors=?";
    private final String GET_ALL = "SELECT idProfessors, firstName, lastName FROM professors";

    private static final Logger LOG = LogManager.getLogger(ProfessorDAO.class);


    @Override
    public void saveEntity(Professor entity) throws ExceptionDAO {
        PreparedStatement pt = null;
        Connection conn = getConnect();
        try {
            pt = conn.prepareStatement(INSERT);
            pt.setString(1, entity.getFirstName());
            pt.setString(2, entity.getLastName());
            pt.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Not saved ", e);
        } finally {
            returnConnect(conn);
            closeResources(pt);
        }
    }

    @Override
    public void update(long id, Professor entity) throws ExceptionDAO {
        PreparedStatement ps = null;
        Connection conn = getConnect();

        try {
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setLong(3, id);
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

    private Professor convert(ResultSet rs) throws SQLException {
        String firstName = rs.getString("firstName");
        String lastName = rs.getString("lastName");
        Professor professor = new Professor(firstName, lastName);
        professor.setId(rs.getLong("idProfessors"));
        return professor;
    }

    public Professor getEntity(long id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        Professor prof;
        try {
            ps = conn.prepareStatement(GET_ONE);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                prof = convert(rs);
            } else {
                throw new ExceptionDAO("Not work");
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the Professor");
        } finally {
            returnConnect(conn);
            closeResources(ps, rs);
        }
        return prof;
    }

    @Override
    public List<Professor> getAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        List<Professor> listProfessors = new ArrayList<>();
        try {
            ps = conn.prepareStatement(GET_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                listProfessors.add(convert(rs));
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the Professors");
        } finally {
            returnConnect(conn);
            closeResources(ps, rs);
        }
        return listProfessors;
    }
}
