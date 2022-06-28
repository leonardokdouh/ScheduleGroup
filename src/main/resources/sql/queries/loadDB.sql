--Professors
    INSERT INTO `LeoMoschnerSchedule`.`professors` (`firstName`, `lastName`) VALUES ('Charles', 'Xavier');
    INSERT INTO `LeoMoschnerSchedule`.`professors` (`firstName`, `lastName`) VALUES ('John', 'Smith');
    INSERT INTO `LeoMoschnerSchedule`.`professors` (`firstName`, `lastName`) VALUES ('Charles', 'Leclerc');
    INSERT INTO `LeoMoschnerSchedule`.`professors` (`firstName`, `lastName`) VALUES ('Carlos', 'Saiz');
    INSERT INTO `LeoMoschnerSchedule`.`professors` (`firstName`, `lastName`) VALUES ('Max', 'Verstapen');
    INSERT INTO `LeoMoschnerSchedule`.`professors` (`firstName`, `lastName`) VALUES ('Sergio', 'Perez');
    INSERT INTO `LeoMoschnerSchedule`.`professors` (`firstName`, `lastName`) VALUES ('George', 'Rusell');
    INSERT INTO `LeoMoschnerSchedule`.`professors` (`firstName`, `lastName`) VALUES ('Lewis', 'Hamilton');
    INSERT INTO `LeoMoschnerSchedule`.`professors` (`firstName`, `lastName`) VALUES ('Lando', 'Norris');
    INSERT INTO `LeoMoschnerSchedule`.`professors` (`firstName`, `lastName`) VALUES ('Daniel', 'Ricciardo');

--Subjects
    INSERT INTO `LeoMoschnerSchedule`.`subjects` (`idSubjects`, `name`, `professors_ID`) VALUES ('1', 'Maths', '1');
    INSERT INTO `LeoMoschnerSchedule`.`subjects` (`idSubjects`, `name`, `professors_ID`) VALUES ('2', 'Physics', '3');
    INSERT INTO `LeoMoschnerSchedule`.`subjects` (`idSubjects`, `name`, `professors_ID`) VALUES ('3', 'English', '2');
    INSERT INTO `LeoMoschnerSchedule`.`subjects` (`idSubjects`, `name`, `professors_ID`) VALUES ('4', 'Spanish', '5');
    INSERT INTO `LeoMoschnerSchedule`.`subjects` (`idSubjects`, `name`, `professors_ID`) VALUES ('5', 'Arts', '4');
    INSERT INTO `LeoMoschnerSchedule`.`subjects` (`idSubjects`, `name`, `professors_ID`) VALUES ('6', 'Economy', '7');
    INSERT INTO `LeoMoschnerSchedule`.`subjects` (`idSubjects`, `name`, `professors_ID`) VALUES ('7', 'Philoshophy', '6');
    INSERT INTO `LeoMoschnerSchedule`.`subjects` (`idSubjects`, `name`, `professors_ID`) VALUES ('8', 'French', '8');
    INSERT INTO `LeoMoschnerSchedule`.`subjects` (`idSubjects`, `name`, `professors_ID`) VALUES ('9', 'Music', '10');
    INSERT INTO `LeoMoschnerSchedule`.`subjects` (`idSubjects`, `name`, `professors_ID`) VALUES ('10', 'Chemistry', '9');

--Classrooms
    INSERT INTO `LeoMoschnerSchedule`.`classrooms` (`classroomsNumber`, `size`, `available`) VALUES ('1', '10', '1');
    INSERT INTO `LeoMoschnerSchedule`.`classrooms` (`classroomsNumber`, `size`, `available`) VALUES ('2', '15', '1');
    INSERT INTO `LeoMoschnerSchedule`.`classrooms` (`classroomsNumber`, `size`, `available`) VALUES ('3', '20', '1');
    INSERT INTO `LeoMoschnerSchedule`.`classrooms` (`classroomsNumber`, `size`, `available`) VALUES ('4', '20', '1');
    INSERT INTO `LeoMoschnerSchedule`.`classrooms` (`classroomsNumber`, `size`, `available`) VALUES ('5', '10', '1');


--Calendars (Only 1 for now with 3 shifts (morning, afternoon and night))
    INSERT INTO `LeoMoschnerSchedule`.`calendar` (`idCalendar`) VALUES ('1');

--Shifts
    INSERT INTO `LeoMoschnerSchedule`.`shifts` (`idShifts`, `name`, `calendario_ID`) VALUES ('1', 'Morning', '1');
    INSERT INTO `LeoMoschnerSchedule`.`shifts` (`idShifts`, `name`, `calendario_ID`) VALUES ('2', 'Afternoon', '1');
    INSERT INTO `LeoMoschnerSchedule`.`shifts` (`idShifts`, `name`, `calendario_ID`) VALUES ('3', 'Night', '1');

--Groups (Only 3 for now)
    INSERT INTO `LeoMoschnerSchedule`.`group` (`idGrupo`, `limitAmount`, `shifts_ID`) VALUES ('1', '10', '1');
    INSERT INTO `LeoMoschnerSchedule`.`group` (`idGrupo`, `limitAmount`, `shifts_ID`) VALUES ('2', '15', '2');
    INSERT INTO `LeoMoschnerSchedule`.`group` (`idGrupo`, `limitAmount`, `shifts_ID`) VALUES ('3', '20', '3');

--Students
    --Group 1 (full)
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('1', 'Lionel', 'Messi', '1');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('2', 'John', 'Aniston', '1');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('3', 'Joseph', 'Banks', '1');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('4', 'Kevin', 'Hudson', '1');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('5', 'Amber', 'Jackson', '1');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('6', 'Frank', 'Simpson', '1');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('7', 'Agustin', 'Smith', '1');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('8', 'Luciana', 'Pitt', '1');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('9', 'Jeniffer', 'Adams', '1');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('10', 'Britany', 'Lake', '1');

    --Group 2
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('11', 'Lucas', 'Newton', '2');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('12', 'Carlos', 'Feldman', '2');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('13', 'Charles', 'Walker', '2');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('14', 'Joaquin', 'Henderson', '2');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('15', 'Julian', 'Alvarez', '2');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('16', 'Jose', 'Mourin', '2');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('17', 'Silvina', 'Sanchez', '2');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('18', 'Paula', 'Moun', '2');

    --Group 3
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('19', 'Marina', 'Lahm', '3');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('20', 'Natalia', 'Humels', '3');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('21', 'Nahir', 'Crimson', '3');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('22', 'Natasha', 'Johnson', '3');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('23', 'Meredith', 'Jollie', '3');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('24', 'Sebastian', 'Pommer', '3');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('25', 'Vladimir', 'Steganov', '3');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('26', 'Viktor', 'Keith', '3');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('27', 'Luciano', 'Peterson', '3');
        INSERT INTO `LeoMoschnerSchedule`.`students` (`idStudents`, `firstName`, `lastName`, `group_Id`) VALUES ('28', 'Sol', 'Helson', '3');

--Days
    --Shift 1
        INSERT INTO `LeoMoschnerSchedule`.`days` (`name`, `hours`, `shifts_ID`) VALUES ('Monday', '4', '1');
        INSERT INTO `LeoMoschnerSchedule`.`days` (`name`, `hours`, `shifts_ID`) VALUES ('Tuesday', '4', '1');
        INSERT INTO `LeoMoschnerSchedule`.`days` (`name`, `hours`, `shifts_ID`) VALUES ('Wednesday', '4', '1');
        INSERT INTO `LeoMoschnerSchedule`.`days` (`name`, `hours`, `shifts_ID`) VALUES ('Thursday', '4', '1');
        INSERT INTO `LeoMoschnerSchedule`.`days` (`name`, `hours`, `shifts_ID`) VALUES ('Friday', '4', '1');

    --Shift 2
        INSERT INTO `LeoMoschnerSchedule`.`days` (`name`, `hours`, `shifts_ID`) VALUES ('Monday', '4', '2');
        INSERT INTO `LeoMoschnerSchedule`.`days` (`name`, `hours`, `shifts_ID`) VALUES ('Tuesday', '4', '2');
        INSERT INTO `LeoMoschnerSchedule`.`days` (`name`, `hours`, `shifts_ID`) VALUES ('Wednesday', '4', '2');
        INSERT INTO `LeoMoschnerSchedule`.`days` (`name`, `hours`, `shifts_ID`) VALUES ('Thursday', '4', '2');
        INSERT INTO `LeoMoschnerSchedule`.`days` (`name`, `hours`, `shifts_ID`) VALUES ('Friday', '4', '2');

    --Shift 3
        INSERT INTO `LeoMoschnerSchedule`.`days` (`name`, `hours`, `shifts_ID`) VALUES ('Monday', '4', '3');
        INSERT INTO `LeoMoschnerSchedule`.`days` (`name`, `hours`, `shifts_ID`) VALUES ('Tuesday', '4', '3');
        INSERT INTO `LeoMoschnerSchedule`.`days` (`name`, `hours`, `shifts_ID`) VALUES ('Wednesday', '4', '3');
        INSERT INTO `LeoMoschnerSchedule`.`days` (`name`, `hours`, `shifts_ID`) VALUES ('Thursday', '4', '3');
        INSERT INTO `LeoMoschnerSchedule`.`days` (`name`, `hours`, `shifts_ID`) VALUES ('Friday', '4', '3');

--Module (Only a few so we can add them from java code)
    INSERT INTO `LeoMoschnerSchedule`.`modules` (`subjects_ID`, `classrooms_ID`, `shifts_ID`) VALUES ('1', '1', '1');
    INSERT INTO `LeoMoschnerSchedule`.`modules` (`subjects_ID`, `classrooms_ID`, `shifts_ID`) VALUES ('2', '1', '1');
    INSERT INTO `LeoMoschnerSchedule`.`modules` (`subjects_ID`, `classrooms_ID`, `shifts_ID`) VALUES ('1', '2', '2');
    INSERT INTO `LeoMoschnerSchedule`.`modules` (`subjects_ID`, `classrooms_ID`, `shifts_ID`) VALUES ('2', '2', '3');

--Students Subjects
    INSERT INTO `LeoMoschnerSchedule`.`studentsSubjects` (`students_ID`, `subjects_ID`, `grade`) VALUES ('1', '1', '8');
    INSERT INTO `LeoMoschnerSchedule`.`studentsSubjects` (`students_ID`, `subjects_ID`, `grade`) VALUES ('1', '2', '9');
    INSERT INTO `LeoMoschnerSchedule`.`studentsSubjects` (`students_ID`, `subjects_ID`, `grade`) VALUES ('1', '3', '6');
    INSERT INTO `LeoMoschnerSchedule`.`studentsSubjects` (`students_ID`, `subjects_ID`, `grade`) VALUES ('1', '4', '5');
    INSERT INTO `LeoMoschnerSchedule`.`studentsSubjects` (`students_ID`, `subjects_ID`, `grade`) VALUES ('2', '4', '10');
    INSERT INTO `LeoMoschnerSchedule`.`studentsSubjects` (`students_ID`, `subjects_ID`, `grade`) VALUES ('2', '5', '7');
    INSERT INTO `LeoMoschnerSchedule`.`studentsSubjects` (`students_ID`, `subjects_ID`, `grade`) VALUES ('2', '6', '3');
    INSERT INTO `LeoMoschnerSchedule`.`studentsSubjects` (`students_ID`, `subjects_ID`, `grade`) VALUES ('3', '7', '4');
    INSERT INTO `LeoMoschnerSchedule`.`studentsSubjects` (`students_ID`, `subjects_ID`, `grade`) VALUES ('3', '7', '9');
    INSERT INTO `LeoMoschnerSchedule`.`studentsSubjects` (`students_ID`, `subjects_ID`, `grade`) VALUES ('3', '1', '2');