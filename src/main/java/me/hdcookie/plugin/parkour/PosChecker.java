package me.hdcookie.plugin.parkour;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PosChecker implements Listener {


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        YamlConfiguration checks = Parkour.getMainInstance().getCheckpointFile();

        if(event.getTo().equals(Utilities.getLocation("cource1", 1))){
            Bukkit.broadcastMessage("ay worked");
        }


    }
}
