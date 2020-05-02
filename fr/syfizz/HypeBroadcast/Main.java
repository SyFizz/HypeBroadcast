package fr.syfizz.HypeBroadcast;

import fr.syfizz.HypeBroadcast.commands.BroadcastCommand;
import fr.syfizz.HypeBroadcast.commands.HypebcCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable(){
        saveDefaultConfig();
        System.out.println(this.getConfig().getString("messages.pluginEnabled"));
        getCommand("broadcast").setExecutor(new BroadcastCommand(this));
        getCommand("hypebc").setExecutor(new HypebcCommand(this));
    }
    public void onDisable(){
        System.out.println(this.getConfig().getString("messages.pluginDisabled"));
    }
}
