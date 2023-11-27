package com.qStivi;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;


public class Main implements net.dv8tion.jda.api.hooks.EventListener {
    Logger logger = org.slf4j.LoggerFactory.getLogger(Main.class);

    public static void main(String[] args)
            throws InterruptedException
    {
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
    public void onEvent(@NotNull GenericEvent genericEvent)
    {
        // On member join or leave update channel name
        if (genericEvent instanceof GuildMemberJoinEvent event)
        {
            var channels = event.getGuild().getTextChannels();
            for (TextChannel channel : channels) {
                if (channel.getName().startsWith("member-count")) {
                    channel.getManager().setName("member-count: " + event.getGuild().getMemberCount()).queue();
                }
            }
        }
        if (genericEvent instanceof GuildMemberRemoveEvent event)
        {
            var channels = event.getGuild().getTextChannels();
            for (TextChannel channel : channels) {
                if (channel.getName().startsWith("member-count")) {
                    channel.getManager().setName("member-count: " + event.getGuild().getMemberCount()).queue();
                }
            }
        }
    }
}
