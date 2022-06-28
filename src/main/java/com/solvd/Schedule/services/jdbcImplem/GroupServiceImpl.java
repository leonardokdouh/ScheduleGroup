package com.solvd.Schedule.services.jdbcImplem;

import com.solvd.Schedule.binary.Group;
import com.solvd.Schedule.dao.IGroupDAO;
import com.solvd.Schedule.dao.impl.GroupDAO;
import com.solvd.Schedule.services.GroupService;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    @Override
    public Group getGroup(long id) {
        IGroupDAO group = new GroupDAO();
        return group.getEntity(id);
    }

    @Override
    public List<Group> getAllGroups() {
        IGroupDAO groupList = new GroupDAO();
        return groupList.getAll();
    }
}
