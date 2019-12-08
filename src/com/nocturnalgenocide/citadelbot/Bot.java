package com.nocturnalgenocide.citadelbot;

import com.nocturnalgenocide.citadelbot.commands.*;
import com.nocturnalgenocide.citadelbot.events.OnMemberJoin;
import com.nocturnalgenocide.citadelbot.events.OnMemberLeave;
import com.nocturnalgenocide.citadelbot.modcommands.*;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Bot {
    private static JDA jda;
    public static String prefix = "c:";
    private static Thread altGame = new Thread("Game Alternation") {
        public void run() {
            while(true) {
                try {
                    jda.getPresence().setPresence(OnlineStatus.ONLINE, Activity.watching("Over " + jda.awaitReady().getGuilds().size() + " Servers"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try{Thread.sleep(10000);} catch(InterruptedException e) {
                    e.printStackTrace();
                }
                jda.getPresence().setPresence(OnlineStatus.ONLINE, Activity.watching("Help Command: c:help"));
                try{Thread.sleep(10000);} catch(InterruptedException e) {
                    e.printStackTrace();
                }
                jda.getPresence().setPresence(OnlineStatus.ONLINE, Activity.watching("Citadel Code Me"));
                try{Thread.sleep(10000);} catch(InterruptedException e) {
                    e.printStackTrace();
                }
                jda.getPresence().setPresence(OnlineStatus.ONLINE, Activity.watching("https://discord.gg/xyBGhjC"));
                try{Thread.sleep(10000);} catch(InterruptedException e) {
                    e.printStackTrace();
                } jda.getPresence().setPresence(OnlineStatus.ONLINE, Activity.watching("http://nocturnalgenocide.com/"));
                try{Thread.sleep(10000);} catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public static void main(String[] args) throws LoginException {
        try {
            String TOKEN = "NjQyOTgzMDYwMjk1Mzg1MDg5.XeyH1g.asJisMNKQdPK0gDhbcS8rgqSFzA";
            jda = new JDABuilder(AccountType.BOT).setToken(TOKEN).build();
            jda.addEventListener(new Help());
            jda.addEventListener(new Rules());
            jda.addEventListener(new Invite());
            jda.addEventListener(new Info());
            jda.addEventListener(new Contact());
            jda.addEventListener(new Clear());
            jda.addEventListener(new Kick());
            jda.addEventListener(new Ban());
            jda.addEventListener(new Mute());
            jda.addEventListener(new Unmute());
            jda.addEventListener(new OnMemberJoin());
            jda.addEventListener(new Say());
            jda.addEventListener(new Kill());
            jda.addEventListener(new Kms());
            jda.addEventListener(new Mention());
            jda.addEventListener(new Misfortune());
            jda.addEventListener(new InviteRewards());
            jda.addEventListener(new Ping());
            jda.addEventListener(new Clown());
            jda.addEventListener(new ShardingInfo());
            jda.addEventListener(new OnMemberLeave());
            jda.addEventListener(new MyCommand());
            jda.addEventListener(new RoleAdd());
            jda.addEventListener(new RoleRemove());

            altGame.start();
        } catch(Exception e) {
            e.getCause();
        }
    }
}
