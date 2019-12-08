package com.nocturnalgenocide.citadelbot.events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.Instant;

public class OnMemberLeave extends ListenerAdapter {
    public void onGuildMemberLeave(GuildMemberLeaveEvent event) {
        Member member = event.getMember();
        EmbedBuilder leave = new EmbedBuilder();
        leave.setAuthor(member.getUser().getName(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl());
        leave.setTitle("Member Leave");
        leave.setColor(Color.BLACK);
        leave.setThumbnail("https://cdn.discordapp.com/attachments/644458524188999704/644759002047053824/giphy.gif");
        leave.setColor(Color.BLACK);
        leave.addField(event.getUser().getAsTag(), " Has Left the Server", false);
        leave.setTimestamp(Instant.now());
        leave.setFooter("Made by: Citadel", "https://cdn.discordapp.com/attachments/649517341973020682/651622218350067712/Altair-2.2.png");
        event.getGuild().getTextChannelById("651330352651960361").sendMessage(leave.build()).queue();
    }
}
