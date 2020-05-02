package fr.syfizz.HypeBroadcast.commands;

import fr.syfizz.HypeBroadcast.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HypebcCommand implements CommandExecutor {

    private Main main;
    public HypebcCommand(Main mainClass){
        this.main = mainClass;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {


        if (args.length == 0) {
            sender.sendMessage(main.getConfig().getString("messages.missingArgs").replaceAll("&","§"));
        }

        else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")){
                if (sender.hasPermission(main.getConfig().getString("permissions.reloadConfigCommand"))){
                    main.reloadConfig();
                    sender.sendMessage(main.getConfig().getString("messages.reloadedConfig").replaceAll("&","§"));
                }
                else {
                    sender.sendMessage(main.getConfig().getString("messages.noPermission").replaceAll("&","§"));
                }

            }
        }
        else{
            sender.sendMessage(main.getConfig().getString("messages.tooMuchArguments").replaceAll("&","§"));
        }

        return true;
    }

}
