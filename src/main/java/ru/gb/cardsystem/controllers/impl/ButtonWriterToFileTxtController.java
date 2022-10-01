package ru.gb.cardsystem.controllers.impl;

import ru.gb.cardsystem.controllers.JComponentController;
import ru.gb.cardsystem.controllers.JComponentWriterController;
import ru.gb.cardsystem.service.impl.FileTxtWriterService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ButtonWriterToFileTxtController extends JComponentWriterController<JButton> {

    private final JComponentController<JTextField> textFieldController;

    protected ButtonWriterToFileTxtController() {
        super(new ArrayList<>(), new FileTxtWriterService());
        this.textFieldController = new TextFieldController();
        initButtonWriterToFileTxtController();
    }

    private void initButtonWriterToFileTxtController() {
        final JButton writeInFile = new JButton("Write to TXT File");
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
