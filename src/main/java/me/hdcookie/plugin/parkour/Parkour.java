package me.hdcookie.plugin.parkour;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Parkour extends JavaPlugin {
    private static Parkour mainInstance;
    private Checkpoints checkpoints;


    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("Parkour Plugin Enabled");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        mainInstance = this;
        checkpoints = new Checkpoints();
        checkpoints.initiateFile();






        //Checks to see if the player is in the right place
        Bukkit.getPluginManager().registerEvents(new PosChecker(), this);

        System.out.println(getCheckpointFile().getString("test"));
        System.out.println(getConfig().getString("test"));

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("Parkour Plugin Disabled");

    }

    public static Parkour getMainInstance(){
        return mainInstance;
    }

    public YamlConfiguration getCheckpointFile(){
        return checkpoints.getFinalFile();
    }

}


