package com.solvd.Schedule.dao.impl;

import com.solvd.Schedule.binary.Subject;
import com.solvd.Schedule.dao.IProfessorDAO;
import com.solvd.Schedule.dao.ISubjectDAO;
import com.solvd.Schedule.util.exceptions.ExceptionDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO extends AbstractConnection implements ISubjectDAO {

    private final String INSERT = "INSERT INTO subjects (name, professorsId) VALUES (?,?)";
    private final String UPDATE = "UPDATE subjects SET name =?, professorsId= ? WHERE idSubjects=?";
    private final String DELETE = "DELETE from subjects WHERE idSubjects=?";
    private final String GET_ONE = "SELECT idSubjects, name, professorsId from subjects WHERE idSubjects=?";
    private final String GET_ALL = "SELECT idSubjects, name, professorsId FROM subjects";

    private static final Logger LOG = LogManager.getLogger(SubjectDAO.class);

    @Override
    public void saveEntity(Subject entity) throws ExceptionDAO {
        PreparedStatement pt = null;
        Connection conn = getConnect();
        try {
            pt = conn.prepareStatement(INSERT);
            pt.setString(1, entity.getName());
            pt.setLong(2, entity.getProfessor().getId());
            pt.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Not saved ", e);
        } finally {
            returnConnect(conn);
            closeResources(pt);
        }
    }

    @Override
    public void update(long id, Subject entity) throws ExceptionDAO {
        PreparedStatement pt = null;
        Connection conn = getConnect();
        try {
            pt = conn.prepareStatement(UPDATE);
            pt.setString(1, entity.getName());
            pt.setLong(2, entity.getProfessor().getId());
            pt.setLong(3, id);
            if (pt.executeUpdate() == 0) {
                throw new ExceptionDAO("The subject did not update");
            }
        } catch (SQLException e) {
            LOG.error("Not updated ", e);
        } finally {
            returnConnect(conn);
            closeResources(pt);
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


    private Subject convert(ResultSet rs) throws SQLException {
        Subject subj = new Subject();
        subj.setId(rs.getLong("idSubjects"));
        subj.setName(rs.getString("name"));
        IProfessorDAO prof = new ProfessorDAO();
        subj.setProfessor(prof.getEntity(rs.getLong("professorsId")));
        return subj;
    }

    @Override
    public Subject getEntity(long id) throws ExceptionDAO {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        Subject sub;
        try {
            ps = conn.prepareStatement(GET_ONE);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                sub = convert(rs);
            } else {
                throw new ExceptionDAO("not working");
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the Subject");
        } finally {
            returnConnect(conn);
            closeResources(ps, rs);
        }
        return sub;
    }

    @Override
    public List<Subject> getAll() throws ExceptionDAO {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        List<Subject> listSub = new ArrayList<>();

        try {
            ps = conn.prepareStatement(GET_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                listSub.add(convert(rs));
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the List of Subjects");
        } finally {
            returnConnect(conn);
            closeResources(ps, rs);
        }
        return listSub;
    }
}