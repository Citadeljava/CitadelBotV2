package com.nocturnalgenocide.citadelbot.commands;

import com.nocturnalgenocide.citadelbot.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.Instant;

public class Info extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase(Bot.prefix + "info")) {
            infoEmbed(event.getChannel(), event.getMember());
        }
    }

    public void infoEmbed(TextChannel channel, Member member) {
        EmbedBuilder info = new EmbedBuilder();
        info.setAuthor(member.getUser().getName(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl());
        info.setTitle("Citadel Bot", "https://discord.gg/fwnzGuq");
        info.setDescription("Info Menu");
        info.setThumbnail("https://cdn.discordapp.com/attachments/644458524188999704/644759002047053824/giphy.gif");
        info.setColor(Color.BLACK);
        info.addField("Bot Owner/Programmer", "Citadel#2755", false);
        info.addField("Main Server", "[[Citadel](https://discord.gg/fwnzGuq)]", false);
        info.addField("Associated Servers", "1. [[Code Army](https://discord.gg/nEpUXsW)]\n2. [[Metropolitania](https://discord.gg/fTjTrSY)]\n3. [[The Mystical Pulse](https://discord.gg/R2UktNz)]\n4. [[Emin's Tech Zone](https://discord.gg/BWYuDFg)]\n5. [[THANKS MILITARY](https://discord.gg/BMjUfJa)]\n6. [[•TEXT & TALK•](https://discord.gg/CVYcasH)]\nIf you would like your server to be added to the list\ndm Citadel#2755", false);
        info.addField("Programming Language", "Java JDK 13\nJava JDA(Java Discord API) 4.0.0_39", false);
        info.setTimestamp(Instant.now());
        info.setFooter("Made by: Citadel | Command Used: c:info", "https://cdn.discordapp.com/attachments/646547818961436693/649132210204704769/Altair-2.2.png");
        channel.sendMessage(info.build()).queue();
    }
}