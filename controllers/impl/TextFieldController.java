package ru.gb.cardsystem.controllers.impl;

import ru.gb.cardsystem.controllers.JComponentController;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TextFieldController extends JComponentController<JTextField> {

    public static final String FIRST_NAME_TEXT_FIELD = "First Name";
    public static final String SECOND_NAME_TEXT_FIELD = "Second Name";
    public static final String PATRONYMIC_TEXT_FIELD = "Patronymic";

    protected TextFieldController() {
        super(new ArrayList<>());
        initTextFields();
    }

    private void initTextFields(){
        initTextField(FIRST_NAME_TEXT_FIELD);
        initTextField(SECOND_NAME_TEXT_FIELD);
        initTextField(PATRONYMIC_TEXT_FIELD);
    }

    private void initTextField(final String text){
        final JTextField textField = new JTextField();
        textField.setText(text);
        textField.setName(text);
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                textField.setText("");
                super.mouseClicked(e);
            }
        });
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(final FocusEvent e) {
                if(textField.getText().isBlank()){
                    textField.setText(text);
                }
                super.focusLost(e);
            }
        });
        getComponents().add(textField);
    }
}
