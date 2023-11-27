package com.qStivi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class VoiceEvent {
    private static final Logger logger = LoggerFactory.getLogger(VoiceEvent.class);
    private final String channelName;
    private final String userName;
    private final LocalDateTime dateTime;
    private final String eventType;
    private final String guildName;
    private final String guildId;
    private final String userId;
    private final String channelId;
    private final String eventTime;
    private final String eventDate;

    public VoiceEvent(String channelName, String userName, LocalDateTime dateTime, String eventType, String guildName, String guildId, String userId, String channelId, String eventTime, String eventDate) {
        this.channelName = channelName;
        this.userName = userName;
        this.dateTime = dateTime;
        this.eventType = eventType;
        this.guildName = guildName;
        this.guildId = guildId;
        this.userId = userId;
        this.channelId = channelId;
        this.eventTime = eventTime;
        this.eventDate = eventDate;
    }

    public void save() {
        try {
            FileWriter csvWriter = new FileWriter("events.csv", true);
            csvWriter.append(channelName);
            csvWriter.append(",");
            csvWriter.append(userName);
            csvWriter.append(",");
            csvWriter.append(dateTime.toString());
            csvWriter.append(",");
            csvWriter.append(eventType);
            csvWriter.append(",");
            csvWriter.append(guildName);
            csvWriter.append(",");
            csvWriter.append(guildId);
            csvWriter.append(",");
            csvWriter.append(userId);
            csvWriter.append(",");
            csvWriter.append(channelId);
            csvWriter.append(",");
            csvWriter.append(eventTime);
            csvWriter.append(",");
            csvWriter.append(eventDate);
            csvWriter.append("\n");

            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            logger.error("Could not write to csv file.");
        }
    }
}
