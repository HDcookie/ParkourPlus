package me.hdcookie.plugin.parkour;

import org.bukkit.Bukkit;

public class ParkourManager {

    private int checkpoint = 0;

    public int getCurrentCheckpoint(){
        return checkpoint;
    }

    public void addCheckpoint(){


        checkpoint++;
        Bukkit.broadcastMessage("added a checkpoint"+checkpoint);
    }

}
