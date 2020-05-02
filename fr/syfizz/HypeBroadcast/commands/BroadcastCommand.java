package fr.syfizz.HypeBroadcast.commands;

import fr.syfizz.HypeBroadcast.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BroadcastCommand implements CommandExecutor {

    private Main main;
    public BroadcastCommand(Main mainClass){
        this.main = mainClass;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {


        if (args.length == 0) {
            sender.sendMessage(main.getConfig().getString("messages.missingArgs").replaceAll("&","§"));
        }

        if (args.length >=1) {
            if (sender.hasPermission(main.getConfig().getString("permissions.broadcastCommand"))){
                StringBuilder broadcast = new StringBuilder();
                for(String part : args) {

                    broadcast.append(part + " ");

                }
                Bukkit.broadcastMessage(broadcast.toString().replaceAll("&","§"));
            }
            else {
                sender.sendMessage(main.getConfig().getString("messages.noPermission").replaceAll("&","§"));
            }
        }

        return true;
    }

}
