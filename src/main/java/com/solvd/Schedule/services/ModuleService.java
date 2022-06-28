package com.solvd.Schedule.services;

import com.solvd.Schedule.binary.Module;

import java.util.List;

public interface ModuleService {

    Module getModule (long id);

    List<Module> getAllModules();

    List<Module> getAllModulesbyShiftId(long id);
}
