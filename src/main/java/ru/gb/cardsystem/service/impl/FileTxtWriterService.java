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

public class FileTxtWriterService implements Writable {

    private final Logger logger;

    public FileTxtWriterService() {
        this.logger = Logger.getAnonymousLogger();
    }

    @Override
    public void write(Map<String, String> data) {
        final File file = new File("Out.txt");
        try (final FileWriter fileWriter = new FileWriter(file, true)) {
            final User user = UserUtils.convertFromRowData(data);
            fileWriter.append(user.toString());
            fileWriter.append('\n');
            fileWriter.flush();
//            fileWriter.close();
        } catch (IOException e) {
            logger.warning(e.getLocalizedMessage());
        }
        logger.info(LoggerMsg.SUCCESSFUL_ACTION_WRITE_IN_FILE_TXT_MSG);
    }
}
