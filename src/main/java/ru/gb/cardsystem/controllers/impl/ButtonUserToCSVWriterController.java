package ru.gb.cardsystem.controllers.impl;

import ru.gb.cardsystem.controllers.JComponentController;
import ru.gb.cardsystem.controllers.JComponentWriterController;
import ru.gb.cardsystem.service.impl.UserToCSVWriterService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ButtonUserToCSVWriterController extends JComponentWriterController<JButton> {

    private JComponentController<JTextField> textFieldController;

    protected ButtonUserToCSVWriterController(JComponentController<JTextField> tfc ) {
        super(new ArrayList<>(), new UserToCSVWriterService());
        this.textFieldController = tfc;
        init();
    }

    public void setTextFieldController(JComponentController<JTextField> tfc){
        this.textFieldController = tfc;
    }

    private void init() {
        final JButton writeInCSV = new JButton("Write in CSV file");
        writeInCSV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final Map<String, String> data = new HashMap<>();
                for (final JTextField textField : textFieldController.getComponents()) {
                    data.put(textField.getName(), textField.getText());
                }
                getWritableService().write(data);
                
            }
        });
        
        getComponents().add(writeInCSV);
    }
}
