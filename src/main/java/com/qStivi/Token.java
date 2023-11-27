package com.qStivi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class Token {
    private static final Logger logger = LoggerFactory.getLogger(Token.class);

    // Get token from token file and if file does not exist or is empty ask for token and save it to file for later use
    public static String getToken() {
        String token = "";
        Path path = Path.of("token");

        try {
            token = Files.readString(path);
        } catch (IOException e) {
            logger.error("Could not read token file.");
        }

        if (token.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter your token:");
            token = scanner.nextLine();
            try {
                Files.writeString(path, token);
            } catch (IOException e) {
                logger.error("Could not write token file.");
            }
        }
        return token;
    }

}
