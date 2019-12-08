package com.nocturnalgenocide.citadelbot.commands;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.concurrent.TimeUnit;

public class MyCommand extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(event.getGuild().getSelfMember().getAsMention())) {
            TextChannel channel = event.getChannel();
            channel.sendMessage("``My prefix is: c:``").complete().delete().queueAfter(20, TimeUnit.SECONDS);
        }
    }
}
