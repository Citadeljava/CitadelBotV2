package com.nocturnalgenocide.citadelbot.commands;

import com.nocturnalgenocide.citadelbot.Bot;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.concurrent.TimeUnit;

public class Mention extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Bot.prefix + "mention")) {
            Member member = event.getMember();
            TextChannel channel = event.getChannel();
            if(!member.hasPermission(Permission.ADMINISTRATOR)) {
                channel.sendMessage("Invalid permissions").complete().delete().queueAfter(10, TimeUnit.SECONDS);
            } else {
                channel.sendMessage("@everyone i will be going down for a few hours for upgrades").queue();
            }
        }
    }
}
