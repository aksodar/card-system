package ru.gb.cardsystem.controllers;

import javax.swing.*;
import java.util.List;

/**
 * An abstraction to describe a controller storing the state of JComponents
 */
public abstract class JComponentController<T extends JComponent> {

    List<T> components;

    protected JComponentController(final List<T> components) {
        this.components = components;
    }

    public List<T> getComponents() {
        return components;
    }

}
