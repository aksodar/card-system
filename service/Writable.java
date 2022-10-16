package ru.gb.cardsystem.service;

import java.util.Map;

/**
 * Interface defining the interaction of data output
 */
public interface Writable {

    void write(Map<String, String> data);

}
