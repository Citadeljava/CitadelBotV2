package com.nocturnalgenocide.citadelbot.commands;

import com.nocturnalgenocide.citadelbot.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.Instant;

public class Clown extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Bot.prefix + "clown")) {
            TextChannel channel = event.getChannel();
            Member member = event.getMember();
            EmbedBuilder clown = new EmbedBuilder();
            clown.setAuthor(member.getUser().getName(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl());
            clown.setTitle("Citadel Bot", "https://discord.gg/xyBGhjC");
            clown.setThumbnail("https://cdn.discordapp.com/attachments/644458524188999704/644759002047053824/giphy.gif");
            clown.setImage("https://cdn.discordapp.com/attachments/645936024786173952/651155570551816223/clown.png");
            clown.setTimestamp(Instant.now());
            clown.setFooter("Made by: Citadel | Command Used: c:clown", "https://cdn.discordapp.com/attachments/649517341973020682/651622218350067712/Altair-2.2.png");
            channel.sendMessage(clown.build()).queue();
        }
    }
}