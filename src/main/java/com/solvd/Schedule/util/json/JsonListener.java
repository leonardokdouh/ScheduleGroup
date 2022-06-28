package com.solvd.Schedule.util.json;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.Schedule.binary.Professor;
import com.solvd.Schedule.util.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonListener {
    private static final Logger LOG = LogManager.getLogger(JsonListener.class);

    public static void getProfessorsList() {
        ObjectMapper om = new ObjectMapper();

        try {
            JavaType secodType = om.getTypeFactory().constructCollectionType(List.class, Professor.class);
            List professors = om.readValue(new File(Constants.PATHJSON.getConstantValues()), secodType);
            for (Object u : professors) {
                LOG.info(u.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException("IOException", e);
        }
    }
}
