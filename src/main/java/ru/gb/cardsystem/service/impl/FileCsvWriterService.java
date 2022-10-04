package ru.gb.cardsystem.service.impl;

import ru.gb.cardsystem.controllers.impl.TextFieldController;
import ru.gb.cardsystem.data.User;
import ru.gb.cardsystem.service.Writable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileCsvWriterService implements Writable {

    public FileCsvWriterService() {

    }
    @Override
    public void write(Map<String, String> data) {
        File file = new  File("Out.csv");
        try {
            FileWriter fw = new FileWriter(file);
            StringBuilder sb = new StringBuilder();
            sb.append(convertFromRowData(data).getFirstName());
            sb.append(";");
            sb.append(convertFromRowData(data).getSecondName());
            sb.append(";");
            sb.append(convertFromRowData(data).getPatronymic());
            fw.write(sb.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

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