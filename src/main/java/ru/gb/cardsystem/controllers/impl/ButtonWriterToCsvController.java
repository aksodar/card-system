package ru.gb.cardsystem.controllers.impl;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import ru.gb.cardsystem.controllers.JComponentController;
import ru.gb.cardsystem.controllers.JComponentWriterController;
import ru.gb.cardsystem.service.impl.CsvWriterService;


public class ButtonWriterToCsvController extends JComponentWriterController<JButton> {

	private final JComponentController<JTextField> textFieldController;

	protected ButtonWriterToCsvController(){
		super(new ArrayList<>(), new CsvWriterService());
		this.textFieldController = new TextFieldController();
		init();
	}

	private void init() {
        final JButton writeInLogger = new JButton("Write to Csv");
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
