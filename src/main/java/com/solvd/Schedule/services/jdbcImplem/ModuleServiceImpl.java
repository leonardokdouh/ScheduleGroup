package com.solvd.Schedule.services.jdbcImplem;

import com.solvd.Schedule.binary.Module;
import com.solvd.Schedule.dao.IModuleDAO;
import com.solvd.Schedule.dao.impl.ModuleDAO;
import com.solvd.Schedule.services.ModuleService;

import java.util.List;

public class ModuleServiceImpl implements ModuleService {

    @Override
    public Module getModule(long id) {
        IModuleDAO modules = new ModuleDAO();
        return modules.getEntity(id);
    }

    @Override
    public List<Module> getAllModules() {
        IModuleDAO modules = new ModuleDAO();
        return modules.getAll();
    }

    @Override
    public List<Module> getAllModulesbyShiftId(long id) {
        IModuleDAO modules = new ModuleDAO();
        return ((ModuleDAO) modules).getAllModulesbyShiftId(id);
    }
}
