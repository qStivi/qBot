package org.example;

public class ConfigException extends RuntimeException {

    public ConfigException(String message) {
        super("The value of " + message + " is malformed or empty!");
    }
}
