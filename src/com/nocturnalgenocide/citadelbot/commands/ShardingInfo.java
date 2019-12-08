package com.nocturnalgenocide.citadelbot.commands;

import com.nocturnalgenocide.citadelbot.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.Instant;

public class ShardingInfo extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Bot.prefix + "shardinfo")) {
            TextChannel channel = event.getChannel();
            Member member = event.getMember();
            EmbedBuilder shard = new EmbedBuilder();
            shard.setAuthor(member.getUser().getName(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl());
            shard.setTitle("Citadel Bot", "https://discord.gg/xyBGhjC");
            shard.setDescription("Sharding Info");
            shard.setColor(Color.BLACK);
            shard.setThumbnail("https://cdn.discordapp.com/attachments/644458524188999704/644759002047053824/giphy.gif");
            shard.addField("Shard 1",  "1000 servers Needed for my first Shard", false);
            shard.setTimestamp(Instant.now());
            shard.setFooter("Made by: Citadel | Command Used: c:shardinfo", "https://cdn.discordapp.com/attachments/646547818961436693/652345643787878451/Altair-2.2-1.png");            channel.sendMessage(shard.build()).queue();
        }
    }
}
