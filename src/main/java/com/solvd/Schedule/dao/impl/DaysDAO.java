package com.solvd.Schedule.dao.impl;

import com.solvd.Schedule.binary.Days;
import com.solvd.Schedule.dao.IDaysDAO;
import com.solvd.Schedule.util.exceptions.ExceptionDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaysDAO extends AbstractConnection implements IDaysDAO {

    private final String UPDATE = "UPDATE days SET name =?, hours= ?, shiftsId=?  WHERE idDays=?";
    private final String GET_ONE = "SELECT idDays, name, hours, shiftsId from days WHERE idDays=?";
    private final String GET_ALL = "SELECT idDays, name, hours, shiftsId FROM days";
    private final String GET_ALL_ID = "SELECT idDays, name, hours, shiftsId FROM days WHERE shiftsId=?";

    private static final Logger LOG = LogManager.getLogger(DaysDAO.class);

    @Override
    public void saveEntity(Days entity) throws ExceptionDAO {
        throw new UnsupportedOperationException("No implementation yet");
    }

    @Override
    public void update(long id, Days entity) throws ExceptionDAO {
        PreparedStatement ps = null;
        Connection conn = getConnect();
        try {
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getHours());
            ps.setLong(3, entity.getShiftsId());
            ps.setLong(4, id);
            if (ps.executeUpdate() == 0) {
                throw new ExceptionDAO("Maybe it don't update the Day");
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
        throw new UnsupportedOperationException("No implementation yet");
    }

    private Days convert(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        int hours = rs.getInt("hours");
        int shiftsId = rs.getInt("shiftsId");
        Days day = new Days(name, hours, shiftsId);
        day.setId(rs.getLong("idDays"));
        return day;
    }


    @Override
    public Days getEntity(long id) throws ExceptionDAO {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        Days days;
        try {
            ps = conn.prepareStatement(GET_ONE);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                days = convert(rs);
            } else {
                throw new ExceptionDAO("Not work");
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the Day");
        } finally {
            returnConnect(conn);
            closeResources(ps, rs);
        }
        return days;
    }
    //get by shifts Id

    @Override
    public List<Days> getAll() throws ExceptionDAO {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        List<Days> daysList = new ArrayList<>();
        try {
            ps = conn.prepareStatement(GET_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                daysList.add(convert(rs));
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the List od Days");
        } finally {
            returnConnect(conn);
            closeResources(ps, rs);
        }
        return daysList;
    }

    public List<Days> getAllbyShiftId(long id) throws ExceptionDAO {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        List<Days> daysList = new ArrayList<>();
        try {
            ps = conn.prepareStatement(GET_ALL_ID);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                daysList.add(convert(rs));
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the List od Days");
        } finally {
            returnConnect(conn);
            closeResources(ps, rs);
        }
        return daysList;
    }
}
