package com.nocturnalgenocide.citadelbot.commands;

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

public class InviteRewards extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Bot.prefix + "IR")) {
            TextChannel channel = event.getChannel();
            Member member = event.getMember();
            if(!member.hasPermission(Permission.ADMINISTRATOR)) {
                channel.sendMessage("Invalid Permissions").complete().delete().queueAfter(10, TimeUnit.SECONDS);
            } else {
                inviteMessage(event.getChannel(), event.getMember());
            }
        }
    }

    public void inviteMessage(TextChannel channel, Member member) {
        channel.sendMessage("@everyone").queue();
        EmbedBuilder invemb = new EmbedBuilder();
        invemb.setAuthor(member.getUser().getName(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl());
        invemb.setTitle("Citadel Bot", "https://discord.gg/xyBGhjC");
        invemb.setDescription("Invite Rewards");
        invemb.setColor(Color.BLACK);
        invemb.setThumbnail("https://cdn.discordapp.com/attachments/644458524188999704/644759002047053824/giphy.gif");
        invemb.addField("5 Invites", "Custom Role", false);
        invemb.addField("10 Invites", "Custom Bot Command", false);
        invemb.addField("15 Invites", "Custom Role & Color", false);
        invemb.addField("20 Invites", "Junior Moderator", false);
        invemb.addField("25 Invites", "Moderator", false);
        invemb.addField("30 Invites", "Junior Admin", false);
        invemb.addField("35 Invites", "Admin", false);
        invemb.setTimestamp(Instant.now());
        invemb.setFooter("Made by: Citadel | Command Used: c:IR", "https://cdn.discordapp.com/attachments/649517341973020682/651622218350067712/Altair-2.2.png");        channel.sendMessage(invemb.build()).queue();
    }
}
