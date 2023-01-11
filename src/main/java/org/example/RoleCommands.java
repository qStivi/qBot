package org.example;

import net.dv8tion.jda.api.events.interaction.command.GenericCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandGroupData;

public class RoleCommands implements ICommand {

    private final static String COMMAND_NAME = "roles";
    private final static String CHANNEL_GROUP_NAME = "channel";
    private final static String ROLE_GROUP_NAME = "role";
    private final static String CREATE_CHANNEL_COMMAND_NAME = "create";
    private final static String MODIFY_CHANNEL_COMMAND_NAME = "modify";
    private final static String REMOVE_CHANNEL_COMMAND_NAME = "remove";
    private final static String CREATE_ROLE_COMMAND_NAME = "create";
    private final static String MODIFY_ROLE_COMMAND_NAME = "modify";
    private final static String REMOVE_ROLE_COMMAND_NAME = "remove";

    @Override
    public void handle(GenericCommandInteractionEvent event) {
        var subCommandGroup = event.getSubcommandGroup();
        var subCommand = event.getSubcommandName();

        if (subCommandGroup == null) throw new NullPointerException("subCommandGroup is null!");
        if (subCommand == null) throw new NullPointerException("subCommand is null!");

        chooseSubCommand(event, subCommandGroup, subCommand);
    }

    private void chooseSubCommand(GenericCommandInteractionEvent event, String subCommandGroup, String subCommand) {
        switch (subCommandGroup) {
            case CHANNEL_GROUP_NAME -> {
                switch (subCommand) {
                    case CREATE_CHANNEL_COMMAND_NAME -> createChannel(event);
                    case MODIFY_CHANNEL_COMMAND_NAME -> modifyChannel(event);
                    case REMOVE_CHANNEL_COMMAND_NAME -> removeChannel(event);
                }
            }
            case ROLE_GROUP_NAME -> {
                switch (subCommand) {
                    case CREATE_ROLE_COMMAND_NAME -> createRole(event);
                    case MODIFY_ROLE_COMMAND_NAME -> modifyRole(event);
                    case REMOVE_ROLE_COMMAND_NAME -> removeRole(event);
                }
            }
        }
    }

    private void removeRole(GenericCommandInteractionEvent event) {
        throw new NotImplementedException();
    }

    private void modifyRole(GenericCommandInteractionEvent event) {
        throw new NotImplementedException();
    }

    private void createRole(GenericCommandInteractionEvent event) {
        throw new NotImplementedException();
    }

    private void removeChannel(GenericCommandInteractionEvent event) {
        throw new NotImplementedException();
    }

    private void modifyChannel(GenericCommandInteractionEvent event) {
        throw new NotImplementedException();
    }

    private void createChannel(GenericCommandInteractionEvent event) {
        event.reply("yee").queue();
    }

    @Override
    public CommandData getCommandData() {
        /*
        roles
        |
        |____channel
            |
            |____create
            |
            |____modify
            |
            |____remove
        |
        |____role
            |
            |____create
            |
            |____modify
            |
            |____remove
         */

        var command = Commands.slash(COMMAND_NAME, "TODO");

        var channelGroup = new SubcommandGroupData(CHANNEL_GROUP_NAME, "TODO");
        var roleGroup = new SubcommandGroupData(ROLE_GROUP_NAME, "TODO");

        var createChannel = new SubcommandData(CREATE_CHANNEL_COMMAND_NAME, "TODO");
        var modifyChannel = new SubcommandData(MODIFY_CHANNEL_COMMAND_NAME, "TODO");
        var removeChannel = new SubcommandData(REMOVE_CHANNEL_COMMAND_NAME, "TODO");

        var createRole = new SubcommandData(CREATE_ROLE_COMMAND_NAME, "TODO");
        var modifyRole = new SubcommandData(MODIFY_ROLE_COMMAND_NAME, "TODO");
        var removeRole = new SubcommandData(REMOVE_ROLE_COMMAND_NAME, "TODO");

        command.addSubcommandGroups(channelGroup.addSubcommands(createChannel, modifyChannel, removeChannel), roleGroup.addSubcommands(createRole, modifyRole, removeRole));

        return command;
    }
}
