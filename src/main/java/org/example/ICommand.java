package org.example;

import net.dv8tion.jda.api.events.interaction.command.GenericCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;

public interface ICommand {

    void handle(GenericCommandInteractionEvent event);

    CommandData getCommandData();

}
