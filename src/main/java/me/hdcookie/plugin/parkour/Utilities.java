package me.hdcookie.plugin.parkour;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

public class Utilities {

    public static Location getLocation(String name, int checkpoint) {
        YamlConfiguration checks = Parkour.getMainInstance().getCheckpointFile();
        String smth = "cources." + name + "." + checkpoint;

        double x = checks.getDouble(smth + ".x");
        double y = checks.getDouble(smth + ".y");
        double z = checks.getDouble(smth + ".z");

        World world = Bukkit.getWorld(checks.getString(smth + ".world"));


        Location location = new Location(world, x, y, z);
        return location;
    }

    public static boolean atLocation(Location loc1, Location loc2) {
        YamlConfiguration checks = Parkour.getMainInstance().getCheckpointFile();


        boolean one = false;
        boolean two = false;
        boolean three = false;

        if (loc1.getBlockX() == loc2.getBlockX()) {
            one = true;
        }
        if (loc1.getBlockY() == loc2.getBlockY()) {
            two = true;
        }
        if (loc1.getBlockZ() == loc2.getBlockZ()) {
            three = true;
        }

        if (one && two && three) {
            return true;
        } else {
            return false;
        }
    }
}
