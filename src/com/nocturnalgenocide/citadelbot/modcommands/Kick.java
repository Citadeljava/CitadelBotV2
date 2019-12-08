package com.nocturnalgenocide.citadelbot.modcommands;

import com.nocturnalgenocide.citadelbot.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class Kick extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Bot.prefix + "kick")) {
            TextChannel channel = event.getChannel();
            Member member = event.getMember();
            if(!member.hasPermission(Permission.KICK_MEMBERS)) {
                EmbedBuilder kickerr = new EmbedBuilder();
                kickerr.setAuthor(member.getUser().getName(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl());
                kickerr.setTitle("UltraSelfBot");
                kickerr.setDescription("Error: Invalid Permissions");
                kickerr.setColor(Color.BLACK);
                kickerr.setTimestamp(Instant.now());
                kickerr.setFooter("Made by Citadel", "https://cdn.discordapp.com/attachments/646547818961436693/652345643787878451/Altair-2.2-1.png");                channel.sendMessage(kickerr.build()).complete().delete().queueAfter(20, TimeUnit.SECONDS);
            } else if(args.length == 1) {
                channel.sendMessage(member.getUser().getAsMention() + "Usage: kick <user>").complete().delete().queueAfter(20, TimeUnit.SECONDS);
            } else {
                Member target = event.getMessage().getMentionedMembers().get(0);
                target.kick().queue();
                channel.sendMessage("Successfully kicked").complete().delete().queueAfter(10, TimeUnit.SECONDS);
            }
        }
    }
}