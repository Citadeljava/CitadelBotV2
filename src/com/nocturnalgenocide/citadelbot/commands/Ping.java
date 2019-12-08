package com.nocturnalgenocide.citadelbot.commands;

import com.nocturnalgenocide.citadelbot.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.Instant;

public class Ping extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Bot.prefix + "ping")) {
            Member member = event.getMember();
            TextChannel channel = event.getChannel();
            long ping = event.getJDA().getGatewayPing();
            EmbedBuilder eb = new EmbedBuilder();
            eb.setAuthor(member.getUser().getName(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl());
            eb.setTitle("Citadel Bot", "https://discord.gg/xyBGhjC");
            eb.setDescription("Ping: " + ping + " ms");
            eb.setThumbnail("https://cdn.discordapp.com/attachments/644458524188999704/644759002047053824/giphy.gif");
            eb.setColor(Color.BLACK);
            eb.setTimestamp(Instant.now());
            eb.setFooter("Made by: Citadel | Command Used: c:ping", "https://cdn.discordapp.com/attachments/649517341973020682/651622218350067712/Altair-2.2.png");            channel.sendMessage(eb.build()).queue();
        }
    }
}