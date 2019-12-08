package com.nocturnalgenocide.citadelbot.events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.time.Instant;

public class OnMemberJoin extends ListenerAdapter {
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        Member member = event.getMember();
        EmbedBuilder join = new EmbedBuilder();
        join.setAuthor(member.getUser().getName(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl());
        join.setTitle("Member Join");
        join.setColor(Color.BLACK);
        join.setThumbnail("https://cdn.discordapp.com/attachments/644458524188999704/644759002047053824/giphy.gif");
        join.setColor(Color.BLACK);
        join.addField(event.getUser().getAsTag(), " Has Joined the Server", false);
        join.setTimestamp(Instant.now());
        join.setFooter("Made by: Citadel", "https://cdn.discordapp.com/attachments/649517341973020682/651622218350067712/Altair-2.2.png");
        event.getGuild().getTextChannelById("651330328484511744").sendMessage(join.build()).queue();
        event.getGuild().addRoleToMember(member, event.getGuild().getRolesByName("Member", true).get(0)).queue();
    }
}