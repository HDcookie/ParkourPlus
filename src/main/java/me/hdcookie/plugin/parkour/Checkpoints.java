package me.hdcookie.plugin.parkour;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Checkpoints {
    public YamlConfiguration finalFile;

    public void initiateFile(){
        String name = "checkpoints.yml";

        File file = new File(Parkour.getMainInstance().getDataFolder(), name);
        Parkour.getMainInstance().saveResource(name, false);

        finalFile = YamlConfiguration.loadConfiguration(file);

    }

    public YamlConfiguration getFinalFile(){
        return finalFile;
    }
}
