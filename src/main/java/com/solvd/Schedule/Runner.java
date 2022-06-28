package com.solvd.Schedule;

import com.solvd.Schedule.binary.Days;
import com.solvd.Schedule.binary.Module;
import com.solvd.Schedule.binary.Shifts;
import com.solvd.Schedule.binary.Subject;
import com.solvd.Schedule.services.DaysService;
import com.solvd.Schedule.services.ShiftService;
import com.solvd.Schedule.services.SubjectService;
import com.solvd.Schedule.services.jdbcImplem.DaysServiceImpl;
import com.solvd.Schedule.services.jdbcImplem.ShiftServiceImpl;
import com.solvd.Schedule.services.jdbcImplem.SubjectServiceImpl;
import com.solvd.Schedule.util.exceptions.InvalidSelection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static com.solvd.Schedule.util.json.JsonListener.getProfessorsList;
import static com.solvd.Schedule.util.menuOptions.Menu.menuOptions;

public class Runner {

    private static final Logger LOG = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        menuOptions();
        switch (sc.nextInt()) {
            case 1:
                String shiftName;
                LOG.info("Select a shift:\n\t1. Morning.\n\t2. Afternoon.");
                if (sc.nextInt() == 1) {
                    shiftName = "Morning";
                } else {
                    shiftName = "Afternoon";
                }
                Shifts shift = new Shifts(shiftName);
                shift.generateDays();
                LOG.info("Your schedule is being created from scratch this might take a while.");
                shift.createFromScratch();
                LOG.info(shift);
                break;
            case 2:
                LOG.info("Loading schedules from DB, this might take a while. Please select a Schedule.");
                ShiftService shiftServ = new ShiftServiceImpl();
                List<Shifts> shiftsList = shiftServ.getShifts();
                DaysService daysServ = new DaysServiceImpl();
                AtomicInteger i = new AtomicInteger(1);
                shiftsList.forEach(shi -> {
                    List<Days> listDays = daysServ.getAllbyShiftId(shi.getId());
                    shi.setDays(listDays);
                    LOG.info("\n" + i.getAndIncrement() + ". " + shi);
                });
                Shifts existingShift = shiftsList.get(sc.nextInt() - 1);
                LOG.info("Loading subjects from DB, this might take a while. Please select a Subject: ");
                SubjectService subjServ = new SubjectServiceImpl();
                AtomicInteger j = new AtomicInteger(1);
                List<Subject> subjectList = subjServ.getAllSubjects();
                subjectList.forEach(sub -> {
                    LOG.info(j.getAndIncrement() + ". " + sub.getName());
                });
                Subject subject = subjectList.get(sc.nextInt() - 1);
                Module module = new Module();
                module.setSubject(subject);
                existingShift.addModule(module);
                LOG.info(existingShift);
                break;
            case 3:
                LOG.info("Here are all the Professors in our School");
                getProfessorsList();
                break;
            default:
                throw new InvalidSelection("You must chose a number between the numbered options");
        }
    }
}