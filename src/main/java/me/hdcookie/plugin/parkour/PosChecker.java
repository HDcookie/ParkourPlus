package me.hdcookie.plugin.parkour;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Objects;

public class PosChecker implements Listener {
    private ParkourManager manager;


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        manager = new ParkourManager();

        YamlConfiguration checks = Parkour.getMainInstance().getCheckpointFile();


        //int courcesAmount = Bukkit.broadcastMessage(String.valueOf(checks.getConfigurationSection("cources").getKeys(false).size()));


        //runs each time with i being cource number.
        for (String key : checks.getConfigurationSection("cources").getKeys(false)) {
            // key = course name
            for (String checkpoint : checks.getConfigurationSection("cources." + key).getKeys(false)) {
                int checkpointInt = Integer.parseInt(checkpoint);

                int currentCheckpoint = manager.getCurrentCheckpoint();
                // checkpoint = 1, 2, 3, etc


                String path = "cources." + key + "." + checkpoint + ".";
                Location location = new Location(Bukkit.getWorld(checks.getString(path + "world")), checks.getInt(path + "x"), checks.getInt(path + "y"), checks.getInt(path + "z"));
                // You now have your location

                if(Utilities.atLocation(event.getTo(), Utilities.getLocation(key, checkpointInt))){
                    Bukkit.broadcastMessage("Key is "+key+" Checkpoint is: "+checkpoint);
                    manager.addCheckpoint();
                }


            }
        }

    }
}
