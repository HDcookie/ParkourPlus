package me.hdcookie.plugin.parkour;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PosChecker implements Listener {


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        YamlConfiguration checks = Parkour.getMainInstance().getCheckpointFile();
        Location location = Utilities.getLocation("cource1", 1);

        boolean one = false;
        boolean two = false;
        boolean three = false;

        if(event.getTo().getBlockX() == location.getBlockX()){
            one = true;
        }
        if(event.getTo().getBlockY() == location.getBlockY()){
            two = true;
        }
        if(event.getTo().getBlockZ() == location.getBlockZ()){
            three = true;
        }

        if(one && two && three){
            Bukkit.broadcastMessage("Worked");
        }

    }
}
