package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;


public class Config {

    private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);
    private final static String FILE_NAME = "qBot.properties";

    public static String DISCORD;

    static {
        var properties = new Properties(1);

        try {
            LOGGER.info("Loading properties file...");
            properties.load(new FileReader(FILE_NAME));

        } catch (IOException e) {
            LOGGER.warn("Error while loading properties file: " + e.getMessage());
            LOGGER.info("Creating new one...");

            properties.setProperty(Keys.DISCORD.toString(), "");

            try {
                properties.store(new FileWriter(FILE_NAME), "YO!");
            } catch (IOException ex) {
                LOGGER.error("Error while creating properties file: " + ex.getMessage());
                System.exit(ex.hashCode());
            }

            LOGGER.info("New properties file has been created. Please enter your API keys.");
            System.exit(0);
        }
        DISCORD = properties.getProperty(Keys.DISCORD.toString());

        if (DISCORD.isEmpty()) {
            throw new ConfigException(Keys.DISCORD.toString());
        } else {
            LOGGER.info("Properties file successfully loaded!");
        }
    }

    public enum Keys {
        DISCORD
    }

}
