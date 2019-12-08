package com.nocturnalgenocide.citadelbot.commands;

import com.nocturnalgenocide.citadelbot.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class Contact extends ListenerAdapter {
    public void onGuildessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Bot.prefix + "contact")) {

        }
    }
    public void contactMessage(TextChannel channel, Member member) {
        EmbedBuilder contact = new EmbedBuilder();
        contact.setAuthor(member.getUser().getName(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl());
        contact.setTitle("Invite Me!", "https://discordapp.com/api/oauth2/authorize?client_id=642983060295385089&permissions=8&scope=bot");
        contact.setDescription("Citadel Bot Invite Link");
        contact.setThumbnail("https://cdn.discordapp.com/attachments/644458524188999704/644759002047053824/giphy.gif");
        contact.setColor(Color.BLACK);
        contact.addField("Discord", "Citadel#2755", false);
        contact.addField("Email", "DamianGriffen@outlook.com", false);
        contact.addField("Instagram", "citadel.java", false);
        contact.addField("Twitter", "_C_i_t_a_d_e_l_", false);
        contact.setTimestamp(Instant.now());
        contact.setFooter("Made by: Citadel | Command Used: c:contact", "https://cdn.discordapp.com/attachments/649517341973020682/651622218350067712/Altair-2.2.png");        channel.sendMessage(contact.build()).complete().delete().queueAfter(60, TimeUnit.SECONDS);
    }
}
