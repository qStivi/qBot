package com.qStivi;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;


public class Main implements net.dv8tion.jda.api.hooks.EventListener {
    Logger logger = org.slf4j.LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        // Get token from token file and if file does not exist or is empty ask for token and save it to file for later use
        String token = Token.getToken();

        // Create JDA instance
        JDA jda = JDABuilder.createDefault(token).build();

        // Add event listener
        jda.addEventListener(new Main());

        // Wait for JDA to be ready
        jda.awaitReady();

        // Set channel name
        var guild = jda.getGuildById(703363806356701295L);
        if (guild != null) {
            var channels = guild.getTextChannels();
            for (TextChannel channel : channels) {
                if (channel.getName().startsWith("member-count")) {
                    channel.getManager().setName("member-count: " + guild.getMemberCount()).queue();
                }
            }
        }
    }

    @Override
    public void onEvent(@NotNull GenericEvent genericEvent) {
        // On member join or leave update channel name
        if (genericEvent instanceof GuildMemberJoinEvent event) {
            var channels = event.getGuild().getTextChannels();
            for (TextChannel channel : channels) {
                if (channel.getName().startsWith("member-count")) {
                    channel.getManager().setName("member-count: " + event.getGuild().getMemberCount()).queue();
                }
            }
        }
        if (genericEvent instanceof GuildMemberRemoveEvent event) {
            var channels = event.getGuild().getTextChannels();
            for (TextChannel channel : channels) {
                if (channel.getName().startsWith("member-count")) {
                    channel.getManager().setName("member-count: " + event.getGuild().getMemberCount()).queue();
                }
            }
        }

        // track voice join activity for each channel in csv file by date and time
        if (genericEvent instanceof GuildVoiceUpdateEvent event) {
            // Get channel joined
            var channelJoined = event.getChannelJoined();
            // Get channel left
            var channelLeft = event.getChannelLeft();
            // Get channel name
            String channelName;
            if (channelJoined != null) {
                channelName = channelJoined.getName();
            } else if (channelLeft != null) {
                channelName = channelLeft.getName();
            } else {
                logger.error("Could not get channel name.");
                channelName = "unknown";
            }
            // Get username
            var userName = event.getEntity().getEffectiveName();
            // Get date and time
            var dateTime = java.time.LocalDateTime.now();
            // Get event type
            var voiceState = event.getEntity().getVoiceState();
            assert voiceState != null;
            var eventType = voiceState.getChannel() == null ? "left" : "joined";
            // Get guild name
            var guildName = event.getGuild().getName();
            // Get guild id
            var guildId = event.getGuild().getId();
            // Get user id
            var userId = event.getEntity().getId();
            // Get channel id
            String channelId;
            if (channelJoined != null) {
                channelId = channelJoined.getId();
            } else if (channelLeft != null) {
                channelId = channelLeft.getId();
            } else {
                logger.error("Could not get channel id.");
                channelId = "unknown";
            }
            // Get event id
            var eventTime = dateTime.toString();
            // Get event id
            var eventDate = dateTime.toLocalDate().toString();

            // Create event object
            var voiceEvent = new VoiceEvent(channelName, userName, dateTime, eventType, guildName, guildId, userId, channelId, eventTime, eventDate);

            // Save event to csv file
            voiceEvent.save();
        }
    }
}
