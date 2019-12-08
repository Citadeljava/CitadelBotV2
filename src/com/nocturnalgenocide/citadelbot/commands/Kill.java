package com.nocturnalgenocide.citadelbot.commands;

import com.nocturnalgenocide.citadelbot.Bot;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Kill extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Bot.prefix + "kill")) {
            TextChannel channel = event.getChannel();
            Member member = event.getMember();
            if(args.length <= 1) {
                channel.sendMessage("Usage: c:kill <@member>").queue();
            } else {
                Member target = event.getMessage().getMentionedMembers().get(0);
                channel.sendMessage(":knife: " + target.getAsMention() + " has been killed " + member.getUser().getAsMention() + " :knife:").queue();
            }
        }
    }
}
