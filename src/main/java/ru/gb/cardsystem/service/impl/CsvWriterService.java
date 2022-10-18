package ru.gb.cardsystem.service.impl;

import ru.gb.cardsystem.controllers.impl.TextFieldController;
import ru.gb.cardsystem.data.User;
import ru.gb.cardsystem.service.Writable;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;

public class CsvWriterService implements Writable{
	@Override
	public void write(Map<String, String> data) {
		File f = new File("test.csv");
		try {
			FileWriter a = new FileWriter(f);
			a.append(convertFromRowData(data).toString());
			a.flush();
			a.close();
			System.out.println("done");
		} catch (Exception e) {
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
