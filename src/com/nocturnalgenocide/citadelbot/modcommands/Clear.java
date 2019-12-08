package com.nocturnalgenocide.citadelbot.modcommands;

import com.nocturnalgenocide.citadelbot.Bot;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Clear extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Bot.prefix + "cls")) {
            Member member = event.getMember();
            TextChannel channel = event.getChannel();
            if(!member.hasPermission(Permission.MESSAGE_MANAGE)) {
                channel.sendMessage("Invalid Permissions").complete().delete().queueAfter(10, TimeUnit.SECONDS);
            } else {
                if(args.length < 3) {
                    channel.sendMessage("Usage: c:cls <#channel> <NumOfMessages>").queue();
                } else {
                    TextChannel target = event.getMessage().getMentionedChannels().get(0);
                    purgeMessages(target, Integer.parseInt(args[2]));
                }
            }
        }
    }

    public void purgeMessages(TextChannel channel, int num) {
        MessageHistory history = new MessageHistory(channel);
        List<Message> messages;
        messages = history.retrievePast(num).complete();
        channel.deleteMessages(messages).queue();
        channel.sendMessage("SuccessFully Deleted " + num + " Messages").complete().delete().queueAfter(10, TimeUnit.SECONDS);
    }
}
