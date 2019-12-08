package com.nocturnalgenocide.citadelbot.commands;

import com.nocturnalgenocide.citadelbot.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.Instant;

public class Help extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Bot.prefix + "help")) {
            helpEmbed(event.getChannel(), event.getMember());
        }
    }

    public void helpEmbed(TextChannel channel, Member member) {
        EmbedBuilder help = new EmbedBuilder();
        help.setAuthor(member.getUser().getName(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl());
        help.setTitle("Citadel Bot", "https://discord.gg/xyBGhjC");
        help.setDescription("Help Menu");
        help.setColor(Color.BLACK);
        help.setThumbnail("https://cdn.discordapp.com/attachments/644458524188999704/644759002047053824/giphy.gif");
        help.addField("c:help", "Displays this Menu", false);
        help.addField("c:rules", "Displays the Server Rules for [[Citadel](https://discord.gg/xyBGhjC)]", false);
        help.addField("c:ping", "Display the ping in 'ms' for the Bot", false);
        help.addField("c:contact", "Citadels Contact Methods", false);
        help.addField("c:invite", "Invite me to your Server", false);
        help.addField("c:kill", "Kill a Specified User", false);
        help.addField("c:clown", "Displays a clown Embed", false);
        help.addField("c:kms", "Kill yourself", false);
        help.addField("c:say", "Have the Bot say a Message", false);
        help.addField("c:info", "Displays the Server/Bot Info for [[Citadel](https://discord.gg/xyBGhjC)]", false);
        help.addField("c:mute", "Mute a Specified User", false);
        help.addField("c:unmute", "Unmute a Specified User", false);
        help.addField("c:kick", "Kick a Specified User", false);
        help.addField("c:addrole", "Add a Role to a user", false);
        help.addField("c:removerole", "Remove a Role from a User", false);
        help.addField("c:ban", "Ban a Specified User", false);
        help.addField("c:cls", "Clear a specified number of message from a specified channel", false);
        help.setTimestamp(Instant.now());
        help.setFooter("Made by: Citadel | Command Used: c:help", "https://cdn.discordapp.com/attachments/649517341973020682/651622218350067712/Altair-2.2.png");        channel.sendMessage(help.build()).queue();
    }
}
