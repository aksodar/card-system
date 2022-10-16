package ru.gb.cardsystem.controllers;

import ru.gb.cardsystem.service.Writable;

import javax.swing.*;
import java.util.List;

/**
 * An abstraction to describe a controller storing the state of JComponents and a writing service
 */
public abstract class JComponentWriterController<T extends JComponent> extends JComponentController<T> {

    Writable writableService;

    protected JComponentWriterController(final List<T> components, final Writable writableService) {
        super(components);
        this.writableService = writableService;
    }

    public Writable getWritableService() {
        return writableService;
    }
}
