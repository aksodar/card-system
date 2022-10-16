package ru.gb.cardsystem.service.impl;

import ru.gb.cardsystem.controllers.impl.TextFieldController;
import ru.gb.cardsystem.data.User;
import ru.gb.cardsystem.service.Writable;

import java.util.Map;
import java.util.logging.Logger;

public class LoggerWriterService implements Writable {

    private final Logger logger;

    public LoggerWriterService() {
        this.logger = Logger.getAnonymousLogger();
    }

    @Override
    public void write(final Map<String, String> data) {
        final User user = convertFromRowData(data);
        logger.info(user.toString());
    }

    private User convertFromRowData(final Map<String, String> data) {
        final User user = new User();
        for(final String nameTextField: data.keySet()){
            switch (nameTextField){
                case TextFieldController.FIRST_NAME_TEXT_FIELD:
                    user.setFirstName(data.get(nameTextField));
                    break;
                case TextFieldController.SECOND_NAME_TEXT_FIELD:
                    user.setSecondName(data.get(nameTextField));
                    break;
                case TextFieldController.PATRONYMIC_TEXT_FIELD:
                    user.setPatronymic(data.get(nameTextField));
                    break;
                default:
                    throw new IllegalStateException("Wrong name field");
            }
        }
        return user;
    }
}
