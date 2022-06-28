package com.solvd.Schedule.dao.impl;

import com.solvd.Schedule.binary.Group;
import com.solvd.Schedule.dao.IGroupDAO;
import com.solvd.Schedule.util.exceptions.ExceptionDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDAO extends AbstractConnection implements IGroupDAO {

    private final String GET_ONE = "SELECT idGroup, shiftsId  from groups WHERE idGroup=?";
    private final String GET_ALL = "SELECT idGroup, limitAmount, shiftsId FROM groups";

    private static final Logger LOG = LogManager.getLogger(GroupDAO.class);

    @Override
    public void saveEntity(Group entity) throws ExceptionDAO {
        throw new UnsupportedOperationException("No implementation yet");
    }

    @Override
    public void update(long id, Group entity) throws ExceptionDAO {
        throw new UnsupportedOperationException("No implementation yet");
    }

    @Override
    public void delete(long id) throws ExceptionDAO {
        throw new UnsupportedOperationException("No implementation yet");
    }

    private Group convert(ResultSet rs) throws SQLException {
        //int shiftsId = rs.getInt("shiftsId");
        //int limitAmount = rs.getInt("limitAmount");
        Group group = new Group();
        group.setShiftId(rs.getInt("shiftsId"));
        group.setId(rs.getLong("idGroup"));
        return group;
    }

    @Override
    public Group getEntity(long id) throws ExceptionDAO {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        Group group;
        try {
            ps = conn.prepareStatement(GET_ONE);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                group = convert(rs);
            } else {
                throw new ExceptionDAO("Not work");
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the Group");
        } finally {
            returnConnect(conn);
            closeResources(ps, rs);
        }
        return group;
    }

    @Override
    public List<Group> getAll() throws ExceptionDAO {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        List<Group> groupList = new ArrayList<>();
        try {
            ps = conn.prepareStatement(GET_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                groupList.add(convert(rs));
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the List of Groups");
        } finally {
            returnConnect(conn);
            closeResources(ps, rs);
        }
        return groupList;
    }
}
