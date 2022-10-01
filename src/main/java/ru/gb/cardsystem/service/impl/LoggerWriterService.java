package ru.gb.cardsystem.service.impl;

import ru.gb.cardsystem.data.User;
import ru.gb.cardsystem.service.Writable;
import ru.gb.cardsystem.util.LoggerMsg;
import ru.gb.cardsystem.util.UserUtils;

import java.util.Map;
import java.util.logging.Logger;

public class LoggerWriterService implements Writable {

    private final Logger logger;

    public LoggerWriterService() {
        this.logger = Logger.getAnonymousLogger();
    }

    @Override
    public void write(final Map<String, String> data) {
        final User user = UserUtils.convertFromRowData(data);
        logger.info(user.toString());
        logger.info(LoggerMsg.SUCCESSFUL_ACTION_WRITE_IN_LOGGER_MSG);
    }
}