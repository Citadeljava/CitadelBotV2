package com.nocturnalgenocide.citadelbot.commands;

import com.nocturnalgenocide.citadelbot.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.Instant;

public class   Invite extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Bot.prefix + "invite")) {
            inviteMessage(event.getChannel(), event.getMember());
        }
    }

    public void inviteMessage(TextChannel  channel, Member member) {
        EmbedBuilder inv = new EmbedBuilder();
        inv.setAuthor(member.getUser().getName(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl());
        inv.setTitle("Invite Me!", "https://discordapp.com/api/oauth2/authorize?client_id=642983060295385089&permissions=8&scope=bot");
        inv.setDescription("Citadel Bot Invite Link");
        inv.setThumbnail("https://cdn.discordapp.com/attachments/644458524188999704/644759002047053824/giphy.gif");
        inv.setColor(Color.BLACK);
        inv.addField("Invite Link", "[[All Permissions](https://discordapp.com/api/oauth2/authorize?client_id=642983060295385089&permissions=8&scope=bot)]", false);
        inv.addField("Invite Link", "[[No Permissions](https://discordapp.com/api/oauth2/authorize?client_id=642983060295385089&permissions=0&scope=bot)]", false);
        inv.setTimestamp(Instant.now());
        inv.setFooter("Made by: Citadel | Command Used: c:invite", "https://cdn.discordapp.com/attachments/649517341973020682/651622218350067712/Altair-2.2.png");        channel.sendMessage(inv.build()).queue();
    }
}
