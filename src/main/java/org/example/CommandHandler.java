package org.example;

import net.dv8tion.jda.api.events.interaction.command.GenericCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CommandHandler extends ListenerAdapter {

    public final static List<ICommand> COMMANDS = new ArrayList<>();
    private final static Logger LOGGER = LoggerFactory.getLogger(CommandHandler.class);

    static {
        COMMANDS.add(new RoleCommands());
    }

    @Override
    public void onGenericCommandInteraction(@NotNull GenericCommandInteractionEvent event) {
        LOGGER.info("GenericCommandInteractionEvent received");
        for (ICommand command : COMMANDS) {
            if (command.getCommandData().getName().equals(event.getName())) {
                LOGGER.info("Creating new Thread to handle command...");
                new Thread(() -> {
                    LOGGER.info("Handling " + command.getCommandData().getName() + "...");
                    command.handle(event);
                }).start();
            }
        }
    }
}
