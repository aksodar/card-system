package ru.gb.cardsystem.service.impl;

import ru.gb.cardsystem.data.User;
import ru.gb.cardsystem.service.Writable;
import ru.gb.cardsystem.util.LoggerMsg;
import ru.gb.cardsystem.util.UserUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

public class FileCsvWriterService implements Writable {
    private final Logger logger;
    public FileCsvWriterService() {
        this.logger = Logger.getAnonymousLogger();
    }

    @Override
    public void write(Map<String, String> data) {
        File file = new File("Logs.csv");
        try (final FileWriter fileWriter = new FileWriter(file, true)) {
            final User user = UserUtils.convertFromRowData(data);
            StringBuilder concat = new StringBuilder();
            concat.append(user.getFirstName());
            concat.append(";");
            concat.append(user.getSecondName());
            concat.append(";");
            concat.append(user.getPatronymic());
            concat.append('\n');
            fileWriter.append(concat);
            fileWriter.flush();
//            fileWriter.close();
        } catch (IOException e) {
            logger.warning(e.getLocalizedMessage());
        }
        logger.info(LoggerMsg.SUCCESSFUL_ACTION_WRITE_IN_FILE_SVG_MSG);
    }

}

