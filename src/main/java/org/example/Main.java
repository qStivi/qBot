package org.example;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;

public class Main {

    public static final JDA JDA = JDABuilder.createLight(Config.DISCORD).build();
    private final static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        registerEventListeners(JDA);
        registerCommands(JDA);
    }

    private static void registerEventListeners(JDA jda) {
        jda.addEventListener(new CommandHandler());
    }

    private static void registerCommands(JDA jda) {
        LOGGER.info("Registering and updating commands...");
        jda.updateCommands().addCommands(CommandHandler.COMMANDS.stream().map(ICommand::getCommandData).collect(Collectors.toList())).complete();
    }
}
