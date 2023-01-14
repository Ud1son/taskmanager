package ru.udisondev.taskmanager.service;

import lombok.Getter;

@Getter
public enum MESSAGE {

    START_MESSAGE("Превет введи команду!"),
    COMMANDS("""
            1. /create
            """);
    private final String message;

    MESSAGE(String message) {
        this.message = message;
    }
}
