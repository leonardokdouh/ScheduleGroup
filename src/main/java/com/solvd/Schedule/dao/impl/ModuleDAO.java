package com.solvd.Schedule.dao.impl;

import com.solvd.Schedule.binary.Module;
import com.solvd.Schedule.dao.IClassroomDAO;
import com.solvd.Schedule.dao.IModuleDAO;
import com.solvd.Schedule.dao.IShiftsDAO;
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

public class ModuleDAO extends AbstractConnection implements IModuleDAO {

    private final String GET_ONE = "SELECT  idModule, subjectsId, classroomsId, shiftsId from modules WHERE idModule=?";
    private final String GET_ALL = "SELECT idModule, subjectsId, classroomsId, shiftsId FROM modules";
    private final String GET_ALL_ID = "SELECT idModule, subjectsId, classroomsId, shiftsId FROM modules WHERE shiftsId=?";

    private static final Logger LOG = LogManager.getLogger(ModuleDAO.class);

    @Override
    public void saveEntity(Module entity) throws ExceptionDAO {
        throw new UnsupportedOperationException("No implementation yet");

    }

    @Override
    public void update(long id, Module entity) throws ExceptionDAO {
        throw new UnsupportedOperationException("No implementation yet");

    }

    @Override
    public void delete(long id) throws ExceptionDAO {
        throw new UnsupportedOperationException("No implementation yet");

    }

    public Module convert(ResultSet rs) throws SQLException {
        ISubjectDAO subj = new SubjectDAO();
        IShiftsDAO shift = new ShiftsDAO();
        IClassroomDAO classRoom = new ClassroomDAO();
        Module mod = new Module();
        mod.setId(rs.getInt("idModule"));
        mod.setShift(shift.getEntity(rs.getInt("shiftsId")));
        mod.setClassroom(classRoom.getEntity(rs.getInt("classroomsId")));
        mod.setSubject(subj.getEntity(rs.getInt("subjectsId")));
        return mod;
    }

    @Override
    public Module getEntity(long id) throws ExceptionDAO {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        Module modu;
        try {
            ps = conn.prepareStatement(GET_ONE);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                modu = convert(rs);
            } else {
                throw new ExceptionDAO("Not work");
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the Module");
        } finally {
            returnConnect(conn);
            closeResources(ps, rs);
        }
        return modu;
    }

    @Override
    public List<Module> getAll() throws ExceptionDAO {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        List<Module> listModu = new ArrayList<>();
        try {
            ps = conn.prepareStatement(GET_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                listModu.add(convert(rs));
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the List of Modules");
        } finally {
            returnConnect(conn);
            closeResources(ps, rs);
        }
        return listModu;
    }

    public List<Module> getAllModulesbyShiftId(long id) throws ExceptionDAO {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnect();
        List<Module> mod = new ArrayList<>();
        try {
            ps = conn.prepareStatement(GET_ALL_ID);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                mod.add(convert(rs));
            }
        } catch (SQLException e) {
            LOG.error("Error in SQL", e);
            throw new ExceptionDAO("Can't reach the List of Shifts");
        } finally {
            returnConnect(conn);
            closeResources(ps, rs);
        }
        return mod;
    }
}
