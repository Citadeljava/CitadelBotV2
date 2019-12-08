package com.nocturnalgenocide.citadelbot.modcommands;

import com.nocturnalgenocide.citadelbot.Bot;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.concurrent.TimeUnit;

public class Unmute extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase(Bot.prefix + "unmute")) {
            Member member = event.getMember();
            TextChannel channel = event.getChannel();
            if(!member.hasPermission(Permission.MANAGE_ROLES)) {
                channel.sendMessage("Invalid Permissions").complete().delete().queueAfter(10, TimeUnit.SECONDS);
            } else {
                if(args.length <= 1) {
                    channel.sendMessage("Usage: c:unmute <@member>").queue();
                } else {
                    Member target = event.getMessage().getMentionedMembers().get(0);
                    Role muted = event.getGuild().getRolesByName("Muted", true).get(0);
                    event.getGuild().removeRoleFromMember(target, muted).queue();

                    channel.sendMessage("Successfully Unmuted " + target.getAsMention()).complete().delete().queueAfter(10, TimeUnit.SECONDS);
                }
            }
        }
    }
}
