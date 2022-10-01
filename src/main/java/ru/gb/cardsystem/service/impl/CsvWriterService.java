package ru.gb.cardsystem.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ru.gb.cardsystem.data.User;

import ru.gb.cardsystem.controllers.impl.TextFieldController;
import ru.gb.cardsystem.service.Writable;

public class CsvWriterService implements Writable {

    @Override
    public void write(Map<String, String> data) {
        File f = new File("Out.csv");

        try {
            FileWriter a = new FileWriter(f);
            a.append(convertFromRowData(data).toString());
            a.flush();
            a.close();

        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }

    private String convertFromRowData(final Map<String, String> data) {
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
        return (String.format("%s;%s;%s;", user.getFirstName(), user.getSecondName(), user.getPatronymic()));
    }
}