package com.nocturnalgenocide.citadelbot.commands;

import com.nocturnalgenocide.citadelbot.Bot;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.concurrent.TimeUnit;

public class Kms extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Bot.prefix + "kms")) {
            TextChannel channel = event.getChannel();
            Member member = event.getMember();
            if(false) {
                channel.sendMessage("Usage: c:kms").complete().delete().queueAfter(10, TimeUnit.SECONDS);
            } else {
                channel.sendMessage(":dagger: " + member.getUser().getAsMention() + " Has committed Suicide because they couldn't handle their troubling life :dagger:").queue();
            }
        }
    }
}
