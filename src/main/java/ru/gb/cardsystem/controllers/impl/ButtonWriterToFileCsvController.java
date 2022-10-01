package ru.gb.cardsystem.controllers.impl;

import ru.gb.cardsystem.controllers.JComponentController;
import ru.gb.cardsystem.controllers.JComponentWriterController;
import ru.gb.cardsystem.service.impl.FileCsvWriterService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ButtonWriterToFileCsvController extends JComponentWriterController<JButton> {
    private final JComponentController<JTextField> textFieldController;

    protected ButtonWriterToFileCsvController() {
        super(new ArrayList<>(), new FileCsvWriterService());
        this.textFieldController = new TextFieldController();
        initButtonWriterToFileCsvController();
    }

    private void initButtonWriterToFileCsvController() {
        final JButton writeInFile = new JButton("Write to CSV File");
        writeInFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final Map<String, String> data = new HashMap<>();
                for (final JTextField textField : textFieldController.getComponents()) {
                    data.put(textField.getName(), textField.getText());
                }
                getWritableService().write(data);
            }
        });

        getComponents().add(writeInFile);
    }
}
