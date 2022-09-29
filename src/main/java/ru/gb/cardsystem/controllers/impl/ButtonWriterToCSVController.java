package ru.gb.cardsystem.controllers.impl;

import ru.gb.cardsystem.controllers.JComponentController;
import ru.gb.cardsystem.controllers.JComponentWriterController;
import ru.gb.cardsystem.service.impl.CSVWriterService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ButtonWriterToCSVController extends JComponentWriterController<JButton> {

    private final JComponentController<JTextField> textFieldController;
    protected ButtonWriterToCSVController() {
        super(new ArrayList<>(), new CSVWriterService());
        this.textFieldController = new TextFieldController();
        init();
    }

    private void init() {
        final JButton writeToCsvFile = new JButton("Write to CSV File");
        writeToCsvFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final Map<String, String> data = new HashMap<>();
                for (final JTextField textField : textFieldController.getComponents()) {
                    data.put(textField.getName(), textField.getText());
                }
                getWritableService().write(data);
            }
        });

        getComponents().add(writeToCsvFile);
    }
}
