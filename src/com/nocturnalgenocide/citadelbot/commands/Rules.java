package com.nocturnalgenocide.citadelbot.commands;

import com.nocturnalgenocide.citadelbot.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.Instant;

public class Rules extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Bot.prefix + "rules")) {
            rulesEmbed(event.getChannel(), event.getMember());
        }
    }

    public void rulesEmbed(TextChannel channel, Member member) {
        EmbedBuilder rules = new EmbedBuilder();
        rules.setAuthor(member.getUser().getName(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl());
        rules.setTitle("Citadel Bot", "https://discord.gg/xyBGhjC");
        rules.setDescription("Server Rules");
        rules.setColor(Color.BLACK);
        rules.setThumbnail("https://cdn.discordapp.com/attachments/644458524188999704/644759002047053824/giphy.gif");
        rules.addField("Rule #1", "Dont Disrespect Admins", false);
        rules.addField("Rule #2", "Dont Use Profane/Vulgar Language", false);
        rules.addField("Rule #3", "Dont Ask for Admin/Mod", false);
        rules.addField("Rule #4", "Dont Raid Attempt to Raid/Spam/Dox or otherwise Threaten any other members", false);
        rules.addField("Rule #5", "Dont try to act tough to anyone", false);
        rules.addField("Rule #6", "If you try and have an ego be warned you will be Exposed for the no knowledge skid you are", false);
        rules.setTimestamp(Instant.now());
        rules.setFooter("Made by: Citadel | Command Used: c:rules", "https://cdn.discordapp.com/attachments/646547818961436693/652345643787878451/Altair-2.2-1.png");        channel.sendMessage(rules.build()).queue();
    }
}
