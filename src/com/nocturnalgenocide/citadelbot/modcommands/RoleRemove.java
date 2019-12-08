package com.nocturnalgenocide.citadelbot.modcommands;

import com.nocturnalgenocide.citadelbot.Bot;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.HierarchyException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.concurrent.TimeUnit;

public class RoleRemove extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Bot.prefix + "removerole")) {
            TextChannel channel = event.getChannel();
            Member member = event.getMember();
            if(!member.hasPermission(Permission.MANAGE_ROLES)) {
                channel.sendMessage("Invalid Permissions").complete().delete().queueAfter(10, TimeUnit.SECONDS);
            } else if (args.length < 3) {
                channel.sendMessage("Usage: c:removerole <Role name> <@member>").complete().delete().queueAfter(10, TimeUnit.SECONDS);
            } else if (args.length == 3) {
                try {
                    Member target = event.getMessage().getMentionedMembers().get(0);
                    Role role = event.getGuild().getRolesByName(args[1], true).get(0);
                    event.getGuild().removeRoleFromMember(target, role).queue();
                    channel.sendMessage(args[1] + " has successfully been remove from " + args[2]).queue();
                } catch(HierarchyException e) {
                    channel.sendMessage(e.getCause().toString()).queue();
                    System.out.println(e);
                }
            }
        }
    }
}
