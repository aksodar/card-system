package ru.gb.cardsystem.service.impl;
import java.util.Map;
import ru.gb.cardsystem.controllers.impl.TextFieldController;
import ru.gb.cardsystem.data.User;
import ru.gb.cardsystem.service.Writable;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



public class FileWriterCsvService implements Writable{
   
    @Override
    public void write(Map<String, String> data){
 try {
            
            convertFromRowData(data).getFirstName().toString();
        
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("OutCSV.csv"));
            writer.write("Имя;Фамилия;Отчество");
            writer.newLine();
            writer.write(convertFromRowData(data).getFirstName().toString());
            writer.write(";".toString());
            writer.write(convertFromRowData(data).getSecondName().toString());
            writer.write(";".toString());
            writer.write(convertFromRowData(data).getPatronymic().toString());
            writer.write(";".toString());
            writer.newLine();
            writer.close();
        
        } catch (IOException ex) {
            ex.printStackTrace();
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
