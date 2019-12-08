package com.nocturnalgenocide.citadelbot.modcommands;

import com.nocturnalgenocide.citadelbot.Bot;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class RoleCreate extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Bot.prefix + "createrole")) {
            Member member = event.getMember();
            TextChannel channel = event.getChannel();
            if(!member.hasPermission(Permission.MANAGE_PERMISSIONS)) {
                channel.sendMessage("Invalid Permissions").complete().delete().queueAfter(10, TimeUnit.SECONDS);
            } else if(args.length < 4) {
                channel.sendMessage("Usage: c:createrole <name> <color> <permissions>").complete().delete().queueAfter(10, TimeUnit.SECONDS);
            } else if(args.length == 4) {
                event.getGuild().createRole().setName(args[1]).setColor(Color.BLACK).setPermissions(Long.valueOf(args[3])).submit();
                channel.sendMessage("``"+args[1]+"``" + " Has successfully been created with Permissions " + "``"+args[3]+"``" + " With Color " + "``"+args[2]+"``").queue();
            }
        }
    }
}