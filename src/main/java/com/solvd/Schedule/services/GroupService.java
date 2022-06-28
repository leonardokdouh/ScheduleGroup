package com.solvd.Schedule.services;

import com.solvd.Schedule.binary.Group;

import java.util.List;

public interface GroupService {

    Group getGroup (long id);

    List<Group> getAllGroups();
}
