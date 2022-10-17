package ru.gb.cardsystem.controllers.impl;

import javax.swing.*;

import ru.gb.cardsystem.controllers.JComponentController;
import ru.gb.cardsystem.controllers.JComponentWriterController;
import ru.gb.cardsystem.service.impl.FileWriterService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ButtonWriterToFileController extends JComponentWriterController<JButton>{
    
    private final JComponentController<JTextField> textFieldController;

    public ButtonWriterToFileController() {
        super(new ArrayList<>(), new FileWriterService());
        this.textFieldController = new TextFieldController();
        
        init();
    }
    
    private void init() {
        final JButton writeInLogger = new JButton("Write in txt");
        writeInLogger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final Map<String, String> data = new HashMap<>();
                for (final JTextField textField : textFieldController.getComponents()) {
                    data.put(textField.getName(), textField.getText());
                }
                getWritableService().write(data);
            }
        });

        getComponents().add(writeInLogger);
    }
}
