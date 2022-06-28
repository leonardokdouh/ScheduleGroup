package com.solvd.Schedule.dao.impl;

import com.solvd.Schedule.binary.Shifts;
import com.solvd.Schedule.dao.IShiftsDAO;
import com.solvd.Schedule.util.exceptions.ExceptionDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShiftsDAO extends AbstractConnection implements IShiftsDAO {

    private final String GET_ONE = "SELECT idShifts, name from shifts WHERE idShifts=?";
    private final String GET_ALL_ID = "SELECT idShifts, name FROM shifts WHERE name=?";
    private final String GET_ALL = "SELECT * FROM shifts";

    private static final Logger LOG = LogManager.getLogger(ShiftsDAO.class);

    private Shifts convert(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        Shifts shift = new Shifts(name);
        shift.setId(rs.getLong("idShifts"));
        return shift;
    }

    @Override
    public Shifts getEntity(long id) throws ExceptionDAO {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        Shifts shift;
        try {
            ps = conn.prepareStatement(GET_ONE);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                shift = convert(rs);
            } else {
                throw new ExceptionDAO("Did not work");
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the Shift");
        } finally {
            returnConnect(conn);
            closeResources(ps, rs);
        }
        return shift;
    }

    @Override
    public List<Shifts> getAll() throws ExceptionDAO {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        List<Shifts> listShifts = new ArrayList<>();
        try {
            ps = conn.prepareStatement(GET_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                listShifts.add(convert(rs));
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the Shifts");
        } finally {
            returnConnect(conn);
            closeResources(ps, rs);
        }
        return listShifts;
    }

    @Override
    public void saveEntity(Shifts entity) throws ExceptionDAO {
        throw new UnsupportedOperationException("No implementation yet");
    }

    @Override
    public void update(long id, Shifts entity) throws ExceptionDAO {
        throw new UnsupportedOperationException("No implementation yet");
    }

    @Override
    public void delete(long id) throws ExceptionDAO {
        throw new UnsupportedOperationException("No implementation yet");
    }

    public List<Shifts> getAllShiftsbyName(String name) throws ExceptionDAO {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        List<Shifts> listStud = new ArrayList<>();
        try {
            ps = conn.prepareStatement(GET_ALL_ID);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                listStud.add(convert(rs));
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the List of Shifts");
        } finally {
            returnConnect(conn);
            closeResources(ps, rs);
        }
        return listStud;
    }
}
