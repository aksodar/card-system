package ru.gb.cardsystem.service;

import java.util.Map;

/**
 * Interface defining the interaction of data output
 */
public interface Writable { // это есть абстракция

    void write(Map<String, String> data);

}
