package ru.gb.cardsystem.service.impl;

import ru.gb.cardsystem.controllers.impl.TextFieldController;
import ru.gb.cardsystem.data.User;
import ru.gb.cardsystem.service.Writable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CSVWriterService implements Writable {
        public void write(Map<String, String> data) {
            File f = new File("Out.csv");
            FileWriter a = null;
            try {
                a = new FileWriter(f);
                User csv_us = convertFromRowData(data);
                a.append(csv_us.getFirstName() + ";" + csv_us.getSecondName() + ";" + csv_us.getPatronymic() + ";");
                a.flush();
                a.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
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
        public CSVWriterService(){

        }
}
